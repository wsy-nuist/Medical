package com.nuist.medical.Controller.Data;

import com.nuist.medical.Constant.HttpCode;
import com.nuist.medical.Utils.CsvUtil;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/train")
@RestController
public class TrainController {


    @Value("${upload.temp}")
    private String tempFilePrefix;



    @GetMapping("/getTrainList")
    public Map<String,Object> getTrainDataList(){
        Map<String,Object> result=new HashMap<>();
        result.put("status",HttpCode.Http_OK.getCode());
        return result;
    }

    @PostMapping("/uploadTrainData")
    public Map<String,Object> uploadTrainData(@RequestParam("file") MultipartFile file) throws IOException, CsvValidationException {
        Map<String,Object> result=new HashMap<>();
        File tempFile=new File(tempFilePrefix+file.getOriginalFilename());
        // 转换成本地文件
        file.transferTo(tempFile);
        /*
        * 缺少上传到服务
        * */
        result.put("status",200);
        result.put("need_fill", CsvUtil.CsvHasEmptyCell(tempFile));
        return result;
    }

}
