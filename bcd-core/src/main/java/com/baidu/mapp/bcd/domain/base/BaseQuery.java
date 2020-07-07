package com.baidu.mapp.bcd.domain.base;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "基础查询对象", name = "BaseQuery")
public class BaseQuery implements Serializable {

    /**
     * 偏移量
     */
    @Schema(description = "偏移量")
    private Integer offset;

    /**
     * 每页显示条数
     */
    @Schema(description = "每页显示条数")
    private Integer limit;

    /**
     * 当前页，从1开始
     */
    @Schema(description = "当前页，从1开始")
    private Integer currentPage;

    /**
     *
     * 通过当前页计算偏移量，
     * @return 返回偏移量，原来的偏移量将被覆盖
     */
    public Integer calculateOffsetFromCurrentPage() {
        offset = ( currentPage - 1 ) * limit;
        return offset;
    }

    /**
     *
     * 通过偏移量计算当前页，
     * @return 返回当前页，原来的当前页将被覆盖
     */
    public Integer calculateCurrentPageFromOffset() {
        currentPage = offset/limit + 1;
        return currentPage;
    }

    @Schema(description = "偏移量")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Schema(description = "偏移量")
    public Integer getOffset() {
        return offset;
    }

    @Schema(description = "每页显示条数")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Schema(description = "每页显示条数")
    public Integer getLimit() {
        return limit;
    }

    @Schema(description = "当前页，从1开始")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Schema(description = "当前页，从1开始")
    public Integer getCurrentPage() {
        return currentPage;
    }

    public String toString() {
        return "BaseQuery{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", currentPage=" + currentPage +
                '}';
    }
}
