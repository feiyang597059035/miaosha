package com.example.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.demo.common.entity.PageBean;
import com.example.demo.common.redis.MiaoshaUserKey;
import com.example.demo.common.util.RedisUtil;
import com.example.demo.common.util.UUIDUtil;
import com.example.demo.common.vo.LoginVo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;

@Service("userService")
public class UserServiceImpl implements UserService {
    public static final String COOKI_NAME_TOKEN = "token";
    @Resource
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Transactional
    @Override
    public void insertSelective(User user) {
        // TODO Auto-generated method stub
        userMapper.insertSelective(user);
    }

    @Override
    public User selectUserInfoById(Integer id, String name) {
        // TODO Auto-generated method stub
        /*Map<String, Object> map=new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        return userMapper.selectUserInfoById(id,name);*/
        /*String yy= userMapper.selectUserInfoById(id,name);
        System.out.println(yy);
        return null;*/

        /*   Map<Integer, User> list = userMapper.selectUserInfoById(id, name);
        Map<Integer, User> map1 = list;*/

        return userMapper.selectUserInfoById(id, name);

    }

    @Override
    public PageBean<User> getPageUserInfo(int size, int limit) {
        // TODO Auto-generated method stub
        PageHelper.startPage(size, limit);
        List<User> list = userMapper.getPageUserInfo();
        PageBean pageInfo = new PageBean<User>(list);
        return pageInfo;
    }

    @Override
    public String login(HttpServletResponse response, LoginVo loginVo) {
        // TODO Auto-generated method stub
        User user = userMapper.getUserInfo(loginVo.getMobile(), loginVo.getPassword());
        if (user != null) {
            // 生成cookie
            String token = UUIDUtil.uuid();
            addCookie(response, token, user);
            return token;
        } else {
            return "";
        }

    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisUtil.set(MiaoshaUserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public User getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User user = redisUtil.get(MiaoshaUserKey.token, token, User.class);
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

}
