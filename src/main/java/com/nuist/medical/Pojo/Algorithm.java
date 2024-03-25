package com.nuist.medical.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-17-14:53
 * @Modified By:
 */

@Data
@Builder
@AllArgsConstructor
public class Algorithm {

    private Integer id;

    private String algorithm_name;

    private String algorithm_description;

    @JsonFormat(pattern = "YYYY-MM-dd",timezone = "GMT+8")
    private Date upload_time;

    private String save_pth;

    private Integer type;

    private String start_code;

    public Algorithm(){

    }
}
