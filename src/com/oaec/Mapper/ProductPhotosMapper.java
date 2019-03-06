package com.oaec.Mapper;

import java.util.List;

import com.oaec.entity.ProductPhotos;

public interface ProductPhotosMapper {

		//����ID��ȡ����
		public ProductPhotos findByProductId(ProductPhotos productPhotos);

		//����ͼƬ����
		public void InsertUpFile(ProductPhotos productPhotos);
		
		//������ƷID��ȡ���
		public List<ProductPhotos> findListByProductId(String productId);
		
		//����ͼƬ������ƷIDɾ��һ������
		public void deleteByImgNameAndProductId(ProductPhotos productPhotos);
		
		//������ƷIDɾ������
		public void deleteByProductId(String product_id);
		
		//������ƷID��ͼƬ���͸���ͼƬ
		public void updateByProductId(ProductPhotos productPhotos);
		
		//��product_idΪ�յ�����ֵ
		public void setProductIdByNullProductId(String product_id);
		
		//������ƷID��ͼƬ����Ϊ0  ��ȡ����
		public Integer findByProductIdCount(ProductPhotos productPhotos);
}	
