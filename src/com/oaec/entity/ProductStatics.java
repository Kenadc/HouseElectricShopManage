package com.oaec.entity;

import java.util.Date;

/**
 * 数据统计
 */
public class ProductStatics {
	/**
	 * id主键
	 */
	private String id;
	/**
	 * 商品id
	 */
	private String 	product_id;
	/**
	 * 浏览次数  默认0次
	 */
	private Integer visit_count;
	/**
	 * 评论次数  默认0次
	 */
	private Integer reply_count;
	/**
	 * 销售总量  默认0
	 */
	private Integer sale_quantity;
	/**
	 * 销售总额 默认0
	 */
	private Double sale_amount;
	/**
	 * 进货总量
	 */
	private Integer purchase_quantity;
	/**
	 * 进货总额
	 */
	private Double purchase_amount;
	/**
	 * 成本均价
	 */
	private Double cost_price;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用来存放计算天数的
	 */
	private Integer dayNum;
	
	/**
	 * 用来存放X坐标上的日期
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
