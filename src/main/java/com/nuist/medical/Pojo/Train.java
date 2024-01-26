package com.nuist.medical.Pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Train {

    private Integer id;

    private String file_name;

    private Date upload_time;

    private String save_pth;

    private String fill_type;

    public Train(){

    }


}
