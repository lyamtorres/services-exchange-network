import java.util.ArrayList;

public class Task {

	private Service service;
	private Member beneficiary; // Correspond a la personne qui va etre beneficie par le service
	private boolean volunteer; // Indique si la tache sera remuneree ou pas
	private double duration;
	private int price;
	private int members;
	
	public Task(Service service, Member beneficiary, boolean volunteer, double duration) {
		this.service = service;
		this.beneficiary = beneficiary;
		this.volunteer = volunteer;
		this.duration = duration;
	}
	
	public int getMembersQuantity() {
		return 0;
	}
	
	public int calculatePrice() {
		int res = (int) (service.getCostPerHour() * this.duration * this.members);
		return res;
	}
}
