package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 检查信息表
 * @author Administrator
 *
 */
public class Detection implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private Integer userId;//用户ID
	private Integer unitId;//被检查单位ID
	private String unitName;//被检查单位
	private String samplName;//样品名称
	private String specifications;//包装分类/规格
	private String bath;//抽检批次
	private String item;//检查项目
	private String result;//检查结果
	private String remark;//备注
	private String detectionPhoto;//检查图片
	private Date createTime;//创建时间
	public Detection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detection(Integer id, Integer userId, Integer unitId, String unitName, String samplName,
			String specifications, String bath, String item, String result, String remark, String detectionPhoto,
			Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.unitId = unitId;
		this.unitName = unitName;
		this.samplName = samplName;
		this.specifications = specifications;
		this.bath = bath;
		this.item = item;
		this.result = result;
		this.remark = remark;
		this.detectionPhoto = detectionPhoto;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getSamplName() {
		return samplName;
	}
	public void setSamplName(String samplName) {
		this.samplName = samplName;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getBath() {
		return bath;
	}
	public void setBath(String bath) {
		this.bath = bath;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDetectionPhoto() {
		return detectionPhoto;
	}
	public void setDetectionPhoto(String detectionPhoto) {
		this.detectionPhoto = detectionPhoto;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Detection [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", unitName=" + unitName
				+ ", samplName=" + samplName + ", specifications=" + specifications + ", bath=" + bath + ", item="
				+ item + ", result=" + result + ", remark=" + remark + ", detectionPhoto=" + detectionPhoto
				+ ", createTime=" + createTime + "]";
	}
	
}
