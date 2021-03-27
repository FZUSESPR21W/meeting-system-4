package com.iforum.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iforum.demo.entity.*;
import com.iforum.demo.service.meetingService;
import com.iforum.demo.service.smallforumService;
import com.iforum.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value = "/meeting", produces = "application/json; charset=utf-8")
public class meetingController {

    @Autowired
    private meetingService meetingService;

    @Autowired
    private com.iforum.demo.service.smallforumService smallforumService;


    @Autowired
    private com.iforum.demo.service.userService userService;

    @ResponseBody
    @RequestMapping(value = "/getAllMeeting" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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

    @ResponseBody
    @RequestMapping(value = "/getMeetingByChairmanid" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getMeetingByChairmanid(@RequestBody String JSONBody){
        JSONObject object = JSONObject.parseObject(JSONBody);
        Integer id=(Integer) object.get("id");
        List<user> allUserList = userService.getAllUser();
        List<meeting> allMeetingList = meetingService.getAllMeeting();
        List<zkNeed2> result = new ArrayList<>();

        for (meeting m:allMeetingList
        ) {

            if (m.getChairmanid().equals(id)) {
                zkNeed2 z=new zkNeed2();
                z.setMeetingTitle(m.getTitle());

                int ss =0;
                for (user u: allUserList
                ) {
                    if (u.getJoinmeetingid() !=null){
                        if(u.getJoinmeetingid().contains(Integer.toString(id))) ss++;
                    }

                }
                z.setNum(ss);
                result.add(z);
            }
        }


        JSONArray array= JSONArray.parseArray(JSON.toJSONString(result));

        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " =======>  接口：/meeting/getMeetingByChairmanid  请求体："+ JSONBody + " 返回结果数：" + result.size());
            System.out.println("########## 返回结果 ########## \n " + array);
            System.out.println("##############################");
            return array;
        }catch (Exception e){
            e.printStackTrace();

        }
        return array;
    }



}
