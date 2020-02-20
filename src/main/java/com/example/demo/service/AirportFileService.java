package com.example.demo.service;

import com.example.demo.dao.MallProductCodeDao;
import com.example.demo.entity.AirportFileEntity;
import com.example.demo.entity.MallProductCode;
import com.example.demo.entity.MallResponse;
import com.example.demo.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangrong 2019/12/30
 */
@Service
@Slf4j
public class AirportFileService {

    @Autowired
    private MallProductCodeDao mallProductCodeDao;
    private final int hqId = 2439;
    private final int branchId = 3447;
    private final String TIMESTAMP = "yyyyMMddHHmmss";

    public MallResponse parseFile(MultipartFile sourceFile) {
        Workbook workbook;
        try {
            FileInputStream file = (FileInputStream) sourceFile.getInputStream();
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            log.info("读取文件流失败：" + e.getMessage());
            return MallResponse.fail("读取文件流失败：" + e.getMessage());
        }
        try {
            // 打开Excel中的第一个Sheet
            Sheet firstSheet = workbook.getSheetAt(0);
            // 读取第一行，记录要读取哪些列
            Map<Integer, String> indexToNameMap = parseFirstRow(firstSheet);
            // 检查文件中未找到对应名称的数据列
            List<String> noColumnNameList = AirportFileEntity.nameToParamMap.keySet()
                    .stream()
                    .filter(columnName -> !indexToNameMap.containsValue(columnName))
                    .collect(Collectors.toList());
            if (!noColumnNameList.isEmpty()) {
                return MallResponse.fail("文件中未找到对应名称的数据列，请检查文件格式", noColumnNameList);
            }
            // 从第二行开始读取数据
            List<Map<String, String>> dataList = parseData(firstSheet, indexToNameMap);
            // 将解析的数据转化为数据对象
            List<MallProductCode> mallProductCodeList = buildSaveData(dataList);
            // 保存数据到数据库
            boolean isSaved = persistData(mallProductCodeList);
            if (isSaved) {
                // 保存上传的文件
                String saveMsg = saveSourceFile(sourceFile);
                if ("suc".equals(saveMsg)) {
                    return MallResponse.ok();
                }
                return MallResponse.fail("数据库保存数据成功，服务器保存文件失败:" + saveMsg);
            }
            return MallResponse.fail("数据库保存数据失败");
        } catch (Exception e) {
            log.info("解析文件报错：" + e.getMessage());
            return MallResponse.fail("解析文件报错：" + e.getMessage());
        }
    }

    /**
     * 保存数据到数据库
     *
     * @param mallProductCodeList
     * @return
     */
    private boolean persistData(List<MallProductCode> mallProductCodeList) {
        List<String> skuList = mallProductCodeList.stream().map(MallProductCode::getSku).collect(Collectors.toList());
        List<MallProductCode> existList = mallProductCodeDao.queryBySkuList(skuList);
        List<MallProductCode> needSaveList = new ArrayList<>();
        if (!existList.isEmpty()) {
            skuList = existList.stream().map(MallProductCode::getSku).collect(Collectors.toList());
            log.info("数据库已存在相同sku记录：{}", skuList);
            String sku;
            String existSku;
            boolean isExist;
            for (MallProductCode productCode : mallProductCodeList) {
                sku = productCode.getSku();
                isExist = false;
                for (MallProductCode existProductCode : existList) {
                    existSku = existProductCode.getSku();
                    if (existSku.equals(sku)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    needSaveList.add(productCode);
                }
            }
        } else {
            needSaveList = mallProductCodeList;
        }
        try {
            return mallProductCodeDao.batchSave(needSaveList);
        } catch (Exception e) {
            log.info("数据库保存数据发生异常：" + e.getMessage());
            return false;
        }
    }

    /**
     * 解析第一行数据
     *
     * @param sheet
     * @return
     */
    private Map<Integer, String> parseFirstRow(Sheet sheet) {
        Map<Integer, String> indexToNameMap = new HashMap<>();
        Row firstRow = sheet.getRow(0);
        Cell cell;
        String cellVal;
        for (int index = 0; index < firstRow.getLastCellNum(); index++) {
            cell = firstRow.getCell(index);
            cellVal = cell.getRichStringCellValue().getString();
            for (String name : AirportFileEntity.nameToParamMap.keySet()) {
                if (name.equals(cellVal)) {
                    indexToNameMap.put(index, cellVal);
                    break;
                }
            }
        }
        return indexToNameMap;
    }

    /**
     * 解析第二行开始的数据行
     *
     * @param sheet
     * @param indexToNameMap
     * @return
     */
    private List<Map<String, String>> parseData(Sheet sheet, Map<Integer, String> indexToNameMap) {
        List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> rowDataMap;
        Row dataRow;
        Cell cell;
        String cellVal;
        String columnName;
        String classParam;
        int lastDataRowIndex = sheet.getLastRowNum();
        for (int rowIndex = 1; rowIndex <= lastDataRowIndex; rowIndex++) {
            dataRow = sheet.getRow(rowIndex);
            rowDataMap = new HashMap<>();
            for (Integer index : indexToNameMap.keySet()) {
                cell = dataRow.getCell(index);
                cellVal = convertCellVal(cell);
                columnName = indexToNameMap.get(index);
                classParam = AirportFileEntity.nameToParamMap.get(columnName);
                rowDataMap.put(classParam, cellVal);
            }
            dataList.add(rowDataMap);
        }
        return dataList;
    }

    private String convertCellVal(Cell cell) {
        int typeCode = cell.getCellType().getCode();
        String value;
        switch (typeCode) {
            case 1:
                value = cell.getStringCellValue();
                break;
            case 0:
                value = String.valueOf(cell.getNumericCellValue());
                break;
            default:
                value = "";
        }
        return value;
    }

    /**
     * 构建要保存的数据对象
     *
     * @param dataList
     * @return
     */
    private List<MallProductCode> buildSaveData(List<Map<String, String>> dataList) {
        List<MallProductCode> mallProductCodeList = new ArrayList<>();
        MallProductCode mallProductCode;
        for (Map<String, String> rowDataMap : dataList) {
            AirportFileEntity airportFileEntity = ObjectUtils.getInstanceFromMap(rowDataMap, AirportFileEntity.class);
            mallProductCode = new MallProductCode();
            mallProductCode.setHqId(hqId);
            mallProductCode.setBranchId(branchId);
            mallProductCode.setMall(airportFileEntity.getShopName());
            String code = airportFileEntity.getCode();
            mallProductCode.setCode(code.contains(".") ? code.substring(0, code.indexOf('.')) : code);
            mallProductCode.setMallId(airportFileEntity.getSku());
            mallProductCode.setSku(airportFileEntity.getSku());
            mallProductCodeList.add(mallProductCode);
        }
        return mallProductCodeList;
    }

    /**
     * 保存上传的文件
     *
     * @param sourceFile
     * @return
     */
    private String saveSourceFile(MultipartFile sourceFile) {
        String sourceFileName = sourceFile.getOriginalFilename();
        String saveFileName = sourceFileName.replace("airport", "airport-" + new SimpleDateFormat(TIMESTAMP).format(new Date()));
        try {
            File file = FileUtils.getFile("/data/share/mall.51hchc.com/" + String.valueOf(hqId) + "/" + String.valueOf(branchId) + "/" + saveFileName);
            if (!file.exists()) {
                file.mkdirs();
            }
            sourceFile.transferTo(file);
        } catch (IOException e) {
            log.info(saveFileName + "文件保存失败：" + e.getMessage());
            return e.getMessage();
        }
        return "suc";
    }

}
