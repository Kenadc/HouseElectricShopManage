package com.oaec.Services;

import java.util.List;
import java.util.Map;

import com.oaec.entity.Product;

public interface ProductServices {

	public void insert(Product product);
	
	public Product findById(Product product);

	public List<Product> list(Product product);
	
	public List<Map<String, Object>> findProductInfoPage(Map<String, Object> params);
	
	public void updateStatus(Product product);
	
	public void updateAllById(Product product);

	public void deleteById(String id);
	
	public Integer findProductInfoPageCount(String user_id);
	
	public void updateProStatusById(Product product);
	
}
