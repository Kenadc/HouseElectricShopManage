package com.oaec.ServicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oaec.Mapper.ProductPhotosMapper;
import com.oaec.Services.ProductPhotosServices;
import com.oaec.entity.ProductPhotos;

public class ProductPhotosServicesImp implements ProductPhotosServices {

	@Autowired
	private ProductPhotosMapper productPhotosMapper;

	@Override
	public ProductPhotos findByProductId(ProductPhotos productPhotos) {
		// TODO Auto-generated method stub
		return productPhotosMapper.findByProductId(productPhotos);
	}

	@Override
	public void InsertUpFile(ProductPhotos productPhotos) {
		// TODO Auto-generated method stub
		productPhotosMapper.InsertUpFile(productPhotos);
	}

	@Override
	public List<ProductPhotos> findListByProductId(String productId) {
		// TODO Auto-generated method stub
		return productPhotosMapper.findListByProductId(productId);
	}

	@Override
	public void deleteByImgNameAndProductId(ProductPhotos productPhotos) {
		// TODO Auto-generated method stub
		productPhotosMapper.deleteByImgNameAndProductId(productPhotos);
	}

	@Override
	public void deleteByProductId(String product_id) {
		// TODO Auto-generated method stub
		productPhotosMapper.deleteByProductId(product_id);
	}

	@Override
	public void updateByProductId(ProductPhotos productPhotos) {
		// TODO Auto-generated method stub
		productPhotosMapper.updateByProductId(productPhotos);
	}

	@Override
	public void setProductIdByNullProductId(String product_id) {
		// TODO Auto-generated method stub
		productPhotosMapper.setProductIdByNullProductId(product_id);
	}

	@Override
	public Integer findByProductIdCount(ProductPhotos productPhotos) {
		// TODO Auto-generated method stub
		return productPhotosMapper.findByProductIdCount(productPhotos);
	}

}
