

import java.util.ArrayList;


public class Task {

	private Service service;
	private Member beneficiary; // Personne qui va etre beneficie par le service
	private boolean volunteer; // Indique si la tache sera remuneree ou pas
	private double duration; // Duration de la tache
	private int price; // Prix de la tache
	private int membersQuantity; // Quantite des membres qui effectueront la tache
	
	public Task(Service service, Member beneficiary, boolean volunteer, double duration,int price,int membersQuantity ) {
		this.service = service;
		this.beneficiary = beneficiary;
		this.volunteer = volunteer;
		this.duration = duration;
		this.membersQuantity=membersQuantity ;
	}
	
	public int getMembersQuantity() {
		return this.membersQuantity ;
	}
	
	public Service getService() {
		return this.service;
	}
	
	public Member getBeneficiary() {
		return this.beneficiary;
	}
	
	// Calcule le prix de la tache si cette tache n'est pas benevole
	public int calculatePrice() {
		int res;
		if (this.volunteer==true) {
			res=0;
			return res;
		}
		else {
			res = (int) (service.getCostPerHour() * this.duration * this.membersQuantity);
		return res;
		}
	}

	@Override
	public String toString() {
		return "Task [service=" + service + ", beneficiary=" + beneficiary + ", volunteer=" + volunteer + ", duration="
				+ duration + ", price=" + price + ", membersQuantity=" + membersQuantity + "]";
	}
	
	
	
	
}