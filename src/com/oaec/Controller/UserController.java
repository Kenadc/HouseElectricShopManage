package com.oaec.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oaec.Services.UserServices;
import com.oaec.Util.DateFormatConverter;
import com.oaec.Util.Query;
import com.oaec.Util.QueryList;
import com.oaec.Util.QueryListByGoodsStatus;
import com.oaec.Util.R;
import com.oaec.Util.SCaptcha;
import com.oaec.Util.StringUtil;
import com.oaec.entity.User;

@Controller
public class UserController {
	@Autowired
	private UserServices userServices;

	/**
	 * ��¼
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/login.action")
//	@ResponseBody
	public void login(User user, HttpSession session, HttpServletRequest req, HttpServletResponse res, ModelAndView mv)
			throws ServletException, IOException {
		// ʵ������֤�����
		SCaptcha instance = new SCaptcha();

		System.out.println(user.toString() + "--------------->:" + instance.scaptcha);
		user.setUserType("0");
		user.setUserStatus("0");
		try {
			if (session.getAttribute("loginInfo") != null) {
				req.getRequestDispatcher("/index.jsp").forward(req, res);
				return;
			}
			if (!user.getKaptchaValidate().equals(instance.scaptcha) || user.getKaptchaValidate() == "") {
				res.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
				return;
			}
			if (userServices.findByOne(user) != null) {
				session.setAttribute("loginInfo", userServices.findByOne(user));
				req.getRequestDispatcher("/index.jsp").forward(req, res);
				return;
			}
//			if(session.getAttribute("loginInfo") == null){
//				res.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
//				return;
//			}
			session.setAttribute("loginInfo", null);
			res.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
			return;
		} catch (Exception e) {
		}
	}

	/**
	 * ajaxLogin ��ȡsession��Ϣ
	 * 
	 * @param user
	 */
	@RequestMapping("/ajaxLogin.action")
	@ResponseBody
	public User ajaxLogin(HttpSession session) {
		User u = (User) session.getAttribute("loginInfo");
		return u;
	}

	/**
	 * ��ҳ��ȡ�û�����
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/user/listPage.action")
	@ResponseBody
	public Object findUserPage(@RequestParam Map<String, Object> params) {
		List<Map<String, Object>> data = userServices.findUserInfoPage(new Query(params));
		List<User> list = this.userServices.findList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("count", list.size());
		map.put("data", data);
		map.put("msg", "");
//		return R.ok().put("data", data).put("count", list.size());
		return map;
	}


	/**
	 * �����û�ID�����û����ܼ����״̬
	 * 
	 * @param user
	 */
	@RequestMapping("/user/updateGoodsLevelById.action")
	@ResponseBody
	public void updateGoodsLevelById(User user) {
		userServices.updateGoodsLevelById(user);
	}

	/**
	 * ��ҳ��ȡ�������״̬Ϊ��1�� ��ѯ����
	 * 
	 * @param user
	 */
	@RequestMapping("/user/findByGoodsStatus.action")
	@ResponseBody
	public Object selectByGoodsStatus(@RequestParam Map<String, Object> params) {

		QueryListByGoodsStatus query = new QueryListByGoodsStatus(params);
		query.setGoodsStatus("1");

		// �������״̬Ϊ��1�� ����������
		User u = new User();
		u.setUserType("1");
		u.setGoodsStatus("1");
		Integer count = userServices.findCountByGoodsStatus(u);

		List<Map<String, Object>> data = userServices.findListByGoodsStatus(new Query(params));
		return R.ok().put("data", data).put("count", count);
	}
	
	/**
	 * ��ҳ��ȡ����ǰ��Ϊ���̵��û�����
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/user/listPageToShop.action")
	@ResponseBody
	public Object findUserPageToShop(@RequestParam Map<String, Object> params) {

		QueryList query = new QueryList(params);
		query.setUserType("0");
		query.setReserveResult("0");

		// ��ȡ����ǰ��Ϊ���̵��û���������
		User u = new User();
		u.setUserType("0");
		u.setReserveResult("0");
		Integer count = userServices.findReserveUserInfoPageCount(u);

		List<Map<String, Object>> data = userServices.findReserveUserInfoPage(new Query(params));
		return R.ok().put("data", data).put("count", count);
	}

	/**
	 * �û������Ϊ����ʱ�����û�ID����reserveTypeΪ "1"
	 * 
	 * @param user
	 */
	@RequestMapping("/user/updateReserveTypeById.action")
	@ResponseBody
	public void updateReserveTypeById(User user) {
		userServices.updateReserveTypeById(user);
	}

	/**
	 * �����û�ID������˽��
	 * 
	 * @param user
	 */
	@RequestMapping("/user/updateReserveResultById.action")
	@ResponseBody
	public void updateReserveResultById(User user) {
		userServices.updateReserveResultById(user);
	}

	/**
	 * �����û�ID����/���õ�ǰ�û�
	 * 
	 * @param user
	 */
	@RequestMapping("/user/updateUserStatusById.action")
	@ResponseBody
	public void updateUserStatusById(User user) {
		userServices.updateUserStatusById(user);
	}

	/**
	 * ��������
	 * 
	 * @throws ParseException
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/user/insert.action", method = RequestMethod.POST)
//	@ResponseBody
	public String insert(HttpServletRequest req, HttpServletResponse res, User user)
			throws ParseException, ServletException, IOException {
		String msg = "";
		Integer num = userServices.findByNickName(user);
		if (num == 1) {
			req.getRequestDispatcher("/Regist.jsp").forward(req, res);
			req.setAttribute("msg", "�û��ѱ�ע��");
			return "";
		}
		if (user.getPassword().equals("") || user.getPassword().trim() == "") {
			req.setAttribute("msg", "���벻��Ϊ��");
			req.getRequestDispatcher("/Regist.jsp").forward(req, res);
			return "";
		}
		// ����UUID
		user.setId(StringUtil.getUUID());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(sdf.format(user.getBirthday()));
		Integer a = d.getMonth();
		System.out.println("d.getMonth():" + d.getMonth());
		DateFormatConverter dc = new DateFormatConverter();
//		String sdfStr = sdf.format(user.getBirthday());
		// ��������
		user.setBirthday(dc.convert(sdf.format(user.getBirthday())));
		// ��������ID
		user.setConstellaId(a.toString());
		userServices.insert(user);
		// ҳ��ת��
		req.getRequestDispatcher("/login.jsp").forward(req, res);
		return "";

	}

	/**
	 * ��������
	 * 
	 * @throws ParseException
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/user/update.action", method = RequestMethod.POST)
	@ResponseBody
	public void update(HttpServletRequest req, HttpServletResponse res,HttpSession session, User user)
			throws ParseException, ServletException, IOException {
		User u = (User)session.getAttribute("loginInfo");
		user.setId(u.getId());
//		if(user.getId().equals("") || user.getId().trim() == null) {
//		}
		if(user.getBirthday() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DateFormatConverter dc = new DateFormatConverter();
			user.setBirthday(dc.convert(sdf.format(user.getBirthday())));
		}

		userServices.update(user);

	}

	/**
	 * �˳�
	 * 
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/loginOut.action")
	public void loginOut(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws IOException {
		if (session != null) {
			session.invalidate();
		}
		res.sendRedirect("/HouseElectricShopManage/login/page/login.jsp");
	}
}
