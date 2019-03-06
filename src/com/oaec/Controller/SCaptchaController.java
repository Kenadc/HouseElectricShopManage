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
 * 生成图片验证码
 * @author itellyou
 *
 */
@Controller
public class SCaptchaController {
    @RequestMapping("/scaptcha.action")
    @ResponseBody
    public String verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //实例生成验证码对象
        SCaptcha instance = new SCaptcha();
        //将验证码存入session
//        session.setAttribute("verification", instance.getCode());
        //向页面输出验证码图片
        instance.write(response.getOutputStream());
        System.out.println("instance.getCode():"+instance.getCode());
        //存放验证码，以便于在登录的时候与该变量比较
        instance.scaptcha = instance.getCode(); 
        return instance.getCode();
    }
}
