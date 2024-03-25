package com.nuist.medical.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-12:33
 * @Modified By:
 */
@Data
@Builder
@AllArgsConstructor
public class Images {

    private Integer id;

    private String image_id;

    private String image_name;

    private String image_size;

    private Date create_time;

    public Images(){


    }
}
