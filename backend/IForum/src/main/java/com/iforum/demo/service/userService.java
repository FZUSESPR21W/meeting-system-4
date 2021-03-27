package com.iforum.demo.service;


import com.iforum.demo.entity.user;
import com.iforum.demo.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int updateUser(String accountNum) {
        System.out.println("123");
        return userMapper.updateUser(accountNum);
    }

    @Override
    public int deleteUserByAccountNum(String accoutNum) {
        return userMapper.deleteUserByAccountNum(accoutNum);
    }

    @Override
    public List<user> getAllUser() {
        return userMapper.getAllUser();
    }
}
