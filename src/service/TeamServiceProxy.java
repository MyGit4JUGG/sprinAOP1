package service;
public class TeamServiceProxy implements TeamService {
	/**��������(ָ��Ҫ�����չҵ����Ǹ����Ķ���)*/
	private TeamService teamService;
	public TeamServiceProxy(TeamService teamService) {
		this.teamService=teamService;
	}
	/**��������(ָ�������չҵ��:��־����)*/
	private LogAspect logAspect;
	public void setLogAspect(LogAspect logAspect) {
		this.logAspect = logAspect;
	}
	
	@Override
	public void saveObject() {
		logAspect.before();
		//System.out.println("method start...");
		this.teamService.saveObject();
		//System.out.println("method end...");
		logAspect.after();
	}
	@Override
	public void updateObject() {
		logAspect.before();
		//System.out.println("method start...");
		this.teamService.updateObject();
		//System.out.println("method start...");
		logAspect.after();
	}
}


