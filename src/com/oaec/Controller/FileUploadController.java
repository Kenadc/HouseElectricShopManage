package com.oaec.Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.oaec.Services.ProductPhotosServices;
import com.oaec.Services.ProductServices;
import com.oaec.Util.DateFormatConverter;
import com.oaec.Util.FileUtil;
import com.oaec.Util.R;
import com.oaec.Util.StringUtil;
import com.oaec.entity.ProductPhotos;
import com.oaec.entity.User;

@Controller
@RequestMapping("/file")
public class FileUploadController {
	
	@Autowired
	private ProductServices productServices;
	@Autowired
	private ProductPhotosServices productPhotosServices;
	
	/**
	 * 图片文件上传 一次一张
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadfile.action")
	@ResponseBody
	public Object oneFileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
		String fileName = "";
		if (cmr.isMultipart(request)) {
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);
			Iterator<String> files = mRequest.getFileNames();
			while (files.hasNext()) {
				MultipartFile mFile = mRequest.getFile(files.next());
				if (mFile != null) {
					fileName = mFile.getOriginalFilename();
//					String path = "E:/upload/" + fileName;
					String path = "E:/MyJavaworkspace/HouseElectricShop/WebContent/productImgs/" + fileName;

					File localFile = new File(path);
					mFile.transferTo(localFile);
				}
			}
		}
		return "http://localhost:8080/HouseElectricShop/productImgs/"+fileName;
	}
	/**
	 * layui多张图片文件上传
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileup.action")
	@ResponseBody
    //参数中的files要和页面中input输入框的name值相同
    public R fileup(@RequestParam("file") MultipartFile[] files,String productId,String imgType,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException {
		User u = (User) session.getAttribute("loginInfo");
		List<ProductPhotos> plist = productPhotosServices.findListByProductId(productId);
		 List list = new ArrayList();
        int count = 0;
        for(int i = 0;i < plist.size();i++) {
        	if(plist.get(i).getImgType().equals("0")) {
        		count++;
        	}
        }
        if(count >= 3) {
        	return R.ok().put("data", "").put("count", count);
        }
      //调用文件上传方法
       String fileName = FileUtil.fileUpload(files);
     //图片插入
       ProductPhotos productPhotos = new ProductPhotos();
       productPhotos.setId(StringUtil.getUUID());
       productPhotos.setProduct_id(productId);
       //productPhotos.setImageUrl("productImgs/" + fileName);   更改前
       productPhotos.setImageUrl(fileName);
       productPhotos.setImgType(imgType);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
		DateFormatConverter dc = new DateFormatConverter();
		productPhotos.setCreateTime(dc.convert(sdf.format(new Date())));
		
        productPhotosServices.InsertUpFile(productPhotos);
        
        list.add(fileName);
        return R.ok().put("data", list).put("count", count);
    }
	/**
	 * layui单张图片文件上传
	 * 
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/fileupOne.action")
	@ResponseBody
    //参数中的files要和页面中input输入框的name值相同
    public R fileupOnee(@RequestParam("file") MultipartFile[] files,String product_id,String imgType,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException {
		User u = (User) session.getAttribute("loginInfo");
		List<ProductPhotos> plist = productPhotosServices.findListByProductId(product_id);
		List list = new ArrayList();
        int count = 0;
        for(int i = 0;i < plist.size();i++) {
        	if(plist.get(i).getImgType().equals("1")) {
        		count++;
        	}
        }
        //调用文件上传方法
        String fileName = FileUtil.fileUpload(files);
        list.add(fileName);
        if(count == 1) {
        	//图片更新
            ProductPhotos productPhotos = new ProductPhotos();
            productPhotos.setProduct_id(product_id);
//            productPhotos.setImageUrl("productImgs/" + fileName);
            productPhotos.setImageUrl(fileName);
            productPhotos.setImgType(imgType);
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
    		DateFormatConverter dc = new DateFormatConverter();
    		productPhotos.setCreateTime(dc.convert(sdf.format(new Date())));
    		
            productPhotosServices.updateByProductId(productPhotos);
            return R.ok().put("data", list).put("count", "");
        }
		
        
        //图片插入
        ProductPhotos productPhotos = new ProductPhotos();
        productPhotos.setId(StringUtil.getUUID());
        productPhotos.setProduct_id(product_id);
        productPhotos.setImageUrl("productImgs/" + fileName);
        productPhotos.setImgType(imgType);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
		DateFormatConverter dc = new DateFormatConverter();
		productPhotos.setCreateTime(dc.convert(sdf.format(new Date())));
		
        productPhotosServices.InsertUpFile(productPhotos);
        return R.ok().put("data", list).put("count", "");
    }
	/**
	 * 删除单个文件
	 * @param filePath
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping("/deletefile.action")
	public String deletefile(String filePath,HttpServletRequest req,HttpServletResponse res) {
		Boolean b = FileUtil.deleteFile(filePath);
		String msg = "";
		if(b) {
			msg="文件删除成功!";
		}else {
			msg="文件删除失败!";
		}
		req.setAttribute("msg", msg);
		
		return "";
	}
}
