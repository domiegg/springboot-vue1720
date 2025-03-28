package com.entity.vo;

import com.entity.KuandaiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宽带预约安装
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kuandai_yuyue")
public class KuandaiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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
     * 理由
     */

    @TableField(value = "kuandai_yuyue_text")
    private String kuandaiYuyueText;


    /**
     * 地点
     */

    @TableField(value = "kuandai_yuyue_address")
    private String kuandaiYuyueAddress;


    /**
     * 报名状态
     */

    @TableField(value = "kuandai_yuyue_yesno_types")
    private Integer kuandaiYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "kuandai_yuyue_yesno_text")
    private String kuandaiYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kuandai_yuyue_shenhe_time")
    private Date kuandaiYuyueShenheTime;


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
	 * 设置：理由
	 */
    public String getKuandaiYuyueText() {
        return kuandaiYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setKuandaiYuyueText(String kuandaiYuyueText) {
        this.kuandaiYuyueText = kuandaiYuyueText;
    }
    /**
	 * 设置：地点
	 */
    public String getKuandaiYuyueAddress() {
        return kuandaiYuyueAddress;
    }


    /**
	 * 获取：地点
	 */

    public void setKuandaiYuyueAddress(String kuandaiYuyueAddress) {
        this.kuandaiYuyueAddress = kuandaiYuyueAddress;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getKuandaiYuyueYesnoTypes() {
        return kuandaiYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setKuandaiYuyueYesnoTypes(Integer kuandaiYuyueYesnoTypes) {
        this.kuandaiYuyueYesnoTypes = kuandaiYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getKuandaiYuyueYesnoText() {
        return kuandaiYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setKuandaiYuyueYesnoText(String kuandaiYuyueYesnoText) {
        this.kuandaiYuyueYesnoText = kuandaiYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getKuandaiYuyueShenheTime() {
        return kuandaiYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setKuandaiYuyueShenheTime(Date kuandaiYuyueShenheTime) {
        this.kuandaiYuyueShenheTime = kuandaiYuyueShenheTime;
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
