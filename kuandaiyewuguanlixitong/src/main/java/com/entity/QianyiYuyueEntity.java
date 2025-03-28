package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 迁移申请
 *
 * @author 
 * @email
 */
@TableName("qianyi_yuyue")
public class QianyiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QianyiYuyueEntity() {

	}

	public QianyiYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名唯一编号
     */
    @ColumnInfo(comment="报名唯一编号",type="varchar(200)")
    @TableField(value = "qianyi_yuyue_uuid_number")

    private String qianyiYuyueUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="text")
    @TableField(value = "qianyi_yuyue_text")

    private String qianyiYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "qianyi_yuyue_yesno_types")

    private Integer qianyiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "qianyi_yuyue_yesno_text")

    private String qianyiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "qianyi_yuyue_shenhe_time")

    private Date qianyiYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "QianyiYuyue{" +
            ", id=" + id +
            ", qianyiYuyueUuidNumber=" + qianyiYuyueUuidNumber +
            ", yonghuId=" + yonghuId +
            ", qianyiYuyueText=" + qianyiYuyueText +
            ", qianyiYuyueYesnoTypes=" + qianyiYuyueYesnoTypes +
            ", qianyiYuyueYesnoText=" + qianyiYuyueYesnoText +
            ", qianyiYuyueShenheTime=" + DateUtil.convertString(qianyiYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
