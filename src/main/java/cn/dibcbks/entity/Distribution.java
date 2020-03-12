package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 配送信息表
 * @author Administrator
 *
 */
public class Distribution implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private String dailyTime;//当前日期
	private Integer type;//送餐类型：1-早餐 2-午餐 3-晚餐'
	private Integer mealsUnitId;//送餐单位ID
	private Integer mealsUserId;//送餐人
	private Integer acceptanceUnitId;//学校ID
	private Integer acceptanceUserId;//验收人ID
	private String packingPhoto;//送餐装箱图
	private String sealPhoto;//装完箱贴封条图
	private String carPhoto;//送餐车图
	private String openedPhoto;//拆封条取餐图
	private Date startTime;//启送时间
	private Date endTime;//送达时间
	private Date acceptanceTime;//验收时间
	private Integer status;//状态：1-启送中  2-已送达 3-已验收
	private String address;//配送地点
	private Date createTime;//创建时间
	public Distribution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Distribution(Integer id, String dailyTime, Integer type, Integer mealsUnitId, Integer mealsUserId,
			Integer acceptanceUnitId, Integer acceptanceUserId, String packingPhoto, String sealPhoto, String carPhoto,
			String openedPhoto, Date startTime, Date endTime, Date acceptanceTime, Integer status, String address,
			Date createTime) {
		super();
		this.id = id;
		this.dailyTime = dailyTime;
		this.type = type;
		this.mealsUnitId = mealsUnitId;
		this.mealsUserId = mealsUserId;
		this.acceptanceUnitId = acceptanceUnitId;
		this.acceptanceUserId = acceptanceUserId;
		this.packingPhoto = packingPhoto;
		this.sealPhoto = sealPhoto;
		this.carPhoto = carPhoto;
		this.openedPhoto = openedPhoto;
		this.startTime = startTime;
		this.endTime = endTime;
		this.acceptanceTime = acceptanceTime;
		this.status = status;
		this.address = address;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDailyTime() {
		return dailyTime;
	}
	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getMealsUnitId() {
		return mealsUnitId;
	}
	public void setMealsUnitId(Integer mealsUnitId) {
		this.mealsUnitId = mealsUnitId;
	}
	public Integer getMealsUserId() {
		return mealsUserId;
	}
	public void setMealsUserId(Integer mealsUserId) {
		this.mealsUserId = mealsUserId;
	}
	public Integer getAcceptanceUnitId() {
		return acceptanceUnitId;
	}
	public void setAcceptanceUnitId(Integer acceptanceUnitId) {
		this.acceptanceUnitId = acceptanceUnitId;
	}
	public Integer getAcceptanceUserId() {
		return acceptanceUserId;
	}
	public void setAcceptanceUserId(Integer acceptanceUserId) {
		this.acceptanceUserId = acceptanceUserId;
	}
	public String getPackingPhoto() {
		return packingPhoto;
	}
	public void setPackingPhoto(String packingPhoto) {
		this.packingPhoto = packingPhoto;
	}
	public String getSealPhoto() {
		return sealPhoto;
	}
	public void setSealPhoto(String sealPhoto) {
		this.sealPhoto = sealPhoto;
	}
	public String getCarPhoto() {
		return carPhoto;
	}
	public void setCarPhoto(String carPhoto) {
		this.carPhoto = carPhoto;
	}
	public String getOpenedPhoto() {
		return openedPhoto;
	}
	public void setOpenedPhoto(String openedPhoto) {
		this.openedPhoto = openedPhoto;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getAcceptanceTime() {
		return acceptanceTime;
	}
	public void setAcceptanceTime(Date acceptanceTime) {
		this.acceptanceTime = acceptanceTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Distribution [id=" + id + ", dailyTime=" + dailyTime + ", type=" + type + ", mealsUnitId=" + mealsUnitId
				+ ", mealsUserId=" + mealsUserId + ", acceptanceUnitId=" + acceptanceUnitId + ", acceptanceUserId="
				+ acceptanceUserId + ", packingPhoto=" + packingPhoto + ", sealPhoto=" + sealPhoto + ", carPhoto="
				+ carPhoto + ", openedPhoto=" + openedPhoto + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", acceptanceTime=" + acceptanceTime + ", status=" + status + ", address=" + address + ", createTime="
				+ createTime + "]";
	}
	
}
