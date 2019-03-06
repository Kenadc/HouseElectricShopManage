package com.oaec.Mapper;

import java.util.List;
import java.util.Map;

import com.oaec.entity.User;

public interface userMapper {
	// 根据昵称和密码查询实现登录
	public User findByOne(User user);

	// 根据昵称查询条数
	public Integer findByNickName(User user);

	// 根据昵称获取对象
	public User findByNickNameObj(User user);

	// 获取所有数据
	public List<User> findList();

	// 插入数据
	public void insert(User user);

	// 修改数据
	public void update(User user);
	
	//分页获取用户信息列表
	public List<Map<String, Object>> findUserInfoPage(Map<String, Object> params);

	//分页获取申请成为店铺的用户信息列表
	public List<Map<String, Object>> findReserveUserInfoPage(Map<String, Object> params);
	
	//查询申请成为店铺的用户信息条数
	public Integer findReserveUserInfoPageCount(User user);
	
	//用户申请成为店铺时根据用户ID设置reserveType为   "1"
	public void updateReserveTypeById(User user);
	
	//根据用户ID更改审核结果
	public void updateReserveResultById(User user);
	
	//根据用户ID启用/禁用当前用户
	public void updateUserStatusById(User user);
	
	//根据用户ID设置用户货架级别
	public void updateGoodsLevelById(User user);
	
	//根据申请货架状态为“1” 获取列表数据
	public List<Map<String, Object>> findListByGoodsStatus(Map<String, Object> params);
	
	//根据申请货架状态为“1” 获取数据条数
	public Integer findCountByGoodsStatus(User user);
	
}
