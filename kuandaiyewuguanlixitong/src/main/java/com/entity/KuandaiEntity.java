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
 * 宽带
 *
 * @author 
 * @email
 */
@TableName("kuandai")
public class KuandaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuandaiEntity() {

	}

	public KuandaiEntity(T t) {
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
     * 宽带名称
     */
    @ColumnInfo(comment="宽带名称",type="varchar(200)")
    @TableField(value = "kuandai_name")

    private String kuandaiName;


    /**
     * 宽带编号
     */
    @ColumnInfo(comment="宽带编号",type="varchar(200)")
    @TableField(value = "kuandai_uuid_number")

    private String kuandaiUuidNumber;


    /**
     * 宽带照片
     */
    @ColumnInfo(comment="宽带照片",type="varchar(200)")
    @TableField(value = "kuandai_photo")

    private String kuandaiPhoto;


    /**
     * 宽带类型
     */
    @ColumnInfo(comment="宽带类型",type="int(11)")
    @TableField(value = "kuandai_types")

    private Integer kuandaiTypes;


    /**
     * 宽带介绍
     */
    @ColumnInfo(comment="宽带介绍",type="text")
    @TableField(value = "kuandai_content")

    private String kuandaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "kuandai_delete")

    private Integer kuandaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：宽带名称
	 */
    public String getKuandaiName() {
        return kuandaiName;
    }
    /**
	 * 设置：宽带名称
	 */

    public void setKuandaiName(String kuandaiName) {
        this.kuandaiName = kuandaiName;
    }
    /**
	 * 获取：宽带编号
	 */
    public String getKuandaiUuidNumber() {
        return kuandaiUuidNumber;
    }
    /**
	 * 设置：宽带编号
	 */

    public void setKuandaiUuidNumber(String kuandaiUuidNumber) {
        this.kuandaiUuidNumber = kuandaiUuidNumber;
    }
    /**
	 * 获取：宽带照片
	 */
    public String getKuandaiPhoto() {
        return kuandaiPhoto;
    }
    /**
	 * 设置：宽带照片
	 */

    public void setKuandaiPhoto(String kuandaiPhoto) {
        this.kuandaiPhoto = kuandaiPhoto;
    }
    /**
	 * 获取：宽带类型
	 */
    public Integer getKuandaiTypes() {
        return kuandaiTypes;
    }
    /**
	 * 设置：宽带类型
	 */

    public void setKuandaiTypes(Integer kuandaiTypes) {
        this.kuandaiTypes = kuandaiTypes;
    }
    /**
	 * 获取：宽带介绍
	 */
    public String getKuandaiContent() {
        return kuandaiContent;
    }
    /**
	 * 设置：宽带介绍
	 */

    public void setKuandaiContent(String kuandaiContent) {
        this.kuandaiContent = kuandaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKuandaiDelete() {
        return kuandaiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setKuandaiDelete(Integer kuandaiDelete) {
        this.kuandaiDelete = kuandaiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Kuandai{" +
            ", id=" + id +
            ", kuandaiName=" + kuandaiName +
            ", kuandaiUuidNumber=" + kuandaiUuidNumber +
            ", kuandaiPhoto=" + kuandaiPhoto +
            ", kuandaiTypes=" + kuandaiTypes +
            ", kuandaiContent=" + kuandaiContent +
            ", kuandaiDelete=" + kuandaiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
