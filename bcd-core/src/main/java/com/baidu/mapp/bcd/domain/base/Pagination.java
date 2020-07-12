package com.baidu.mapp.bcd.domain.base;

import java.io.Serializable;
import java.util.List;
import java.util.function.Consumer;

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

    private Object ext;

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public void each(Consumer<T> consumer) {
        if (dataList != null && !dataList.isEmpty()) {
            for (T t : dataList) {
                consumer.accept(t);
            }
        }
    }

    public String toString() {
        return "Pagination{" +
                "total = " + total +
                ", dataList = " + dataList +
                '}';
    }
}
