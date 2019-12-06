
public class UserInterface {

	public static void main(String[] args) {
		
		//Creer nouveau service
		Service service1 = new Service("jardinage", 10);
		System.out.println(service1.toString());
		
		//Creer nouveau membre
		Member member1 = new Member("Rodrigue", 100);
		
		//Creer nouvelle tache
		Task task1 = new Task(service1, member1, true, 60.5);
		
	}

}
