package com.yiwen.fastjson.rce.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yiwen.fastjson.rce.bean.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2020年04月12日 10时41分
 * @Created by yiwen
 */
@RestController
@RequestMapping("/user")
public class RceController {

    @PostMapping("/insert")
    public Integer insert(@RequestBody User user){
        System.out.println("insert enter user:" + JSONObject.toJSONString(user));
        //存在漏洞的方法
        try {
            JSON.parse(user.getName());
        } catch (Exception e) {
            //do nothing
        }

        System.out.println("insert end");
        /** 模拟返回成功 **/
        return 1;
    }

}
