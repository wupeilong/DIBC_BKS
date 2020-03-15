package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 采购信息表
 * @author Administrator
 *
 */
public class Procurement implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private Integer unitId;//采购单位ID
	private String unitName;//采购
	private Integer userId;//采购员ID
	private String username;//采购员
	private String supplier;//供应商
	private String supplierBusinessLicense;//供应商营业执照
	private String supplierProductionLicense;//食品经营许可证
	private String supplierQualification;//供应商资质
	private String supplierPerson;//供货人
	private String supplierPhone;//联系电话
	private Integer acceptanceUserId;//验收人ID
	private String acceptanceUsername;//验收人
	private String invoice;//发票
	private Date purchasingTime;//进货时间
	private Date acceptanceTime;//验收时间
	private Integer status;//状态：0-未验收 1-已验收 
	private List<ProcurementDetail> detailList;
	public Procurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Procurement(Integer id, Integer unitId, String unitName, Integer userId, String username, String supplier,
			String supplierBusinessLicense, String supplierProductionLicense, String supplierQualification,
			String supplierPerson, String supplierPhone, Integer acceptanceUserId, String acceptanceUsername,
			String invoice, Date purchasingTime, Date acceptanceTime, Integer status,
			List<ProcurementDetail> detailList) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.unitName = unitName;
		this.userId = userId;
		this.username = username;
		this.supplier = supplier;
		this.supplierBusinessLicense = supplierBusinessLicense;
		this.supplierProductionLicense = supplierProductionLicense;
		this.supplierQualification = supplierQualification;
		this.supplierPerson = supplierPerson;
		this.supplierPhone = supplierPhone;
		this.acceptanceUserId = acceptanceUserId;
		this.acceptanceUsername = acceptanceUsername;
		this.invoice = invoice;
		this.purchasingTime = purchasingTime;
		this.acceptanceTime = acceptanceTime;
		this.status = status;
		this.detailList = detailList;
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
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getSupplierBusinessLicense() {
		return supplierBusinessLicense;
	}
	public void setSupplierBusinessLicense(String supplierBusinessLicense) {
		this.supplierBusinessLicense = supplierBusinessLicense;
	}
	public String getSupplierProductionLicense() {
		return supplierProductionLicense;
	}
	public void setSupplierProductionLicense(String supplierProductionLicense) {
		this.supplierProductionLicense = supplierProductionLicense;
	}
	public String getSupplierQualification() {
		return supplierQualification;
	}
	public void setSupplierQualification(String supplierQualification) {
		this.supplierQualification = supplierQualification;
	}
	public String getSupplierPerson() {
		return supplierPerson;
	}
	public void setSupplierPerson(String supplierPerson) {
		this.supplierPerson = supplierPerson;
	}
	public String getSupplierPhone() {
		return supplierPhone;
	}
	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	public Integer getAcceptanceUserId() {
		return acceptanceUserId;
	}
	public void setAcceptanceUserId(Integer acceptanceUserId) {
		this.acceptanceUserId = acceptanceUserId;
	}
	public String getAcceptanceUsername() {
		return acceptanceUsername;
	}
	public void setAcceptanceUsername(String acceptanceUsername) {
		this.acceptanceUsername = acceptanceUsername;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public Date getPurchasingTime() {
		return purchasingTime;
	}
	public void setPurchasingTime(Date purchasingTime) {
		this.purchasingTime = purchasingTime;
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
	public List<ProcurementDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<ProcurementDetail> detailList) {
		this.detailList = detailList;
	}
	@Override
	public String toString() {
		return "Procurement [id=" + id + ", unitId=" + unitId + ", unitName=" + unitName + ", userId=" + userId
				+ ", username=" + username + ", supplier=" + supplier + ", supplierBusinessLicense="
				+ supplierBusinessLicense + ", supplierProductionLicense=" + supplierProductionLicense
				+ ", supplierQualification=" + supplierQualification + ", supplierPerson=" + supplierPerson
				+ ", supplierPhone=" + supplierPhone + ", acceptanceUserId=" + acceptanceUserId
				+ ", acceptanceUsername=" + acceptanceUsername + ", invoice=" + invoice + ", purchasingTime="
				+ purchasingTime + ", acceptanceTime=" + acceptanceTime + ", status=" + status + ", detailList="
				+ detailList + "]";
	}
	
	
}
