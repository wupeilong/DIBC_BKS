package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人卫生信息表
 * @author Administrator
 *
 */
public class Hygiene implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer hygieneId;//主键ID
	private Integer userId;//用户ID
	private String username;//用户名字
	private String dailyTime;//当前日期
	private Double celsius;//摄氏度
	private String healthCodePhoto;//健康码图片
	private String fever;//发热
	private String diarrhea;//腹泻
	private String woundsFester;//伤口化脓
	private String hygiene;//个人卫生
	private String other;//其他
	private String remark;//备注
	private Date uploadTime;//上传时间
	public Hygiene() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hygiene(Integer hygieneId, Integer userId, String dailyTime, Double celsius, String healthCodePhoto,
			String fever, String diarrhea, String woundsFester, String hygiene, String other, String remark,
			Date uploadTime) {
		super();
		this.hygieneId = hygieneId;
		this.userId = userId;
		this.dailyTime = dailyTime;
		this.celsius = celsius;
		this.healthCodePhoto = healthCodePhoto;
		this.fever = fever;
		this.diarrhea = diarrhea;
		this.woundsFester = woundsFester;
		this.hygiene = hygiene;
		this.other = other;
		this.remark = remark;
		this.uploadTime = uploadTime;
	}
	public Integer getHygieneId() {
		return hygieneId;
	}
	public void setHygieneId(Integer hygieneId) {
		this.hygieneId = hygieneId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDailyTime() {
		return dailyTime;
	}
	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}
	public Double getCelsius() {
		return celsius;
	}
	public void setCelsius(Double celsius) {
		this.celsius = celsius;
	}
	public String getHealthCodePhoto() {
		return healthCodePhoto;
	}
	public void setHealthCodePhoto(String healthCodePhoto) {
		this.healthCodePhoto = healthCodePhoto;
	}
	public String getFever() {
		return fever;
	}
	public void setFever(String fever) {
		this.fever = fever;
	}
	public String getDiarrhea() {
		return diarrhea;
	}
	public void setDiarrhea(String diarrhea) {
		this.diarrhea = diarrhea;
	}
	public String getWoundsFester() {
		return woundsFester;
	}
	public void setWoundsFester(String woundsFester) {
		this.woundsFester = woundsFester;
	}
	public String getHygiene() {
		return hygiene;
	}
	public void setHygiene(String hygiene) {
		this.hygiene = hygiene;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	@Override
	public String toString() {
		return "Hygiene [hygieneId=" + hygieneId + ", userId=" + userId + ", dailyTime=" + dailyTime + ", celsius="
				+ celsius + ", healthCodePhoto=" + healthCodePhoto + ", fever=" + fever + ", diarrhea=" + diarrhea
				+ ", woundsFester=" + woundsFester + ", hygiene=" + hygiene + ", other=" + other + ", remark=" + remark
				+ ", uploadTime=" + uploadTime + "]";
	}
	
	
}
