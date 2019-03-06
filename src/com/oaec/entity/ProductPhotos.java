package com.oaec.entity;

import java.util.Date;

/**
 * ���
 */
public class ProductPhotos {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ��Ʒid
	 */
	private String 	product_id;
	/**
	 * ͼƬ��
	 */
	private String name;
	/**
	 * ͼƬurl
	 */
	private String imageUrl;
	/**
	 * ͼƬ����
	 */
	private String intro;
	/**
	 * ״̬    Ĭ��0  ;0���ã�1����
	 */
	private String imgType;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	public ProductPhotos() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductPhotos(String id, String product_id, String name, String imageUrl, String intro, String imgType,
			Date createTime) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.intro = intro;
		this.imgType = imgType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ProductPhotos [id=" + id + ", product_id=" + product_id + ", name=" + name + ", imageUrl=" + imageUrl
				+ ", intro=" + intro + ", imgType=" + imgType + ", createTime=" + createTime + "]";
	}

}
