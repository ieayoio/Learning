Spring EL三元运算(if-then-else)实例
http://www.yiibai.com/spring/spring-el-ternary-operator-if-then-else-example.html

Spring EL支持三元运算符，执行“if then else”条件检查。 例如，
condition ? true : false
Spring EL以注解形式
Spring EL三元运算符可使用@Value注解。在这个例子中，如果“itemBean.qtyOnHand”小于100，则设置“customerBean.warning”为true，否则将其设置为false。
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	@Value("#{itemBean.qtyOnHand < 100 ? true : false}")
	private boolean warning;

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	@Override
	public String toString() {
		return "Customer [warning=" + warning + "]";
	}

}
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {

	@Value("99")
	private int qtyOnHand;
	
	public int getQtyOnHand() {
		return qtyOnHand;
	}

	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

}
输出

Customer [warning=true]
Spring EL以XML形式
请参阅在XML文件定义bean的等效版本。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
 
	<bean id="customerBean" class="com.yiibai.core.Customer">
		<property name="warning" 
                          value="#{itemBean.qtyOnHand < 100 ? true : false}" />
	</bean>
 
	<bean id="itemBean" class="com.yiibai.core.Item">
		<property name="qtyOnHand" value="99" />
	</bean>
	
</beans>
输出结果

Customer [warning=true]
在XML中，需要小于运算符使用"&lt;"替换“<”。

下载代码 - http://pan.baidu.com/s/1qXjtJru
