Spring EL正则表达式实例
http://www.yiibai.com/spring/spring-el-regular-expression-example.html

Spring EL支持正则表达式，可使用一个简单的关键词“matches”。如下实例，
@Value("#{'100' matches '\\d+' }")
private boolean isDigit;
它测试'100'是否是通过正则表达式‘\\d+‘测试过的一个有效的数字。
Spring EL以注解的形式
请参阅下面的 Spring EL 正则表达式的例子，这里有部分掺入三元运算符，这使得 Spring EL 非常灵活，功能强大。
下面的例子应该是不言自明的。
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	// email regular expression
	String emailRegEx = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)" +
			"*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// if this is a digit?
	@Value("#{'100' matches '\\d+' }")
	private boolean validDigit;

	// if this is a digit + ternary operator
	@Value("#{ ('100' matches '\\d+') == true ? " +
			"'yes this is digit' : 'No this is not a digit'  }")
	private String msg;

	// if this emailBean.emailAddress contains a valid email address?
	@Value("#{emailBean.emailAddress matches customerBean.emailRegEx}")
	private boolean validEmail;

	//getter and setter methods, and constructor	
}
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emailBean")
public class Email {

	@Value("admin@yiibai.com")
	String emailAddress;

	//...
}
输出

Customer [isDigit=true, msg=yes this is digit, isValidEmail=true]
Spring EL以XML的形式
请参阅在XML文件定义bean的等效版本。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="customerBean" class="com.yiibai.core.Customer">
	  <property name="validDigit" value="#{'100' matches '\d+' }" />
	  <property name="msg"
		value="#{ ('100' matches '\d+') == true ? 'yes this is digit' : 'No this is not a digit'  }" />
	  <property name="validEmail"
		value="#{emailBean.emailAddress matches '^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$' }" />
	</bean>

	<bean id="emailBean" class="com.yiibai.core.Email">
	  <property name="emailAddress" value="admin@yiibai.com" />
	</bean>

</beans>
下载代码 – http://pan.baidu.com/s/1jHklXt0
