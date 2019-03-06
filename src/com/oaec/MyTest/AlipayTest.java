package com.oaec.MyTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
 
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
 
public class AlipayTest {
	
	private final String SERVER_URL = "https://openapi.alipaydev.com/gateway.do";//֧�������أ�ɳ����Թ̶���
//	private final String SERVER_URL = "https://openapi.alipay.com/gateway.do";//֧�������أ��̶���
	
	//Ӧ��˽Կ
	private final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDAMe1hK7Kqxvue+0K5wMbkDEAZadga3XM197yrBk8KI+R1LzxJxEbLFw6ceAmGdV8iOIeK2wEQ53PLb+mrH6XZjLNWcFsDraMMPz1vM8YI48nqeXb31sXasXzxygZqVQW0LBIM2C4ChnidDiWvqKFWQC/7gCqLHHngT3zBnsWOalAzI5zDgjE+2XjraMcDCpqVTl7N7kqTSJU9XGViMdfcsF1M91WMNa6ttSEjMVa/98FwYwmelQKFBYoV4EMwH+7EipVZENLK96NxYPQjD8mCB1e9VX5QiK/7g35Xcw6QOIE6mTXWkxqtOmfCOvwpZdUhdheUtgTceR4kGntka/X/AgMBAAECggEABCEOeIf3zrN3tHKxfEwn+b5JokIj4m/ficlIxGPeTtl2jw30vaD55GMabUIm8jyTTqjoQJNz8mkGk9hTrNmBNqtPLww66FlSp3C0YS87kfVS4Ta615hFp+0oQgmVGbO566UGvj/mvScmcDldleiJjtDSNxUJ1PNHqwoKJB7FH8ofToFg2+L8MTQcSgW08sUAg5X0rxGLUnADhPxEol3Zj5nTHGNNXOWwcAb+gwUQhDQ5In3x8oe/DA8GXKMprzojyeEMYMKKCvkBBxJ/PPzQVgAVUaOD1LPaHbS8EpuEb4S4INysPCotSTYe1YSlYdRn2f3mGCZRjwAzh05s3UIMAQKBgQD/jw5LUkcBytiNpXj+MxvKXF28Mhv6wb1q2se1/1aPoKRP4SfBfvGEfkck9qVAFTgrsXIiBJDZEIwEje2QF21aREu/r6OZhSNAPwY3DChyG5eEqnsPY8sHCNo85gSRxp1M8KXrItFVeFfSQyRqiGJ1hrGBjG05G+AQybYFayWuxQKBgQDAht4pNlm3azily2RV0Qhl7wlQPZkmXgcsYp6SiyHXPlcyHBlxG0G9gnEo5hQsQSjLzDMBsm+C8eqJOpR1ki8faBfg+CtCc9I0oysLuofT+rlnH8rktBI9BzvXYYGSDcKKi/yMASL2C4nZMtGtit60QnMdqO/CDtLGK33iZRvd8wKBgQC3Pkxxlb10e45rgosPOnZi03giyYtmciTvyZAJ39yhf/5RiJCJHgzvg9xflLtJB+4O5l2AJuX1vvenDF2bRDEU2IO4HqigG+b62jYKop0dtMsgRV2X22Zo1OAnaoc8P73qvWM7Buwy7OeLzLj/6msu+jWtPpPSrzoqz3fEyt9qQQKBgFuTizblMFWLfb12+nnLXQhHZBGzyxYx4Y2eNzkTTvx4HberH/rp8SI4WqUOk4fdUo9lyNlEy7/oXBv8LkOiTiHNPJZ41PLd7p21AzOn/RW6i9fein6wnIBE4ZT4P05+lwuZvH3HyJ5qLJ6QiqXWiUoK1YDFK44NyPoUE+PNHi07AoGBALlGHF0yh6qXablUyxOVnxnGn5kAqEL6gT8N+Wyb7bBBeOfvR0NYgQiwlod9Pl6g6EAS/9LjgWn1IPKHNZ+hRPzSUxeDnm8zQo++AIGs2lFTrQo9uL7WCyWI5RtfZXuC1NBPNJNPO5k5N5gatv/U0xOG15Veciu6EsX+8RqmvIMY";
	//������Ϣ����Ҫ�޸�
	private final String FORMAT = "json";
	private final String CHARSET = "utf-8";
	private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwDHtYSuyqsb7nvtCucDG5AxAGWnYGt1zNfe8qwZPCiPkdS88ScRGyxcOnHgJhnVfIjiHitsBEOdzy2/pqx+l2YyzVnBbA62jDD89bzPGCOPJ6nl299bF2rF88coGalUFtCwSDNguAoZ4nQ4lr6ihVkAv+4Aqixx54E98wZ7FjmpQMyOcw4IxPtl462jHAwqalU5eze5Kk0iVPVxlYjHX3LBdTPdVjDWurbUhIzFWv/fBcGMJnpUChQWKFeBDMB/uxIqVWRDSyvejcWD0Iw/JggdXvVV+UIiv+4N+V3MOkDiBOpk11pMarTpnwjr8KWXVIXYXlLYE3HkeJBp7ZGv1/wIDAQAB";
	private final String SIGN_TYPE = "RSA2";
	
