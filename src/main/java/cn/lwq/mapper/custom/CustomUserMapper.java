package cn.lwq.mapper.custom;

import cn.lwq.mapper.UserMapper;

public interface CustomUserMapper extends UserMapper {

	/**
	 * 根据用户名查密码
	 * @param uName 用户名
	 * @return
	 */
	String selectUpwdByUname(String uName);
}
