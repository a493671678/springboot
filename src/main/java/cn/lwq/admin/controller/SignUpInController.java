package cn.lwq.admin.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.lwq.model.User;
import cn.lwq.service.SignUpInService;

/**
 * @author 林伟强
 *
 * 2017年8月25日
 */
@Controller
public class SignUpInController {
	private static final Logger logger = Logger.getLogger(SignUpInController.class);
	@Autowired
	private SignUpInService signUpInservice;
	
	
	/**
	 * 注册
	 * @param user
	 * @param uRpwd
	 * @param uName
	 * @return
	 */
	@RequestMapping("/signupC")
	public String signup(User user,String uRpwd,String uName){
		signUpInservice.signup(user);
		logger.info("注册成功");
		return "signup";
	}
	
	@RequestMapping("/signinC")
	public String signin(User user,HttpSession session){
		if(!StringUtils.isBlank(signUpInservice.signin(user))){
			session.setAttribute("uName", user.getuName());
			session.setAttribute("uPhone", user.getuPhone());
			logger.info("登录成功，转到首页");
			return "index";
		}
		logger.info("登录失败，转到登录页面");
		return "signin";
		
	}
}