	//���渶
	private final String APP_ID = "2016091900549394";//ɳ��APPID(����)
	
	private String AUTH_CODE = "2088102176366057";//������(һ��һ��)
	
	private AlipayClient alipayClient;
	@Before
	public void setUp(){
		alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
	}
	
	@Test
	public void doPost(HttpServletRequest httpRequest,
            HttpServletResponse httpResponse) throws ServletException, IOException {
				AlipayClient alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); //��ó�ʼ����AlipayClient
				AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//����API��Ӧ��request
				alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
				alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//�ڹ������������û�����֪ͨ��ַ
				alipayRequest.setBizContent("{" +
				"    \"out_trade_no\":\"20150320010101001\"," +
				"    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
				"    \"total_amount\":88.88," +
				"    \"subject\":\"Iphone6 16G\"," +
				"    \"body\":\"Iphone6 16G\"," +
				"    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
				"    \"extend_params\":{" +
				"    \"sys_service_provider_id\":\"2088511833207846\"" +
				"    }"+
				"  }");//���ҵ�����
				String form="";
				try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); //����SDK���ɱ�
				} catch (AlipayApiException e) {
				e.printStackTrace();
			}
				httpResponse.setContentType("text/html;charset=" + CHARSET);
				httpResponse.getWriter().write(form);//ֱ�ӽ������ı�html�����ҳ��
				httpResponse.getWriter().flush();
				httpResponse.getWriter().close();
	}
	
	@Test
	public void testTradePay() {//���渶
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		AlipayTradePayModel model = new AlipayTradePayModel();
		
		model.setOutTradeNo(System.currentTimeMillis()+"");//������
		model.setSubject("����");//��Ʒ˵��
		model.setTotalAmount("10");//���
		model.setAuthCode(AUTH_CODE);//ɳ��Ǯ���еĸ�����
		model.setScene("bar_code");//wave_code ����֧��; bar_code ����֧��
		
		try {
			request.setBizModel(model);
			AlipayTradePayResponse response = alipayClient.execute(request);
			
			System.out.println(response.getBody());
			System.out.println(response.getTradeNo());
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTransToaccount(){//����ת��(�˿�)
		AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
		//���� ת����Ϣ
		String bizContent = getBizContent01();
		request.setBizContent(bizContent);
		
		try {
			AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
			
			System.out.println(response.isSuccess());
			System.out.println(response.getCode());
			System.out.println(response.getBody());
		} catch (AlipayApiException e) {
			
			e.printStackTrace();
		}
	}
	
	private String getBizContent01(){
		//qhskwo0031@sandbox.com(���)  pcbwne3288@sandbox.com(�̼�)
		//ALIPAY_USERID		ALIPAY_LOGONID
		String outBizNo = System.currentTimeMillis()+"";
		
		JSONObject object = new JSONObject();
		object.put("out_biz_no", outBizNo);//Ψһ������
		object.put("payee_type", "ALIPAY_LOGONID");//�տ��˻�����
		object.put("payee_account", "xdjaao0743@sandbox.com");//�տ��ʺ�
		object.put("payee_real_name", "ɳ�价��");//�տ��ʵ����
		
		object.put("amount", 0.1);//���
		object.put("remark", "ת�˱�ע");//ת�˱�ע
		
		return object.toJSONString();
	}
	
	@Test
	public void testTransQuery(){//����ת�˼�¼��ѯ
		AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
		String bizContent = "{out_biz_no:1501047155276}";
		request.setBizContent(bizContent);
		
		try {
			AlipayFundTransOrderQueryResponse response = alipayClient.execute(request);
			
			System.out.println(response.isSuccess());
			System.out.println(response.getCode());
			System.out.println(response.getBody());
			
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	
 
}
