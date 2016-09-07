Spring自动扫描组件
http://www.yiibai.com/spring/spring-auto-scanning-components.html


通常情况下，声明所有的Bean类或组件的XML bean配置文件，这样Spring容器可以检测并注册Bean类或组件。 其实，Spring是能够自动扫描，检测和预定义的项目包并实例化bean，不再有繁琐的Bean类声明在XML文件中。
下面是一个简单的Spring项目，包括客户服务和DAO层。让我们来探讨手动申明组件和自动扫描组件之间的不同。
1、手动声明组件
看到在 Spring 的一个正常方式来声明一个 bean。
一个正常的 bean.

package com.yiibai.customer.dao;

public class CustomerDAO 
{
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}	
}
DAO 层.

package com.yiibai.customer.services;

import com.yiibai.customer.dao.CustomerDAO;

public class CustomerService 
{
	CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]";
	}
		
}
bean配置文件(applicationContext.xml)，在Spring中的一个普通 bean 配置。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">
	
	<bean id="customerService" class="com.yiibai.customer.services.CustomerService">
		<property name="customerDAO" ref="customerDAO" />
	</bean>

	<bean id="customerDAO" class="com.yiibai.customer.dao.CustomerDAO" />

</beans>
执行程序

package com.yiibai.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiibai.customer.services.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    	  new ClassPathXmlApplicationContext(new String[] {"Spring-Customer.xml"});

    	CustomerService cust = (CustomerService)context.getBean("customerService");
    	System.out.println(cust);
    	
    }
}
输出结果

CustomerService [customerDAO=Hello , This is CustomerDAO]
2. 自动组件扫描
现在，启用Spring组件扫描功能。
使用@Component注释来表示这是类是一个自动扫描组件。
package com.yiibai.customer.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO 
{
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}	
}
DAO层，添加@Component，表明这也是一个自动扫描组件。
package com.yiibai.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yiibai.customer.dao.CustomerDAO;

@Component
public class CustomerService 
{
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]";
	}
} 
将这个“context:component”在bean配置文件，这意味着，在 Spring 中启用自动扫描功能。base-package 是指明存储组件，Spring将扫描该文件夹，并找出Bean(注解为@Component)并注册到 Spring 容器。

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<context:component-scan base-package="com.yiibai.customer" />

</beans>
执行它

package com.yiibai.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiibai.customer.services.CustomerService;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    	   new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});

    	CustomerService cust = (CustomerService)context.getBean("customerService");
    	System.out.println(cust);
    	
    }
}
输出结果

CustomerService [customerDAO=Hello , This is CustomerDAO]
这是 Spring 中的自动扫描组件如何工作。
自定义自动扫描组件名称
默认情况下，Spring 将小写部件的第一字符- 从'CustomerService'到'CustomerService'。可以检索该组件名称为“CustomerService”。
CustomerService cust = (CustomerService)context.getBean("customerService");
要创建组件的自定义名称，你可以这样自定义名称：

@Service("AAA")
public class CustomerService 
...
现在，可以用'AAA'这个名称进行检索。
CustomerService cust = (CustomerService)context.getBean("AAA");
自动组件扫描注释类型
在Spring2.5中，有4种类型的组件自动扫描注释类型
@Component – 指示自动扫描组件。
@Repository – 表示在持久层DAO组件。
@Service – 表示在业务层服务组件。
@Controller – 表示在表示层控制器组件。
因此，使用哪一个？其实并不那么重要。参见 @Repository，@Service 或 @Controller 源代码。
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Repository {

	String value() default "";

} 
你可能会发现，所有的 @Repository, @Service 或 @Controller 被注解为 @Component。因此，我们可以只使用 @Component 对所有组件进行自动扫描？是的，Spring会自动扫描所有组件的 @Component 注解。

它工作正常，但不是一个好的做法，为便于阅读，应该始终声明@Repository，@ Service 或 @Controller 在指定的层，使你的代码更易于阅读，如下：
DAO 层

package com.yiibai.customer.dao;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO 
{
	@Override
	public String toString() {
		return "Hello , This is CustomerDAO";
	}	
}
Service 层

package com.yiibai.customer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiibai.customer.dao.CustomerDAO;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]";
	}
		
}

下载代码 – http://pan.baidu.com/s/1o7hwcHW
