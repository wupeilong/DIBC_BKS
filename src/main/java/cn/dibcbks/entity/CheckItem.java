package cn.dibcbks.entity;

import java.io.Serializable;

/**
 * 检查项目信息表
 * @author Administrator
 *
 */
public class CheckItem implements Serializable {
	/**
	 * 序列化版本ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键ID
	private String item;//检查项目
	private String content;//检查内容
	public CheckItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckItem(Integer id, String item, String content) {
		super();
		this.id = id;
		this.item = item;
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CheckItem [id=" + id + ", item=" + item + ", content=" + content + "]";
	}
	
}
