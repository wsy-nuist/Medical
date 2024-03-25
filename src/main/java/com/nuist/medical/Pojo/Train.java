package com.nuist.medical.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Train {

    private Integer id;

    private String file_name;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date upload_time;

    private String save_pth;

    private String fill_type;

    private String size;

    private String type;

    public Train(){

    }


}
