package com.iforum.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iforum.demo.entity.meeting;
import com.iforum.demo.service.meetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value = "meeting", produces = "application/json; charset=utf-8")
public class meetingController {

    @Autowired
    private meetingService meetingService;

    @ResponseBody
    @RequestMapping(value = "getAllMeeting" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getAllMeeting(@RequestBody String JSONBody){
        JSONObject object = JSONObject.parseObject(JSONBody);
        List<meeting> meetingList = meetingService.getAllMeeting();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(meetingList));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date) + " =======>  接口：getAllMeeting  请求体：" + JSONBody + " 返回结果数：" + meetingList.size() );
        System.out.println("########## 返回结果 ########## \n " + array);
        System.out.println("##############################");
        return array;
    }


}
