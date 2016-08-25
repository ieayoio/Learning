package cn.ieayoio.spring.spring015_InitializingBean_DisposableBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by ieayoio on 16-8-25.
 */
public class CustomerService implements InitializingBean, DisposableBean {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 所有属性设置之后,调用之前被执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method after properties are set : " + message);
    }

    /**
     * 在ClassPathXmlApplicationContext调用close方法时被调用
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "message='" + message + '\'' +
                '}';
    }
}