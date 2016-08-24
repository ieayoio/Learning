参考ListFactoryBean
可参考：http://www.yiibai.com/spring/spring-setfactorybean-example.html

SetFactoryBean 类为开发者提供了一种可在 Spring bean 配置文件创建一个具体的Set集合(HashSet 和 TreeSet)。
这里有一个 ListFactoryBean。例如，在运行时它将实例化 HashSet，并注入到一个 bean 属性中。
package com.yiibai.common;

import java.util.Set;

public class Customer 
{
	private Set sets;
	//...
}
Spring的bean配置文件。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="sets">
			<bean class="org.springframework.beans.factory.config.SetFactoryBean">
				<property name="targetSetClass">
					<value>java.util.HashSet</value>
				</property>
				<property name="sourceSet">
					<list>
						<value>one</value>
						<value>2</value>
						<value>three</value>
					</list>
				</property>
			</bean>
		</property>
	</bean>

</beans>
另外，还可以使用 util的模式 和<util:set> 来做到同样的事情。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/util
	http://www.springframework.org/schema/util/spring-util-2.5.xsd">

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="sets">
			<util:set set-class="java.util.HashSet">
				<value>one</value>
				<value>2</value>
				<value>three</value>
			</util:set>
		</property>
	</bean>

</beans>
请记住必须包函 util 模式，否则会出现下面的错误：
Caused by: org.xml.sax.SAXParseException: 
	The prefix "util" for element "util:set" is not bound.
执行结果

package com.yiibai.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    	Customer cust = (Customer)context.getBean("CustomerBean");
    	System.out.println(cust);
    	
    }
}
输出结果：

Customer [sets=[2, one, three]] Type=[class java.util.HashSet]
实例化 HashSet，在运行时注入到客户的set集合属性。

下载代码 – http://pan.baidu.com/s/1o7woXQU