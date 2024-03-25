package com.nuist.medical.Service;

import com.nuist.medical.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-25-14:40
 * @Modified By:
 */
@Mapper
public interface UserService {

    //判断是否存在用户
    User hasUser(User user);

    //获取用户信息
    User getUserInfo(String user_id);
}
