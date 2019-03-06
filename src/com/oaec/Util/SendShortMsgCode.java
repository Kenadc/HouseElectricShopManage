package com.oaec.Util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
/**
 * �˴����ð����ƶ�����֤��API�ӿڷ�����֤��
 */
public class SendShortMsgCode {
	public static void sendShortMsgCode(String msgCode,String phone,String type) {
	    String host = "http://dingxin.market.alicloudapi.com";
	    String path = "/dx/sendSms";
	    String method = "POST";
	    String appcode = "fedd8757ffeb4865aa1c85329ffa42bd";
	    Map<String, String> headers = new HashMap<String, String>();
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("mobile", phone);
	    querys.put("param", "code:"+msgCode);
	    if(type.trim().equals("0")) {
	    	querys.put("tpl_id", "TP1711063");
	    }
	    //ע����֤��
	    if(type.trim().equals("1")) {
	    	querys.put("tpl_id", "TP1811211");
	    }
	    //��¼��֤��
	    if(type.trim().equals("2")) {
	    	querys.put("tpl_id", "TP1811212");
	    }
	    //������֤��
	    if(type.trim().equals("3")) {
	    	querys.put("tpl_id", "TP1811213");
	    }
	    //֪ͨ��֤��
	    if(type.trim().equals("4")) {
	    	querys.put("tpl_id", "TP1811214");
	    }
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
