package service;
/**借助此对象封装扩展业务*/
public class LogAspect {

	public void before(){
		//.....
		System.out.println("method start..");
	}
	public void after(){
		//.....
		System.out.println("method end..");
	}
}
