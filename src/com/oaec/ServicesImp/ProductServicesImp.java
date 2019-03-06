package com.oaec.ServicesImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.oaec.Mapper.productMapper;
import com.oaec.Services.ProductServices;
import com.oaec.entity.Product;

public class ProductServicesImp implements ProductServices {

	@Autowired
	private productMapper productmapper;
	
	@Override
	public void insert(Product product) {
		productmapper.insert(product);
	}

	@Override
	public Product findById(Product product) {
		// TODO Auto-generated method stub
		return productmapper.findById(product);
	}

	@Override
	public List<Product> list(Product product) {
		// TODO Auto-generated method stub
		return productmapper.list(product);
	}

	@Override
	public List<Map<String, Object>> findProductInfoPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return productmapper.findProductInfoPage(params);
	}

	@Override
	public void updateStatus(Product product) {
		// TODO Auto-generated method stub
		productmapper.updateStatus(product);
	}

	@Override
	public void updateAllById(Product product) {
		// TODO Auto-generated method stub
		productmapper.updateAllById(product);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		productmapper.deleteById(id);
	}

	@Override
	public Integer findProductInfoPageCount(String user_id) {
		// TODO Auto-generated method stub
		return productmapper.findProductInfoPageCount(user_id);
	}

	@Override
	public void updateProStatusById(Product product) {
		// TODO Auto-generated method stub
		productmapper.updateProStatusById(product);
	}

}
