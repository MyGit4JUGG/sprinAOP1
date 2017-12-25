package service;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class DyServiceProxy {
	/**ҵ�������*/
	static class ServiceHandler 
	      implements InvocationHandler{
		/**Ŀ�����*/
		private Object target;
		/**��װ����չҵ���һ������*/
		private TransactionAspect tx;
		public ServiceHandler(Object target,
				TransactionAspect tx) {
			this.target=target;
			this.tx=tx;
		}
		/**
		 * @param proxy  ָ��������
		 * @param method ָ��ӿ��еķ�������
		 * @param args   ���������в���
		 */
		@Override
		public Object invoke(Object proxy,
				Method method,
				Object[] args) throws Throwable {
			 
			if(!method.isAnnotationPresent(Transaction.class)){
				return method.invoke(target, args);
			}else{
			//������
			tx.beginTransaction();
			//ҵ��ִ��(����ҵ��)
			Object result=
			method.invoke(target, args);
			//�����ύ
			tx.endTransaction();
			return result;
			}
		}
	}
	/**��̬�������Ϊ�κ�ʵ���˽ӿڵĶ��󴴽��������
	 * 1)��������˭����?JDK�ײ�(���������Լ���д������)
	 * 2)���������˭����?JDK�ײ�
	 * ���ִ���Ϊʲô��֮Ϊ��̬������?
	 * ����������ʱ����������,�����������,�������
	 * ��һ����̬����,�������ǳ����ִ���Ϊ��̬����.
	 * */
	public static void main(String[] args) {
		//�����������Ϊ�����ʵ���˽ӿڵĶ��󴴽��������
		//���ִ����������ķ�ʽ��֮Ϊ��̬����
		//1.����Ŀ�����
		TeamServiceImpl target=new TeamServiceImpl();
		//2.�����������(ΪĿ����󴴽��������)
		TeamService proxy=(TeamService)
				Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loader
				target.getClass().getInterfaces(),//interfaces
				new ServiceHandler(target,
				new TransactionAspect()));//handler(������)
		//3.ִ��ҵ��(�ɴ���ȥִ��Ŀ�����ľ���ҵ��)
		proxy.saveObject();
		proxy.updateObject();
		//˵��:��ִ�д�������saveObject����ʱ,�ײ���Զ�
		//����ServiceHandler�����invoke����
	}
}






