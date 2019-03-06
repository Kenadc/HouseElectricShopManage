package com.oaec.Mapper;

import java.util.List;
import java.util.Map;

import com.oaec.entity.User;

public interface userMapper {
	// �����ǳƺ������ѯʵ�ֵ�¼
	public User findByOne(User user);

	// �����ǳƲ�ѯ����
	public Integer findByNickName(User user);

	// �����ǳƻ�ȡ����
	public User findByNickNameObj(User user);

	// ��ȡ��������
	public List<User> findList();

	// ��������
	public void insert(User user);

	// �޸�����
	public void update(User user);
	
	//��ҳ��ȡ�û���Ϣ�б�
	public List<Map<String, Object>> findUserInfoPage(Map<String, Object> params);

	//��ҳ��ȡ�����Ϊ���̵��û���Ϣ�б�
	public List<Map<String, Object>> findReserveUserInfoPage(Map<String, Object> params);
	
	//��ѯ�����Ϊ���̵��û���Ϣ����
	public Integer findReserveUserInfoPageCount(User user);
	
	//�û������Ϊ����ʱ�����û�ID����reserveTypeΪ   "1"
	public void updateReserveTypeById(User user);
	
	//�����û�ID������˽��
	public void updateReserveResultById(User user);
	
	//�����û�ID����/���õ�ǰ�û�
	public void updateUserStatusById(User user);
	
	//�����û�ID�����û����ܼ���
	public void updateGoodsLevelById(User user);
	
	//�����������״̬Ϊ��1�� ��ȡ�б�����
	public List<Map<String, Object>> findListByGoodsStatus(Map<String, Object> params);
	
	//�����������״̬Ϊ��1�� ��ȡ��������
	public Integer findCountByGoodsStatus(User user);
	
}
