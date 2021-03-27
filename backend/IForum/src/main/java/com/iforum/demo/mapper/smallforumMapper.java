package com.iforum.demo.mapper;

import com.iforum.demo.entity.smallforum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface smallforumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    int insert(smallforum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    int insertSelective(smallforum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    smallforum selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(smallforum record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table smallforum
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(smallforum record);

    List<smallforum> getAllSmallForum();
}