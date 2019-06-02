/*
 * 2011-108 ������������ϵͳ
 *
 * (C) ��Ȩ���У��Ϻ���¡��Ϣ�������޹�˾
 *             www.jite.net
 */
package Axis2Service.service;

/**
 * desc��
 *
 * @author <a href="mailto:wanghaox@jite.net">wanghaox</a>
 * @version SVN $Revision: 1.1 $ $Date: 2011/07/12 02:06:49 $
 */
public class Calculate {
    public Integer sum(Integer num1, Integer num2) {
        return num1 + num2;
    }


    public String test(String param) {
        System.out.println("服务端被请求了一次....");
        return "axis2服务端(TestService)返回:"+param;
    }
}
