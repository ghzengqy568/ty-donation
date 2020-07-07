
package com.baidu.mapp.bcd.domain.em;

public enum Deleted {
    DELETED_NO((byte) 0, "正常"),
    DELETED_YES((byte) 1, "已删除");

    private byte value;
    private String name;

    Deleted(byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
