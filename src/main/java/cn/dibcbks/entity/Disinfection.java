package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 清洗消毒信息表
 * @author Administrator
 *
 */
public class Disinfection implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private String dailyTime;//清洗消毒日期
	private Integer unitId;//清洗消毒单位
	private Integer userId;//消毒人员ID
	private String username;//消毒人员
	private String tools;//工具类
	private String cleaningFacilities;//保洁设施
	private String method;//消毒方法
	private String tablewareType;//餐（饮）具种类
	private Date startTime;//开始时间
	private Date endTime;//结束时间
	private String disinfectionPhoto;//清洗消毒图片
	private Date createTime;//创建时间
	public Disinfection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disinfection(Integer id, String dailyTime, Integer unitId, Integer userId, String username, String tools,
			String cleaningFacilities, String method, String tablewareType, Date startTime, Date endTime,
			String disinfectionPhoto, Date createTime) {
		super();
		this.id = id;
		this.dailyTime = dailyTime;
		this.unitId = unitId;
		this.userId = userId;
		this.username = username;
		this.tools = tools;
		this.cleaningFacilities = cleaningFacilities;
		this.method = method;
		this.tablewareType = tablewareType;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public String getTools() {
		return tools;
	}
	public void setTools(String tools) {
		this.tools = tools;
	}
	public String getCleaningFacilities() {
		return cleaningFacilities;
	}
	public void setCleaningFacilities(String cleaningFacilities) {
		this.cleaningFacilities = cleaningFacilities;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getTablewareType() {
		return tablewareType;
	}
	public void setTablewareType(String tablewareType) {
		this.tablewareType = tablewareType;
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
		return "Disinfection [id=" + id + ", dailyTime=" + dailyTime + ", unitId=" + unitId + ", userId=" + userId
				+ ", username=" + username + ", tools=" + tools + ", cleaningFacilities=" + cleaningFacilities
				+ ", method=" + method + ", tablewareType=" + tablewareType + ", startTime=" + startTime + ", endTime="
				+ endTime + ", disinfectionPhoto=" + disinfectionPhoto + ", createTime=" + createTime + "]";
	}
			  
}
