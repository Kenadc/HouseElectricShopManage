package com.oaec.entity;

import java.util.Date;

/**
  * �������� 
 */
public class ProductComment {
	/**
	 * id����
	 */
	private String id;
	/**
	 * ��Ʒid
	 */
	private String 	product_id;
	/**
	 * �û�id
	 */
	private String user_id;
	/**
	 * ���Աid
	 */
	private String auditor_id;
	/**
	 * ��������
	 */
	private String content;
	/**
	 * ״̬(�����,��ʾ,����)  Ĭ����ʾ
	 */
	private String status;
	/**
	 *  ����ʱ��
	 */
	private Date createTime;
	/**
	 * ���ʱ��
	 */
	private Date reserveTime;
	/**
	 * ��˱�ע
	 */
	private String reserveBeizhu;
	/**
	 * ֧������
	 */
	private String support_count;
	/**
	 * ��������
	 */
	private String oppose_count;
	/**
	 * �ٱ�
	 */
	private String report_count;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAuditor_id() {
		return auditor_id;
	}
	public void setAuditor_id(String auditor_id) {
		this.auditor_id = auditor_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	public String getReserveBeizhu() {
		return reserveBeizhu;
	}
	public void setReserveBeizhu(String reserveBeizhu) {
		this.reserveBeizhu = reserveBeizhu;
	}
	public String getSupport_count() {
		return support_count;
	}
	public void setSupport_count(String support_count) {
		this.support_count = support_count;
	}
	public String getOppose_count() {
		return oppose_count;
	}
	public void setOppose_count(String oppose_count) {
		this.oppose_count = oppose_count;
	}
	public String getReport_count() {
		return report_count;
	}
	public void setReport_count(String report_count) {
		this.report_count = report_count;
	}
	@Override
	public String toString() {
		return "ProductComment [id=" + id + ", product_id=" + product_id + ", user_id=" + user_id + ", auditor_id="
				+ auditor_id + ", content=" + content + ", status=" + status + ", createTime=" + createTime
				+ ", reserveTime=" + reserveTime + ", reserveBeizhu=" + reserveBeizhu + ", support_count="
				+ support_count + ", oppose_count=" + oppose_count + ", report_count=" + report_count + "]";
	}
}
