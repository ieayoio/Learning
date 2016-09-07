Spring过滤器组件自动扫描
http://www.yiibai.com/spring/spring-filtering-components-in-auto-scanning.html

在这个Spring自动组件扫描的教程，您已经了解如何使Spring自动扫描您的组件。在这篇文章中，我们将展示如何使用组件过滤器自动扫描过程。
1.过滤组件 - 包含
参见下面的例子中使用Spring “过滤” 扫描并注册匹配定义“regex”，即使该类组件的名称未标注 @Component 。
DAO 层

package com.yiibai.customer.dao;

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
import com.yiibai.customer.dao.CustomerDAO;

public class CustomerService 
{
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String toString() {
		return "CustomerService [customerDAO=" + customerDAO + "]";
	}
		
}
Spring 过滤

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<context:component-scan base-package="com.yiibai" >

		<context:include-filter type="regex" 
                       expression="com.yiibai.customer.dao.*DAO.*" />

		<context:include-filter type="regex" 
                       expression="com.yiibai.customer.services.*Service.*" />

	</context:component-scan>

</beans>
执行

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
输出

CustomerService [customerDAO=Hello , This is CustomerDAO]
在这个XML过滤中，所有文件的名称中包含 DAO 或 Service(*DAO.*, *Services.*) 单词将被检测并在 Spring 容器中注册。
2.过滤组件 - 不包含
另外，您还可以排除指定组件，以避免 Spring 检测和 Spring 容器注册。不包括在这些文件中标注有 @Service 。
<context:component-scan base-package="com.yiibai.customer" >
		<context:exclude-filter type="annotation" 
			expression="org.springframework.stereotype.Service" />		
	</context:component-scan>
不包括那些包含DAO这个词组文件名。
<context:component-scan base-package="com.yiibai" >
		<context:exclude-filter type="regex" 
			expression="com.yiibai.customer.dao.*DAO.*" />		
	</context:component-scan>

下载代码 – http://pan.baidu.com/s/1pKnzB2F
