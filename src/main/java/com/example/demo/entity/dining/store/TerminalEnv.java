package com.example.demo.entity.dining.store;

/**
 * 终端设备环境对象
 */
public class TerminalEnv {
    //设备相关信息
    private String deviceIdentifier;//设备唯一码, iOS UUID
//    private String deviceName;//设备名称
    private String deviceModel;//设备型号
    private String deviceSysName;//设备系统名称, 例如iOS Android
    private String deviceSysVersion;//设备系统版本号
    private String deviceSysClockZone;//设备系统时区
//    private String deviceSysDatetime;//设备系统当前日期时间
    //App信息
    private String appName;//App名称
    private String appVersion;//App版本号

    public String getDeviceIdentifier() {
        return deviceIdentifier;
    }

    public void setDeviceIdentifier(String deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceSysName() {
        return deviceSysName;
    }

    public void setDeviceSysName(String deviceSysName) {
        this.deviceSysName = deviceSysName;
    }

    public String getDeviceSysVersion() {
        return deviceSysVersion;
    }

    public void setDeviceSysVersion(String deviceSysVersion) {
        this.deviceSysVersion = deviceSysVersion;
    }

    public String getDeviceSysClockZone() {
        return deviceSysClockZone;
    }

    public void setDeviceSysClockZone(String deviceSysClockZone) {
        this.deviceSysClockZone = deviceSysClockZone;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
