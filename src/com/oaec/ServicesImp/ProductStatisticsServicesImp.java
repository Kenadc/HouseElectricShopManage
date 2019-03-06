package com.oaec.ServicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oaec.Mapper.ProductStatisticsMapper;
import com.oaec.Services.ProductStatisticsServices;
import com.oaec.entity.ProductStatics;

public class ProductStatisticsServicesImp implements ProductStatisticsServices{
	
	@Autowired 
	private	ProductStatisticsMapper productStatisticsMapper;

	@Override
	public void insert(ProductStatics productStatics) {
		// TODO Auto-generated method stub
		productStatisticsMapper.insert(productStatics);
	}

	@Override
	public ProductStatics findOneByProductId(String productId) {
		// TODO Auto-generated method stub
		return productStatisticsMapper.findOneByProductId(productId);
	}

	@Override
	public Integer allCount() {
		// TODO Auto-generated method stub
		return productStatisticsMapper.allCount();
	}

	@Override
	public ProductStatics findOneByDate(ProductStatics productStatics) {
		// TODO Auto-generated method stub
		return productStatisticsMapper.findOneByDate(productStatics);
	}

	@Override
	public Integer CountByProductId(String product_id) {
		// TODO Auto-generated method stub
		return productStatisticsMapper.CountByProductId(product_id);
	}

	@Override
	public void updateByProductId(ProductStatics productStatics) {
		// TODO Auto-generated method stub
		productStatisticsMapper.updateByProductId(productStatics);
	}

	@Override
	public List<ProductStatics> findListByDate(ProductStatics productStatics) {
		// TODO Auto-generated method stub
		return productStatisticsMapper.findListByDate(productStatics);
	}

	@Override
	public List<ProductStatics> listByProductId(String product_id) {
		// TODO Auto-generated method stub
		return productStatisticsMapper.listByProductId(product_id);
	}

}
