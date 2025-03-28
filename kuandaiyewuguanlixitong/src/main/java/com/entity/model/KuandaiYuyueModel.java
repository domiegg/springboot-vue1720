package com.entity.model;

import com.entity.KuandaiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宽带预约安装
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KuandaiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宽带
     */
    private Integer kuandaiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 理由
     */
    private String kuandaiYuyueText;


    /**
     * 地点
     */
    private String kuandaiYuyueAddress;


    /**
     * 报名状态
     */
    private Integer kuandaiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String kuandaiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kuandaiYuyueShenheTime;


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
	 * 获取：理由
	 */
    public String getKuandaiYuyueText() {
        return kuandaiYuyueText;
    }


    /**
	 * 设置：理由
	 */
    public void setKuandaiYuyueText(String kuandaiYuyueText) {
        this.kuandaiYuyueText = kuandaiYuyueText;
    }
    /**
	 * 获取：地点
	 */
    public String getKuandaiYuyueAddress() {
        return kuandaiYuyueAddress;
    }


    /**
	 * 设置：地点
	 */
    public void setKuandaiYuyueAddress(String kuandaiYuyueAddress) {
        this.kuandaiYuyueAddress = kuandaiYuyueAddress;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getKuandaiYuyueYesnoTypes() {
        return kuandaiYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setKuandaiYuyueYesnoTypes(Integer kuandaiYuyueYesnoTypes) {
        this.kuandaiYuyueYesnoTypes = kuandaiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getKuandaiYuyueYesnoText() {
        return kuandaiYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setKuandaiYuyueYesnoText(String kuandaiYuyueYesnoText) {
        this.kuandaiYuyueYesnoText = kuandaiYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getKuandaiYuyueShenheTime() {
        return kuandaiYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setKuandaiYuyueShenheTime(Date kuandaiYuyueShenheTime) {
        this.kuandaiYuyueShenheTime = kuandaiYuyueShenheTime;
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
