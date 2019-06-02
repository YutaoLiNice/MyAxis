package com.springboocxf.demo;

import com.springboocxf.another.HelloImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


@Configuration
public class TestConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/test/*");
    }
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), userService());
        endpoint.publish("/user");
        return endpoint;
    }
    //mdm同步人员部门
    /*@Bean
    public Endpoint syncEmpOrgImpl() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new SyncEmpOrgImpl());// 绑定要发布的服务实现类
        endpoint.publish("/syncEmpOrgImpl"); // 接口访问地址
        return endpoint;
    }*/
    //hello
    @Bean
    public Endpoint hello() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new HelloImpl());// 绑定要发布的服务实现类
        endpoint.publish("/hello"); // 接口访问地址
        return endpoint;
    }
}

