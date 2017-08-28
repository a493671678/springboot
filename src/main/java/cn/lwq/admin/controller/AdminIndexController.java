package cn.lwq.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController {
	
	/**
	 * 返回注册页面
	 * @return
	 */
	@RequestMapping("/signupShow")
	public String signup(){
		return "signup";
	}
	/**
	 * 返回登陆页面
	 * @return
	 */
	@RequestMapping("/signinShow")
	public String signin(){
		return "signin";
	}
	/**
	 * 返回忘记密码页面
	 * @return
	 */
	@RequestMapping("/forgotShow")
	public String forgot(){
		return "forgot";
	}
}
