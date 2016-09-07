Spring自动装配Beans
http://www.yiibai.com/spring/spring-auto-wiring-beans-in-xml.html


在Spring框架，可以用 auto-wiring 功能会自动装配Bean。要启用它，只需要在 <bean>定义“autowire”属性。
<bean id="customer" class="com.yiibai.common.Customer" autowire="byName" />
在Spring中，支持 5 自动装配模式。
no – 缺省情况下，自动配置是通过“ref”属性手动设定
byName – 根据属性名称自动装配。如果一个bean的名称和其他bean属性的名称是一样的，将会自装配它。
byType – 按数据类型自动装配。如果一个bean的数据类型是用其它bean属性的数据类型，兼容并自动装配它。
constructor – 在构造函数参数的byType方式。
autodetect – 如果找到默认的构造函数，使用“自动装配用构造”; 否则，使用“按类型自动装配”。
示例
Customer 和 Person 对象自动装配示范。
package com.yiibai.common;

public class Customer 
{
	private Person person;
	
	public Customer(Person person) {
		this.person = person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	//...
}
package com.yiibai.common;

public class Person 
{
	//...
}
1. Auto-Wiring ‘no’
这是默认的模式，你需要通过 'ref' 属性来连接 bean。
<bean id="customer" class="com.yiibai.common.Customer">
                  <property name="person" ref="person" />
	</bean>

	<bean id="person" class="com.yiibai.common.Person" />
2. Auto-Wiring ‘byName’
按属性名称自动装配。在这种情况下，由于对“person” bean的名称是相同于“customer” bean 的属性(“person”)名称，所以，Spring会自动通过setter方法将其装配 – “setPerson(Person person)“.

<bean id="customer" class="com.yiibai.common.Customer" autowire="byName" />	
<bean id="person" class="com.yiibai.common.Person" />
查看完整的示例 – Spring按名称自动装配

3. Auto-Wiring ‘byType’
通过按属性的数据类型自动装配Bean。在这种情况下，由于“Person” bean中的数据类型是与“customer” bean的属性(Person对象)的数据类型一样的，所以，Spring会自动通过setter方法将其自动装配。– “setPerson(Person person)“.

<bean id="customer" class="com.yiibai.common.Customer" autowire="byType" />
<bean id="person" class="com.yiibai.common.Person" />
查看完整的示例 – Spring通过类型自动装配

4. Auto-Wiring ‘constructor’
通过构造函数参数的数据类型按属性自动装配Bean。在这种情况下，由于“person” bean的数据类型与“customer” bean的属性(Person对象)的构造函数参数的数据类型是一样的，所以，Spring通过构造方法自动装配 – “public Customer(Person person)“.

<bean id="customer" class="com.yiibai.common.Customer" autowire="constructor" />
	
	<bean id="person" class="com.yiibai.common.Person" />
查看完整的示例 – 

查看完整的示例 – Spring按AutoDetect自动装配成功.

注
这是一件好事，这两个auto-wire’ 和 ‘dependency-check’ 相结合，以确保属性始终自动装配成功。
<bean id="customer" class="com.yiibai.common.Customer" 
			autowire="autodetect" dependency-check="objects />
	
	<bean id="person" class="com.yiibai.common.Person" />
结论
在我看来，Spring ‘auto-wiring’ 以极大的成本做出更快开发效率 - 它增加了对整个 bean 配置文件复杂性，甚至不知道哪些bean将自动装配哪个Bean。
在实践中，我更顷向手动关联创建，它始终是干净，也很好地工作，或者使用 @Autowired 注解，这是更加灵活和建议。

