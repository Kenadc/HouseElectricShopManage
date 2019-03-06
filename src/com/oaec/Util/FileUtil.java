package com.oaec.Util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.multipart.MultipartFile;

import com.oaec.entity.ProductPhotos;

/**
 * �ļ���ȡ������
 */
public class FileUtil {
	/**
	 * ɾ�������ļ�
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {// ɾ�������ļ�
		boolean flag = false;
	    File file;
		flag = false;
        file = new File(filePath);
        if (file.exists() && file.isFile()) {
            file.delete();// �ļ�ɾ��
            flag = true;
        }
        return true;
    }
	
	public static String fileUpload(MultipartFile[] files) {
		//ʵ����һ���ļ���ŵ�Ŀ¼��ַ
        String dir = "E:/MyJavaworkspace/HouseElectricShopManage/WebContent/productImgs/";
        //List list = new ArrayList();
        String filename = "";
        for (MultipartFile file : files){
            System.out.println("�ļ�����:"+file.getContentType());
            filename = file.getOriginalFilename();
            String suffix = filename.substring(filename.length() - 3);
            System.out.println("�ļ���:"+filename);
            System.out.println("�ļ���׺:"+suffix);
            System.out.println("�ļ���С:"+file.getSize()/1024+"KB");
            
            //ͼƬ����
            /*ProductPhotos productPhotos = new ProductPhotos();
            productPhotos.setProduct_id(product_id);
            productPhotos.setImageUrl("productImgs/" + filename);
            productPhotos.setImgType(imgType);
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
    		DateFormatConverter dc = new DateFormatConverter();
    		productPhotos.setCreateTime(dc.convert(sdf.format(new Date())));
    		
            productPhotosServices.updateByProductId(productPhotos);*/
            
            //list.add(filename);
            //����Ҫ�����ļ���·��
            File dirFile = new File(dir,filename);
            if (!dirFile.exists()){
                dirFile.mkdirs();
            }
            try {
                //���ļ�д�봴����·��
                file.transferTo(dirFile);
                System.out.println("�ļ�����ɹ�~");
            } catch (IOException e) {
                e.printStackTrace();
            }
 
        }
		return filename;
	}
}