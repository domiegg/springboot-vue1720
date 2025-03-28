package com.entity.vo;

import com.entity.YewurenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 业务人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yewurenyuan")
public class YewurenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 业务人员姓名
     */

    @TableField(value = "yewurenyuan_name")
    private String yewurenyuanName;


    /**
     * 业务人员手机号
     */

    @TableField(value = "yewurenyuan_phone")
    private String yewurenyuanPhone;


    /**
     * 业务人员身份证号
     */

    @TableField(value = "yewurenyuan_id_number")
    private String yewurenyuanIdNumber;


    /**
     * 业务人员头像
     */

    @TableField(value = "yewurenyuan_photo")
    private String yewurenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 余额
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 业务人员邮箱
     */

    @TableField(value = "yewurenyuan_email")
    private String yewurenyuanEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：业务人员姓名
	 */
    public String getYewurenyuanName() {
        return yewurenyuanName;
    }


    /**
	 * 获取：业务人员姓名
	 */

    public void setYewurenyuanName(String yewurenyuanName) {
        this.yewurenyuanName = yewurenyuanName;
    }
    /**
	 * 设置：业务人员手机号
	 */
    public String getYewurenyuanPhone() {
        return yewurenyuanPhone;
    }


    /**
	 * 获取：业务人员手机号
	 */

    public void setYewurenyuanPhone(String yewurenyuanPhone) {
        this.yewurenyuanPhone = yewurenyuanPhone;
    }
    /**
	 * 设置：业务人员身份证号
	 */
    public String getYewurenyuanIdNumber() {
        return yewurenyuanIdNumber;
    }


    /**
	 * 获取：业务人员身份证号
	 */

    public void setYewurenyuanIdNumber(String yewurenyuanIdNumber) {
        this.yewurenyuanIdNumber = yewurenyuanIdNumber;
    }
    /**
	 * 设置：业务人员头像
	 */
    public String getYewurenyuanPhoto() {
        return yewurenyuanPhoto;
    }


    /**
	 * 获取：业务人员头像
	 */

    public void setYewurenyuanPhoto(String yewurenyuanPhoto) {
        this.yewurenyuanPhoto = yewurenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：余额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：业务人员邮箱
	 */
    public String getYewurenyuanEmail() {
        return yewurenyuanEmail;
    }


    /**
	 * 获取：业务人员邮箱
	 */

    public void setYewurenyuanEmail(String yewurenyuanEmail) {
        this.yewurenyuanEmail = yewurenyuanEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
