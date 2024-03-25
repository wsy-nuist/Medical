package com.nuist.medical.Controller.Login;


import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Pojo.User;
import com.nuist.medical.Service.Impl.UserServiceImpl;
import com.nuist.medical.Utils.JwtConfig;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
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
 * @Date Created in 2024-03-24-21:26
 * @Modified By:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private JwtConfig jwtService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/userLogin")
    public Map<String,Object> userLogin(@RequestBody User user){
        Map<String,Object> res=new HashMap<>();
        if(!StringUtils.isEmpty(user.getUser_id())&&!StringUtils.isEmpty(user.getPassword())){
            User loginUser=userService.hasUser(user);
            if(loginUser!=null) {
                res.put("user",loginUser);
                res.put("token", jwtService.generateJwt(user));
                res.put("status", HttpCode.Http_OK.getCode());
            }
            else
                res.put("status", HttpCode.INTERNAL_ERROR.getCode());
        }
        else{
            res.put("status", HttpCode.INTERNAL_ERROR.getCode());
        }
        return res;
    }

}







//eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMSIsImlhdCI6MTcxMTMzNTY2NCwiZXhwIjoxNzExNDIyMDY0fQ.yWdaCBVwoEoSWFBKgZESH9oTEmOw-xEAS-S9PG2GTCE








