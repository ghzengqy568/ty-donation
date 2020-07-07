package com.baidu.mapp.bcd.domain.em;

public enum Enabled {
    disabled((byte) 0, "不可用"),
    enable((byte) 1, "可用");

    private byte value;
    private String name;

    Enabled(byte value, String name) {
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

    public static Enabled fromValue(Byte value) {
        if (value == null || value < (byte) 0 || value > (byte) 1) {
            throw new IllegalArgumentException("Enum Enabled value [1,2], but accept value = " + value);
        }
        if (value == 0) {
            return disabled;
        } else if (value == 1) {
            return enable;
        }
        return null;
    }
}
