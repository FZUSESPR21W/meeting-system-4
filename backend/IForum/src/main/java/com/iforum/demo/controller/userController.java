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
    @RequestMapping(value = "/getUserByAccountNum" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject getUserByAccountNum(@RequestBody String JSONBody){
        try {
            JSONObject object = JSONObject.parseObject(JSONBody);
            JSONObject result = new JSONObject();
            if (!object.containsKey("accountNum") && !object.containsKey("password")){
                result.put("state","Error");
                result.put("RequestBody",JSONBody);
                result.put("userInfo",null);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/getUserByAccountNum  请求体：" + JSONBody + " 返回结果数：0"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
            else {
                user user1 = userService.getUserByAccountNum((String) object.get("accountNum"));
                if (user1 == null){
                    result.put("state","Error");
                    result.put("RequestBody",JSONBody);
                    result.put("userInfo","user does not exist");
                    return result;
                }else {
                    result.put("state","success");
                    result.put("RequestBody",JSONBody);
                    result.put("id",user1.getId().toString());
                    result.put("accountNum",user1.getAccoutnum().toString());
                    result.put("password",user1.getPassword().toString());
                    result.put("name",user1.getName() == null ? "Null":user1.getName());
                    result.put("sex",user1.getSex() == null ? "Null":user1.getSex());
                    result.put("identity",user1.getIdentity() == null ? "Null": user1.getIdentity());
                    result.put("joinmeetingid",user1.getJoinmeetingid() == null ? "Null" : user1.getJoinmeetingid());
                    result.put("joinsmallforumid",user1.getJoinsmallforumid() == null ? "Null" : user1.getJoinsmallforumid() );
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(formatter.format(date) + " =======>  接口：/user/getUserByAccountNum  请求体：" + JSONBody + " 返回结果数：1"  );
                    System.out.println("########## 返回结果 ########## \n " + result);
                    System.out.println("##############################");
                    return result;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("state","Error");
            result.put("RequestBody",JSONBody);
            result.put("userInfo",null);
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JSONObject updateUser(@RequestBody String JSONBody){
        try {
            JSONObject object = JSONObject.parseObject(JSONBody);
            JSONObject result = new JSONObject();
            if (!object.containsKey("accountNum") && !object.containsKey("password")){
                result.put("state","Error");
                result.put("RequestBody",JSONBody);
                result.put("userInfo",null);
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                System.out.println(formatter.format(date) + " =======>  接口：/user/updateUser  请求体：" + JSONBody + " 返回结果数：0"  );
                System.out.println("########## 返回结果 ########## \n " + result);
                System.out.println("##############################");
                return result;
            }
            else {
                user user1 = userService.getUserByAccountNum((String) object.get("accountNum"));


                if (user1 == null){
                    result.put("state","Error");
                    result.put("RequestBody",JSONBody);
                    result.put("userInfo","user does not exist");
                    return result;
                }else {
                    if(object.containsKey("name")) user1.setName((String)object.get("name"));
                    if(object.containsKey("sex")) user1.setSex((String)object.get("sex"));
                    if(object.containsKey("joinmeetingid")) user1.setJoinmeetingid((String)object.get("joinmeetingid"));
                    if(object.containsKey("joinsmallforumid")) user1.setJoinsmallforumid((String)object.get("joinsmallforumid"));
                    userService.updateUser(user1);

                    result.put("state","success");
                    result.put("RequestBody",JSONBody);
                    result.put("id",user1.getId().toString());
                    result.put("accountNum",user1.getAccoutnum().toString());
                    result.put("password",user1.getPassword().toString());
                    result.put("name",user1.getName() == null ? "Null":user1.getName());
                    result.put("sex",user1.getSex() == null ? "Null":user1.getSex());
                    result.put("identity",user1.getIdentity() == null ? "Null": user1.getIdentity());
                    result.put("joinmeetingid",user1.getJoinmeetingid() == null ? "Null" : user1.getJoinmeetingid());
                    result.put("joinsmallforumid",user1.getJoinsmallforumid() == null ? "Null" : user1.getJoinsmallforumid() );
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(formatter.format(date) + " =======>  接口：/user/updateUser  请求体：" + JSONBody + " 返回结果数：1"  );
                    System.out.println("########## 返回结果 ########## \n " + result);
                    System.out.println("##############################");
                    return result;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            JSONObject result = new JSONObject();
            result.put("state","Error");
            result.put("RequestBody",JSONBody);
            result.put("userInfo",null);
            return result;
        }
    }



}
