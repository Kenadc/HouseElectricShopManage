package com.oaec.entity;

import java.io.Serializable;
import java.util.Date;

/**
  *  �û���
 */
public class User{
	/**
	 * id  ����
	 */
	private String id;
	/**
	 * �ǳ�
	 */
	private String nickName;
	/**
	 * ����
	 */
	private String password;
	/**
	 * �Ա�
	 */
	private String sex;
	/**
	 * �û�����
	 */
	private String userType;
	/**
	 * ����
	 */
	private Date birthday;
	/**
	 * ���֤
	 */
	private String idCard;
	/**
	 * ��ʵ����
	 */
	private String realName;
	/**
	 * ����ID
	 */
	private String constellaId;
	/**
	 * ��ס��ַ
	 */
	private String liveAddress;
	/**
	 * �����ַ
	 */
	private String homeAddress;
	/**
	 * ͷ���ַ
	 */
	private String headUrl;
	/**
	 * ����ID
	 */
	private String hobbyId;
	/**
	 * �ֻ���
	 */
	private String tel;
	/**
	 * ����
	 */
	private String email;
	/**
	 * ��֤��
	 */
	private String kaptchaValidate;
	/**
	 * ���״̬��(1ͨ����2��ͨ��)
	 */
	private String reserveType;
	
	/**
	 * ��˽��
	 */
	private String reserveResult;
	
	/**
	 * �û�״̬
	 */
	private String userStatus;
	
	//���ܼ���1-3,2-5
	private String goodsLevel;

	//����״̬Ĭ��0;   1--->���ܴ�������״̬
	private String goodsStatus;
	
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsLevel() {
		return goodsLevel;
	}
	public void setGoodsLevel(String goodsLevel) {
		this.goodsLevel = goodsLevel;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getReserveResult() {
		return reserveResult;
	}
	public void setReserveResult(String reserveResult) {
		this.reserveResult = reserveResult;
	}
	public String getReserveType() {
		return reserveType;
	}
	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}
	public String getKaptchaValidate() {
		return kaptchaValidate;
	}
	public void setKaptchaValidate(String kaptchaValidate) {
		this.kaptchaValidate = kaptchaValidate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getConstellaId() {
		return constellaId;
	}
	public void setConstellaId(String constellaId) {
		this.constellaId = constellaId;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHeadUrl() {
		return headUrl;
	}
	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}
	public String getHobbyId() {
		return hobbyId;
	}
	public void setHobbyId(String hobbyId) {
		this.hobbyId = hobbyId;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", password=" + password + ", sex=" + sex + ", userType="
				+ userType + ", birthday=" + birthday + ", idCard=" + idCard + ", realName=" + realName
				+ ", constellaId=" + constellaId + ", liveAddress=" + liveAddress + ", homeAddress=" + homeAddress
				+ ", headUrl=" + headUrl + ", hobbyId=" + hobbyId + ", tel=" + tel + ", email=" + email
				+ ", kaptchaValidate=" + kaptchaValidate + ", reserveType=" + reserveType + ", reserveResult="
				+ reserveResult + ", userStatus=" + userStatus + ", goodsLevel=" + goodsLevel + ", goodsStatus="
				+ goodsStatus + "]";
	}
}
