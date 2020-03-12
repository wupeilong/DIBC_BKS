package cn.dibcbks.entity;

import java.io.Serializable;

/**
 * 单位信息表
 * @author Administrator
 *
 */
public class Unit implements Serializable {
	 /**
	  * 序列化版本ID
	  */
	 private static final long serialVersionUID = 1L;
	 private Integer uniId;//单位ID
	 private String unitName;//单位/企业/学校名称
	 private String legalPerson;//法人/校长
	 private String businessLicenseCode;//营业执照编码
	 private String businessLicense;//营业执照图片
	 private String productionLicense_code;//生产许可证编码
	 private String productionLicense;//生产许可证图片
	 private String unitAddress;//单位地址
	 private String createTime;//创建时间
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Unit(Integer uniId, String unitName, String legalPerson, String businessLicenseCode, String businessLicense,
			String productionLicense_code, String productionLicense, String unitAddress, String createTime) {
		super();
		this.uniId = uniId;
		this.unitName = unitName;
		this.legalPerson = legalPerson;
		this.businessLicenseCode = businessLicenseCode;
		this.businessLicense = businessLicense;
		this.productionLicense_code = productionLicense_code;
		this.productionLicense = productionLicense;
		this.unitAddress = unitAddress;
		this.createTime = createTime;
	}
	public Integer getUniId() {
		return uniId;
	}
	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getBusinessLicenseCode() {
		return businessLicenseCode;
	}
	public void setBusinessLicenseCode(String businessLicenseCode) {
		this.businessLicenseCode = businessLicenseCode;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getProductionLicense_code() {
		return productionLicense_code;
	}
	public void setProductionLicense_code(String productionLicense_code) {
		this.productionLicense_code = productionLicense_code;
	}
	public String getProductionLicense() {
		return productionLicense;
	}
	public void setProductionLicense(String productionLicense) {
		this.productionLicense = productionLicense;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Unit [uniId=" + uniId + ", unitName=" + unitName + ", legalPerson=" + legalPerson
				+ ", businessLicenseCode=" + businessLicenseCode + ", businessLicense=" + businessLicense
				+ ", productionLicense_code=" + productionLicense_code + ", productionLicense=" + productionLicense
				+ ", unitAddress=" + unitAddress + ", createTime=" + createTime + "]";
	}
	 
	 
}
