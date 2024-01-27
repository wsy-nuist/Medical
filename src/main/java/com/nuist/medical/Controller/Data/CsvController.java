package com.nuist.medical.Controller.Data;

import com.alibaba.fastjson.JSONObject;
import com.nuist.medical.Constant.HttpCode;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 吴思宇
 * @Description:
 * @Param:
 * @Date Created in 2024-01-27-17:18
 * @Modified By:
 */

@RestController
@RequestMapping("/csv")
public class CsvController {

    @PostMapping("/csvReader")
    public Map<String,Object> csvReader(@RequestBody JSONObject file){
        Map<String,Object> result=new HashMap<>();
        String[] line;
        List<String[]> lines=new ArrayList<>();
        Integer begin=file.getInteger("begin");
        Integer end=file.getInteger("end");
        Integer index=0;
        try{
            CSVReader csvReader=new CSVReader(new FileReader(file.getString("save_pth")));
            while((line=csvReader.readNext())!=null){
                if(index>=begin&&index<=end){
                    lines.add(line);
                }
                else if(index>end){
                    break;
                }
                index++;
            }

            csvReader.close();
        }
        catch(CsvValidationException|IOException e){
            result.put("status", HttpCode.INTERNAL_ERROR.getCode());
        }

        return result;
    }
}
