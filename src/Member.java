

import java.util.ArrayList;

public class Member {
	
	private String memberName;
	private int money; // Quantite d'argent que chaque membre possede
	private ArrayList <Service> skillList; // L'ensemble de competences de chaque membre
	private Group groupName;
	
	public Member (String memberName, int money, Group groupName){
		this.memberName=memberName;
		this.money=money;
		this.groupName= groupName;
		this.skillList=new ArrayList<Service>();
	}
	
	public String getMemberName() {
		return memberName;
	}

	public int getMoney() {
		return money;
	}

	public ArrayList<Service> getSkillList() {
		return skillList;
	}

	public Group getGroupName() {
		return groupName;
	}
	
	// Verifie pour chaque membre sa capacite a effectuer une tache
	public boolean isAuthorized(Network Network1)  {
		for (Service service1 : skillList) {
			if(service1==((Network1.getAssignedTask()).getService())) {
				return true;
			}
		}
		return false;
	}
	
	// Ajoute des nouvelles competences aux membres
	public void addSkills(Service Service1) {
		skillList.add(Service1);
	}
	
	// Ajoute de l'argent a un membre
	public void addMoney(int res) {
		this.money+=res;
	}
	
	// Retire de l'argent a un membre
	public void reduceMoney(int res) {
		this.money-=res;
	}
	
	// Fait un transfert d'argent entre les membres
	public void transferMoney(Member Member2, int somme) throws Exception{
		if (this.money>=somme) {
			this.reduceMoney(somme);
			Member2.addMoney(somme);
		} 
		else {
			throw new Exception("Quantite d'argent insuffisante"); 
		}
	}

	// Permet de recevoir de l'argent de la part d'autres membres
	public void receiveMoney
	(Member Member2,int somme) throws Exception{
		if (Member2.money>=somme) {
			Member2.reduceMoney(somme);
			this.addMoney(somme);
		} 
		else {
			throw new Exception("Quantite d'argent insuffisante"); 
		}
	}

	@Override
	public String toString() {
		return "Member [nameMember=" + memberName + ", money=" + money + ", Talents=" + skillList + ", nameGroupe="
				+ groupName + "]";
	}
}