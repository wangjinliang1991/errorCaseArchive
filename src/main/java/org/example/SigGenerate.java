package org.example;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestUtil;

import java.util.Date;

/**
 * @author wangjl
 * @date 2023/11/8
 */
public class SigGenerate {
    public static String generateSig() {
        String APISecret = "f8437320-276a-11ed-99b9-133b3aefc64d";
        Date date = DateUtil.date();
        String dateStr = DateUtil.format(date, DatePattern.PURE_DATETIME_PATTERN);
//        String dateStr = "20231108134008";
        String account = "X00000020193";
        String str = account+APISecret+dateStr;
        return DigestUtil.md5Hex(str).toUpperCase();
    }

    public static String generateAuthorization() {
        String account = "X00000020193";
        Date date = DateUtil.date();
        String dateStr = DateUtil.format(date, DatePattern.PURE_DATETIME_PATTERN);
//        String dateStr = "20231108134008";
        String original = account+":"+dateStr;
        return Base64.encode(original);
    }


    public static void main(String[] args) {
        System.out.println("sig");
        System.out.println(generateSig());
        System.out.println("Authorization");
        System.out.println(generateAuthorization());
    }
}
