package org.example.url;

import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wangjl
 * @date 2024/1/11
 */
public class UrlTest {
    public static void main(String[] args) {
        String longUrl = "https://iflyzj-test.hmsk.com.cn:8866/mopower/businessUpload?companyId=1&applicationId=1&viewId=655f619091f9d2730a8f95ab&worksheetId=655f619091f9d2730a8f95a4&orderId=KGD00000022&orderName=ebfc59f0a09111ee8a8d61741676e21a&fieldId=f00640209fe611ee9763416955c16e17";
        URL url = null;
        try {
            url = new URL(longUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        String query = url.getQuery();
        System.out.println(query);
        String s = StrUtil.subBefore(longUrl, query, true);
        System.out.println(s);
    }


}
