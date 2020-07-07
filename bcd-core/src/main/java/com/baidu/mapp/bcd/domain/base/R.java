package com.baidu.mapp.bcd.domain.base;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "通用响应返回对象")
public class R<T> implements Serializable {

    /**
     * 返回状态码
     */
    @Schema(description = "返回状态码")
    private int status;

    /**
     * 返回信息
     */
    @Schema(description = "返回信息")
    private String msg;

    /**
     * 返回结果数据
     */
    @Schema(description = "结果数据" )
    private T data;

    public static <T> R<T> error() {
        return error(500, "fail");
    }

    public static <T> R<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> R<T> error(Integer status, String msg) {
        R<T> r = new R<>();
        r.setStatus(status);
        r.setMsg(msg);
        return r;
    }

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setStatus(0);
        r.setMsg("success");
        return r;
    }

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setStatus(0);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    @Schema(description = "返回状态码")
    public int getStatus() {
        return status;
    }

    @Schema(description = "返回状态码")
    public void setStatus(int status) {
        this.status = status;
    }

    @Schema(description = "返回信息")
    public String getMsg() {
        return msg;
    }

    @Schema(description = "返回信息")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Schema(description = "结果数据" )
    public T getData() {
        return data;
    }

    @Schema(description = "结果数据")
    public void setData(T data) {
        this.data = data;
    }
}
