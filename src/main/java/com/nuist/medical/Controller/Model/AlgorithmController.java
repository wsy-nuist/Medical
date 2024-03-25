package com.nuist.medical.Controller.Model;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Pojo.Algorithm;
import com.nuist.medical.Service.Impl.AlgorithmServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-03-17-15:10
 * @Modified By:
 */
@RequestMapping("/algorithm")
@RestController
public class AlgorithmController {

    @Value("${upload.algorithm}")
    private String algorithmSavePth;

    @Autowired
    private AlgorithmServiceImpl algorithmService;


    @PostMapping("/getAlgorithmList")
    public Map<String,Object> getAlgorithmList(){
        Map<String,Object> res=new HashMap<>();
        List<? extends Algorithm> algorithmsList=algorithmService.getAlgorithmList();
        res.put("status", HttpCode.Http_OK.getCode());
        res.put("algorithmList",algorithmsList);
        return res;
    }


    @PostMapping("/uploadAlgorithm")
    public Map<String,Object> uploadAlgorithm(@Param("file")MultipartFile file,
                                              @Param("algorithmName") String algorithmName,
                                              @Param("algorithmDescription") String algorithmDescription,
                                              @Param("startCode")String startCode){
        Map<String,Object> res=new HashMap<>();
        String fileName=file.getOriginalFilename();
        String savePth=algorithmSavePth+fileName;
        File tempFile=new File(savePth);
        try {
            file.transferTo(tempFile);
            Algorithm algorithm=Algorithm.builder().
                    algorithm_name(algorithmName).
                    algorithm_description(algorithmDescription).
                    save_pth(savePth).
                    type(1).
                    start_code(startCode).
                    upload_time(new Date(System.currentTimeMillis())).
                    build();
            algorithmService.uploadNewAlgorithm(algorithm);
            res.put("status",HttpCode.Http_OK.getCode());
        } catch (IOException e) {
            res.put("status",HttpCode.INTERNAL_ERROR.getCode());
        }
        return res;
    }

}
