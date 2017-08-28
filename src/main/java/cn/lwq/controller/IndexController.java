package cn.lwq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("index", "on");
		model.addAllAttributes(map);
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(Model model){
		Map<String,String> map = new HashMap<String,String>();
		map.put("about", "on");
		model.addAllAttributes(map);
		return "about";
	}
}
