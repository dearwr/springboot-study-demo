package com.example.demo.entity.dining.store.waimai;

import org.omg.CORBA.Object;

import java.util.Date;

/**
 * 订单状态
 *
 * Created by liuchang on 2017/9/26.
 */
public class Status {

    /**
     * 类型
     */
    private StatusType type;
    /**
     * 显示名称
     */
    private String name;
    /**
     * 时间
     */
    private Date date;

    private Operator operator;

    /**
     * 扩展数据
     */
    private Object exdata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusType getType() {
        return type;
    }

    public void setType(StatusType type) {
        if(type == StatusType.INVALID){
            this.type = StatusType.REFUND;
        }
        if(name == null){
            name = type.getName();
        }
        this.type = type;
    }

    public Object getExdata() {
        return exdata;
    }

    public void setExdata(Object exdata) {
        this.exdata = exdata;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
