package com.nuist.medical.Pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Model {

    private String model_id;

    private String model_name;

    private String model_type;

    private String train_data_id;

    private String  save_pth;
    public Model(){

    }
}
