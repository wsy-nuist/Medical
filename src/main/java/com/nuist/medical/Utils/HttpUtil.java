package com.nuist.medical.Utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import com.alibaba.fastjson.JSON;

public class HttpUtil {

    public String getPostRequest(URL url, int timeout, Map<String,String> param) throws IOException {
        String result=null;
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setConnectTimeout(timeout);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json");
        connection.setDoOutput(true);
        //将需要发送的参数转换为json数据格式
        String params=JSON.toJSONString(param);
        //写入输出流
        OutputStream op=connection.getOutputStream();
        op.write(params.getBytes());
        op.flush();
        op.close();

        if(connection.getResponseCode()==200){
            String lines="";
            StringBuffer sb=new StringBuffer();
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((lines=in.readLine())!=null)
                sb.append(lines);
            in.close();
            result=sb.toString();
        }
        return result;

    }

}
