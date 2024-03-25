package com.nuist.medical.Service.Impl;

import com.nuist.medical.Pojo.User;
import com.nuist.medical.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-25-14:41
 * @Modified By:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService userService;


    @Override
    public User hasUser(User user) {
        return userService.hasUser(user);
    }

    @Override
    public User getUserInfo(String user_id) {
        return userService.getUserInfo(user_id);
    }
}
