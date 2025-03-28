package com.entity.vo;

import com.entity.KuandaiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宽带开户
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kuandai_order")
public class KuandaiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "kuandai_order_uuid_number")
    private String kuandaiOrderUuidNumber;


    /**
     * 宽带
     */

    @TableField(value = "kuandai_id")
    private Integer kuandaiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 订单类型
     */

    @TableField(value = "kuandai_order_types")
    private Integer kuandaiOrderTypes;


    /**
     * 订单创建时间
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
	 * 设置：订单编号
	 */
    public String getKuandaiOrderUuidNumber() {
        return kuandaiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setKuandaiOrderUuidNumber(String kuandaiOrderUuidNumber) {
        this.kuandaiOrderUuidNumber = kuandaiOrderUuidNumber;
    }
    /**
	 * 设置：宽带
	 */
    public Integer getKuandaiId() {
        return kuandaiId;
    }


    /**
	 * 获取：宽带
	 */

    public void setKuandaiId(Integer kuandaiId) {
        this.kuandaiId = kuandaiId;
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
	 * 设置：订单类型
	 */
    public Integer getKuandaiOrderTypes() {
        return kuandaiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setKuandaiOrderTypes(Integer kuandaiOrderTypes) {
        this.kuandaiOrderTypes = kuandaiOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
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
