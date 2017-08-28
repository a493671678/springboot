package cn.lwq.utils;

import java.security.MessageDigest;

import org.springframework.util.Base64Utils;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.mysql.jdbc.util.Base64Decoder;

public class MyUtils {
	
	public static String getMd5(String str){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(str.getBytes("utf-8"));
			StringBuilder resStr = new StringBuilder();
			for (byte b:result){
				int number = b & 0xff;
				String numStr = Integer.toHexString(number);
				if(numStr.length() == 1){
					resStr.append("0");
				}
				resStr.append(numStr);
			}
			return resStr.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
