package com.iforum.demo.service;


import com.iforum.demo.entity.meeting;
import com.iforum.demo.mapper.meetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class meetingService implements meetingMapper {

    @Autowired
    private meetingMapper meetingMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(meeting record) {
        return 0;
    }

    @Override
    public int insertSelective(meeting record) {
        return 0;
    }

    @Override
    public meeting selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(meeting record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(meeting record) {
        return 0;
    }

    @Override
    public List<meeting> getAllMeeting() {
        return meetingMapper.getAllMeeting();
    }
}
