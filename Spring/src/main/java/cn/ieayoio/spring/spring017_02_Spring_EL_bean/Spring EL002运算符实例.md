Spring EL运算符实例
http://www.yiibai.com/spring/spring-el-operators-example.html

Spring EL支持大多数标准的数学，逻辑和关系运算符。 例如，
关系运算符 – 等于 (==, eq), 不等于 (!=, ne), 小于 (<, lt), 小于或等于 (<= , le), 大于 (>, gt), 和大于或等于 (>=, ge).
逻辑运算符 – 且, 或, 非 (!).
数学运算符 – 加法(+), 减法 (-), 乘法 (*), 除法(/), 除模(%) 和指数幂 (^).
Spring EL以注解的形式
这个例子说明了如何在 SpEL 中使用运算符。
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Customer {

	//Relational operators
	
	@Value("#{1 == 1}") //true
	private boolean testEqual;
	
	@Value("#{1 != 1}") //false
	private boolean testNotEqual;
	
	@Value("#{1 < 1}") //false
	private boolean testLessThan;
	
	@Value("#{1 <= 1}") //true
	private boolean testLessThanOrEqual;
	
	@Value("#{1 > 1}") //false
	private boolean testGreaterThan;
	
	@Value("#{1 >= 1}") //true
	private boolean testGreaterThanOrEqual;

	//Logical operators , numberBean.no == 999
	
	@Value("#{numberBean.no == 999 and numberBean.no < 900}") //false
	private boolean testAnd;
	
	@Value("#{numberBean.no == 999 or numberBean.no < 900}") //true
	private boolean testOr;
	
	@Value("#{!(numberBean.no == 999)}") //false
	private boolean testNot;

	//Mathematical operators
	
	@Value("#{1 + 1}") //2.0
	private double testAdd;
	
	@Value("#{'1' + '@' + '1'}") //1@1
	private String testAddString;
	
	@Value("#{1 - 1}") //0.0
	private double testSubtraction;

	@Value("#{1 * 1}") //1.0
	private double testMultiplication;
	
	@Value("#{10 / 2}") //5.0
	private double testDivision;
	
	@Value("#{10 % 10}") //0.0
	private double testModulus ;
	
	@Value("#{2 ^ 2}") //4.0
	private double testExponentialPower;

	@Override
	public String toString() {
		return "Customer [testEqual=" + testEqual + ", testNotEqual="
				+ testNotEqual + ", testLessThan=" + testLessThan
				+ ", testLessThanOrEqual=" + testLessThanOrEqual
				+ ", testGreaterThan=" + testGreaterThan
				+ ", testGreaterThanOrEqual=" + testGreaterThanOrEqual
				+ ", testAnd=" + testAnd + ", testOr=" + testOr + ", testNot="
				+ testNot + ", testAdd=" + testAdd + ", testAddString="
				+ testAddString + ", testSubtraction=" + testSubtraction
				+ ", testMultiplication=" + testMultiplication
				+ ", testDivision=" + testDivision + ", testModulus="
				+ testModulus + ", testExponentialPower="
				+ testExponentialPower + "]";
	}
	
}
package com.yiibai.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("numberBean")
public class Number {

	@Value("999")
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

}
执行

Customer obj = (Customer) context.getBean("customerBean");
System.out.println(obj);
输出结果

Customer [testEqual=true, testNotEqual=false, testLessThan=false, testLessThanOrEqual=true, testGreaterThan=false, testGreaterThanOrEqual=true, testAnd=false, testOr=true, testNot=false, testAdd=2.0, testAddString=1@1, testSubtraction=0.0, testMultiplication=1.0, testDivision=5.0, testModulus=0.0, testExponentialPower=4.0]

Spring EL以XML形式
请参阅在XML文件定义bean的等效版本。在XML中，类似 < 小于符号不支持，应该使用下面所示文本形式，例如文本等值， ('<' = 'lt') 和 ('<=' = 'le').

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="customerBean" class="com.yiibai.core.Customer">
	
	  <property name="testEqual" value="#{1 == 1}" />
	  <property name="testNotEqual" value="#{1 != 1}" />
	  <property name="testLessThan" value="#{1 lt 1}" />
	  <property name="testLessThanOrEqual" value="#{1 le 1}" />
	  <property name="testGreaterThan" value="#{1 > 1}" />
	  <property name="testGreaterThanOrEqual" value="#{1 >= 1}" />
		
	  <property name="testAnd" value="#{numberBean.no == 999 and numberBean.no lt 900}" />
	  <property name="testOr" value="#{numberBean.no == 999 or numberBean.no lt 900}" />
	  <property name="testNot" value="#{!(numberBean.no == 999)}" />
		
	  <property name="testAdd" value="#{1 + 1}" />
	  <property name="testAddString" value="#{'1' + '@' + '1'}" />
	  <property name="testSubtraction" value="#{1 - 1}" />
	  <property name="testMultiplication" value="#{1 * 1}" />
	  <property name="testDivision" value="#{10 / 2}" />
	  <property name="testModulus" value="#{10 % 10}" />
	  <property name="testExponentialPower" value="#{2 ^ 2}" />
		
	</bean>
	
	<bean id="numberBean" class="com.yiibai.core.Number">
		<property name="no" value="999" />
	</bean>

</beans>
下载代码 - http://pan.baidu.com/s/1MLG1w

