package com.oaec.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Services.ProductPhotosServices;
import com.oaec.Util.DateFormatConverter;
import com.oaec.Util.R;
import com.oaec.entity.Product;
import com.oaec.entity.ProductPhotos;

@Controller
@RequestMapping("/product/photo")
public class ProductPhotosController {

	@Autowired
	private ProductPhotosServices productPhotosServices;

	/**
	 * 根据图片名和商品ID删除一条数据
	 * 
	 * @param productPhotos
	 * @return
	 */
	@RequestMapping("/deleteByImgNameAndProductId.action")
	@ResponseBody
	public void deleteByImgNameAndProductId(ProductPhotos productPhotos) {
		productPhotosServices.deleteByImgNameAndProductId(productPhotos);
	}

	/**
	 * 根据商品ID和图片类型为1 修改图片地址
	 * 
	 * @param productId
	 * @param imgType
	 * @param imageUrl
	 * @return
	 */
	@RequestMapping("/updateByProductId.action")
	@ResponseBody
	public R updateByProductId(ProductPhotos productPhotos) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		DateFormatConverter dc = new DateFormatConverter();
		productPhotos.setCreateTime(dc.convert(sdf.format(new Date())));
		// 根据商品ID和图片类型更新图片
		productPhotosServices.updateByProductId(productPhotos);
		return R.ok().put("data", productPhotos.getImageUrl());
	}

	/**
	 * 获取商品相册条数，也作为商家申请货架的时候这个条数用来做判断
	 * 
	 * @param product
	 * @param req
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/product/getProductPhotosCount.action")
	@ResponseBody
	public R getProductPhotosCount(ProductPhotos productPhotos, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		Integer count = productPhotosServices.findByProductIdCount(productPhotos);
		return R.ok().put("count", count);
	}
}
