package com.oaec.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Services.ProductServices;
import com.oaec.Services.ProductStatisticsServices;
import com.oaec.entity.Product;
import com.oaec.entity.ProductStatics;
import com.oaec.entity.User;

/**
 * 数据统计
 * 
 * @author 陆仙
 *
 */
@Controller
@RequestMapping("/productStatistics")
public class ProductStatisticsController {

	@Autowired
	private ProductStatisticsServices productStatisticsServices;

	@Autowired
	private ProductServices productServices;

	//根据商品ID获取集合数据
	@RequestMapping("/listByProductId.action")
	@ResponseBody
	public Map<String,Object> listByProductId(HttpSession session) {
		User user = (User) session.getAttribute("loginInfo");
		Map<String,Object> map = new HashMap<String, Object>();
		//浏览次数、销售总额、销售总量
		int visit = 0;
		int sale_quantity = 0;
		double sale_amount = 0;
		//商品类实例化
		Product product = new Product();
		//循环
		List<Product> list = productServices.list(product);
		for (int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getUser_id().equals(user.getId())) {
				List<ProductStatics> plist = productStatisticsServices.listByProductId(list.get(i).getId());
				for(int j = 0;j<plist.size();j++) {
					sale_quantity = plist.get(j).getSale_quantity() + sale_quantity;
					sale_amount = plist.get(j).getSale_amount() + sale_amount;
					visit = plist.get(j).getVisit_count() + visit;
				}
			}
		}
		map.put("code", 200);
		map.put("visit", visit);
		map.put("sale_amount", sale_amount);
		map.put("sale_quantity", sale_quantity);

