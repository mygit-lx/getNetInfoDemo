package com.test;

import com.util.GetInfo;

/**
 * Created by LuoX-PC on 2016/8/23.
 */
public class Test {
    @org.junit.Test
    public void test01(){
        GetInfo getInfo = new GetInfo();
        //定义访问的链接
        String url = "http://www.baidu.com";
        //自定义正则表达式：获取你想要的内容
        String regularStr = "src=\\\"(.+?)\\\"";
        String re = getInfo.connUtil(url);
        String r = getInfo.regularUtil(re,regularStr);
        //System.out.println(re);
        System.out.println(r);
    }
}
