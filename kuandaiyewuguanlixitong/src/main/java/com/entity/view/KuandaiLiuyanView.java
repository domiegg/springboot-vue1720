package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.KuandaiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 宽带留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("kuandai_liuyan")
public class KuandaiLiuyanView extends KuandaiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 宽带
		/**
		* 宽带名称
		*/

		@ColumnInfo(comment="宽带名称",type="varchar(200)")
		private String kuandaiName;
		/**
		* 宽带编号
		*/

		@ColumnInfo(comment="宽带编号",type="varchar(200)")
		private String kuandaiUuidNumber;
		/**
		* 宽带照片
		*/

		@ColumnInfo(comment="宽带照片",type="varchar(200)")
		private String kuandaiPhoto;
		/**
		* 宽带类型
		*/
		@ColumnInfo(comment="宽带类型",type="int(11)")
		private Integer kuandaiTypes;
			/**
			* 宽带类型的值
			*/
			@ColumnInfo(comment="宽带类型的字典表值",type="varchar(200)")
			private String kuandaiValue;
		/**
		* 宽带介绍
		*/

		@ColumnInfo(comment="宽带介绍",type="text")
		private String kuandaiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer kuandaiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public KuandaiLiuyanView() {

	}

	public KuandaiLiuyanView(KuandaiLiuyanEntity kuandaiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, kuandaiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 宽带

		/**
		* 获取： 宽带名称
		*/
		public String getKuandaiName() {
			return kuandaiName;
		}
		/**
		* 设置： 宽带名称
		*/
		public void setKuandaiName(String kuandaiName) {
			this.kuandaiName = kuandaiName;
		}

		/**
		* 获取： 宽带编号
		*/
		public String getKuandaiUuidNumber() {
			return kuandaiUuidNumber;
		}
		/**
		* 设置： 宽带编号
		*/
		public void setKuandaiUuidNumber(String kuandaiUuidNumber) {
			this.kuandaiUuidNumber = kuandaiUuidNumber;
		}

		/**
		* 获取： 宽带照片
		*/
		public String getKuandaiPhoto() {
			return kuandaiPhoto;
		}
		/**
		* 设置： 宽带照片
		*/
		public void setKuandaiPhoto(String kuandaiPhoto) {
			this.kuandaiPhoto = kuandaiPhoto;
		}
		/**
		* 获取： 宽带类型
		*/
		public Integer getKuandaiTypes() {
			return kuandaiTypes;
		}
		/**
		* 设置： 宽带类型
		*/
		public void setKuandaiTypes(Integer kuandaiTypes) {
			this.kuandaiTypes = kuandaiTypes;
		}


			/**
			* 获取： 宽带类型的值
			*/
			public String getKuandaiValue() {
				return kuandaiValue;
			}
			/**
			* 设置： 宽带类型的值
			*/
			public void setKuandaiValue(String kuandaiValue) {
				this.kuandaiValue = kuandaiValue;
			}

		/**
		* 获取： 宽带介绍
		*/
		public String getKuandaiContent() {
			return kuandaiContent;
		}
		/**
		* 设置： 宽带介绍
		*/
		public void setKuandaiContent(String kuandaiContent) {
			this.kuandaiContent = kuandaiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getKuandaiDelete() {
			return kuandaiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setKuandaiDelete(Integer kuandaiDelete) {
			this.kuandaiDelete = kuandaiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "KuandaiLiuyanView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", newMoney=" + newMoney +
			", yonghuEmail=" + yonghuEmail +
			", kuandaiName=" + kuandaiName +
			", kuandaiUuidNumber=" + kuandaiUuidNumber +
			", kuandaiPhoto=" + kuandaiPhoto +
			", kuandaiContent=" + kuandaiContent +
			", kuandaiDelete=" + kuandaiDelete +
			"} " + super.toString();
	}
}
