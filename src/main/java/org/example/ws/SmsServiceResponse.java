package org.example.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.Response;

/**
 * @author wangjl
 * @date 2024/2/18
 */
@XmlRootElement(name = "smsServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsServiceResponse {
    private Response result;

    public Response getResult() {
        return result;
    }

    public void setResult(Response result) {
        this.result = result;
    }
}
