package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.common.result.CodeMsg;
import com.example.demo.common.result.Result;
import com.example.demo.common.util.RedisUtil;
import com.example.demo.common.vo.LoginVo;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @Autowired
    RedisUtil redisService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        // 登录
        String token = userService.login(response, loginVo);
        return Result.write(CodeMsg.SUCCESS, token);
    }
}
