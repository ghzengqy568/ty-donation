package com.baidu.mapp.bcd.domain;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {

    /**
     * column-name:id
     * 活动ID
     */
    private Long id;

    /**
     * column-name:theme
     * 活动主题
     */
    private String theme;

    /**
     * column-name:description
     * 活动描述
     */
    private String description;

    /**
     * column-name:start_time
     * 活动开始时间
     */
    private Date startTime;

    /**
     * column-name:end_time
     * 活动结束时间
     */
    private Date endTime;

    /**
     * column-name:cert_code
     * 证书编码
     */
    private String certCode;

    /**
     * column-name:sign
     * 存证签名
     */
    private String sign;

    /**
     * column-name:status
     * 活动状态， 0-待实施， 1-实施中， 2-实施完成
     */
    private Byte status;

    /**
     * column-name:create_time
     * 创建时间
     */
    private Date createTime;

    /**
     * column-name:last_modify_time
     * 更新时间
     */
    private Date lastModifyTime;

    /**
     * 活动
     */
    public Activity() {
        
    }

    /**
     * 活动
     */
    private Activity(XBuilder builder) {
        this.id = builder.id;
        this.theme = builder.theme;
        this.description = builder.description;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.certCode = builder.certCode;
        this.sign = builder.sign;
        this.status = builder.status;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 活动ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 活动ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 活动主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 活动主题
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * 活动描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 活动描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 活动开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 活动开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 活动结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 活动结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
     * 活动状态， 0-待实施， 1-实施中， 2-实施完成
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 活动状态， 0-待实施， 1-实施中， 2-实施完成
     */
    public void setStatus(Byte status) {
        this.status = status;
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

    public Activity copyFrom(Activity other) {
        this.id = other.id;
        this.theme = other.theme;
        this.description = other.description;
        this.startTime = other.startTime;
        this.endTime = other.endTime;
        this.certCode = other.certCode;
        this.sign = other.sign;
        this.status = other.status;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Activity> T copyFrom(Activity from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setTheme(from.theme);
        to.setDescription(from.description);
        to.setStartTime(from.startTime);
        to.setEndTime(from.endTime);
        to.setCertCode(from.certCode);
        to.setSign(from.sign);
        to.setStatus(from.status);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            theme: '',
            description: '',
            startTime: '',
            endTime: '',
            certCode: '',
            sign: '',
            status: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"theme\": \"\",\"description\": \"\",\"startTime\": \"\",\"endTime\": \"\",\"certCode\": \"\",\"sign\": \"\",\"status\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", theme=").append(theme);
        sb.append(", description=").append(description);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", certCode=").append(certCode);
        sb.append(", sign=").append(sign);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 活动ID
         */
        private Long id;

        /**
         * 活动主题
         */
        private String theme;

        /**
         * 活动描述
         */
        private String description;

        /**
         * 活动开始时间
         */
        private Date startTime;

        /**
         * 活动结束时间
         */
        private Date endTime;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 存证签名
         */
        private String sign;

        /**
         * 活动状态， 0-待实施， 1-实施中， 2-实施完成
         */
        private Byte status;

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
         * 活动ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 活动主题
         */
        public XBuilder theme(String theme) {
            this.theme = theme;
            return this;
        }

        /**
         * 活动描述
         */
        public XBuilder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * 活动开始时间
         */
        public XBuilder startTime(Date startTime) {
            this.startTime = startTime;
            return this;
        }

        /**
         * 活动结束时间
         */
        public XBuilder endTime(Date endTime) {
            this.endTime = endTime;
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
         * 活动状态， 0-待实施， 1-实施中， 2-实施完成
         */
        public XBuilder status(Byte status) {
            this.status = status;
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

        public Activity build() {
            return new Activity(this);
        }
    }
}