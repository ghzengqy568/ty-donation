package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "DrawRecordFlow", description = "领取记录流水")
public class DrawRecordFlow implements Serializable {

    /**
     * column-name:id
     * 领取记录流水ID
     */
    @Schema(description = "领取记录流水ID")
    private Long id;

    /**
     * column-name:donatory_id
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private Long donatoryId;

    /**
     * column-name:draw_time
     * 领取时间
     */
    @Schema(description = "领取时间")
    private Date drawTime;

    /**
     * column-name:cert_code
     * 证书编码
     */
    @Schema(description = "证书编码")
    private String certCode;

    /**
     * column-name:sign
     * 存证签名
     */
    @Schema(description = "存证签名")
    private String sign;

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
     * 领取记录流水
     */
    public DrawRecordFlow() {
        
    }

    /**
     * 领取记录流水
     */
    private DrawRecordFlow(XBuilder builder) {
        this.id = builder.id;
        this.donatoryId = builder.donatoryId;
        this.drawTime = builder.drawTime;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 领取记录流水ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 领取记录流水ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 受赠人ID
     */
    public Long getDonatoryId() {
        return donatoryId;
    }

    /**
     * 受赠人ID
     */
    public void setDonatoryId(Long donatoryId) {
        this.donatoryId = donatoryId;
    }

    /**
     * 领取时间
     */
    public Date getDrawTime() {
        return drawTime;
    }

    /**
     * 领取时间
     */
    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    /**
     * 证书编码
     */
    public String getCertCode() {
        return certCode;
    }

    /**
     * 证书编码
     */
    public void setCertCode(String certCode) {
        this.certCode = certCode == null ? null : certCode.trim();
    }

    /**
     * 存证签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 存证签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
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

    public DrawRecordFlow copyFrom(DrawRecordFlow other) {
        this.id = other.id;
        this.donatoryId = other.donatoryId;
        this.drawTime = other.drawTime;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends DrawRecordFlow> T copyFrom(DrawRecordFlow from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setDonatoryId(from.donatoryId);
        to.setDrawTime(from.drawTime);
        to.setCertCode(from.certCode);
        to.setSign(from.sign);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            donatoryId: '',
            drawTime: '',
            certCode: '',
            sign: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"donatoryId\": \"\",\"drawTime\": \"\",\"certCode\": \"\",\"sign\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", donatoryId=").append(donatoryId);
        sb.append(", drawTime=").append(drawTime);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 领取记录流水ID
         */
        private Long id;

        /**
         * 受赠人ID
         */
        private Long donatoryId;

        /**
         * 领取时间
         */
        private Date drawTime;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 存证签名
         */
        private String sign;

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
         * 领取记录流水ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 受赠人ID
         */
        public XBuilder donatoryId(Long donatoryId) {
            this.donatoryId = donatoryId;
            return this;
        }

        /**
         * 领取时间
         */
        public XBuilder drawTime(Date drawTime) {
            this.drawTime = drawTime;
            return this;
        }

        /**
         * 证书编码
         */
        public XBuilder certCode(String certCode) {
            this.certCode = certCode;
            return this;
        }

        /**
         * 存证签名
         */
        public XBuilder sign(String sign) {
            this.sign = sign;
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

        public DrawRecordFlow build() {
            return new DrawRecordFlow(this);
        }
    }
}