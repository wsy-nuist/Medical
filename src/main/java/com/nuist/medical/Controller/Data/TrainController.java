package com.nuist.medical.Controller.Data;

import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Pojo.Train;
import com.nuist.medical.Service.Impl.TrainServiceImpl;
import com.nuist.medical.Utils.CsvUtil;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/train")
@RestController
public class TrainController {


    @Value("${upload.temp}")
    private String tempFilePrefix;

    @Autowired
    TrainServiceImpl trainService;


    @GetMapping("/getTrainList")
    public Map<String,Object> getTrainDataList(){
        Map<String,Object> result=new HashMap<>();
        result.put("status",HttpCode.Http_OK.getCode());
        result.put("trainList",trainService.getTrainList());
        return result;
    }

    @PostMapping("/uploadTrainData")
    public Map<String,Object> uploadTrainData(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException {
        Map<String,Object> result=new HashMap<>();
        String file_name=file.getOriginalFilename();
        String save_pth=tempFilePrefix+file_name;
        File tempFile=new File(save_pth);
        Train train=Train.builder().save_pth(save_pth).file_name(file_name).upload_time(new Date(System.currentTimeMillis())).build();
        // 转换成本地文件
        file.transferTo(tempFile);
        /*
        * 缺少上传到服务
        * */
        trainService.uploadNewTrainList(train);
        result.put("status",HttpCode.Http_OK.getCode());
        result.put("need_fill", CsvUtil.CsvHasEmptyCell(tempFile));
        return result;
    }

}
