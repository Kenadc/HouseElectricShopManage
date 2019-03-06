package com.oaec.entity;

import java.util.Date;

/**
 * ����ͳ��
 */
public class ProductStatics {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ��Ʒid
	 */
	private String 	product_id;
	/**
	 * �������  Ĭ��0��
	 */
	private Integer visit_count;
	/**
	 * ���۴���  Ĭ��0��
	 */
	private Integer reply_count;
	/**
	 * ��������  Ĭ��0
	 */
	private Integer sale_quantity;
	/**
	 * �����ܶ� Ĭ��0
	 */
	private Double sale_amount;
	/**
	 * ��������
	 */
	private Integer purchase_quantity;
	/**
	 * �����ܶ�
	 */
	private Double purchase_amount;
	/**
	 * �ɱ�����
	 */
	private Double cost_price;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ������ż���������
	 */
	private Integer dayNum;
	
	/**
	 * �������X�����ϵ�����
	 */
	private String titleNav;
	
	 
	public String getTitleNav() {
		return titleNav;
	}
	public void setTitleNav(String titleNav) {
		this.titleNav = titleNav;
	}
	public Integer getDayNum() {
		return dayNum;
	}
	public void setDayNum(Integer dayNum) {
		this.dayNum = dayNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
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
	public Integer getVisit_count() {
		return visit_count;
	}
	public void setVisit_count(Integer visit_count) {
		this.visit_count = visit_count;
	}
	public Integer getReply_count() {
		return reply_count;
	}
	public void setReply_count(Integer reply_count) {
		this.reply_count = reply_count;
	}
	public Integer getSale_quantity() {
		return sale_quantity;
	}
	public void setSale_quantity(Integer sale_quantity) {
		this.sale_quantity = sale_quantity;
	}
	public Double getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(Double sale_amount) {
		this.sale_amount = sale_amount;
	}
	public Integer getPurchase_quantity() {
		return purchase_quantity;
	}
	public void setPurchase_quantity(Integer purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}
	public Double getPurchase_amount() {
		return purchase_amount;
	}
	public void setPurchase_amount(Double purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	public Double getCost_price() {
		return cost_price;
	}
	public void setCost_price(Double cost_price) {
		this.cost_price = cost_price;
	}
	@Override
	public String toString() {
		return "ProductStatics [id=" + id + ", product_id=" + product_id + ", visit_count=" + visit_count
				+ ", reply_count=" + reply_count + ", sale_quantity=" + sale_quantity + ", sale_amount=" + sale_amount
				+ ", purchase_quantity=" + purchase_quantity + ", purchase_amount=" + purchase_amount + ", cost_price="
				+ cost_price + ", createTime=" + createTime + ", dayNum=" + dayNum + "]";
	}
	
}
