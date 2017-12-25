package faq;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 * 泛型:JDK1.5推出编译时的一种类型,用于严格规范
 * 类中成员的一种实现方式.它在运行时无效.
 * */
public class ReflectDemo01 {
	public static void main(String[] args) 
	throws Exception{
		ArrayList<String> list=
		new ArrayList<String>();//Object[]
		list.add("A");
		list.add("B");
		//list.add(100);
		//请用你学过的知识点,在运行时将100添加到list
		Class<?> c=list.getClass();
		Method method=
		c.getDeclaredMethod("add",Object.class);
		//执行list对象add方法
		method.invoke(list,100);
		System.out.println(list);
	}
}



