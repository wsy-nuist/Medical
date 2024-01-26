package com.nuist.medical.Controller.Model;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Pojo.Model;
import com.nuist.medical.Service.Impl.ModelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        modelService.createEmptyModel(model.getString("model_name"));
        result.put("status",200);
        return result;
    }

}
