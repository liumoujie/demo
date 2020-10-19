package com.manulife.lmj;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
public class WebServiceApplication {
    public static void main(String[] args) throws Exception {
//        SpringApplication.run(WebServiceApplication.class, args);

        JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();

        List<String> files = new ArrayList<>();
        files.add("C:\\workSpace\\demo\\ws\\src\\main\\resources\\wsdl\\WeatherWebService.wsdl");

        Client client=dcflient.createClient("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl", files);

        Object[] objects=client.invoke("getWeatherbyCityName","成都");
        System.out.println("*******"+objects[0].toString());

//        Object[] objectall=client.invoke("getAlLUser");
//        System.out.println("*******"+objectall[0].toString());

    }
}
