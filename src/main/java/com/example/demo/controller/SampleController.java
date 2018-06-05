package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.entity.PageBean;
import com.example.demo.common.redis.MiaoshaUserKey;
import com.example.demo.common.redis.UserKey;
import com.example.demo.common.result.CodeMsg;
import com.example.demo.common.result.Result;
import com.example.demo.common.util.RedisUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "Joshua");
        long i = 1 / 0;
        return "hello";
    };

    @ResponseBody
    @RequestMapping("/getResult")
    public Result<Map<String, String>> getResult() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Joshua");
        return Result.write(CodeMsg.SUCCESS, map);
        /*return Result.success(CodeMsg.SUCCESS);*/
        /* return Result.error(CodeMsg.SESSION_ERROR);*/
    }

    @ResponseBody
    @RequestMapping("/getResult1")
    public Result<String> getResult1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Joshua");
        long i = 1 / 0;
        return Result.write(CodeMsg.SUCCESS, "");
        /*return Result.success(CodeMsg.SUCCESS);*/
        /* return Result.error(CodeMsg.SESSION_ERROR);*/
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public Result<PageBean<User>> getUser(Integer id, String name) {

        PageBean<User> page = userService.getPageUserInfo(1, 10);
        return Result.write(CodeMsg.SUCCESS, page);
    }

    @ResponseBody
    @RequestMapping("/setRedis")
    public Result<Boolean> setRedis() {
        User user = new User();
        user.setId(1L);
        user.setUserName("ss");
        redisUtil.set(MiaoshaUserKey.token, "ss", user);
        redisUtil.set(UserKey.getById, "" + 1, user);// UserKey:id1
        return Result.success(CodeMsg.SUCCESS);
    }

    @ResponseBody
    @RequestMapping("/getRedis")
    public Result<User> getRedis() {
        User user = redisUtil.get(UserKey.getById, "" + 1, User.class);
        return Result.write(CodeMsg.SUCCESS, user);
    }

}
