package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 留样息表样
 * @author Administrator
 *
 */
public class Samples implements Serializable {
		/**
		 * 序列化版本ID
		 */
		private static final long serialVersionUID = 1L;
		private Integer id;//主键ID
		private Integer unitId;//留样单位ID
		private Integer userId;//留样人ID
		private String sampleName;//样品名称
		private Date sampleTime;//留样时间
		private Integer sampleCount;//留样数量
		private String samplePhoto;//样品图片
		private String remark;//备注
		public Samples() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Samples(Integer id, Integer unitId, Integer userId, String sampleName, Date sampleTime,
				Integer sampleCount, String samplePhoto, String remark) {
			super();
			this.id = id;
			this.unitId = unitId;
			this.userId = userId;
			this.sampleName = sampleName;
			this.sampleTime = sampleTime;
			this.sampleCount = sampleCount;
			this.samplePhoto = samplePhoto;
			this.remark = remark;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getUnitId() {
			return unitId;
		}
		public void setUnitId(Integer unitId) {
			this.unitId = unitId;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getSampleName() {
			return sampleName;
		}
		public void setSampleName(String sampleName) {
			this.sampleName = sampleName;
		}
		public Date getSampleTime() {
			return sampleTime;
		}
		public void setSampleTime(Date sampleTime) {
			this.sampleTime = sampleTime;
		}
		public Integer getSampleCount() {
			return sampleCount;
		}
		public void setSampleCount(Integer sampleCount) {
			this.sampleCount = sampleCount;
		}
		public String getSamplePhoto() {
			return samplePhoto;
		}
		public void setSamplePhoto(String samplePhoto) {
			this.samplePhoto = samplePhoto;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		@Override
		public String toString() {
			return "Samples [id=" + id + ", unitId=" + unitId + ", userId=" + userId + ", sampleName=" + sampleName
					+ ", sampleTime=" + sampleTime + ", sampleCount=" + sampleCount + ", samplePhoto=" + samplePhoto
					+ ", remark=" + remark + "]";
		}
		
	  
}
