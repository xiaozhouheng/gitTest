package cn.abl.pojo;

import java.io.Serializable;
import java.util.Date;

public class UUser implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String userName;

    private String passWord;

    private String email;

    private Integer status;

    private Integer createUserId;

    private Integer userType;

    private String modularPrivilege;

    private String dataPrivilege;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getModularPrivilege() {
        return modularPrivilege;
    }

    public void setModularPrivilege(String modularPrivilege) {
        this.modularPrivilege = modularPrivilege == null ? null : modularPrivilege.trim();
    }

    public String getDataPrivilege() {
        return dataPrivilege;
    }

    public void setDataPrivilege(String dataPrivilege) {
        this.dataPrivilege = dataPrivilege == null ? null : dataPrivilege.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}