package com.oaec.Services;

import java.util.List;

import com.oaec.entity.ProductStatics;

public interface ProductStatisticsServices {
	// ��������
	public void insert(ProductStatics productStatics);

	// ������ƷID��ȡ��������
	public ProductStatics findOneByProductId(String productId);

	// ��ȡ���ű����������
	public Integer allCount();

	// ����ʱ���ȡһ������
	public ProductStatics findOneByDate(ProductStatics productStatics);

	// ����ʱ���ȡ�б�����
	public List<ProductStatics> findListByDate(ProductStatics productStatics);

	// ������ƷID���ض���������Ϊ�жϸ��������ڵ����Ƿ��Ѿ���ӵ�����
	public Integer CountByProductId(String product_id);

	// ������ƷID����������(��ʽ������) �޸�����ͳ�Ʊ�
	public void updateByProductId(ProductStatics productStatics);

	// ������ƷID��ȡ����
	public List<ProductStatics> listByProductId(String product_id);
}
