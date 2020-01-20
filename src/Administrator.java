

import java.util.ArrayList;

public class Administrator extends Member {
	private ArrayList<Network> networkList; // Liste de reseaux d'un administrateur
	private ArrayList<Member> workerList; // Liste de travailleurs disponible pour un reseau
	private ArrayList<Task> completedTasks; // Liste de taches a effectuer
	
	public Administrator (String memberName, int money, Group groupName){
		super (memberName, money, groupName);
		this.networkList=new ArrayList<Network>();
		this.workerList=new ArrayList<Member>();
		this.completedTasks=new  ArrayList<Task>();
	}

	public ArrayList<Network> getNetworkList() {
		return networkList;
	}

	public ArrayList<Member> getWorkerList() {
		return workerList;
	}

	public ArrayList<Task> getCompletedTasks() {
		return completedTasks;
	}

	// Ajoute un travailleur qui soit disponible a un reseau
	public void addAvailableWorker (Member Member1) {
		workerList.add(Member1);
	}
	
	// Enleve un travailleur qui est disponible a un reseau
	public void removeAvailableWorker(int i) {
		workerList.remove(i);
	}
	
	// Retourne le nombre de travailleurs etant disponibles
	public int getAvailableWorkers () {
		return  workerList.size();
	}
	
	// Cree un reseau qui ensuite va etre ajote a la liste de reseaux
	public Network createNetwork (Administrator Admin1, String nameNetework, Task Task1) {
		Network Network1= new Network (this, nameNetework, Task1);
		networkList.add(Network1);
		return Network1;	
	}

	// Permet que l'administrateur puisse recuperer un mot de passe genere par le reseau
	public int getAdminPassword(Network Network1, int password) {
		int result= password;
		return result;
	}
	
	// Ajoute un nouveau membre en tant qu'administrateur
	public void addMemberAsAdmin(Network Network1,Administrator Admin1, int result, int password) throws Exception {
		Network1.addMemberNetwork(result, password, Network1, Admin1) ;
	}

	// Enleve des membres en tant qu'administrateur
	public void removeMemberAsAdmin(Network Network1, int i, int result, int password) throws Exception {//retire un nouveau membre depuis l'administrateur
		Network1.removeMember(i, result, password);
	}
	
	// Verifie si la tache a toutes les conditions necessaires pour pouvoir etre effectue
	public boolean approveTask(Network Network1, Member Member1, Task Task1, int result, int i, int password, Administrator Admin1) throws Exception{ // Verifie si la personne demandant la tache possede assez d'argent
		if(Member1.getMoney()>=Task1.calculatePrice()) {
			if (Network1.getWorkersQuantity()==Task1.getMembersQuantity()) { // Verifie s'il existent assez de membres
				System.out.println("Tache faisable");
				return true;
			} 
			else if(Network1.getWorkersQuantity()>Task1.getMembersQuantity()) { // Enleve les membres qui ne vont pas etre utiles
				Network1.removeMember(i, result, password);
				System.out.println("Tache faisable");
				return true;
			}
			else { // Des membres qualifies vont etre ajoutes
				Network1.addMemberNetwork (result, password, Network1, Admin1);
				System.out.println("Tache faisable");
				return true;
			}
		}
		else {
			System.out.println("Quantite d'argent insuffisante");
			System.out.println("Tache infaisable");
			return false;
		}
	}
	
	// Paye tous les membres du reseau en tant qu'administrateur
	public void payMembersAsAdmin(Network Network1, int res) {
		Network1.payMembers(res);
	}
	
	// La tache etant complete, preleve de l'argent a la personne demandant la tache, paye aux travailleurs et ajoute la tache dans l'historique
	public void toFinalize(Network Network1 ,Member Member1, Task Task1, int result, int i, int res, int password, Administrator Admin1) throws Exception {//une fois que la tache est fini en prelve l'argent du demandeur et on paye les travaillieur
		if(approveTask(Network1, Member1, Task1, result, i, password, Admin1)) {
			(Member1.getGroupName()).reduceMoney(Member1, res);
			payMembersAsAdmin(Network1, res);
			completedTasks.add(Task1);
		}
		else {
			throw new Exception ("La tache n'est pas encore approuvee");
		}
	}
	
	// Retourne la quantite de taches completees
	public int getCompletedTasksQuantity() {
		return completedTasks.size();
	}

	// Permet de voir une tache parmi les taches completes
	public Task seeCompletedTasks(int i) {
		return  completedTasks.get(i);
	}
	
	// Ajoute un reseau dans la liste de reseaux
	public void addNetwork(Network Network1) {
		networkList.add(Network1);
	}

	// Enleve un reseau de la liste de reseaux
	public void removeNetwork(int i) {
		networkList.remove(i);
	}

	// Retourne le nombre de reseaux possedes par l'administrateur
	public int networksQuantity() {
		return networkList.size();
	}

	// Ajoute un administrateur secondaire en tant qu'administrateur principal
	public void addAdmin(Network Network2, Administrator Admin2) {
		Network2.addOtherAdmin(Admin2);
	}
	
	// Retire un administrateur secondaire en tant qu'administrateur principal
	public void removeAdmin(Network Network2, int i) {
		Network2.removeOtherAdmin(i);
	}
}