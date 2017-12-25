package service;

public interface TeamService {
	  @Transaction
	  void saveObject();
	  void updateObject();
}
