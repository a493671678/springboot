package cn.lwq.service;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lwq.mapper.custom.CustomSystemDateMapper;
import cn.lwq.mapper.custom.CustomUserMapper;
import cn.lwq.model.User;
import cn.lwq.utils.MyUtils;

@Service
public class SignUpInService {

	@Autowired
	private CustomUserMapper customUserMapper;
	
	@Autowired
	private CustomSystemDateMapper customSystemDateMapper;
	
	/**
	 * 注册
	 * @param user
	 */
	public void signup(User user){
		Date now = customSystemDateMapper.selectNow();
		user.setuFtime(now);
		user.setuLtime(now);
		user.setuTime(now);
		customUserMapper.insertSelective(user);
	}
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public String signin(User user){
		String uPwd = customUserMapper.selectUpwdByUname(user.getuName());
		if(StringUtils.equals(uPwd, MyUtils.getMd5(user.getuPwd()))){
			return "success"; 
		}
		return null;
	}
	
}
