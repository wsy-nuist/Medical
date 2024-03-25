package com.nuist.medical.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-21:49
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
public class User {

    private Integer id;

    private String user_id;

    private String username;

    private String password;

    private String avatar_url;

    public User(){

    }
}
