package org.example;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.hash.MurmurHash;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjl
 * @date 2023/12/14
 */
public class HutoolTest {

    public static void login() {
        String defaultAccount =  "test_arm";
        String account = StrUtil.format("{}@{}", "aaa",defaultAccount);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("lastCodeKey", "")
                .set("loginName",account)
                .set("password",11)
                .set("extenType","Local")
                .set("remember",true)
                .set("login_busyType",true)
                .set("loginFlag","kf");
        String data = JSONUtil.toJsonStr(jsonObject);

        String escape = EscapeUtil.escape(data);
        System.out.println(data);
    }

    public static void createSafeKey() {

    }

    public static void socket() {
        String token = "b62badb0-9a49-11ee-b1fa-dbb97f0e8935";
        String exten = "8034";
        String account = "N00000020169";
        String password = "123456Aa";
        String token1 = DigestUtil.md5Hex(token + "_&_" + exten + "_&_" + account);
        String pwd = DigestUtil.md5Hex(token1 + DigestUtil.md5Hex(password));
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("username",exten).set("password",pwd).set("account",account);
        String base64Data = Base64.encode(JSONUtil.toJsonStr(jsonObject));
        // 设置密钥和密钥偏移量
        AES aes = new AES("CBC",  "PKCS7Padding","7moor1234567891234567890".getBytes(),"88f875ce0e9b4884".getBytes());
        // 加密为16进制表示
        String enHex = aes.encryptHex(base64Data);
        System.out.println(enHex);
    }


    public static void getEndOfDay() {
        Date date = DateUtil.date();
        Date endOfDay = DateUtil.endOfDay(date);
        String eodStr = endOfDay.toString();
        System.out.println(eodStr);
    }

    public static void quote() {
        // {"code": "1234"}
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code","1234");
        String quote = JSONUtil.quote(JSONUtil.toJsonStr(jsonObject));
        System.out.println(quote);
    }

    public static void getShortUrl() {
        String longUrl = "companyId=2&applicationId=3&worksheetId=655f619091f9d2730a8f95a4&orderId=KGD00000004&fieldId=65840b628cc3e66621b121a1";
        String s = hashToBase62(longUrl);
        System.out.println(s);
    }


    public static String hashToBase62(String str) {
        int i = MurmurHash.hash32(str);
        long num = i < 0 ? Integer.MAX_VALUE - (long) i : i;
        return convertDecToBase62(num);
    }
    private static String convertDecToBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int i = (int) (num % SIZE);
            sb.append(CHARS[i]);
            num /= SIZE;
        }
        return sb.reverse().toString();
    }

    private static char[] CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static int SIZE = CHARS.length;


    public static void short1() {
        String urlStr = "https://iflyzj.hmsk.com.cn/mopower/businessUpload?companyId={companyId}&applicationId={applicationId}&worksheetId={worksheetId}&orderId=${orderId}&fieldId={fieldId}";

        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String query = url.getQuery();
        System.out.println(query);
        Map<String,String> queryParams = new HashMap<>();
        for (String param : query.split("&")) {
            String[] keyValue = param.split("=");
            queryParams.put(keyValue[0], keyValue[1]);
        }
        // 输出查询参数
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static  void extractLongUrl() {
        String longUrl = "companyId=1&applicationId=22&worksheetId=333&orderId=444&fieldId=555";
        Map<String, String> queryParams = new HashMap<>();
        for (String param : longUrl.split("&")) {
            String[] keyValue = param.split("=");
            queryParams.put(keyValue[0], keyValue[1]);
        }
        System.out.println(queryParams);
    }


    public static void main(String[] args) {
        // e559a22da3a184858300b8bb99a81619eb3d4508e69d47c6668bf3ba0cdaa1d1f42abedb750ab4add64663c9b95a0c794b65b4a64708d7929c9a9e2fc79c1ada80d109a5265f76c243e78eb1d583e0bf7f7a6a07d2e9bcb07f6520174588178439c2a47e4f31af547f6534449e7d22d63646a9912bb732d2d9478bbe888650f2
        // e559a22da3a184858300b8bb99a81619eb3d4508e69d47c6668bf3ba0cdaa1d1f42abedb750ab4add64663c9b95a0c794b65b4a64708d7929c9a9e2fc79c1ada80d109a5265f76c243e78eb1d583e0bf7f7a6a07d2e9bcb07f6520174588178439c2a47e4f31af547f6534449e7d22d63646a9912bb732d2d9478bbe888650f2
//        socket();
//        getEndOfDay();
//        login();
//        quote();
//        getShortUrl();
//        short1();
        extractLongUrl();
    }
}
