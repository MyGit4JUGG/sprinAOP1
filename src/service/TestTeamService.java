package service;

public class TestTeamService {
	public static void main(String[] args) {
		//����ҵ��
		TeamServiceImpl serviceImpl=
		new TeamServiceImpl();
		//��װ����ҵ��
		TeamServiceProxy teamService=
		new TeamServiceProxy(serviceImpl);
		//�����չҵ��
		LogAspect logAspect=
		new LogAspect();
		teamService.setLogAspect(logAspect);
		
		
		teamService.saveObject();
		teamService.updateObject();
	}
}
