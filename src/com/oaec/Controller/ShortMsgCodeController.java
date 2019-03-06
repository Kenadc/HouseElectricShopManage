package com.oaec.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Util.SendShortMsgCode;

/**
 * ������֤��
 * @author itellyou
 *
 */
@Controller
public class ShortMsgCodeController {
	/**
	 * ��ȡ������֤��
	 * @param req
	 * @param phone  �ֻ�����
	 * @param type
	 * @return
	 */
	@RequestMapping("/getShortMsgCode.action")
	@ResponseBody
	public Map<String,Object> getShortMsgCode(HttpServletRequest req,String phone,String type) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", "�ɹ�");
		map.put("code", 200);
		//����6λ�������������  ��֤��
		String msgCode = "";
		for(int i = 0;i<6;i++) {
			int b=(int)(Math.random()*9);//����0-10�����������
			msgCode = b + msgCode;
		}
		//���÷���������֤��
		SendShortMsgCode.sendShortMsgCode(msgCode,phone,type);
		//��֤�ж�
		if(phone.trim().equals("")) {
			map.put("data", "�ֻ��Ų���Ϊ��!");
			map.put("msg", "ʧ��");
			map.put("code", 500);
			return map;
		}
		//�жϷ�����֤�����������Ҫ���ص�����
		if(type.trim().equals("4")) {
			map.put("data", "֪ͨ��Ϣ�ѷ���!");
		}else {
			map.put("data", msgCode);
		}
		return map;
	}
}
