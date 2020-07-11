package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

@Schema(name = "CertificateHash", description = "多链映射记录")
public class CertificateHash implements Serializable {

    /**
     * column-name:id
     * 存证ID
     */
    @Schema(description = "存证ID")
    private Long id;

    /**
     * column-name:cert_code
     * 证书编码
     */
    @Schema(description = "证书编码")
    private String certCode;

    /**
     * column-name:uuid
     * 多链ID身份
     */
    @Schema(description = "多链ID身份")
    private String uuid;

    /**
     * 多链映射记录
     */
    public CertificateHash() {
        
    }

    /**
     * 多链映射记录
     */
    private CertificateHash(XBuilder builder) {
        this.id = builder.id;
        this.certCode = builder.certCode;
        this.uuid = builder.uuid;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 存证ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 存证ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 多链ID身份
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 多链ID身份
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public CertificateHash copyFrom(CertificateHash other) {
        this.id = other.id;
        this.certCode = other.certCode;
        this.uuid = other.uuid;
        return this;
    }

    public static <T extends CertificateHash> T copyFrom(CertificateHash from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setCertCode(from.certCode);
        to.setUuid(from.uuid);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            certCode: '',
            uuid: ''
        }
        */
        
        return "{\"id\": \"\",\"certCode\": \"\",\"uuid\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", certCode=").append(certCode);
        sb.append(", uuid=").append(uuid);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 存证ID
         */
        private Long id;

        /**
         * 证书编码
         */
        private String certCode;

        /**
         * 多链ID身份
         */
        private String uuid;

        private XBuilder() {
            
        }

        /**
         * 存证ID
         */
        public XBuilder id(Long id) {
            this.id = id;
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
         * 多链ID身份
         */
        public XBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public CertificateHash build() {
            return new CertificateHash(this);
        }
    }
}