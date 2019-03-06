package com.oaec.entity;

import java.util.Date;
import java.util.List;

/**
 *  ��Ʒ
 */
public class Product {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ��Ʒ����
	 */
	private String 	name;
	/**
	 * �۸�
	 */
	private String price;
	/**
	 * �г��۸�
	 */
	private String market_price;
	/**
	 * �ɱ���
	 */
	private String cost_price;
	/**
	 * ��Ʒ����
	 */
	private String integral;
	/**
	 * ����״̬���¼�,�ϼ�,Ԥ�ۣ�
	 */
	private String status;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * Ʒ��
	 */
	private String brand;
	/**
	 * �����
	 */
	private String category_id;
	/**
	 * ���ͱ��
	 */
	private String type_id;
	/**
	 * ��Ʒ�ͺ�
	 */
	private String marque;
	/**
	 * ����
	 */
	private String func;
	/**
	 * ѡ���ȵ�
	 */
	private String hotSpots;
	/**
	 * ��������
	 */
	private String kitApp;
	/**
	 * ͼƬ
	 */
	private String imgUrl;
	/**
	 * �û�ID���ò�Ʒ�����ĸ��̼ң�
	 */
	private String user_id;
	/**
	 * ��Ʒ����
	 */
	private String content;
	/*
	 * �û��ǳ�
	 */
	private String nickName;
	
	/**
	 * ��Ʒ״̬
	 */
	private String productStatus;
	
	/**
	 * ��������
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
