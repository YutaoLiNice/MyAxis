package Axis2ServiceClient.axis2;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

public class WebserviceClient {

    public static void main(String[] args) {

        try {
            //本机tomcat端口为18080,参数是wsdl网址的一部分
            EndpointReference targetEPR = new EndpointReference("http://localhost:8080/services/AxisService");
            RPCServiceClient sender = new RPCServiceClient();
            Options options = sender.getOptions();
            //超时时间20s
            options.setTimeOutInMilliSeconds(2 * 20000L);
            options.setTo(targetEPR);
            /**
             * 参数:
             * 1：在网页上执行 wsdl后xs:schema标签的targetNamespace路径
             * <xs:schema  targetNamespace="http://axis2.com">
             * 2：<xs:element name="test"> ======这个标签中name的值
             */
           QName qname = new QName("http://service.Axis2Service", "sum");
            //方法的入参
           // String str = "我是客户端";
            int a=1;
            int b=2;
            Object[] param = new Object[]{a,b};
            //这是针对返值类型的
            Class<?>[] types = new Class[]{String.class};
            /**
             * RPCServiceClient类的invokeBlocking方法调用了WebService中的方法。
             * invokeBlocking方法有三个参数
             * 第一个参数的类型是QName对象，表示要调用的方法名；
             * 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
             * 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
             * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}。
             */
            Object[] response = sender.invokeBlocking(qname, param, types);
            System.out.println(response[0]);
        } catch (AxisFault e) {
            e.printStackTrace();
        }
    }
}
