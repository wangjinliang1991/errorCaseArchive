package org.example.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author wangjl
 * @date 2024/2/18
 */
@Endpoint
public class SmsServiceEndpoint {
    private static final String NAMESPACE_URI = "http://www.sms.upbms.hp.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "smsServiceRequest")
    @ResponsePayload
    public Element handleRequest(@RequestPayload SmsServiceRequest request) throws Exception {
        // 解析传入的参数
        String target = request.getTarget();
        String action = request.getAction();
        String xmldata = request.getXmldata();
        String brief = request.getBrief();
        System.out.println("target is: "+target);
        System.out.println("action is: "+action);
        System.out.println("xmldata is: "+xmldata);
        System.out.println("brief is: "+brief);


        // 构造SOAP响应
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element envelope = document.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "soap:Envelope");
        Element body = document.createElement("soap:Body");
        envelope.appendChild(body);

        Element smsServiceResponse = document.createElementNS(NAMESPACE_URI, "ns1:smsServiceResponse");
        body.appendChild(smsServiceResponse);

        Element result = document.createElement("result");
        smsServiceResponse.appendChild(result);

        // 构造响应XML
        String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<SmsServiceRsp>" +
                "<Response>" +
                "<RspCode>1000</RspCode>" +
                "</Response>" +
                "</SmsServiceRsp>";
        result.setTextContent(responseXml);

        return envelope;
    }
}
