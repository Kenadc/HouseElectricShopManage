package com.oaec.Mapper;

import java.util.List;

import com.oaec.entity.ProductPhotos;

public interface ProductPhotosMapper {

		//根据ID获取对象
		public ProductPhotos findByProductId(ProductPhotos productPhotos);

		//多张图片插入
		public void InsertUpFile(ProductPhotos productPhotos);
		
		//根据商品ID获取相册
		public List<ProductPhotos> findListByProductId(String productId);
		
		//根据图片名和商品ID删除一条数据
		public void deleteByImgNameAndProductId(ProductPhotos productPhotos);
		
		//根据商品ID删除数据
		public void deleteByProductId(String product_id);
		
		//根据商品ID和图片类型更新图片
		public void updateByProductId(ProductPhotos productPhotos);
		
		//把product_id为空的设置值
		public void setProductIdByNullProductId(String product_id);
		
		//根据商品ID和图片类型为0  获取条数
		public Integer findByProductIdCount(ProductPhotos productPhotos);
}	
