package com.nuist.medical.Controller.Model;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Pojo.Model;
import com.nuist.medical.Pojo.Train;
import com.nuist.medical.Service.Impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/model")
@RestController
public class ModelController {

    @Autowired
    ModelServiceImpl modelService;

    @PostMapping("/getModelList")
    public Map<String,Object> getModelList(){
        Map<String,Object> result=new HashMap<>();
        result.put("status",200);
        result.put("modelList",modelService.queryModelList());
        return result;
    }

    @PostMapping("/createEmptyModel")
    public Map<String,Object> createEmptyModel(@RequestBody JSONObject model){
        Map<String,Object> result=new HashMap<>();
        Model m=Model.builder().
                model_name(model.getString("modelName")).
                model_description(model.getString("modelDescription")).
                create_time(new Date(System.currentTimeMillis())).
                build();
        modelService.createEmptyModel(m);
        result.put("status", HttpCode.Http_OK.getCode());
        return result;
    }

    @PostMapping("/modelTrain")
    @Async
    public void modelTrain(){

    }

}
