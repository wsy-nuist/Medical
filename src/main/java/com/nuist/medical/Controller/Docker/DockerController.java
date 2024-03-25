package com.nuist.medical.Controller.Docker;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Service.Impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-24-12:47
 * @Modified By:
 */
@RestController
@RequestMapping("/docker")
public class DockerController {

    @Autowired
    private ImageServiceImpl imageService;

    @PostMapping("/getDockerImageList")
    public Map<String,Object> getDockerImageList(/*@RequestBody JSONObject request*/){
        Map<String,Object> res=new HashMap<>();
        List<?> imageList=imageService.getImageList();
        res.put("status", HttpCode.Http_OK.getCode());
        res.put("imageList",imageList);
        return res;
    }



}
