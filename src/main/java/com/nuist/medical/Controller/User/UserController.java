package com.nuist.medical.Controller.User;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Annotation.LoginRequired;
import com.nuist.medical.Annotation.LoginUser;
import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Pojo.User;
import com.nuist.medical.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-25-14:34
 * @Modified By:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @LoginRequired
    @PostMapping("/getUserInfo")
    public Map<String,Object> getUserInfo(@LoginUser String user_id){
        Map<String,Object> res=new HashMap<>();
        User user=userService.getUserInfo(user_id);
        res.put("user",user);
        res.put("status", HttpCode.Http_OK.getCode());
        return res;
    }
}
