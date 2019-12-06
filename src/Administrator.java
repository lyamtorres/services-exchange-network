package projet;

import java.util.Scanner;

public class Administrator {
	
	private String nameAdministrator;
	private Scanner passWord;
	protected Network adminNetwork;
	private Group Normal;
	
	
	Administrator(String Administrator,Network adminNetwork,Group Normal ){
		
		this.nameAdministrator=nameAdministrator;
		
		this.adminNetwork=adminNetwork;
		
		this.Normal=Normal;
		
		passWord= new Scanner(System.in);
		
	}
	
	public String getAdminName() {
		return this.nameAdministrator;
	}
	
	public Network CreateNetWork () {
		String nameNetwork ;
		String netPassWord;
		Network adminNetwork= new Network (this,nameNetwork,netPassWord);
	}
	
	public String EnterPassWord() {
		String result=passWord.next();
		return result; 
	}
	
	public void addWorker(Member Member1 ) {
		while (getWorkerNumber()< getTaskNumber()) {
			
		
		for (Member i: Worker() ) {
			for (service j: ServiceList()) {
				
				if ((Member[i].Service[j]).equals(Task.Service.name)) {
					
					Worker.add(Member[i]);
				}
			}
		}
		
	}
	}
	
	public void reduceWorker(int i) {
		
		while (getWorkerNumber()>getTaskNumber()) {
		Worker.remove(i);
		}
	}
	
	public boolean isTakPossible() {
	
		if (Member.getMonney()=Task.getValue()) {
			if(getWorkerNumber()==getTaskNumber()) {
				return true;
			}
			if (getWorkerNumber()>getTaskNumber()) {
				
				reduceWorker(i);
				
				return true;
			
			}
			if(getWorkerNumber()<getTaskNumber()) {
				
				addWorker();
				
				return true;
			}
				
		}else {
			return false;
		}
	}
	

}
