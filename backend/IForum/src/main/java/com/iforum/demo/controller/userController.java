package com.iforum.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iforum.demo.entity.user;
import com.iforum.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@EnableAutoConfiguration
@CrossOrigin
@RequestMapping(value = "/user", produces = "application/json; charset=utf-8")
public class userController {

    @Autowired
    private userService userService;

    @ResponseBody
    @RequestMapping(value = "/register" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject register(@RequestBody String JSONBody){
        try {
            JSONObject object = JSONObject.parseObject(JSONBody);
            JSONObject result = new JSONObject();

            if (!object.containsKey("accountNum") && !object.containsKey("password")){
                result.put("state","Error");
                result.put("RequestBody",JSONBody);
                result.put("isCreateSuccess",0);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/register  请求体：" + JSONBody + " 返回结果数：1"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
            else {
                int isCreateSuccess = userService.insert(new user((String) object.get("accountNum"),(String)object.get("password")));
                result.put("state","success");
                result.put("RequestBody",JSONBody);
                result.put("isCreateSuccess",isCreateSuccess);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/register  请求体：" + JSONBody + " 返回结果数：1"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("state","Error");
            result.put("RequestBody",JSONBody);
            result.put("isCreateSuccess",0);
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/update" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject update(@RequestBody String JSONBody){
        try {
            JSONObject object = JSONObject.parseObject(JSONBody);
            JSONObject result = new JSONObject();
            if (!object.containsKey("accountNum") && !object.containsKey("password")){
                result.put("state","Error");
                result.put("RequestBody",JSONBody);
                result.put("isCreateSuccess",0);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/register  请求体：" + JSONBody + " 返回结果数：1"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
            else {
                int isCreateSuccess = userService.insert(new user((String) object.get("accountNum"),(String)object.get("password")));
                result.put("state","success");
                result.put("RequestBody",JSONBody);
                result.put("isCreateSuccess",isCreateSuccess);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/register  请求体：" + JSONBody + " 返回结果数：1"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("state","Error");
            result.put("RequestBody",JSONBody);
            result.put("isCreateSuccess",0);
            return result;
        }
    }

}
