package com.oaec.Mapper;

import java.util.List;
import java.util.Map;

import com.oaec.entity.Product;

public interface productMapper {

		// 插入数据
		public void insert(Product product);
		
		//根据ID获取对象
		public Product findById(Product product);
		// 修改数据
		//public void update(Product product);
		
		//获取商品
		public List<Product> list(Product product);
		
		//分页获取商品信息列表
		public List<Map<String, Object>> findProductInfoPage(Map<String, Object> params);
		
		//根据用户ID获取条数
		public Integer findProductInfoPageCount(String user_id);
		
		//上架/下架
		public void updateStatus(Product product);
		
		//根据商品ID更新所有信息
		public void updateAllById(Product product);

		//根据商品ID删除该商品相关数据
		public void deleteById(String id);
		
		//根据商品ID启用禁用商品
		public void updateProStatusById(Product product);
}	
