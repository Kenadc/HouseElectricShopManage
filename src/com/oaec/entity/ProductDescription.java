package com.oaec.entity;

/**
 * ��Ʒ����
 */
public class ProductDescription {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ��Ʒid
	 */
	private String 	product_id;
	/**
	 * ��Ʒ���
	 */
	private String code;
	/**
	 * ����
	 */
	private String title;
	/**
	 * ����
	 */
	private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ProductDescription [id=" + id + ", product_id=" + product_id + ", code=" + code + ", title=" + title
				+ ", content=" + content + "]";
	}

}
