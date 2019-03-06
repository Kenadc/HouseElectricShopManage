package com.oaec.Controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.oaec.Services.OrderDetailServices;
import com.oaec.Services.OrderServices;
import com.oaec.Services.ProductServices;
import com.oaec.Util.DateFormatConverter;
import com.oaec.Util.DateUtil;
import com.oaec.Util.KdniaoSubscribeAPI;
import com.oaec.Util.StringUtil;
import com.oaec.alipay.AlipayConfig;
import com.oaec.entity.Alipay;
import com.oaec.entity.Order;
import com.oaec.entity.OrderDetail;
import com.oaec.entity.Product;
import com.oaec.entity.User;
import com.oaec.entity.alipay_trade_query_response;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderServices orderServices;
	@Autowired
	private ProductServices productServices;
	@Autowired
	private OrderDetailServices orderDetailServices;

	@RequestMapping("/insert.action")
	@ResponseBody
	public String insert(alipay_trade_query_response atqr, HttpSession session, HttpServletRequest request,
			HttpServletResponse reponse) throws AlipayApiException, UnsupportedEncodingException {
		Product p = new Product();
		Order order = new Order();
		OrderDetail orderDetail = new OrderDetail();

		String product_id = (String) session.getAttribute("product_id");
		p.setId(product_id);
		Product product = productServices.findById(p);
		System.out.println("product_id:==>" + product_id);

		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

		// 订单号
		String out_trade_no = "20181123132114577";
		// 支付宝交易号
		String trade_no = "2018112322001440120500550562";

		// 请二选一设置
		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"}");

		// 将拿到的字符串对象转对象
		String result = alipayClient.execute(alipayRequest).getBody();
		JSONObject jsonobject = JSONObject.fromObject(result);
		Alipay alipay = (Alipay) JSONObject.toBean(jsonobject, Alipay.class);

		// 生成UUID
		String UUID = StringUtil.getUUID();
		order.setId(UUID);
		order.setOrder_id(out_trade_no);
		order.setPayment(alipay.getAlipay_trade_query_response().getTotal_amount());
		order.setPayment_type("支付宝");
		order.setPost_free("0");
		order.setType("1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormatConverter dc = new DateFormatConverter();
		if (order.getCreate_time() == null) {
			order.setCreate_time(null);
		} else {
			order.setCreate_time(dc.convert(sdf.format(order.getCreate_time())));
		}
		if (order.getUpdate_time() == null) {
			order.setUpdate_time(null);
		} else {
			order.setUpdate_time(dc.convert(sdf.format(new Date())));
		}
		if (order.getPayment_time() == null) {
			order.setPayment_time(null);
		} else {
			order.setPayment_time(dc.convert(atqr.getSend_pay_date()));
		}
		if (order.getConsign_time() == null) {
			order.setConsign_time(null);
		} else {
			order.setConsign_time(dc.convert(sdf.format(order.getConsign_time())));
		}
		if (order.getEnd_time() == null) {
			order.setEnd_time(null);
		} else {
			order.setEnd_time(dc.convert(sdf.format(order.getEnd_time())));
		}
		if (order.getClose_time() == null) {
			order.setClose_time(null);
		} else {
			order.setClose_time(dc.convert(sdf.format(order.getClose_time())));
		}
		order.setShipping_name("申通快递");
		order.setShipping_code(DateUtil.getTimeInMillis().toString());
		order.setBuyer_message("买家留言");
		order.setBuyer_rate("买家是否评价");
		User user = (User) session.getAttribute("loginInfo");
		if (user == null) {
			order.setUser_id("");
		}
		order.setUser_id(user.getId());

		// 调用订单插入数据方法
		orderServices.insert(order);

		orderDetail.setId(StringUtil.getUUID());
		orderDetail.setOrder_id(UUID);
		orderDetail.setNum(atqr.getCountTotal());
		orderDetail.setProduct_id(product_id);
		orderDetail.setTitle(product.getName());
		orderDetail.setPic_path("");
		orderDetail.setPrice(alipay.getAlipay_trade_query_response().getTotal_amount());
		orderDetail.setTotal_fee(alipay.getAlipay_trade_query_response().getTotal_amount());

		// 调用订单详情插入数据方法
		orderDetailServices.insert(orderDetail);

		// 输出
		System.out.println("-----------------------" + result);
		session.setAttribute("product_id", null);

		// 生成13位物流号
		String msgCode = "";
		for (int i = 0; i < 13; i++) {
			int b = (int) (Math.random() * 9);// 产生0-10的整数随机数
			msgCode = b + msgCode;
		}

		//智选物流
		KdniaoSubscribeAPI api = new KdniaoSubscribeAPI();
		try {
			String logistcsResult = api.orderTracesSubByJson(msgCode,user.getTel(),"18766664453",
					user.getLiveAddress(),"收货人地址",product.getName());
			System.out.print(logistcsResult);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 根据订单ID获取对象数据
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping("/findByOrderId.action")
	public String findByOrderId(Order order, HttpServletRequest req) {
		System.out.println("order-in:" + order.toString());
		Order o = orderServices.findByOrderId(order);
		System.out.println("order-select:" + o.toString());

		req.setAttribute("orderinfo", o);
		return "";
	}

	@RequestMapping("/findByUserId.action")
	@ResponseBody
	public List<Order> findByUserId(String userid) {
		System.out.println("userid-->:" + userid);
		List<Order> list = orderServices.findByUserId(userid);
		return list;
	}
}
