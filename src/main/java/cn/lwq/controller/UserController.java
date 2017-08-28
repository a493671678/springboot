package cn.lwq.controller;

import cn.lwq.model.User;
import cn.lwq.service.UserService;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
        List<User> user = userService.getUserInfo();
        for (User user2 : user) {
        	System.out.println("user.getName():"+user2.getuName());
        	logger.info("user.getAge():"+user2.getuAge());
		}
        return user;
    }
}
