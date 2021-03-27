package com.iforum.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iforum.demo.entity.message;
import com.iforum.demo.entity.smallforum;
import com.iforum.demo.service.messageService;
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
@RequestMapping(value = "/message", produces = "application/json; charset=utf-8")
public class messageController {
    @Autowired
    private messageService messageService;

    @ResponseBody
    @RequestMapping(value = "/getAllMessage" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONArray getAllMessage(){
        List<message> list = messageService.getAllMessage();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date) + " =======>  接口：/message/getAllMessage  请求体：无" + " 返回结果数：" + list.size());
        System.out.println("########## 返回结果 ########## \n " + array);
        System.out.println("##############################");
        return array;
    }

    @ResponseBody
    @RequestMapping(value = "/setMessage" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getSetMessage(@RequestBody String JSONBody){

        try {
            JSONObject object = JSONObject.parseObject(JSONBody);
            message message = new message();
            if(object.containsKey("time")) message.setTime((String)object.get("time"));
            if(object.containsKey("context")) message.setContext((String)object.get("context"));
            if(object.containsKey("belongto")) message.setBelongto((Integer) object.get("belongto"));
            Integer state = messageService.insert(message);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state",state);
            jsonObject.put("messageInfo",message.toString());
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            System.out.println(formatter.format(date) + " =======>  接口：/message/setMessage  请求体："+ JSONBody );
            System.out.println("########## 返回结果 ########## \n " + jsonObject.toString());
            System.out.println("##############################");
            return jsonObject;
        }catch (Exception e){
            e.printStackTrace();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("state","input Error");
        }
      return new JSONObject();
    }




}
