package com.entity.vo;

import com.entity.QianyiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 迁移申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qianyi_yuyue")
public class QianyiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "qianyi_yuyue_uuid_number")
    private String qianyiYuyueUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 理由
     */

    @TableField(value = "qianyi_yuyue_text")
    private String qianyiYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "qianyi_yuyue_yesno_types")
    private Integer qianyiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "qianyi_yuyue_yesno_text")
    private String qianyiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "qianyi_yuyue_shenhe_time")
    private Date qianyiYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：报名唯一编号
	 */
    public String getQianyiYuyueUuidNumber() {
        return qianyiYuyueUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setQianyiYuyueUuidNumber(String qianyiYuyueUuidNumber) {
        this.qianyiYuyueUuidNumber = qianyiYuyueUuidNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：理由
	 */
    public String getQianyiYuyueText() {
        return qianyiYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setQianyiYuyueText(String qianyiYuyueText) {
        this.qianyiYuyueText = qianyiYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getQianyiYuyueYesnoTypes() {
        return qianyiYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setQianyiYuyueYesnoTypes(Integer qianyiYuyueYesnoTypes) {
        this.qianyiYuyueYesnoTypes = qianyiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getQianyiYuyueYesnoText() {
        return qianyiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setQianyiYuyueYesnoText(String qianyiYuyueYesnoText) {
        this.qianyiYuyueYesnoText = qianyiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getQianyiYuyueShenheTime() {
        return qianyiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setQianyiYuyueShenheTime(Date qianyiYuyueShenheTime) {
        this.qianyiYuyueShenheTime = qianyiYuyueShenheTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
