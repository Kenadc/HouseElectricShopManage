package com.oaec.Services;

import java.util.List;

import com.oaec.entity.ProductStatics;

public interface ProductStatisticsServices {
	// 插入数据
	public void insert(ProductStatics productStatics);

	// 根据商品ID获取整条数据
	public ProductStatics findOneByProductId(String productId);

	// 获取整张表的销售总量
	public Integer allCount();

	// 根据时间获取一条数据
	public ProductStatics findOneByDate(ProductStatics productStatics);

	// 根据时间获取列表数据
	public List<ProductStatics> findListByDate(ProductStatics productStatics);

	// 根据商品ID返回对象条数作为判断该条数据在当天是否已经添加到数据
	public Integer CountByProductId(String product_id);

	// 根据商品ID、当天日期(格式年月日) 修改数据统计表
	public void updateByProductId(ProductStatics productStatics);

	// 根据商品ID获取数据
	public List<ProductStatics> listByProductId(String product_id);
}
