<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- zswy.gzegn.gov.cn -->
<link type="text/css" rel="stylesheet"	href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/login.css" />
<link rel="icon" href="../../favicon.ico">
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<title>家用电器后台管理系统</title>
</head>
<script type="text/javascript">
	var v = 0;
</script>

<body>

	<!--内容开始-->
	<div class="login_web">
		<form action="/HouseElectricShopManage/login.action"
			method="post">
			<div class="login_content">
				<div class="login_title">
					<span>家用电器后台管理系统<span>
				</div>
				<div class="form_content">
					<input type="text" class="user_input" placeholder="用户名"
						name="nickName" />
					<input type="password" class="pwd_input"
						placeholder="密码" name="password" /> 
					<input type="text" class="yaz_input" name="kaptchaValidate" placeholder="请输入验证码" 
						style="width:  378px !important; margin:  auto; height:  36px; line-height:  36px; margin:  5px 0px 5px 58px; border:  0px; border-radius:  5px; padding-left:  50px;float:  left;" />
					<!-- onclick="this.src='/HouseElectricShopManage/scaptcha.action?v=this.src'" -->
					<img src="/HouseElectricShopManage/scaptcha.action" onclick="v++;var httpSrc='/HouseElectricShopManage/scaptcha.action?v=' + v;this.src=httpSrc;"
						class="yzm_img" />
					<!-- <div class="text_input">
						<span class="span_1"><input type="checkbox"
							name="rememberMe" />&nbsp;记住用户名</span> <span class="span_2">忘记密码？</span>
					</div> -->
					<div class="but_input">
						<input type="submit" value="登录" class="submit_iput" /> <input
							type="reset" value="重置" class="reset_input" />
					</div>
					<!-- <div class="text_cont">
						如在贵州统一认证无账号，请点击<a href="#">&nbsp;立即注册</a>
					</div> -->
				</div>
				<!-- <div class="remind_info">如遇到账户登陆问题，请直接拨打我们的运维热血：0851-86987176</div> -->
			</div>
		</form>

		<div class="copyright">版权所有@家用电器商城丨黔ICP备15091901号</div>

	</div>
	<!--内容结束-->

</body>
</html>
