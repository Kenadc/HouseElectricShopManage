package com.oaec.entity;
/**
 * �ջ���ַ 
 */
public class DeliveryAddress {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ����ID
	 */
	private String 	order_id;
	/**
	 * �ջ���ȫ��
	 */
	private String receiver_name;
	/**
	 * �ջ��˵绰
	 */
	private String receiver_phone;
	/**
	 * ʡ��
	 */
	private String receiver_state;
	/**
	 * ����
	 */
	private String receiver_city;
	/**
	 * ��/��
	 */
	private String receiver_district;
	/**
	 * �ջ���ַ
	 */
	private String receiver_address;
	/**
	 * ��������
	 */
	private String receiver_zip;
	/**
	 * ����ʱ��
	 */
	private String created_time;
	/**
	 * ����ʱ��
	 */
	private String updated_time;
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
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public String getReceiver_state() {
		return receiver_state;
	}
	public void setReceiver_state(String receiver_state) {
		this.receiver_state = receiver_state;
	}
	public String getReceiver_city() {
		return receiver_city;
	}
	public void setReceiver_city(String receiver_city) {
		this.receiver_city = receiver_city;
	}
	public String getReceiver_district() {
		return receiver_district;
	}
	public void setReceiver_district(String receiver_district) {
		this.receiver_district = receiver_district;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_zip() {
		return receiver_zip;
	}
	public void setReceiver_zip(String receiver_zip) {
		this.receiver_zip = receiver_zip;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}
	@Override
	public String toString() {
		return "DeliveryAddress [id=" + id + ", order_id=" + order_id + ", receiver_name=" + receiver_name
				+ ", receiver_phone=" + receiver_phone + ", receiver_state=" + receiver_state + ", receiver_city="
				+ receiver_city + ", receiver_district=" + receiver_district + ", receiver_address=" + receiver_address
				+ ", receiver_zip=" + receiver_zip + ", created_time=" + created_time + ", updated_time=" + updated_time
				+ "]";
	}

}
