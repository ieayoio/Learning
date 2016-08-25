package cn.ieayoio.spring.spring015_Init_method_destroy_method;

/**
 * Created by ieayoio on 16-8-25.
 */
public class CustomerService {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //    建议使用init-method 和 destroy-methodbean 在Bena配置文件，而不是执行 InitializingBean 和 DisposableBean 接口，也会造成不必要的耦合代码在Spring。
    public void initIt11() throws Exception {
        System.out.println("Init method after properties are set sssssss: " + message);
    }

    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "message='" + message + '\'' +
                '}';
    }
}