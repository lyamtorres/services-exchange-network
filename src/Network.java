

import java.util.ArrayList;
import java.util.Random;

public class Network {
	
	private String networkName; // Nom du reseau
	private Administrator admin; // Administrateur principal du reseau
	private Task assignedTask; // Tache a faire pour ce reseau
	private ArrayList<Member> workerList; // Liste de travailleurs compatibles pour faire la tache
	private ArrayList<Administrator> otherAdminList; // Administrateurs secondaires
	
	public Network (Administrator admin, String networkName, Task assignedTask){
		this.networkName=networkName;
		this.admin=admin;
		this.assignedTask=assignedTask;
		this.otherAdminList=new ArrayList<Administrator>();
		this.workerList = new ArrayList<Member>();
	}

	public String getNetworkName() {
		return networkName;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public Task getAssignedTask() {
		return assignedTask;
	}

	public ArrayList<Member> getWorkerList() {
		return workerList;
	}

	public ArrayList<Administrator> getOtherAdminList() {
		return otherAdminList;
	}
	
	// Genere un mot de passe qui pourra etre recupere par des administrateurs
	public int getPassword() {
		int password;
		Random rand = new Random();
		password=rand.nextInt();
		return password;
	}
	
	// Retourne le nombre de personnes qui travaillent pour ce reseau
	public int getWorkersQuantity() {
		return workerList.size();
	}
	
	// Verifie si le mot de passe est correct
	public boolean verifyPassword(int result,int password) {
		return (result==password);
	}
	
	// Ajoute un membre au reseau
	public void addMemberNetwork (int result, int password, Network Network1, Administrator Admin1) throws Exception {
		if (verifyPassword(result,password)) {
			for(Member Member1 : Admin1.getWorkerList()) {
				if(getWorkersQuantity()<(this.assignedTask).getMembersQuantity()) {
					if (Member1.isAuthorized(Network1)) {
						workerList.add(Member1);
					}
				}
			}
		} 
		else {
			throw new Exception("mot de passe incorecte,reessayer");
		}
	}
	
	// Retire un membre du reseau
	public void removeMember(int i, int password, int result) throws Exception {
		if (verifyPassword(result,password)) {
			while (getWorkersQuantity()==(this.assignedTask).getMembersQuantity()) {
				workerList.remove(i);
			}
		} 
		else {
			throw new Exception("Mot de passe incorrect");
		}
	}
	
	// Permet de payer a tous les membres du reseau
	public void payMembers (int res) {
		for (Member Member1: workerList) {
			Member1.addMoney(res);
		}
	}
	
	// Ajoute des administrateurs secondaires
	public void addOtherAdmin (Administrator Admin2) {
		otherAdminList.add(Admin2);
	}
	
	// Enleve des administrateurs secondaires
	public void removeOtherAdmin(int i) {
		otherAdminList.remove(i);
	}
	
	// Retourne le nombre total d'administrateurs
	public int adminsQuantity() {
		return(otherAdminList.size() +1) ;
	}

	@Override
	public String toString() {
		return "Network [nameNetwork=" + networkName + ", admin=" + admin + ", Task1=" + assignedTask + ", Worker=" + workerList
				+ ", SecondariesAdmin=" + otherAdminList + "]";
	}
}