package com.entity.model;

import com.entity.KuandaiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宽带开户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KuandaiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String kuandaiOrderUuidNumber;


    /**
     * 宽带
     */
    private Integer kuandaiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 订单类型
     */
    private Integer kuandaiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：订单编号
	 */
    public String getKuandaiOrderUuidNumber() {
        return kuandaiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setKuandaiOrderUuidNumber(String kuandaiOrderUuidNumber) {
        this.kuandaiOrderUuidNumber = kuandaiOrderUuidNumber;
    }
    /**
	 * 获取：宽带
	 */
    public Integer getKuandaiId() {
        return kuandaiId;
    }


    /**
	 * 设置：宽带
	 */
    public void setKuandaiId(Integer kuandaiId) {
        this.kuandaiId = kuandaiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getKuandaiOrderTypes() {
        return kuandaiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setKuandaiOrderTypes(Integer kuandaiOrderTypes) {
        this.kuandaiOrderTypes = kuandaiOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
