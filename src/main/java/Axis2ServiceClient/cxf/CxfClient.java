package Axis2ServiceClient.cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


public class CxfClient {
    public static void main(String[] args) {
        testCxfClient();
    }


    public  static  void testCxfClient() {
        //结果
        String result = "";
        int a =3,b=3;
        //axis2服务端地址
        String url = "http://localhost:8080/services/AxisService";

        //创建工厂
        final JaxWsProxyFactoryBean sf = new JaxWsProxyFactoryBean();
        //对工厂对象附加属性,服务端地址,客户端接口
        sf.setServiceClass(cxfInterface.class);
        sf.setAddress(url);
        //通过工厂方法创建具体实现的实例,也就是上面定义的接口
        cxfInterface zipKinServiceTest = (cxfInterface) sf.create();
        //调用接口方法,接收返回值
        result = zipKinServiceTest.getServiceTest(a ,b);
        System.out.println(result.toString());
    }
}
