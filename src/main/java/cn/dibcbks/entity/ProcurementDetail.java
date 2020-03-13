package cn.dibcbks.entity;

import java.io.Serializable;
import java.util.Date;

public class ProcurementDetail implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private String procurementId;//采购信息ID
	private String productName;//商品名字
	private String count;//数量
	private Date productionDate;//生产日期
	private Integer qualified;//是否合格：0-否 1-是
	public ProcurementDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProcurementDetail(String procurementId, String productName, String count, Date productionDate,
			Integer qualified) {
		super();
		this.procurementId = procurementId;
		this.productName = productName;
		this.count = count;
		this.productionDate = productionDate;
		this.qualified = qualified;
	}
	public String getProcurementId() {
		return procurementId;
	}
	public void setProcurementId(String procurementId) {
		this.procurementId = procurementId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public Integer getQualified() {
		return qualified;
	}
	public void setQualified(Integer qualified) {
		this.qualified = qualified;
	}
	@Override
	public String toString() {
		return "ProcurementDetail [procurementId=" + procurementId + ", productName=" + productName + ", count=" + count
				+ ", productionDate=" + productionDate + ", qualified=" + qualified + "]";
	}
	
	
}
