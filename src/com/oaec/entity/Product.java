package com.oaec.entity;

import java.util.Date;
import java.util.List;

/**
 *  商品
 */
public class Product {
	/**
	 * id主键
	 */
	private String id;
	/**
	 * 商品名称
	 */
	private String 	name;
	/**
	 * 价格
	 */
	private String price;
	/**
	 * 市场价格
	 */
	private String market_price;
	/**
	 * 成本价
	 */
	private String cost_price;
	/**
	 * 商品积分
	 */
	private String integral;
	/**
	 * 货架状态（下架,上架,预售）
	 */
	private String status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 品牌
	 */
	private String brand;
	/**
	 * 类别编号
	 */
	private String category_id;
	/**
	 * 类型编号
	 */
	private String type_id;
	/**
	 * 商品型号
	 */
	private String marque;
	/**
	 * 功能
	 */
	private String func;
	/**
	 * 选购热点
	 */
	private String hotSpots;
	/**
	 * 厨房电器
	 */
	private String kitApp;
	/**
	 * 图片
	 */
	private String imgUrl;
	/**
	 * 用户ID（该产品属于哪个商家）
	 */
	private String user_id;
	/**
	 * 商品描述
	 */
	private String content;
	/*
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 商品状态
	 */
	private String productStatus;
	
	/**
	 * 进货总量
	 */
	private String purchase_quantity;
	
	
	public String getPurchase_quantity() {
		return purchase_quantity;
	}
	public void setPurchase_quantity(String purchase_quantity) {
		this.purchase_quantity = purchase_quantity;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private List<ProductPhotos> productPhotosList;
	
	
	public List<ProductPhotos> getProductPhotosList() {
		return productPhotosList;
	}
	public void setProductPhotosList(List<ProductPhotos> productPhotosList) {
		this.productPhotosList = productPhotosList;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getHotSpots() {
		return hotSpots;
	}
	public void setHotSpots(String hotSpots) {
		this.hotSpots = hotSpots;
	}
	public String getKitApp() {
		return kitApp;
	}
	public void setKitApp(String kitApp) {
		this.kitApp = kitApp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public String getCost_price() {
		return cost_price;
	}
	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	public String getIntegral() {
		return integral;
	}
	public void setIntegral(String integral) {
		this.integral = integral;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", market_price=" + market_price
				+ ", cost_price=" + cost_price + ", integral=" + integral + ", status=" + status + ", createTime="
				+ createTime + ", brand=" + brand + ", category_id=" + category_id + ", type_id=" + type_id
				+ ", marque=" + marque + ", func=" + func + ", hotSpots=" + hotSpots + ", kitApp=" + kitApp
				+ ", imgUrl=" + imgUrl + ", user_id=" + user_id + ", content=" + content + ", nickName=" + nickName
				+ ", productStatus=" + productStatus + ", productPhotosList=" + productPhotosList + "]";
	}
	
}
