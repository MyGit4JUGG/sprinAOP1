package service;

public class TransactionAspect {
	
	  public void beginTransaction(){
		  System.out.println("beginTransaction");
	  }
	  
	  public void endTransaction(){
		  System.out.println("endTransaction");
	  }  
}
