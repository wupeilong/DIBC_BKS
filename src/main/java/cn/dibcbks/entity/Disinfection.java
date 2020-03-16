package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 清洗消毒信息表
 * @author Administrator
 *
 */
public class Disinfection implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9081659886805268936L;
	private Integer id;//主键ID
	private String dailyTime;//清洗消毒日期
	private Integer unitId;//清洗消毒单位
	private String unitName;//消毒人员
	private Integer userId;//消毒人员ID
	private String username;//消毒人员		
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private String result;//清洗消毒图片
	private String disinfectionPhoto;//清洗消毒图片
	private Date createTime;//创建时间
	public Disinfection() {
		super();
	}
	public Disinfection(Integer id, String dailyTime, Integer unitId, String unitName, Integer userId, String username,
			Date startTime, Date endTime, String result, String disinfectionPhoto, Date createTime) {
		super();
		this.id = id;
		this.dailyTime = dailyTime;
		this.unitId = unitId;
		this.unitName = unitName;
		this.userId = userId;
		this.username = username;
		this.startTime = startTime;
		this.endTime = endTime;
		this.result = result;
		this.disinfectionPhoto = disinfectionPhoto;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDisinfectionPhoto() {
		return disinfectionPhoto;
	}
	public void setDisinfectionPhoto(String disinfectionPhoto) {
		this.disinfectionPhoto = disinfectionPhoto;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Disinfection [id=" + id + ", dailyTime=" + dailyTime + ", unitId=" + unitId + ", unitName=" + unitName
				+ ", userId=" + userId + ", username=" + username + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", result=" + result + ", disinfectionPhoto=" + disinfectionPhoto + ", createTime=" + createTime
				+ "]";
	}
	
}
