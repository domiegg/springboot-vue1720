package com.entity.model;

import com.entity.YewurenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 业务人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YewurenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 业务人员姓名
     */
    private String yewurenyuanName;


    /**
     * 业务人员手机号
     */
    private String yewurenyuanPhone;


    /**
     * 业务人员身份证号
     */
    private String yewurenyuanIdNumber;


    /**
     * 业务人员头像
     */
    private String yewurenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 余额
     */
    private Double newMoney;


    /**
     * 业务人员邮箱
     */
    private String yewurenyuanEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：业务人员姓名
	 */
    public String getYewurenyuanName() {
        return yewurenyuanName;
    }


    /**
	 * 设置：业务人员姓名
	 */
    public void setYewurenyuanName(String yewurenyuanName) {
        this.yewurenyuanName = yewurenyuanName;
    }
    /**
	 * 获取：业务人员手机号
	 */
    public String getYewurenyuanPhone() {
        return yewurenyuanPhone;
    }


    /**
	 * 设置：业务人员手机号
	 */
    public void setYewurenyuanPhone(String yewurenyuanPhone) {
        this.yewurenyuanPhone = yewurenyuanPhone;
    }
    /**
	 * 获取：业务人员身份证号
	 */
    public String getYewurenyuanIdNumber() {
        return yewurenyuanIdNumber;
    }


    /**
	 * 设置：业务人员身份证号
	 */
    public void setYewurenyuanIdNumber(String yewurenyuanIdNumber) {
        this.yewurenyuanIdNumber = yewurenyuanIdNumber;
    }
    /**
	 * 获取：业务人员头像
	 */
    public String getYewurenyuanPhoto() {
        return yewurenyuanPhoto;
    }


    /**
	 * 设置：业务人员头像
	 */
    public void setYewurenyuanPhoto(String yewurenyuanPhoto) {
        this.yewurenyuanPhoto = yewurenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：业务人员邮箱
	 */
    public String getYewurenyuanEmail() {
        return yewurenyuanEmail;
    }


    /**
	 * 设置：业务人员邮箱
	 */
    public void setYewurenyuanEmail(String yewurenyuanEmail) {
        this.yewurenyuanEmail = yewurenyuanEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
