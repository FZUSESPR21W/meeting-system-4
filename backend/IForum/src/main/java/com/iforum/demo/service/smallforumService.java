package com.iforum.demo.service;

import com.iforum.demo.entity.smallforum;
import com.iforum.demo.mapper.smallforumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class smallforumService implements smallforumMapper {

    @Autowired
    private smallforumMapper smallforumMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(smallforum record) {
        return 0;
    }

    @Override
    public int insertSelective(smallforum record) {
        return 0;
    }

    @Override
    public smallforum selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(smallforum record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(smallforum record) {
        return 0;
    }

    @Override
    public List<smallforum> getAllSmallForum() {
        return smallforumMapper.getAllSmallForum();
    }
}
