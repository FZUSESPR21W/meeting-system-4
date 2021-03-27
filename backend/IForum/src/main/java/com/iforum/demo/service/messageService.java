package com.iforum.demo.service;

import com.iforum.demo.entity.message;
import com.iforum.demo.mapper.messageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class messageService implements messageMapper {

    @Autowired
    private messageMapper messageMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(message record) {
        return 0;
    }

    @Override
    public int insertSelective(message record) {
        return 0;
    }

    @Override
    public message selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(message record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(message record) {
        return 0;
    }

    @Override
    public List<message> getAllMessage() {
        return messageMapper.getAllMessage();
    }
}
