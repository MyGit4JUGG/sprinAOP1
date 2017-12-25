package service;
public class TeamServiceProxy implements TeamService {
	/**定义属性(指向要添加扩展业务的那个核心对象)*/
	private TeamService teamService;
	public TeamServiceProxy(TeamService teamService) {
		this.teamService=teamService;
	}
	/**定义属性(指向具体扩展业务:日志处理)*/
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


