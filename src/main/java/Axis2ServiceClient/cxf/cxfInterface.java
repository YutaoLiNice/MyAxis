package Axis2ServiceClient.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


/**
 * ZipKinService:webservice服务端提供的服务名-------->service.xml <service name="AxisService">
 * targetNamespace:对应webservice服务端wsdl?中的targetNamespace
 */
@WebService(name = "AxisService",targetNamespace = "http://service.Axis2Service")
public interface cxfInterface {

    /**
     * CXF客户端本地接口调用端,参数param
     * @param a b @WebMethod(operationName = "sum")服务端方法名字,@WebParam(name = "param")参数名字
     * @return @WebResult客户端返回的结果类型--->String
     */
    @WebMethod(operationName = "sum")
    @WebResult(targetNamespace="http://service.Axis2Service")
   // String getServiceTest(@WebParam(name = "num1,num2",targetNamespace = "http://service.Axis2Service")int a,int b);
    String getServiceTest(@WebParam(name = "num1")int a,@WebParam(name = "num2")int b);
}
