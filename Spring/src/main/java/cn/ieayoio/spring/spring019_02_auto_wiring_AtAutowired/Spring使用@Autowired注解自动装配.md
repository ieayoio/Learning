# Spring使用@Autowired注解自动装配

总结：

> - [ ] 普通装配
> - [x] 在字段上装配
> - [ ] 构造方法上装配
> - [ ] setter方法上装配


> * 关于注册AutowiredAnnotationBeanPostProcessor，可以使用 Include <context:annotation-config />替代,详细可以参看原文链接
> * 关于依赖检查
> * 类似的装配可以增加@Qualifier注解进行区分

## 使用@Qualifier注解的例子
```java
public class Customer 
{
	@Autowired
	@Qualifier("PersonBean1")
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
} 
```

## 原文内容

易百原文链接：[Spring使用@Autowired注解自动装配](http://www.yiibai.com/spring/spring-auto-wiring-beans-with-autowired-annotation.html)

在上一篇 Spring在XML自动装配 示例中,它会匹配当前Spring容器任何bean的属性自动装配。在大多数情况下，你可能只需要在特定的 bean 自动装配属性。
在Spring中，可以使用 @Autowired 注解通过setter方法，构造函数或字段自动装配Bean。此外，它可以在一个特定的bean属性自动装配。
注 @Autowired注解是通过匹配数据类型自动装配Bean。

请参见下面的完整的例子来演示如何使用@Autowired。
1. Beans
一个 Customer bean 在bean配置文件中声明。稍后，您将使用 “@Autowired” 来自动装配一个Person bean。
package com.yiibai.common;

public class Customer 
{
	//you want autowired this field.
	private Person person;
	
	private int type;
	private String action;
	
	//getter and setter method
	
}
<beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="action" value="buy" />
		<property name="type" value="1" />
	</bean>

	<bean id="PersonBean" class="com.yiibai.common.Person">
		<property name="name" value="yiibai" />
		<property name="address" value="address 123" />
		<property name="age" value="28" />
	</bean>
	
</beans>
2. 注册AutowiredAnnotationBeanPostProcessor
要启用@Autowired，必须注册“AutowiredAnnotationBeanPostProcessor'，你可以用两种方式做到这一点：
1. Include <context:annotation-config />
添加 Spring 上下文和<context:annotation-config />在bean配置文件中。
<beans 
	//...
	xmlns:context="http://www.springframework.org/schema/context"
	//...
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">
	//...

	<context:annotation-config />
	//...
</beans>
下面是完整的实例

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<context:annotation-config />

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="action" value="buy" />
		<property name="type" value="1" />
	</bean>

	<bean id="PersonBean" class="com.yiibai.common.Person">
		<property name="name" value="yiibai" />
		<property name="address" value="address ABC" />
		<property name="age" value="29" />
	</bean>
	
</beans>
2.  包含 AutowiredAnnotationBeanPostProcessor
直接在bean配置文件包含“AutowiredAnnotationBeanPostProcessor”。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

<bean 
class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
	
	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="action" value="buy" />
		<property name="type" value="1" />
	</bean>

	<bean id="PersonBean" class="com.yiibai.common.Person">
		<property name="name" value="yiibai" />
		<property name="address" value="address ABC" />
		<property name="age" value="29" />
	</bean>
	
</beans>
3. @Autowired示例
现在，你可以通过 @Autowired 自动装配 bean，它可以在 setter 方法，构造函数或字段中使用。
1. @Autowired setter 方法

package com.yiibai.common;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer 
{
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
	
	@Autowired
	public void setPerson(Person person) {
		this.person = person;
	}
}
2. @Autowired 构造方法

package com.yiibai.common;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer 
{
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
	
	@Autowired
	public Customer(Person person) {
		this.person = person;
	}
}
3. @Autowired 字段

package com.yiibai.common;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer 
{
	@Autowired
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
}
上面的例子会自动装配“PersonBean”到Customer的person属性。
执行它

package com.yiibai.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    	  new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
    	
    	Customer cust = (Customer)context.getBean("CustomerBean");
    	System.out.println(cust);
    	
    }
}
输出

Customer [person=Person [name=YiibaiA], type=1, action=buy]
依赖检查
默认情况下，@Autowired将执行相关检查，以确保属性已经装配正常。当Spring无法找到匹配的Bean装配，它会抛出异常。要解决这个问题，可以通过 @Autowired 的“required”属性设置为false来禁用此检查功能。

package com.yiibai.common;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer 
{
	@Autowired(required=false)
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
}
在上面的例子中，如果Spring不能找到一个匹配的Bean，person属性将不设定。
@Qualifier
@Qualifier注解我们用来控制bean应在字段上自动装配。例如，具有两个类似的 person bean 配置文件。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<context:annotation-config />

	<bean id="CustomerBean" class="com.yiibai.common.Customer">
		<property name="action" value="buy" />
		<property name="type" value="1" />
	</bean>

	<bean id="PersonBean1" class="com.yiibai.common.Person">
		<property name="name" value="yiibai-1" />
		<property name="address" value="address-1" />
		<property name="age" value="29" />
	</bean>
	
	<bean id="PersonBean2" class="com.yiibai.common.Person">
		<property name="name" value="yiibai-2" />
		<property name="address" value="address-2" />
		<property name="age" value="28" />
	</bean>
	
</beans>
Spring知道哪个 bean 应当装配？
为了解决这个问题，可以使用 @Qualifier 自动装配一个特定的 bean，例如，
package com.yiibai.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Customer 
{
	@Autowired
	@Qualifier("PersonBean1")
	private Person person;
	private int type;
	private String action;
	//getter and setter methods
} 
这意味着，“PersonBean1” bean被自动装配到customer的person属性。阅读下面完整的例子 – Spring自动装配@Qualifier实例

总结
这@Autowired注解非常灵活，功能强大，绝对比bean配置文件的“autowire”属性要更好。

下载代码 –  http://pan.baidu.com/s/1o7oNBTo

