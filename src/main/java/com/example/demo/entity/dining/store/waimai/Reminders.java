package com.example.demo.entity.dining.store.waimai;

import java.util.Date;

/**
 * Created by liuchang on 2017/12/4.
 */
public class Reminders {

    private String id;
    private int number;
    private Date time;
    private boolean reply;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isReply() {
        return reply;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }
}
