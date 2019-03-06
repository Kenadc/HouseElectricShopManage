package com.oaec.entity;

import java.util.Date;
import java.util.List;

/**
 *  ����
 */
public class Order {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ����ID
	 */
	private String order_id;
	/**
	 * ʵ�����(��ȷ��2λ��)
	 */
	private String payment;
	/**
	 * ֧������
	 */
	private String payment_type;
	/**
	 * �ʷ�(��ȷ��2λ��)
	 */
	private String post_free;
	/**
	 * ����״̬(123456)
	 */
	private String type;
	/**
	 * ��������ʱ��
	 */
	private Date create_time;
	/**
	 * ��������ʱ��
	 */
	private Date update_time;
	/**
	 * ����ʱ��
	 */
	private Date payment_time;
	/**
	 * ����ʱ��
	 */
	private Date consign_time;
	/**
	 * �������ʱ��
	 */
	private Date end_time;
	/**
	 * ���׹ر�ʱ��
	 */
	private Date close_time;
	/**
	 * ��������
	 */
	private String shipping_name;
	/**
	 * ��������
	 */
	private String shipping_code;
	/**
	 * �������
	 */
	private String buyer_message;
	/**
	 * ����Ƿ�����
	 */
	private String buyer_rate;
	/**
	 * �û�id
	 */
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getPost_free() {
		return post_free;
	}
	public void setPost_free(String post_free) {
		this.post_free = post_free;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public Date getConsign_time() {
		return consign_time;
	}
	public void setConsign_time(Date consign_time) {
		this.consign_time = consign_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}
	public String getShipping_name() {
		return shipping_name;
	}
	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}
	public String getShipping_code() {
		return shipping_code;
	}
	public void setShipping_code(String shipping_code) {
		this.shipping_code = shipping_code;
	}
	public String getBuyer_message() {
		return buyer_message;
	}
	public void setBuyer_message(String buyer_message) {
		this.buyer_message = buyer_message;
	}
	public String getBuyer_rate() {
		return buyer_rate;
	}
	public void setBuyer_rate(String buyer_rate) {
		this.buyer_rate = buyer_rate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_id=" + order_id + ", payment=" + payment + ", payment_type=" + payment_type
				+ ", post_free=" + post_free + ", type=" + type + ", create_time=" + create_time + ", update_time="
				+ update_time + ", payment_time=" + payment_time + ", consign_time=" + consign_time + ", end_time="
				+ end_time + ", close_time=" + close_time + ", shipping_name=" + shipping_name + ", shipping_code="
				+ shipping_code + ", buyer_message=" + buyer_message + ", buyer_rate=" + buyer_rate + ", user_id="
				+ user_id + "]";
	}

}