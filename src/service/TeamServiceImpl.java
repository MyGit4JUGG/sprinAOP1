package service;
/**在已有项目中如何在核心业务
 * 基础上添加新功能(扩展业务)?
 * 1)直接硬编码(在原有业务方法中直接添加扩展业务)
 * 优势:容易理解
 * 劣势:
 * a)违背OCP原则(开闭原则:对扩展开放,对修改关闭)
 * b)缺少封装的概念(需要对扩展业务进行封装)
 * c)代码量大,维护困难.
 * 2)扩展新的业务类,在此业务类中整合核心业务,扩展业务
 * 优势:
 * a)遵循OCP
 * b)封装扩展业务
 * 劣势:
 * a)实际应用中可能需要扩展很多的业务类(基于接口)
 * b)对象会比较多,管理起来相对困难.
 * 说明:在软件编程中通常将这样扩展方式理解为代理模式
 * 
 * 何为代理模式?
 * 
 * 客户端对象通过代理对象去执行目标对象的业务实现,这种方式
 * 我们称之为代理模式
 * 
 * 代理模式中的核心角色?
 * a)抽象对象(一般为接口)
 * b)目标对象(封装了核心业务)
 * c)代理对象(可以访问目标对象,添加扩展业务)
 * 备注:目标对象与代理对象一般要实现共同的接口.
 * 
 * 代理模式解决了什么问题?
 * a)OCP(保护目标对象)
 * b)在不改变原有代码基础上添加扩展功能
 * 
 * 代理模式类型:
 * 1)静态代理(基于某个接口自己写代理类)
 * 2)动态代理(由系统创建代理类及对象,一般借助JDK或CGLIB)
 * 
 * 通过动态代理如何为核心业务对象添加扩展业务.
 * 
 * */

public class TeamServiceImpl implements TeamService {
	//此方法上要使用事务
	
	@Override
	public void saveObject() {
		//System.out.println("method start..");//扩展业务
		System.out.println("saveObject");//核心业务
		//System.out.println("method end..");
	}
	@Override
	public void updateObject() {
		//System.out.println("method start..");
		System.out.println("updateObject");//核心业务
		//System.out.println("method end..");
	}
}
