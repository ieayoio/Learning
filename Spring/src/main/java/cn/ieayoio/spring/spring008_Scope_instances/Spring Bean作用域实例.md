在Spring中，bean作用域用于确定哪种类型的 bean 实例应该从Spring容器中返回给调用者。bean支持的5种范围域：
    单例 - 每个Spring IoC 容器返回一个bean实例
    原型- 当每次请求时返回一个新的bean实例
    请求 - 返回每个HTTP请求的一个Bean实例
    会话 - 返回每个HTTP会话的一个bean实例
    全局会话- 返回全局HTTP会话的一个bean实例
在大多数情况下，可能只处理了 Spring 的核心作用域 - 单例和原型，默认作用域是单例。
注：意味着只有在一个基于web的Spring ApplicationContext情形下有效！
单例VS原型
这里有一个例子来说明，bean的作用域单例和原型之间的不同：
````
    package com.yiibai.customer.services;
    
    public class CustomerService 
    {
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
````
1.单例例子
如果 bean 配置文件中没有指定 bean 的范围，默认为单例。
````
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

       <bean id="customerService" 
            class="com.yiibai.customer.services.CustomerService" />
		
</beans>
````
执行结果：

````
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

    	CustomerService custA = (CustomerService)context.getBean("customerService");
    	custA.setMessage("Message by custA");
    	System.out.println("Message : " + custA.getMessage());
    	
    	//retrieve it again
    	CustomerService custB = (CustomerService)context.getBean("customerService");
    	System.out.println("Message : " + custB.getMessage());
    }
}
````
输出结果

    Message : Message by custA
    Message : Message by custA 
由于 bean 的 “CustomerService' 是单例作用域，第二个通过提取”custB“将显示消息由 ”custA' 设置，即使它是由一个新的 getBean()方法来提取。在单例中，每个Spring IoC容器只有一个实例，无论多少次调用 getBean()方法获取它，它总是返回同一个实例。

2.原型例子
如果想有一个新的 “CustomerService”bean 实例，每次调用它的时候，需要使用原型(prototype)来代替。
````
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

   <bean id="customerService" class="com.yiibai.customer.services.CustomerService" 
         scope="prototype"/>
		
</beans>
````
运行-执行

    Message : Message by custA
    Message : null
在原型作用域，必须为每个 getBean()方法中调用返回一个新的实例。
3. Bean作用域注释
还可以使用注释来定义 bean 的作用域。
````
package com.yiibai.customer.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CustomerService 
{
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
````
启用自动组件扫描
````
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">

       <context:component-scan base-package="com.yiibai.customer" />
		
</beans>
````
