package com.qingying.common;

import java.util.Calendar;

/**
 * Author: Elephant
 * Date: 2019-4-22
 * Desc:工具类
 */
public class ElephantUtils {

    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMdd = "yyyyMMdd";
    private final static String providerId = "3";

    /**
     * 格式为：供应商识别号_酒店编号_自增序号，
     * 自增序号用 uint64
     *
     * @param hotelId
     * @return
     */
    public static String genMsgId(String hotelId) {
        StringBuffer stringBuffer = new StringBuffer(providerId);
        stringBuffer.append("_").append(hotelId);
        long basetime = Long.parseLong("1555985000000");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
       /* SimpleDateFormat format = new SimpleDateFormat("mmss");
        String mmss = format.format(calendar.getTime());
        System.out.println(mmss);*/
        stringBuffer.append("_").append((timeInMillis - basetime) / 100);
        //System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    /*public static void main(String[] args) {
        genMsgId("8000201");
    }*/


}
