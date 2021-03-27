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
@RequestMapping(value = "/sForum", produces = "application/json; charset=utf-8")
public class smallForumController {
    @Autowired
    private smallforumService smallforumService;

    @Autowired
    private meetingService meetingService;

    @Autowired
    private userService userService;

    @ResponseBody
    @RequestMapping(value = "/getAllSForum" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getAllMeeting(){

            List<smallforum> list = smallforumService.getAllSmallForum();
            JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " =======>  接口：/sForum/getAllSForum  请求体："  + " 返回结果数：" + list.size());
            System.out.println("########## 返回结果 ########## \n " + array);
            System.out.println("##############################");
            return array;

    }

    @ResponseBody
    @RequestMapping(value = "/getlSForumByChairmanid" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getlMessageByChairmanid(@RequestBody String JSONBody){
        JSONObject object = JSONObject.parseObject(JSONBody);
        String id=(String) object.get("id");
        List<smallforum> allSmallForumList = smallforumService.getAllSmallForum();
        List<user> allUserList = userService.getAllUser();
        List<meeting> allMeetingList = meetingService.getAllMeeting();
        List<zkNeed> result = new ArrayList<>();

        for (smallforum s:allSmallForumList
        ) {

            if (s.getSmallchairmanid().equals(id)) {
                zkNeed z=new zkNeed();
                z.setsForumTitle(s.getSmallforumname());
                for (meeting m:allMeetingList
                     ) {
                    if(s.getBelongto().equals(m.getId())){
                        z.setMeetingId(m.getId());
                        z.setMeetingTitle(m.getTitle());
                    }
                }

                int ss =0;
                for (user u: allUserList
                ) {
                    if(u.getJoinsmallforumid().contains(id)) ss++;
                }
                z.setsForumSize(ss);
                result.add(z);
            }
        }


        JSONArray array= JSONArray.parseArray(JSON.toJSONString(result));

        try {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " =======>  接口：/sForum/getlSForumByChairmanid  请求体："+ JSONBody + " 返回结果数：" + result.size());
            System.out.println("########## 返回结果 ########## \n " + array);
            System.out.println("##############################");
            return array;
        }catch (Exception e){
            e.printStackTrace();

        }
        return array;
    }


}
