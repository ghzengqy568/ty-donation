package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "DrawDonateDetailRel", description = "领取和捐赠明细关系表")
public class DrawDonateDetailRel implements Serializable {

    /**
     * column-name:id
     * 领取和捐赠明细关系ID
     */
    @Schema(description = "领取和捐赠明细关系ID")
    private Long id;

    /**
     * column-name:draw_record_id
     * 领取记录ID
     */
    @Schema(description = "领取记录ID")
    private Long drawRecordId;

    /**
     * column-name:donate_detail_id
     * 捐赠明细ID
     */
    @Schema(description = "捐赠明细ID")
    private Long donateDetailId;

    /**
     * column-name:create_time
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;

    /**
     * column-name:last_modify_time
     * 更新时间
     */
    @Schema(description = "更新时间")
    private Date lastModifyTime;

    /**
     * 领取和捐赠明细关系表
     */
    public DrawDonateDetailRel() {
        
    }

    /**
     * 领取和捐赠明细关系表
     */
    private DrawDonateDetailRel(XBuilder builder) {
        this.id = builder.id;
        this.drawRecordId = builder.drawRecordId;
        this.donateDetailId = builder.donateDetailId;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 领取和捐赠明细关系ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 领取和捐赠明细关系ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 领取记录ID
     */
    public Long getDrawRecordId() {
        return drawRecordId;
    }

    /**
     * 领取记录ID
     */
    public void setDrawRecordId(Long drawRecordId) {
        this.drawRecordId = drawRecordId;
    }

    /**
     * 捐赠明细ID
     */
    public Long getDonateDetailId() {
        return donateDetailId;
    }

    /**
     * 捐赠明细ID
     */
    public void setDonateDetailId(Long donateDetailId) {
        this.donateDetailId = donateDetailId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 更新时间
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public DrawDonateDetailRel copyFrom(DrawDonateDetailRel other) {
        this.id = other.id;
        this.drawRecordId = other.drawRecordId;
        this.donateDetailId = other.donateDetailId;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends DrawDonateDetailRel> T copyFrom(DrawDonateDetailRel from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setDrawRecordId(from.drawRecordId);
        to.setDonateDetailId(from.donateDetailId);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            drawRecordId: '',
            donateDetailId: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"drawRecordId\": \"\",\"donateDetailId\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drawRecordId=").append(drawRecordId);
        sb.append(", donateDetailId=").append(donateDetailId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 领取和捐赠明细关系ID
         */
        private Long id;

        /**
         * 领取记录ID
         */
        private Long drawRecordId;

        /**
         * 捐赠明细ID
         */
        private Long donateDetailId;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 更新时间
         */
        private Date lastModifyTime;

        private XBuilder() {
            
        }

        /**
         * 领取和捐赠明细关系ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 领取记录ID
         */
        public XBuilder drawRecordId(Long drawRecordId) {
            this.drawRecordId = drawRecordId;
            return this;
        }

        /**
         * 捐赠明细ID
         */
        public XBuilder donateDetailId(Long donateDetailId) {
            this.donateDetailId = donateDetailId;
            return this;
        }

        /**
         * 创建时间
         */
        public XBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        /**
         * 更新时间
         */
        public XBuilder lastModifyTime(Date lastModifyTime) {
            this.lastModifyTime = lastModifyTime;
            return this;
        }

        public DrawDonateDetailRel build() {
            return new DrawDonateDetailRel(this);
        }
    }
}