package com.entity.vo;

import com.entity.KuandaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宽带
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kuandai")
public class KuandaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宽带名称
     */

    @TableField(value = "kuandai_name")
    private String kuandaiName;


    /**
     * 宽带编号
     */

    @TableField(value = "kuandai_uuid_number")
    private String kuandaiUuidNumber;


    /**
     * 宽带照片
     */

    @TableField(value = "kuandai_photo")
    private String kuandaiPhoto;


    /**
     * 宽带类型
     */

    @TableField(value = "kuandai_types")
    private Integer kuandaiTypes;


    /**
     * 宽带介绍
     */

    @TableField(value = "kuandai_content")
    private String kuandaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "kuandai_delete")
    private Integer kuandaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：宽带名称
	 */
    public String getKuandaiName() {
        return kuandaiName;
    }


    /**
	 * 获取：宽带名称
	 */

    public void setKuandaiName(String kuandaiName) {
        this.kuandaiName = kuandaiName;
    }
    /**
	 * 设置：宽带编号
	 */
    public String getKuandaiUuidNumber() {
        return kuandaiUuidNumber;
    }


    /**
	 * 获取：宽带编号
	 */

    public void setKuandaiUuidNumber(String kuandaiUuidNumber) {
        this.kuandaiUuidNumber = kuandaiUuidNumber;
    }
    /**
	 * 设置：宽带照片
	 */
    public String getKuandaiPhoto() {
        return kuandaiPhoto;
    }


    /**
	 * 获取：宽带照片
	 */

    public void setKuandaiPhoto(String kuandaiPhoto) {
        this.kuandaiPhoto = kuandaiPhoto;
    }
    /**
	 * 设置：宽带类型
	 */
    public Integer getKuandaiTypes() {
        return kuandaiTypes;
    }


    /**
	 * 获取：宽带类型
	 */

    public void setKuandaiTypes(Integer kuandaiTypes) {
        this.kuandaiTypes = kuandaiTypes;
    }
    /**
	 * 设置：宽带介绍
	 */
    public String getKuandaiContent() {
        return kuandaiContent;
    }


    /**
	 * 获取：宽带介绍
	 */

    public void setKuandaiContent(String kuandaiContent) {
        this.kuandaiContent = kuandaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKuandaiDelete() {
        return kuandaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setKuandaiDelete(Integer kuandaiDelete) {
        this.kuandaiDelete = kuandaiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
