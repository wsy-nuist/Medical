package com.nuist.medical.Controller.Data;
import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Annotation.LoginRequired;
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
import java.text.DecimalFormat;
import java.util.*;


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
        String fileName=file.getOriginalFilename();
        String savePth=tempFilePrefix+fileName;
        File tempFile=new File(savePth);
        DecimalFormat df =new DecimalFormat("0");
        Train train=Train.builder().
                save_pth(savePth).
                file_name(fileName.substring(0,fileName.lastIndexOf("."))).
                upload_time(new Date(System.currentTimeMillis())).
                //文件大小
                size(df.format(file.getSize()/1024)).
                type(fileName.substring(fileName.lastIndexOf(".")+1)).
                build();
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

    //删除文件
    @DeleteMapping("/deleteFile")
    public Map<String,Object> deleteFile(@RequestBody JSONObject request){
        Map<String,Object> res=new HashMap<>();
        File file=new File(request.getString("save_pth"));
        try{
            file.delete();
            trainService.deleteTrainFile(request.getString("id"));
        }
        catch (Exception e){
            res.put("status",HttpCode.INTERNAL_ERROR.getCode());
            return res;
        }
        res.put("status",HttpCode.Http_OK.getCode());
        return res;
    }

    //查询文件
    @PostMapping("/queryFile")
    public Map<String,Object> queryFile(@RequestBody JSONObject request){
        Map<String,Object> res=new HashMap<>();
        String filename=request.getString("filename");
        List<Train> trainList=trainService.queryTrainList(filename);
        res.put("status",HttpCode.Http_OK.getCode());
        res.put("trainList",trainList);
        return res;
    }

}
