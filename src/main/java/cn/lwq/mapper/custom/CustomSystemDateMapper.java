package cn.lwq.mapper.custom;

import java.util.Date;

public interface CustomSystemDateMapper {
	/**
	 * 获取数据库系统时间
	 * @return
	 */
	Date selectNow();
}
