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
 * 宽带预约安装
 *
 * @author 
 * @email
 */
@TableName("kuandai_yuyue")
public class KuandaiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuandaiYuyueEntity() {

	}

	public KuandaiYuyueEntity(T t) {
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
     * 宽带
     */
    @ColumnInfo(comment="宽带",type="int(11)")
    @TableField(value = "kuandai_id")

    private Integer kuandaiId;


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
    @TableField(value = "kuandai_yuyue_text")

    private String kuandaiYuyueText;


    /**
     * 地点
     */
    @ColumnInfo(comment="地点",type="varchar(200)")
    @TableField(value = "kuandai_yuyue_address")

    private String kuandaiYuyueAddress;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "kuandai_yuyue_yesno_types")

    private Integer kuandaiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "kuandai_yuyue_yesno_text")

    private String kuandaiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "kuandai_yuyue_shenhe_time")

    private Date kuandaiYuyueShenheTime;


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
        return "KuandaiYuyue{" +
            ", id=" + id +
            ", kuandaiId=" + kuandaiId +
            ", yonghuId=" + yonghuId +
            ", kuandaiYuyueText=" + kuandaiYuyueText +
            ", kuandaiYuyueAddress=" + kuandaiYuyueAddress +
            ", kuandaiYuyueYesnoTypes=" + kuandaiYuyueYesnoTypes +
            ", kuandaiYuyueYesnoText=" + kuandaiYuyueYesnoText +
            ", kuandaiYuyueShenheTime=" + DateUtil.convertString(kuandaiYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