		return map;
	}
	
	
	// 根据商品ID获取整条数据
	@RequestMapping("/findOneByProductId.action")
	@ResponseBody
	public ProductStatics findOneByProductId(String productId, HttpSession session) {
		User user = (User) session.getAttribute("loginInfo");
		Product product = new Product();
		List<Product> list = productServices.list(product);
		for (int i = 0; i < list.size(); i++) {
			productStatisticsServices.findOneByProductId(list.get(i).getId());
		}

		return null;
	}

	/**
	 * 系统管理员 依次获取当天往后推7天的数据
	 * 
	 * @return
	 */
	@RequestMapping("/findListByDate.action")
	@ResponseBody
	public Map<String, Object> findListByDate(String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 存放浏览次数
		int[] visit = new int[7];
		// 存放销售总量
		int[] saleQuantity = new int[7];
		// 存放销售总额
		double[] saleAmount = new double[7];

		// 存放折线图标题
		String[] titleNav = new String[7];
		for (int k = 0; k < 7; k++) {
			titleNav[k] = sdf.format(getDateBefore(new Date(), k));
		}
		for (int i = 0; i < 7; i++) {
			// 存放浏览次数1 总量1 总额1
			int visit1 = 0;
			int saleQuantity1 = 0;
			double saleAmount1 = 0;

			ProductStatics productStatics = new ProductStatics();
			productStatics.setDayNum(i);
			List<ProductStatics> psList = productStatisticsServices.findListByDate(productStatics);
			if (psList.size() > 0) {
				for (int j = 0; j < psList.size(); j++) {
					visit1 = psList.get(j).getVisit_count() + visit1;
					saleQuantity1 = psList.get(j).getSale_quantity() + saleQuantity1;
					saleAmount1 = psList.get(j).getSale_amount() + saleAmount1;

					visit[i] = visit1;
					saleQuantity[i] = saleQuantity1;
					saleAmount[i] = saleAmount1;
				}
			}
		}
		// 数据分析
		if (type.equals("1")) {
			map.put("titleNav", titleNav);
			map.put("visit", visit);
			map.put("saleQuantity", saleQuantity);
			map.put("saleAmount", saleAmount);
			map.put("msg", "success");
		} else if (type.equals("2")) {//// 数据统计
			List<ProductStatics> plist = new ArrayList<ProductStatics>();
			for (int i = 0; i < titleNav.length; i++) {
				ProductStatics p = new ProductStatics();
				p.setTitleNav(titleNav[i]);
				p.setSale_amount(saleAmount[i]);
				p.setSale_quantity(saleQuantity[i]);
				p.setVisit_count(visit[i]);
				plist.add(p);
			}
			map.put("msg", "");
			map.put("data", plist);
			map.put("count", plist.size());
		}
		map.put("code", 200);

		return map;
	}

	/**
	 * 商家 依次获取当天往后推7天的数据
	 * 
	 * @param productStatics
	 * @return
	 */
	@RequestMapping("/findOneByDate.action")
	@ResponseBody
	public Map<String, Object> findOneByDate(HttpSession session,String type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User user = (User) session.getAttribute("loginInfo");
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductStatics> pslist = new ArrayList<>();

		// 存放浏览次数
		int[] visit = new int[7];
		// 存放销售总量
		int[] saleQuantity = new int[7];
		// 存放销售总额
		double[] saleAmount = new double[7];
		// 存放浏览次数1 总量1 总额1
		int visit1 = 0;
		int saleQuantity1 = 0;
		double saleAmount1 = 0;

		int visit2 = 0;
		int saleQuantity2 = 0;
		double saleAmount2 = 0;

		int visit3 = 0;
		int saleQuantity3 = 0;
		double saleAmount3 = 0;

		int visit4 = 0;
		int saleQuantity4 = 0;
		double saleAmount4 = 0;

		int visit5 = 0;
		int saleQuantity5 = 0;
		double saleAmount5 = 0;

		int visit6 = 0;
		int saleQuantity6 = 0;
		double saleAmount6 = 0;

		int visit7 = 0;
		int saleQuantity7 = 0;
		double saleAmount7 = 0;
		// 存放折线图标题
		String[] titleNav = new String[7];
		// 获取商品列表数据
		Product product = new Product();
		List<Product> plist = productServices.list(product);

		for (int k = 0; k < 7; k++) {
			titleNav[k] = sdf.format(getDateBefore(new Date(), k));
		}

		for (int j = 0; j < plist.size(); j++) {
			if (plist.get(j).getUser_id().equals(user.getId())) {
				for (int i = 0; i < 7; i++) {
					ProductStatics productStatics = new ProductStatics();
					productStatics.setProduct_id(plist.get(j).getId());
					productStatics.setDayNum(i);
					ProductStatics pro = productStatisticsServices.findOneByDate(productStatics);

					if (pro != null) {
						if (sdf.format(pro.getCreateTime()).equals(titleNav[0])) {
							visit1 = pro.getVisit_count() + visit1;
							saleQuantity1 = pro.getSale_quantity() + saleQuantity1;
							saleAmount1 = pro.getSale_amount() + saleAmount1;

							visit[i] = visit1;
							saleQuantity[i] = saleQuantity1;
							saleAmount[i] = saleAmount1;

						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[1])) {
							visit2 = pro.getVisit_count() + visit2;
							saleQuantity2 = pro.getSale_quantity() + saleQuantity2;
							saleAmount2 = pro.getSale_amount() + saleAmount2;

							visit[i] = visit2;
							saleQuantity[i] = saleQuantity2;
							saleAmount[i] = saleAmount2;
						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[2])) {
							visit3 = pro.getVisit_count() + visit3;
							saleQuantity3 = pro.getSale_quantity() + saleQuantity3;
							saleAmount3 = pro.getSale_amount() + saleAmount3;

							visit[i] = visit3;
							saleQuantity[i] = saleQuantity3;
							saleAmount[i] = saleAmount3;
						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[3])) {
							visit4 = pro.getVisit_count() + visit4;
							saleQuantity4 = pro.getSale_quantity() + saleQuantity4;
							saleAmount4 = pro.getSale_amount() + saleAmount4;

							visit[i] = visit4;
							saleQuantity[i] = saleQuantity4;
							saleAmount[i] = saleAmount4;
						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[4])) {
							visit5 = pro.getVisit_count() + visit5;
							saleQuantity5 = pro.getSale_quantity() + saleQuantity5;
							saleAmount5 = pro.getSale_amount() + saleAmount5;

							visit[i] = visit5;
							saleQuantity[i] = saleQuantity5;
							saleAmount[i] = saleAmount5;
						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[5])) {
							visit6 = pro.getVisit_count() + visit6;
							saleQuantity6 = pro.getSale_quantity() + saleQuantity6;
							saleAmount6 = pro.getSale_amount() + saleAmount6;

							visit[i] = visit6;
							saleQuantity[i] = saleQuantity6;
							saleAmount[i] = saleAmount6;
						} else if (sdf.format(pro.getCreateTime()).equals(titleNav[6])) {
							visit7 = pro.getVisit_count() + visit7;
							saleQuantity7 = pro.getSale_quantity() + saleQuantity7;
							saleAmount7 = pro.getSale_amount() + saleAmount7;

							visit[i] = visit7;
							saleQuantity[i] = saleQuantity7;
							saleAmount[i] = saleAmount7;
						}
					}
				}
			}
		}
		// 数据分析
		if (type.equals("1")) {
			map.put("titleNav", titleNav);
			map.put("visit", visit);
			map.put("saleQuantity", saleQuantity);
			map.put("saleAmount", saleAmount);
			map.put("msg", "success");
		} else if (type.equals("2")) {//// 数据统计
			List<ProductStatics> pl = new ArrayList<ProductStatics>();
			for (int i = 0; i < titleNav.length; i++) {
				ProductStatics p = new ProductStatics();
				p.setTitleNav(titleNav[i]);
				p.setSale_amount(saleAmount[i]);
				p.setSale_quantity(saleQuantity[i]);
				p.setVisit_count(visit[i]);
				pl.add(p);
			}
			map.put("msg", "");
			map.put("data", pl);
			map.put("count", pl.size());
		}
		map.put("code", 200);

//		map.put("code", 200);
//		map.put("msg", "success");
//		map.put("titleNav", titleNav);
//		map.put("visit", visit);
//		map.put("saleQuantity", saleQuantity);
//		map.put("saleAmount", saleAmount);
		return map;
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}
}
