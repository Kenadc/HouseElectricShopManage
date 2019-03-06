package com.oaec.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oaec.Util.SCaptcha;

/**
 * ����ͼƬ��֤��
 * @author itellyou
 *
 */
@Controller
public class SCaptchaController {
    @RequestMapping("/scaptcha.action")
    @ResponseBody
    public String verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // ������Ӧ�����͸�ʽΪͼƬ��ʽ
        response.setContentType("image/jpeg");
        // ��ֹͼ�񻺴档
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //ʵ��������֤�����
        SCaptcha instance = new SCaptcha();
        //����֤�����session
//        session.setAttribute("verification", instance.getCode());
        //��ҳ�������֤��ͼƬ
        instance.write(response.getOutputStream());
        System.out.println("instance.getCode():"+instance.getCode());
        //�����֤�룬�Ա����ڵ�¼��ʱ����ñ����Ƚ�
        instance.scaptcha = instance.getCode(); 
        return instance.getCode();
    }
}
