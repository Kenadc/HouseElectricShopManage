package com.oaec.MyTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.junit.Test;

import com.oaec.Util.HttpUtils;

public class TestDuanXinYanZhengMa {
	@Test
	public void getRandom() {
		String str = "";
		for(int i = 0;i<6;i++) {
			int b=(int)(Math.random()*9);//����0-10�����������
			str = b + str;
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
	    String host = "http://dingxin.market.alicloudapi.com";
	    String path = "/dx/sendSms";
	    String method = "POST";
	    String appcode = "fedd8757ffeb4865aa1c85329ffa42bd";
	    Map<String, String> headers = new HashMap<String, String>();
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("mobile", "18785461074");
	    querys.put("param", "code:961105");
	    querys.put("tpl_id", "TP1711063");
	    Map<String, String> bodys = new HashMap<String, String>();
	    try {
	    	/**
	    	* ��Ҫ��ʾ����:
	    	* HttpUtils���
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* ����
	    	*
	    	* ��Ӧ�����������
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
	    	System.out.println(response.toString());
	    	//��ȡresponse��body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
