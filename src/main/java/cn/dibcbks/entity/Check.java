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
	private String unit_name;//检查单位公司
	private String unit_address;//检查单位地址
	private String unit_type;//单位类型：1-大学 2-高职高专 3-中学 4-小学 5-幼儿园 6-餐饮企业
	private String unit_principal;//单位负责人
	private String unit_phone;//联系电话
	private String result;//检查结果
	private String other;//其他需要说明的情况
	private String inspectors;//检查人员
	private String daily_time;//检查日期
	private Integer check_type;//检查类型：1-单位自检 2-市监局专监 3-督查组检查
	private String checkPhoto;//检查图片
	private Date createTime;//创建时间
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Check(Integer id, Integer userId, Integer unitId, String unit_name, String unit_address, String unit_type,
			String unit_principal, String unit_phone, String result, String other, String inspectors, String daily_time,
			Integer check_type, String checkPhoto, Date createTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.unitId = unitId;
		this.unit_name = unit_name;
		this.unit_address = unit_address;
		this.unit_type = unit_type;
		this.unit_principal = unit_principal;
		this.unit_phone = unit_phone;
		this.result = result;
		this.other = other;
		this.inspectors = inspectors;
		this.daily_time = daily_time;
		this.check_type = check_type;
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
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getUnit_address() {
		return unit_address;
	}
	public void setUnit_address(String unit_address) {
		this.unit_address = unit_address;
	}
	public String getUnit_type() {
		return unit_type;
	}
	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}
	public String getUnit_principal() {
		return unit_principal;
	}
	public void setUnit_principal(String unit_principal) {
		this.unit_principal = unit_principal;
	}
	public String getUnit_phone() {
		return unit_phone;
	}
	public void setUnit_phone(String unit_phone) {
		this.unit_phone = unit_phone;
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
	public String getDaily_time() {
		return daily_time;
	}
	public void setDaily_time(String daily_time) {
		this.daily_time = daily_time;
	}
	public Integer getCheck_type() {
		return check_type;
	}
	public void setCheck_type(Integer check_type) {
		this.check_type = check_type;
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
		return "Check [id=" + id + ", userId=" + userId + ", unitId=" + unitId + ", unit_name=" + unit_name
				+ ", unit_address=" + unit_address + ", unit_type=" + unit_type + ", unit_principal=" + unit_principal
				+ ", unit_phone=" + unit_phone + ", result=" + result + ", other=" + other + ", inspectors="
				+ inspectors + ", daily_time=" + daily_time + ", check_type=" + check_type + ", checkPhoto="
				+ checkPhoto + ", createTime=" + createTime + "]";
	}
	 
}
