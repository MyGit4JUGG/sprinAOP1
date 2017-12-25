package service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class DyServiceProxy {
	/**业务处理对象*/
	static class ServiceHandler 
	      implements InvocationHandler{
		/**目标对象*/
		private Object target;
		/**封装了扩展业务的一个对象*/
		private TransactionAspect tx;
		public ServiceHandler(Object target,
				TransactionAspect tx) {
			this.target=target;
			this.tx=tx;
		}
		/**
		 * @param proxy  指向代理对象
		 * @param method 指向接口中的方法对象
		 * @param args   方法对象中参数
		 */
		@Override
		public Object invoke(Object proxy,
				Method method,
				Object[] args) throws Throwable {
			 
			if(!method.isAnnotationPresent(Transaction.class)){
				return method.invoke(target, args);
			}else{
			//事务开启
			tx.beginTransaction();
			//业务执行(核心业务)
			Object result=
			method.invoke(target, args);
			//事务提交
			tx.endTransaction();
			return result;
			}
		}
	}
	/**动态代理可以为任何实现了接口的对象创建代理对象
	 * 1)代理类由谁创建?JDK底层(无需我们自己再写代理类)
	 * 2)代理对象由谁创建?JDK底层
	 * 这种代理为什么称之为动态代理呢?
	 * 程序在运行时创建代理类,创建代理对象,这个过程
	 * 是一个动态过程,所以我们称这种代理为动态代理.
	 * */
	public static void main(String[] args) {
		//这个方法可以为任意的实现了接口的对象创建代理对象
		//这种创建代理对象的方式称之为动态代理
		//1.创建目标对象
		TeamServiceImpl target=new TeamServiceImpl();
		//2.创建代理对象(为目标对象创建代理对象)
		TeamService proxy=(TeamService)
				Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loader
				target.getClass().getInterfaces(),//interfaces
				new ServiceHandler(target,
				new TransactionAspect()));//handler(处理器)
		//3.执行业务(由代理去执行目标对象的具体业务)
		proxy.saveObject();
		proxy.updateObject();
		//说明:当执行代理对象的saveObject方法时,底层会自动
		//调用ServiceHandler对象的invoke方法
	}
}






