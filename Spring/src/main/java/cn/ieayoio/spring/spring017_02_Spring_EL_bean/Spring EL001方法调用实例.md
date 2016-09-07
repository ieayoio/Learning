Spring EL方法调用实例
http://www.yiibai.com/spring/spring-el-method-invocation-example.html


Spring表达式语言(使用SpEL)允许开发人员使用表达式来执行方法和将返回值以注入的方式到属性，或叫作“使用SpEL方法调用”。
Spring EL在注解的形式
了解如何实现Spring EL方法调用与@Value注释。
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	@Value("#{'yiibai'.toUpperCase()}")
	private String name;

	@Value("#{priceBean.getSpecialPrice()}")
	private double amount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", amount=" + amount + "]";
	}

}
package com.yiibai.core;

import org.springframework.stereotype.Component;

@Component("priceBean")
public class Price {

	public double getSpecialPrice() {
		return new Double(199.09);
	}

}
输出

Customer [name=YIIBAI, amount=199.09]
一点解释
在字串文本上调用 toUpperCase()方法。
@Value("#{'yiibai'.toUpperCase()}")
private String name;
在 ‘priceBean‘ Bean上调用getSpecialPrice() 方法

@Value("#{priceBean.getSpecialPrice()}")
private double amount;
Spring EL在XML的形式
请参阅在XML文件定义bean的等效版本。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
 
	<bean id="customerBean" class="com.yiibai.core.Customer">
		<property name="name" value="#{'yiibai'.toUpperCase()}" />
		<property name="amount" value="#{priceBean.getSpecialPrice()}" />
	</bean>
 
	<bean id="priceBean" class="com.yiibai.core.Price" />
	
</beans>
输出

Customer [name=YIIBAI, amount=199.09]
下载代码 –  http://pan.baidu.com/s/1mhdwodU