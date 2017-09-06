package cn.lwq.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.lwq.utils.MyUtils;
import net.coobird.thumbnailator.Thumbnails;

@Controller
public class ImageController {
	
	@RequestMapping("/image")
	@ResponseBody
	public void image(HttpServletRequest request,HttpServletResponse res,@RequestParam(value="imageT")MultipartFile file,String sizeT,String width,String height){
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			res.setHeader("content-type", "application/octet-stream");
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			OutputStream os = null;
			try {
			String cd = "D:\\photo\\";
			long time = System.currentTimeMillis();
			cd += time + "." + fileName.split("\\.")[1];
			File f = new File(cd);
			file.transferTo(f);
			os = res.getOutputStream();
			if(StringUtils.isBlank(sizeT)){
				while(f.length() > Double.parseDouble(sizeT)*1024){
					Thumbnails.of(f).scale(0.9).toFile(f);
				}
			}
			if(StringUtils.isBlank(width)&&StringUtils.isBlank(height)){
				Thumbnails.of(f).size(Integer.parseInt(width), Integer.parseInt(height)).keepAspectRatio(false).toFile(f);
			}
		    MyUtils.download(res,f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("success");
		}else{
			System.out.println("error");
		}
	}
}
