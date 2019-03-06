package com.oaec.ServicesImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.oaec.Mapper.userMapper;
import com.oaec.Services.UserServices;
import com.oaec.entity.User;

public class UserServicesImp implements UserServices{
	@Autowired
	private userMapper usermapper;

	@Override
	public User findByOne(User user) {
		// TODO Auto-generated method stub
		return usermapper.findByOne(user);
	}

	@Override
	public List<User> findList() {
		// TODO Auto-generated method stub
		return usermapper.findList();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		usermapper.insert(user);
	}

	@Override
	public User findById(String nickName, String password, String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findByNickName(User user) {
		// TODO Auto-generated method stub
		return usermapper.findByNickName(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		usermapper.update(user);
	}

	@Override
	public User findByNickNameObj(User user) {
		// TODO Auto-generated method stub
		return usermapper.findByNickNameObj(user);
	}

	@Override
	public List<Map<String, Object>> findUserInfoPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return usermapper.findUserInfoPage(params);
	}

	@Override
	public List<Map<String, Object>> findReserveUserInfoPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return usermapper.findReserveUserInfoPage(params);
	}

	@Override
	public Integer findReserveUserInfoPageCount(User user) {
		// TODO Auto-generated method stub
		return usermapper.findReserveUserInfoPageCount(user);
	}

	@Override
	public void updateReserveTypeById(User user) {
		// TODO Auto-generated method stub
		usermapper.updateReserveTypeById(user);
	}

	@Override
	public void updateReserveResultById(User user) {
		// TODO Auto-generated method stub
		usermapper.updateReserveResultById(user);
	}

	@Override
	public void updateUserStatusById(User user) {
		// TODO Auto-generated method stub
		usermapper.updateUserStatusById(user);
	}

	@Override
	public void updateGoodsLevelById(User user) {
		// TODO Auto-generated method stub
		usermapper.updateGoodsLevelById(user);
	}

	@Override
	public List<Map<String, Object>> findListByGoodsStatus(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return usermapper.findListByGoodsStatus(params);
	}

	@Override
	public Integer findCountByGoodsStatus(User user) {
		// TODO Auto-generated method stub
		return usermapper.findCountByGoodsStatus(user);
	}

}
