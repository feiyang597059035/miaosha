package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserInfoById(Integer id, String name);

    User getUserInfo(String name, String password);

    /* User selectUserInfoById(Integer id,String name);
    
    User selectUserInfoById(Map<String, Object> map);*/

    /* String selectUserInfoById(Integer id,String name);*/

    /*  Map<String, Object> selectUserInfoById(Integer id,String name);*/
    /*@MapKey("id")
    Map<Integer, User> selectUserInfoById(Integer id,String name);*/
    /**
     * 分页获取用户信息
     * 
     * @param size
     * @param limit
     * @return
     */
    public List<User> getPageUserInfo();
}