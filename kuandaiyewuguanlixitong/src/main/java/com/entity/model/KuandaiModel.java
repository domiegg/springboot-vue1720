package com.entity.model;

import com.entity.KuandaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宽带
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KuandaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宽带名称
     */
    private String kuandaiName;


    /**
     * 宽带编号
     */
    private String kuandaiUuidNumber;


    /**
     * 宽带照片
     */
    private String kuandaiPhoto;


    /**
     * 宽带类型
     */
    private Integer kuandaiTypes;


    /**
     * 宽带介绍
     */
    private String kuandaiContent;


    /**
     * 逻辑删除
     */
    private Integer kuandaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
