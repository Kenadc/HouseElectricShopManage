package com.oaec.Mapper;

import java.util.List;
import java.util.Map;

import com.oaec.entity.Product;

public interface productMapper {

		// ��������
		public void insert(Product product);
		
		//����ID��ȡ����
		public Product findById(Product product);
		// �޸�����
		//public void update(Product product);
		
		//��ȡ��Ʒ
		public List<Product> list(Product product);
		
		//��ҳ��ȡ��Ʒ��Ϣ�б�
		public List<Map<String, Object>> findProductInfoPage(Map<String, Object> params);
		
		//�����û�ID��ȡ����
		public Integer findProductInfoPageCount(String user_id);
		
		//�ϼ�/�¼�
		public void updateStatus(Product product);
		
		//������ƷID����������Ϣ
		public void updateAllById(Product product);

		//������ƷIDɾ������Ʒ�������
		public void deleteById(String id);
		
		//������ƷID���ý�����Ʒ
		public void updateProStatusById(Product product);
}	
