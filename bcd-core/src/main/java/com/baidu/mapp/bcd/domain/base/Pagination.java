package com.baidu.mapp.bcd.domain.base;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "通用响应返回对象")
public class Pagination<T> implements Serializable {

    /**
     * 总记录数
     */
    @Schema(description = "总记录数")
    private Long total;

    /**
     * 数据列表
     */
    @Schema(description = "数据列表")
    private List<T> dataList;

    @Schema(description = "总记录数")
    public void setTotal(Long total) {
        this.total = total;
    }

    @Schema(description = "总记录数")
    public Long getTotal() {
        return total;
    }

    @Schema(description = "数据列表")
    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Schema(description = "数据列表")
    public List<T> getDataList() {
        return dataList;
    }

    public String toString() {
        return "Pagination{" +
                "total = " + total +
                ", dataList = " + dataList +
                '}';
    }
}
