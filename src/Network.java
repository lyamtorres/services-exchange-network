package projet;
import java.lang.reflect.Member;
import java.util.ArrayList;
public class Network {
	private String nameNetwork;
	private String netPassWord;
	private Administrator modo;
	private ArrayList<Member>Worker;
	
	Network (Administrator modo,String nameNetwork,String netPassWord ){
		
		this.nameNetwork=nameNetwork;
		this.modo=modo;
		this.netPassWord=netPassWord;
		
		Worker = new ArrayList<Member>();
	}
	
	public String getnameNetwork() {
		return this.nameNetwork;
	}
	
	public Administrator getModo() {
		return this.modo;
	}
	
	public String getnetPassWord() {
		return this.netPassWord;
	}
	
	
	public int getWorkerNumber() {
		return Worker.size();
	}
	
	public boolean isValidPassWord(String result) {
		
		return (result).equals(this.netPassWord);
	}
	
	public void addWorker(Member Member1) {
		
		if (isValidPassWord(result)) {
		
			while (getWorkerNumber()< getTaskNumber()) {
			
		
		
				for (Member  i: Worker() ) {
			
					for (service j:ServiceList()) {
				
						if ((Member[i].Service[j]).equals(Task.Service.name)) {
					
					
							Worker.add(Member[i]);
				
						}
			
					}
		
				}
		
	
			}
		}else {
			System.out.println("mot de passe incorrecte");
		
		}
	
	}
	
	public void reduceWorker(Member) {
		
		if(isValidPassWord(result)) {
		
			while (getWorkerNumber()>getTaskNumber()) {
		
				Worker.remove(i);
		}
		}else {
			System.out.println("mot de passe incorrecte");
		}
	
	}
}
