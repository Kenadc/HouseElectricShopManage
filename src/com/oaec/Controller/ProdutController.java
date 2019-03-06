package com.oaec.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Services.ProductPhotosServices;
import com.oaec.Services.ProductServices;
import com.oaec.Services.ProductStatisticsServices;
import com.oaec.Util.DateFormatConverter;
import com.oaec.Util.DateUtil;
import com.oaec.Util.Query;
import com.oaec.Util.R;
import com.oaec.Util.StringUtil;
import com.oaec.entity.Product;
import com.oaec.entity.ProductPhotos;
import com.oaec.entity.ProductStatics;
import com.oaec.entity.User;
import com.oaec.entity.alipay_trade_query_response;

@Controller
//@RequestMapping("/product")
public class ProdutController {

	@Autowired
	private ProductServices productServices;
	@Autowired
	private ProductPhotosServices productPhotosServices;
	@Autowired
	private ProductStatisticsServices productStatisticsServices;
	
	/**
	 * ��������
	 * @param product
	 * @param req
	 * @param res
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/product/insert.action")
	@ResponseBody
	public R insert(Product product,HttpServletRequest req,HttpServletResponse res,HttpSession session) throws ServletException, IOException {
		User u = (User) session.getAttribute("loginInfo");
		//����UUID
//		String UUID = StringUtil.getUUID();
//		product.setId(UUID);
		product.setUser_id(u.getId());
		product.setMarque(DateUtil.getTimeInMillis().toString());
		
		if(product.getName().trim().equals("")) {
			return R.ok("��Ʒ���Ʋ���Ϊ��");
		}
		if(product.getName().contains("�յ�")) {
			product.setType_id("1");
		}else if(product.getName().contains("����") || product.getName().contains("ϴ�»�")){
			product.setType_id("3");
		}else if(product.getName().contains("����") || product.getName().contains("Һ��") || product.getName().contains("����")){
			product.setType_id("4");
		}else {
			product.setType_id("2");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		DateFormatConverter dc = new DateFormatConverter();
		product.setCreateTime(dc.convert(sdf.format(new Date())));
		product.setProductStatus("0");
		//��Ʒ����
		productServices.insert(product);
		
		//����ͳ�Ʋ���
		//purchase_quantity
		ProductStatics p = new ProductStatics();
		p.setId(StringUtil.getUUID());
		p.setProduct_id(product.getId());
		p.setCost_price(Double.parseDouble(product.getCost_price()));
		p.setPurchase_quantity(Integer.parseInt(product.getPurchase_quantity()));
		p.setPurchase_amount(Integer.parseInt(product.getPurchase_quantity()) * Double.parseDouble(product.getPrice()));
		p.setVisit_count(0);
		p.setReply_count(0);
		p.setSale_amount(0.0);
		p.setSale_quantity(0);
		p.setCreateTime(dc.convert(sdf.format(new Date())));
		
		if(productStatisticsServices.CountByProductId(product.getId()) > 0) {
			return R.ok("�����쳣");
		}
		productStatisticsServices.insert(p);
		
		//��product_idΪ�յ�����ֵ
		//productPhotosServices.setProductIdByNullProductId(product.getId());
		
		return R.ok("��Ʒ��ӳɹ�");
	}
	/**
	 * ��Ų�Ʒid��session��
	 * @param product
	 * @param atqr
	 * @param req
	 * @param res
	 * @param session
	 * @return  
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/setAttribute.action")
	public String setAttribute(Product product,alipay_trade_query_response atqr,HttpServletRequest req,HttpServletResponse res,HttpSession session) throws ServletException, IOException {
		//��ʽ
//		session.setAttribute("product_id", product.getId());
		//����
		session.setAttribute("product_id", "3bafd99fe672488a83fd1d981f7d684e");
		return "alipay.trade.page.pay";
	}
	
	/**
	 * ��ȡ��Ʒ�б���Ϣ
	 * @param product
	 * @param req
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/list.action")
	public String list(Product product,HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		List<Product> list = productServices.list(product);
		ProductPhotos productPhotos = null;
		for(int i = 0;i<list.size();i++) {
			productPhotos = new ProductPhotos();
			productPhotos.setProduct_id(list.get(i).getId());
			productPhotos.setImgType("1");
			ProductPhotos p = productPhotosServices.findByProductId(productPhotos);
			System.out.println("productPhotos:"+p);
			list.get(i).setImgUrl(p.getImageUrl());
		}
		req.setAttribute("productList", list);
		return "index";
	}
	/**
	 * �����̼�ID   ��ҳ��ȡ��Ʒ����
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/product/listPage.action")
	@ResponseBody
	public Object findUserPage(@RequestParam Map<String, Object> params,HttpSession session) {
		User u = (User) session.getAttribute("loginInfo");
		
		List<Map<String, Object>> data = productServices.findProductInfoPage(new Query(params));
		//��ȡ����
		Integer num = productServices.findProductInfoPageCount(u.getId());
		List<Map<String, Object>> data1 = new ArrayList<Map<String, Object>>();
		int count = 0;
		for(int i = 0;i<data.size();i++) {
			if(data.get(i).get("user_id").equals(u.getId())) {
				count++;
				System.out.println("come in");
				data1.add(data.get(i));
			}
		}
		
		System.out.println("data--------------->>>>:"+data1.toString());
		
		return R.ok().put("data", data1).put("count", num);
	}
	/**
	 * ��ҳ��ȡ������Ʒ����
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/product/listPageAll.action")
	@ResponseBody
	public Object listPageAll(@RequestParam Map<String, Object> params,HttpSession session) {
		
		List<Map<String, Object>> data = productServices.findProductInfoPage(new Query(params));
		//��ȡ����
		Product p = new Product();
		List<Product> list = productServices.list(p);
		
		return R.ok().put("data", data).put("count", list.size());
	}
	
	/*
	 * ������ƷID��ȡ��Ʒ��Ϣ
	 * ��������ƷID
	 */
	@RequestMapping("/product/findById.action")
	@ResponseBody
	public Object findById(Product product,HttpSession session) {
		User u = (User) session.getAttribute("loginInfo");
		//������ƷID��ȡ��Ʒ��Ϣ
		Product p = productServices.findById(product);
		//��ȡ��ƷID��Ӧ��ͼƬ
		List<ProductPhotos> pList = productPhotosServices.findListByProductId(p.getId());
		p.setProductPhotosList(pList);
		p.setNickName(u.getNickName());
		return p;
	}
	
	/*
	 * �ϼ�/�¼�
	 */
	@RequestMapping("/product/updateStatus.action")
	@ResponseBody
	public void updateStatus(Product product) {
		productServices.updateStatus(product);
	}
	
	/*
	 * ����/����
	 */
	@RequestMapping("/product/updateProStatusById.action")
	@ResponseBody
	public void updateProStatusById(Product product) {
		productServices.updateProStatusById(product);
	}
	
	/*
	 * ������ƷID����������Ϣ
	 */
	@RequestMapping("/product/updateAllById.action")
	@ResponseBody
	public void updateAllById(Product product) {
		productServices.updateAllById(product);
	}
	
	/**
	 * ������ƷIDɾ����Ʒ�������
	 * @param id
	 */
	@RequestMapping("/product/deleteById.action")
	@ResponseBody
	public void deleteById(String id) {
		productServices.deleteById(id);
		productPhotosServices.deleteByProductId(id);
	}
}
