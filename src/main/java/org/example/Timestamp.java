package org.example;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * @author wangjl
 * @date 2024/1/9
 */
public class Timestamp {
    public static void main(String[] args) {
        String timeStr = "1704784010913";
        long time = Long.parseLong(timeStr);
//        System.out.println(System.currentTimeMillis());
//        long time = System.currentTimeMillis();

        DateTime dateTime = DateUtil.date(time);
        System.out.println(dateTime);
    }
}
