package com.oaec.Services;

import java.util.List;
import java.util.Map;

import com.oaec.entity.User;

public interface UserServices {
	public User findById(String nickName, String password, String tel);

	public User findByOne(User user);

	public Integer findByNickName(User user);

	public List<User> findList();

	public void insert(User user);

	public void update(User user);

	public User findByNickNameObj(User user);

	public List<Map<String, Object>> findUserInfoPage(Map<String, Object> params);

	public List<Map<String, Object>> findReserveUserInfoPage(Map<String, Object> params);

	public Integer findReserveUserInfoPageCount(User user);

	public void updateReserveTypeById(User user);

	public void updateReserveResultById(User user);

	public void updateUserStatusById(User user);

	// �����û�ID�����û����ܼ���
	public void updateGoodsLevelById(User user);

	// �����������״̬Ϊ��1�� ��ȡ�б�����
	public List<Map<String, Object>> findListByGoodsStatus(Map<String, Object> params);

	// �����������״̬Ϊ��1�� ��ȡ��������
	public Integer findCountByGoodsStatus(User user);
}
