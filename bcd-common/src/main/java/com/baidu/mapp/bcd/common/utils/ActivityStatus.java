package com.baidu.mapp.bcd.common.utils;

/**
 * 活动状态枚举 0-待实施， 1-实施中， 2-实施完成
 */
public enum ActivityStatus {

    INIT((byte) 0, "待实施"),
    ING((byte) 1, "实施中"),
    DONE((byte) 2, "实施完成");

    private Byte status;

    private String desc;

    ActivityStatus(Byte status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
