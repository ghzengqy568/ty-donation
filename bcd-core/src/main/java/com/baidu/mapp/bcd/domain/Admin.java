package com.baidu.mapp.bcd.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.Date;

@Schema(name = "Admin", description = "管理员")
public class Admin implements Serializable {

    /**
     * column-name:id
     * 管理员ID
     */
    @Schema(description = "管理员ID")
    private Long id;

    /**
     * column-name:admin_user_name
     * 管理员用户ID
     */
    @Schema(description = "管理员用户ID")
    private String adminUserName;

    /**
     * column-name:admin_pwd
     * 管理员密码
     */
    @Schema(description = "管理员密码")
    private String adminPwd;

    /**
     * column-name:admin_name
     * 管理员名称
     */
    @Schema(description = "管理员名称")
    private String adminName;

    /**
     * column-name:login_token
     * 登录token
     */
    @Schema(description = "登录token")
    private String loginToken;

    /**
     * column-name:last_login_time
     * 最后一次登录时间
     */
    @Schema(description = "最后一次登录时间")
    private Date lastLoginTime;

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
     * 管理员
     */
    public Admin() {
        
    }

    /**
     * 管理员
     */
    private Admin(XBuilder builder) {
        this.id = builder.id;
        this.adminUserName = builder.adminUserName;
        this.adminPwd = builder.adminPwd;
        this.adminName = builder.adminName;
        this.loginToken = builder.loginToken;
        this.lastLoginTime = builder.lastLoginTime;
        this.createTime = builder.createTime;
        this.lastModifyTime = builder.lastModifyTime;
    }

    public static XBuilder newBuilder() {
        return new XBuilder();
    }

    /**
     * 管理员ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 管理员ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 管理员用户ID
     */
    public String getAdminUserName() {
        return adminUserName;
    }

    /**
     * 管理员用户ID
     */
    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName == null ? null : adminUserName.trim();
    }

    /**
     * 管理员密码
     */
    public String getAdminPwd() {
        return adminPwd;
    }

    /**
     * 管理员密码
     */
    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    /**
     * 管理员名称
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 管理员名称
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    /**
     * 登录token
     */
    public String getLoginToken() {
        return loginToken;
    }

    /**
     * 登录token
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? null : loginToken.trim();
    }

    /**
     * 最后一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

    public Admin copyFrom(Admin other) {
        this.id = other.id;
        this.adminUserName = other.adminUserName;
        this.adminPwd = other.adminPwd;
        this.adminName = other.adminName;
        this.loginToken = other.loginToken;
        this.lastLoginTime = other.lastLoginTime;
        this.createTime = other.createTime;
        this.lastModifyTime = other.lastModifyTime;
        return this;
    }

    public static <T extends Admin> T copyFrom(Admin from, T to) {
        if (to == null){
            throw new RuntimeException("`to` must not be null");
        }
        to.setId(from.id);
        to.setAdminUserName(from.adminUserName);
        to.setAdminPwd(from.adminPwd);
        to.setAdminName(from.adminName);
        to.setLoginToken(from.loginToken);
        to.setLastLoginTime(from.lastLoginTime);
        to.setCreateTime(from.createTime);
        to.setLastModifyTime(from.lastModifyTime);
        return to;
    }

    public static String toEmptyJsonString() {
        /*
        {
            id: '',
            adminUserName: '',
            adminPwd: '',
            adminName: '',
            loginToken: '',
            lastLoginTime: '',
            createTime: '',
            lastModifyTime: ''
        }
        */
        
        return "{\"id\": \"\",\"adminUserName\": \"\",\"adminPwd\": \"\",\"adminName\": \"\",\"loginToken\": \"\",\"lastLoginTime\": \"\",\"createTime\": \"\",\"lastModifyTime\": \"\"}" ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adminUserName=").append(adminUserName);
        sb.append(", adminPwd=").append(adminPwd);
        sb.append(", adminName=").append(adminName);
        sb.append(", loginToken=").append(loginToken);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append("]");
        return sb.toString();
    }

    public static final class XBuilder {

        /**
         * 管理员ID
         */
        private Long id;

        /**
         * 管理员用户ID
         */
        private String adminUserName;

        /**
         * 管理员密码
         */
        private String adminPwd;

        /**
         * 管理员名称
         */
        private String adminName;

        /**
         * 登录token
         */
        private String loginToken;

        /**
         * 最后一次登录时间
         */
        private Date lastLoginTime;

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
         * 管理员ID
         */
        public XBuilder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * 管理员用户ID
         */
        public XBuilder adminUserName(String adminUserName) {
            this.adminUserName = adminUserName;
            return this;
        }

        /**
         * 管理员密码
         */
        public XBuilder adminPwd(String adminPwd) {
            this.adminPwd = adminPwd;
            return this;
        }

        /**
         * 管理员名称
         */
        public XBuilder adminName(String adminName) {
            this.adminName = adminName;
            return this;
        }

        /**
         * 登录token
         */
        public XBuilder loginToken(String loginToken) {
            this.loginToken = loginToken;
            return this;
        }

        /**
         * 最后一次登录时间
         */
        public XBuilder lastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
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

        public Admin build() {
            return new Admin(this);
        }
    }
}