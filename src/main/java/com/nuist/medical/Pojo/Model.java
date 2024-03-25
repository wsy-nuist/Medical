package com.nuist.medical.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Model {

    private String model_id;

    private String model_name;

    private String model_description;

    @JsonFormat(pattern ="YYYY-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private Date create_time;

    private String model_type;

    private String train_data_id;

    private String  save_pth;


    public Model(){

    }
}
