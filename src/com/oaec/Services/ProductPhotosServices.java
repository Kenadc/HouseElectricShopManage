package com.oaec.Services;

import java.util.List;

import com.oaec.entity.ProductPhotos;

public interface ProductPhotosServices {
	public ProductPhotos findByProductId(ProductPhotos productPhotos);

	public void InsertUpFile(ProductPhotos productPhotos);

	public List<ProductPhotos> findListByProductId(String productId);

	public void deleteByImgNameAndProductId(ProductPhotos productPhotos);

	public void deleteByProductId(String product_id);

	public void updateByProductId(ProductPhotos productPhotos);

	public void setProductIdByNullProductId(String product_id);
	
	public Integer findByProductIdCount(ProductPhotos productPhotos);
}
