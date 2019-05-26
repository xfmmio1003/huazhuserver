package com.qingying.mqtt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpUitls {

    private static final Logger logger = LoggerFactory.getLogger(HttpUitls.class);
    public static Map<String,String> globalMap = new HashMap<String, String>();


    public static String sendPost(String hotelId,String roomNo,String msgType,String msg) {

        long t1 = new Date().getTime();

        StringBuffer requestParams = new StringBuffer("info=");
        StringBuffer strUrl = new StringBuffer("http://");
        //根据酒店编号 和 房间号得出对应ip地址和端口,端口暂时固定为84
        String roomIp = globalMap.get("ip."+hotelId+"."+roomNo);
        strUrl.append(roomIp).append(":84");
        requestParams.append(msg);

        /**
         * 连接服务器 发送指令
         */
        URL url = null;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(strUrl.toString());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            //设置接收数据的格式  
            httpURLConnection.setRequestProperty("Accep","*/*");

            //设置发送数据的格式  text/html application/json
            httpURLConnection.setRequestProperty("Content-Type","text/html");

            httpURLConnection.connect();
            long t2 = new Date().getTime();
            double d = (double) ((t2-t1));

            logger.info("send To:"+strUrl.toString()+" msg:"+requestParams.toString());
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((httpURLConnection.getOutputStream()),"UTF-8");
            outputStreamWriter.append(requestParams.toString());
            outputStreamWriter.flush();
            outputStreamWriter.close();
            logger.info("connetct success 耗时:"+d +" ms");

            //使用BufferedReader输入流来读取URL的响应  
            BufferedReader bufferedReader =  new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String strLine = "";
            while((strLine = bufferedReader.readLine()) != null){
                stringBuffer.append(strLine);
            }
            bufferedReader.close();
            logger.info("响应:"+stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return null;

    }
}
