package com.nuist.medical.Service;


import com.nuist.medical.Pojo.Model;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelService {

    // query model you have created
    List<Model> queryModelList();

    // create a new model
    void createEmptyModel(String model_name);

}
