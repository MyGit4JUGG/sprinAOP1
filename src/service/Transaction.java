package service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**注解:
 * JDK1.5推出的一种新的对象类型,编译完成以后也会生成字节码文件
 * 注解的应用场景:
 * 以元数据(描述数据的数据)的方式描述类,属性,方法等对象
 * 注解的定义:
 * 1)使用@interface进行声明
 * 2)使用@Target说明这个注解能应用在哪些元素上
 * 3)使用@Retention说明这个注解在何时有效
 * 
 * 我们自己定义注解一般是声明此注解在运行时有效,
 * 并且一般会结合反射使用注解.
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transaction {//编译完成以后Transaction.class
    
}







