package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LuoX-PC on 2016/8/23.
 */
public class GetInfo {
    public  String connUtil(String url){
        //用于存储网页内容
        String webInfo = "";
        //缓冲字符输入流
        BufferedReader br = null;
        try {
            //将字符串url转url对象
            URL urlInfo = new URL(url);
            //初始化url连接
            URLConnection connection = urlInfo.openConnection();
            connection.connect();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine())!=null){
                webInfo += line;
            }
        }catch (Exception e){
            System.out.println("请求异常："+e);
            e.printStackTrace();
        }finally {
            try {
                if(br != null){
                    br.close();
                }
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
        return webInfo;
    }

    public  String regularUtil(String webInfo, String regularStr){
        Pattern pattern = Pattern.compile(regularStr);
        Matcher matcher = pattern.matcher(webInfo);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }
}
