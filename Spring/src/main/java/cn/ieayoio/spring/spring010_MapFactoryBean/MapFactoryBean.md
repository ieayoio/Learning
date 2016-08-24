参考ListFactoryBean
可参考：http://www.yiibai.com/spring/spring-mapfactorybean-example.html


MapFactoryBean类为开发者提供了一种在Spring的bean配置文件中创建一个具体的Map集合类(HashMap和TreeMap)。
这里有一个MapFactoryBean。例如，在运行时它将实例化一个HashMap，并注入到一个bean属性。
package com.yiibai.common;

import java.util.Map;

public class Customer 
{
	private Map maps;
	//...
}
Spring 的 bean 配置文件。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="maps">
			<bean class="org.springframework.beans.factory.config.MapFactoryBean">
				<property name="targetMapClass">
					<value>java.util.HashMap</value>
				</property>
				<property name="sourceMap">
					<map>
						<entry key="Key1" value="one" />
						<entry key="Key2" value="two" />
						<entry key="Key3" value="three" />
					</map>
				</property>
			</bean>
		</property>
	</bean>

</beans>
另外，还可以使用 util 的模式和<util:map>来做到同样的事情。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:util="http://www.springframework.org/schema/util"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/util
	http://www.springframework.org/schema/util/spring-util-2.5.xsd">

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="maps">
			<util:map map-class="java.util.HashMap">
				<entry key="Key1" value="1" />
				<entry key="Key2" value="2" />
				<entry key="Key3" value="3" />
			</util:map>
		</property>
	</bean>

</beans>
请记住包函util模式，否则会出现下面的错误
Caused by: org.xml.sax.SAXParseException: 
	The prefix "util" for element "util:map" is not bound.
执行结果...

package com.yiibai.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

    	Customer cust = (Customer)context.getBean("CustomerBean");
    	System.out.println(cust);
    	
    }
}
输出结果：

	
	
	
	

		Customer [maps={Key2=two, Key1=one, Key3=three}]
	

在运行时实例化一个HashMap和注入到客户的映射(Map)属性。

下载代码 – http://pan.baidu.com/s/1kTXsDoj
