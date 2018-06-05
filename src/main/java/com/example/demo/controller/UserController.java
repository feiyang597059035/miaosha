package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.entity.PageBean;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/insert")
    public String insert(String userName, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        userService.insertSelective(user);

        return "成功";
    }

    @RequestMapping("/selectUser")
    public ModelAndView selectUser(Integer id, String name) {
        userService.selectUserInfoById(id, name);
        return new ModelAndView("index");
    }

    @RequestMapping("/freemarker")
    public String hello(Map<String, Object> map) {
        map.put("name", "FreeMarker");
        int i = 0;
        /*if (i==0) {
        	throw new MyException("11", "assa");
        }*/
        logger.info("sdds");
        logger.error("ss");

        /*Long i=9L;
        Long s=i/0;*/
        Person person = new Person();
        System.out.println(new Person().getAge());
        return "freemarker";
    }

    @ResponseBody
    @RequestMapping("/freemarker1")
    public String hellow(Map<String, Object> map) {
        map.put("name", "FreeMarker");
        String[] arr = new String[1];
        arr[1] = "ss";
        return "freemarker";
    }

    @ResponseBody
    @RequestMapping("/getPage")
    public PageBean<User> getPage(Integer size, Integer limit) {
        PageBean<User> pageBean = userService.getPageUserInfo(size, limit);
        return pageBean;
    }
}
