package com.oaec.Mapper;

import java.util.List;

import com.oaec.entity.Order;

public interface OrderMapper {

		// ��������
		public void insert(Order order);

		// �޸�����
		//public void update(Product product);
		
		//���ݶ���ID��ѯ����
		public Order findByOrderId(Order order);
		
		//�����û�ID��ѯ����
		public List<Order> findByUserId(String userid);
}	
