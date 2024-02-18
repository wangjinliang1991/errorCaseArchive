package org.example.ws;

import org.example.soap.ws.client.generated.MobileCodeWS;

/**
 *  webservice调用demo, 生成文件 wsimport -s src/main/java/ -keep -p org.example.soap.ws.client.generated "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl"
 * @author wangjl
 * @date 2024/2/18
 */
public class MobileCodeWSInvoke {
    public static void main(String[] args) {
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        String mobileCode = mobileCodeWS.getMobileCodeWSSoap().getMobileCodeInfo("13516872186", null);
        System.out.println(mobileCode);
    }
}
