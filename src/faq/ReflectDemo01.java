package faq;
import java.lang.reflect.Method;
import java.util.ArrayList;
/**
 * ����:JDK1.5�Ƴ�����ʱ��һ������,�����ϸ�淶
 * ���г�Ա��һ��ʵ�ַ�ʽ.��������ʱ��Ч.
 * */
public class ReflectDemo01 {
	public static void main(String[] args) 
	throws Exception{
		ArrayList<String> list=
		new ArrayList<String>();//Object[]
		list.add("A");
		list.add("B");
		//list.add(100);
		//������ѧ����֪ʶ��,������ʱ��100��ӵ�list
		Class<?> c=list.getClass();
		Method method=
		c.getDeclaredMethod("add",Object.class);
		//ִ��list����add����
		method.invoke(list,100);
		System.out.println(list);
	}
}



