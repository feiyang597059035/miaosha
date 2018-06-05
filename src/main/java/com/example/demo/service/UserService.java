package com.example.demo.service;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.common.entity.PageBean;
import com.example.demo.common.vo.LoginVo;
import com.example.demo.model.User;

public interface UserService {
    public void insertSelective(User user);

    public User selectUserInfoById(Integer id, String name);

    /**
     * 分页获取用户信息
     * 
     * @param size
     * @param limit
     * @return
     */
    public PageBean<User> getPageUserInfo(int size, int limit);

    /**
     * 登录
     * 
     * @param response
     * @param loginVo
     * @return
     */
    public String login(HttpServletResponse response, LoginVo loginVo);

    public User getByToken(HttpServletResponse response, String token);

}
