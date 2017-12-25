package service;

public class TestTeamService {
	public static void main(String[] args) {
		//核心业务
		TeamServiceImpl serviceImpl=
		new TeamServiceImpl();
		//封装核心业务
		TeamServiceProxy teamService=
		new TeamServiceProxy(serviceImpl);
		//添加扩展业务
		LogAspect logAspect=
		new LogAspect();
		teamService.setLogAspect(logAspect);
		
		
		teamService.saveObject();
		teamService.updateObject();
	}
}
