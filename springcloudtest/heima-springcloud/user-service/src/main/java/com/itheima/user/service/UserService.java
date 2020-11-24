package com.itheima.user.service;

import com.itheima.user.mapper.UserMapper;
import com.itheima.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据主键查询用户
     * @param id 用户id
     * @return 用户
     */
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
    public int updateById(User user) {return userMapper.updateByPrimaryKey(user);}
    public int deleteById(Long id) {return userMapper.deleteByPrimaryKey(id);}
    public int insertById(User user){return userMapper.insertSelective(user);}
}
