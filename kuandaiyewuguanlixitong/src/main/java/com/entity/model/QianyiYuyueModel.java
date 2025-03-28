package com.entity.model;

import com.entity.QianyiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 迁移申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QianyiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String qianyiYuyueUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 理由
     */
    private String qianyiYuyueText;


    /**
     * 报名状态
     */
    private Integer qianyiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String qianyiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date qianyiYuyueShenheTime;


    /**
     * 活动报名时间
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
	 * 获取：报名唯一编号
	 */
    public String getQianyiYuyueUuidNumber() {
        return qianyiYuyueUuidNumber;
    }


    /**
	 * 设置：报名唯一编号
	 */
    public void setQianyiYuyueUuidNumber(String qianyiYuyueUuidNumber) {
        this.qianyiYuyueUuidNumber = qianyiYuyueUuidNumber;
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
	 * 获取：理由
	 */
    public String getQianyiYuyueText() {
        return qianyiYuyueText;
    }


    /**
	 * 设置：理由
	 */
    public void setQianyiYuyueText(String qianyiYuyueText) {
        this.qianyiYuyueText = qianyiYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getQianyiYuyueYesnoTypes() {
        return qianyiYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setQianyiYuyueYesnoTypes(Integer qianyiYuyueYesnoTypes) {
        this.qianyiYuyueYesnoTypes = qianyiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getQianyiYuyueYesnoText() {
        return qianyiYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setQianyiYuyueYesnoText(String qianyiYuyueYesnoText) {
        this.qianyiYuyueYesnoText = qianyiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getQianyiYuyueShenheTime() {
        return qianyiYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setQianyiYuyueShenheTime(Date qianyiYuyueShenheTime) {
        this.qianyiYuyueShenheTime = qianyiYuyueShenheTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：活动报名时间
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
