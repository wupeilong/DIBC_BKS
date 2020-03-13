package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 检查信息表
 * @author Administrator
 *
 */
public class Check implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private Integer userId;//用户ID
	private Integer unitId;//单位ID
	private String unitName;//检查单位公司
	private String unitAddress;//检查单位地址
	private String unitType;//单位类型
	private String unitPrincipal;//单位负责人
	private String unitPhone;//联系电话
	private String result;//检查结果
	private String other;//其他需要说明的情况
	private String inspectors;//检查人员
	private String dailyTime;//检查日期
	private Integer checkType;//检查类型：1-单位自检 2-市监局专监 3-督查组检查
	private String checkPhoto;//检查图片
	private Date createTime;//创建时间
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Check(Integer id, Integer userId, Integer unitId, String unitName, String unitAddress, String unitType,
			String unitPrincipal, String unitPhone, String result, String other, String inspectors, String dailyTime,
			Integer checkType, String checkPhoto, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.unitId = unitId;
		this.unitName = unitName;
		this.unitAddress = unitAddress;
		this.unitType = unitType;
		this.unitPrincipal = unitPrincipal;
		this.unitPhone = unitPhone;
		this.result = result;
		this.other = other;
		this.inspectors = inspectors;
		this.dailyTime = dailyTime;
		this.checkType = checkType;
		this.checkPhoto = checkPhoto;
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
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getUnitPrincipal() {
		return unitPrincipal;
	}
	public void setUnitPrincipal(String unitPrincipal) {
		this.unitPrincipal = unitPrincipal;
	}
	public String getUnitPhone() {
		return unitPhone;
	}
	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getInspectors() {
		return inspectors;
	}
	public void setInspectors(String inspectors) {
		this.inspectors = inspectors;
	}
	public String getDailyTime() {
		return dailyTime;
	}
	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}
	public Integer getCheckType() {
		return checkType;
	}
	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	public String getCheckPhoto() {
		return checkPhoto;
	}
	public void setCheckPhoto(String checkPhoto) {
		this.checkPhoto = checkPhoto;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Check [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", unitName=" + unitName
				+ ", unitAddress=" + unitAddress + ", unitType=" + unitType + ", unitPrincipal=" + unitPrincipal
				+ ", unitPhone=" + unitPhone + ", result=" + result + ", other=" + other + ", inspectors=" + inspectors
				+ ", dailyTime=" + dailyTime + ", checkType=" + checkType + ", checkPhoto=" + checkPhoto
				+ ", createTime=" + createTime + "]";
	}
	
}
