package com.iforum.demo.service;


import com.iforum.demo.entity.user;
import com.iforum.demo.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class userService implements userMapper {
    @Autowired
    private userMapper userMapper;


    @Override
    public int insert(user record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(user record) {
        return 0;
    }

    @Override
    public user getUserByAccountNum(String accountNum) {
        return userMapper.getUserByAccountNum(accountNum);
    }

    @Override
    public int updateUser(user record) {
        return userMapper.updateUser(record);
    }
}
