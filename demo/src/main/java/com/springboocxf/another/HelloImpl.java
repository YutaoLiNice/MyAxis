package com.springboocxf.another;

import org.springframework.stereotype.Component;
import javax.jws.WebService;
@Component("HelloImpl")
@WebService(
        serviceName="helloService",//【对外发布的服务名 】：需要见名知意
        targetNamespace="http://another.springboocxf.com",//【名称空间】：【实现类包名的反缀】
        endpointInterface = "com.springboocxf.another.IHello")//【服务接口全路径】  【接口的包名】
public class HelloImpl implements IHello {
    @Override
    public String sayHello(String name) {
        System.out.println("=======================>" + name);
        return "hello ： " + name;
    }
}

