package com.springboocxf.demo;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class handTest {

    public static void main(String args[]) throws Exception{
       // demoUser();
        demoHello();
    }
    private static void demoHello() throws Exception {
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8090/test/hello?wsdl");
        Object[] objects=client.invoke("sayHello","lili");

        //输出调用结果
        System.out.println("*****"+objects[0].toString());
    }


    private static void demoUser() throws Exception {
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8090/test/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("getUser","411001");
        //输出调用结果
        System.out.println("*****"+objects[0].toString());
    }
}
