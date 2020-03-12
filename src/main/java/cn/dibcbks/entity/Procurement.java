package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Integer userId;//采购员ID
	private String productName;//商品名字
	private String specifications;//规格
	private Integer count;//数量
	private String supplier;//供应商
	private String supplierBusinessLicense;//供应商营业执照
	private String supplierProductionLicense;//食品经营许可证
	private String supplierQualification;//供应商资质
	private Date productionDate;//生产日期
	private String productionBatch;//生产批次
	private String supplierPerson;//供货人
	private String supplierPhone;//联系电话
	private Integer acceptanceUserId;//验收人ID
	private String invoice;//发票
	private Date purchasingTime;//进货时间
	private Date acceptanceTime;//验收时间
	private Integer status;//状态：0-未验收 1-合格 2-不合格
	public Procurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Procurement(Integer id, Integer unitId, Integer userId, String productName, String specifications,
			Integer count, String supplier, String supplierBusinessLicense, String supplierProductionLicense,
			String supplierQualification, Date productionDate, String productionBatch, String supplierPerson,
			String supplierPhone, Integer acceptanceUserId, String invoice, Date purchasingTime, Date acceptanceTime,
			Integer status) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.userId = userId;
		this.productName = productName;
		this.specifications = specifications;
		this.count = count;
		this.supplier = supplier;
		this.supplierBusinessLicense = supplierBusinessLicense;
		this.supplierProductionLicense = supplierProductionLicense;
		this.supplierQualification = supplierQualification;
		this.productionDate = productionDate;
		this.productionBatch = productionBatch;
		this.supplierPerson = supplierPerson;
		this.supplierPhone = supplierPhone;
		this.acceptanceUserId = acceptanceUserId;
		this.invoice = invoice;
		this.purchasingTime = purchasingTime;
		this.acceptanceTime = acceptanceTime;
		this.status = status;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public String getProductionBatch() {
		return productionBatch;
	}
	public void setProductionBatch(String productionBatch) {
		this.productionBatch = productionBatch;
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

	@Override
	public String toString() {
		return "Procurement [id=" + id + ", unitId=" + unitId + ", userId=" + userId + ", productName=" + productName
				+ ", specifications=" + specifications + ", count=" + count + ", supplier=" + supplier
				+ ", supplierBusinessLicense=" + supplierBusinessLicense + ", supplierProductionLicense="
				+ supplierProductionLicense + ", supplierQualification=" + supplierQualification + ", productionDate="
				+ productionDate + ", productionBatch=" + productionBatch + ", supplierPerson=" + supplierPerson
				+ ", supplierPhone=" + supplierPhone + ", acceptanceUserId=" + acceptanceUserId + ", invoice=" + invoice
				+ ", purchasingTime=" + purchasingTime + ", acceptanceTime=" + acceptanceTime + ", status=" + status
				+ "]";
	}

	
	
}
