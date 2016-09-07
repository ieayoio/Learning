Spring EL Lists,Maps实例
http://www.yiibai.com/spring/spring-el-lists-maps-example.html


在这篇文章中，我们将介绍如何使用Spring EL从 Map 和 List 中获得值。事实上，使用SpEL与 Map 和 List 的工作方式与Java是完全一样的。请参阅例如：
//get map whete key = 'MapA'
@Value("#{testBean.map['MapA']}")
private String mapA;

//get first value from list, list is 0-based.
@Value("#{testBean.list[0]}")
private String list;
Spring EL以注解的形式
在这里，创建了一个HashMap和ArrayList，并添加了一些初始测试数据。
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	@Value("#{testBean.map['MapA']}")
	private String mapA;

	@Value("#{testBean.list[0]}")
	private String list;

	public String getMapA() {
		return mapA;
	}

	public void setMapA(String mapA) {
		this.mapA = mapA;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Customer [mapA=" + mapA + ", list=" + list + "]";
	}

}
package com.yiibai.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("testBean")
public class Test {

	private Map<String, String> map;
	private List<String> list;

	public Test() {
		map = new HashMap<String, String>();
		map.put("MapA", "This is MapA");
		map.put("MapB", "This is MapB");
		map.put("MapC", "This is MapC");

		list = new ArrayList<String>();
		list.add("List0");
		list.add("List1");
		list.add("List2");

	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
执行程序

Customer obj = (Customer) context.getBean("customerBean");
System.out.println(obj);
输出结果:

Customer [mapA=This is MapA, list=List0]

Spring EL以XML的形式
请参阅在XML文件定义bean的等效版本。
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="customerBean" class="com.yiibai.core.Customer">
		<property name="mapA" value="#{testBean.map['MapA']}" />
		<property name="list" value="#{testBean.list[0]}" />
	</bean>

	<bean id="testBean" class="com.yiibai.core.Test" />

</beans>
下载代码  – http://pan.baidu.com/s/1gdTxfKv