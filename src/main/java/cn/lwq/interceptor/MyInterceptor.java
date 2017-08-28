package cn.lwq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {
	
	Logger logger = Logger.getLogger(MyInterceptor.class);
	private static final String[] ignore_uri={"/signupShow","/signinShow","/forgot","signinC","signupC"};
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.error("======拦截器关闭====afterCompletion=========");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.error("=======执行处理完毕=====postHandle============");
		long starttime = (long)arg0.getAttribute("starttime");
		arg0.removeAttribute("starttimes");
		long endtime = System.currentTimeMillis();
		logger.error("请求地址："+arg0.getRequestURL()+"处理时间：{"+(endtime-starttime)+"}ms");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.error("=======拦截器启动======preHandle============");
		String url = arg0.getRequestURL().toString();
		logger.error("请求的uri："+url);
		arg0.setAttribute("starttime", System.currentTimeMillis());
		for (String uri : ignore_uri) {
			if(url.contains(uri)){
				return true;
			}
		}
		if(!StringUtils.isBlank((CharSequence) arg0.getSession().getAttribute("uName"))){
			logger.error("uName:" + arg0.getSession().getAttribute("uName"));
			return true;
		}
		logger.error("=======拦截成功跳转到登录页面");
		arg0.getRequestDispatcher("/signinShow").forward(arg0, arg1);
		return false;
	}

}
