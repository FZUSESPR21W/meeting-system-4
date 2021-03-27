package com.iforum.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iforum.demo.entity.meeting;
import com.iforum.demo.entity.smallforum;
import com.iforum.demo.service.meetingService;
import com.iforum.demo.service.smallforumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value = "/sForum", produces = "application/json; charset=utf-8")
public class smallForumController {
    @Autowired
    private smallforumService smallforumService;

    @ResponseBody
    @RequestMapping(value = "/getAllSForum" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getAllMeeting(){

            List<smallforum> list = smallforumService.getAllSmallForum();
            JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " =======>  接口：/sForum/getAllSForum  请求体：无" + " 返回结果数：" + list.size());
            System.out.println("########## 返回结果 ########## \n " + array);
            System.out.println("##############################");
            return array;

    }

}
