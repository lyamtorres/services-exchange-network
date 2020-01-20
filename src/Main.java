

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Creation des membres
		Member Member1 = new Member("Romain", 100, new Zero());
		Member Member2 = new Member ("Pauline",100,new Normal());
		Member Member3 = new Member ("Nolwenn",100,new Half());
		Member Member4 = new Member ("Souleymanne",100,new Half());
		Member Member5 = new Member ("Lyam",100,new Normal());
		Member Member6 = new Member ("Gloire",100,new Zero());
		Member Member7 = new Member ("Fiti", 100, new Half());
		
		// Verification de la quantite d'argent de depart
		System.out.println("Quantite d'argent de départ pour les membres: ");
		System.out.println("Membre1: " + Member1.getMoney() + " euros");
		System.out.println("Membre2: " + Member2.getMoney() + " euros");
		System.out.println("Membre3: " + Member3.getMoney() + " euros");
		System.out.println("Membre5: " + Member5.getMoney() + " euros");
		System.out.println("Membre6: " + Member6.getMoney() + " euros");
		System.out.println("Membre7: " + Member7.getMoney() + " euros");
		System.out.println("");
		
		// Creation des administrateurs
		Administrator Admin1 = new Administrator("Lea", 90, new Normal());
		Administrator Admin2 = new Administrator("Bob", 70, new Normal());
		Administrator Admin3 = new Administrator("Dylan", 60, new Normal());
	
		// Creation des services
		Service Service1 = new Service ("Jardinage", 2);
		Service Service2 = new Service ("Cablage", 6);
		Service Service3 = new Service ("Informatique", 2);
		Service Service4 = new Service ("Menage", 1);
		
		// Creation de taches
		Task Task1 = new Task (Service1, Member1, false, 9.8,2,2);
		Task Task2 = new Task (Service2, Member2, true, 9.8,2,2);
		
		// Recuperation du prix des taches
		System.out.println("Prix de certaines taches: ");
		int res1=Task1.calculatePrice();
		System.out.println("Le prix de la tache est: " + res1 + " euros");
		int res2=Task2.calculatePrice();
		System.out.println("Le prix de la tache est: " + res2 + " euros");
		System.out.println("");
		
		// Creation du reseau 2 directement
		Network Network2 = new Network (Admin1, "Informatique", Task2);
		
		// Ajout des services a un membre
		Member1.addSkills(Service1);
		Member1.addSkills(Service2);
		Member1.addSkills(Service3);
		Member2.addSkills(Service1);
		Member3.addSkills(Service2);
		Member4.addSkills(Service2);
		Member5.addSkills(Service2);
		Member6.addSkills(Service2);
		Member3.addSkills(Service1);
		Member4.addSkills(Service1);
		Member5.addSkills(Service1);
		Member6.addSkills(Service1);
		
		// Creation du reseau 1 depuis la classe administrateur
		Network Network1=Admin1.createNetwork(Admin1, "jardinage", Task1);
		
		// Test de compatibilite des membre pour une tache
		System.out.println("Compatibilite du membre1: ");
		try {
		System.out.println(Member1.isAuthorized(Network1));
		System.out.println("");
		} 
		catch (Exception e) {
			System.out.println(e);	
		}
		System.out.println("Compatibilite du membre2: ");
		try {
			System.out.println(Member2.isAuthorized(Network1));
			System.out.println("");
		}
		catch (Exception f) {
			System.out.println(f);
		}
		
		// Test d'ajout de membres dans la liste de l'administrateur
		Admin2.addAvailableWorker (Member3);
		Admin2.addAvailableWorker (Member4);
		Admin2.addAvailableWorker (Member5);
		Admin2.addAvailableWorker (Member6);
		Admin1.addAvailableWorker (Member1);
		Admin1.addAvailableWorker (Member2);
		System.out.println("Quantité de travailleurs disponibles: ");
		System.out.println(Admin1.getAvailableWorkers());
		System.out.println("");
		
		// Test du fonctionnement du reseau
		int password1 = Network1.getPassword(); // Le reseau genere un mot de passe aleatoire du reseau 1
		int result1 = Admin1.getAdminPassword(Network1, password1); // L'administrateur recupere le mot de passe du reseau 2
		int password2 = Network2.getPassword();
		int result2 = Admin1.getAdminPassword(Network2, password2);
		System.out.println("Mot de passe est correct: ");
		try { // Verification du mot de passe
			System.out.println(Network1.verifyPassword(result1, password1));
			System.out.println("");
		}
		catch (Exception d) {
			System.out.println(d);
		}
		
		// Test d'ajout de membres
		try {
			Network2.addMemberNetwork(result2, password2, Network2, Admin2);
		}
		catch (Exception g) {
			System.out.println(g);
		}
		
		try {
			Admin2.addMemberAsAdmin(Network2, Admin2, result2, password2);
		}
		catch (Exception h) {
			System.out.println(h);
		}
		
		try {
			Network1.addMemberNetwork(result1, password1, Network1, Admin1);
		}
		catch (Exception l) {
			System.out.println(l);
		}
		
		try {
			Admin1.addMemberAsAdmin(Network1, Admin1, result1, password1);
		}
		catch (Exception m) {
			System.out.println(m);
		}
		
		// Test d'ajout d'un administrateur secondaire
		System.out.println("Quantite de travailleurs: ");
		System.out.println(Network2.getWorkersQuantity() + " travailleurs");
		System.out.println("");
		Network1.addOtherAdmin (Admin2);
		Admin1.addAdmin(Network1, Admin3);
		System.out.println("Quantite d'administrateurs secondaires: ");
		System.out.println(Network1.adminsQuantity() + " administrateurs");
		System.out.println("");
		
		// Test de la faisabilite d'une tache
		System.out.println("Faisabilite des taches: ");
		try {
			System.out.println(Admin2.approveTask(Network2, Member2, Task1, result2, 1, password2, Admin2));
		}
		catch (Exception j) {
			System.out.println(j);
		}
		
		try {
			Admin2.toFinalize(Network2, Member2, Task2, result2, 1, res2, password2, Admin2);
		}
		catch (Exception k) {
			System.out.println(k);
		}
		
		try {	
			Admin1.toFinalize(Network1, Member7, Task1, result1, 1, res1, password1, Admin1);
		}	
		catch (Exception n) {
				System.out.println(n);
		}
		
		try {
			Admin1.toFinalize(Network1, Member6, Task1, result1, 1, res1, password1, Admin1);
		}	
			catch (Exception n) {
				System.out.println(n);
		}

		try {
			Admin1.toFinalize(Network1, Member5, Task1, result1, 1, res1, password1, Admin1);
		}
		catch (Exception n) {
			System.out.println(n);
		}
		System.out.println("");
		
		// Affichage de la quantite d'argent final pour chaque membre 
		System.out.println("Quantite d'argent final pour chaque membre: ");
		System.out.println("Membre2: " + Member2.getMoney() + " euros");
		System.out.println("Membre3: " + Member3.getMoney()+ " euros");
		System.out.println("Membre5: " + Member5.getMoney()+ " euros");
		System.out.println("Membre6: " + Member6.getMoney()+ " euros");
		System.out.println("Membre7: " + Member7.getMoney()+ " euros");
		System.out.println("");
		
		// Test de l'historique de taches 
		System.out.println("Quantite de taches completees pour chaque administrateur: ");
		System.out.println("Admin1: " + Admin1.getCompletedTasksQuantity() + " taches");
		System.out.println("Admin2: " + Admin2.getCompletedTasksQuantity() + " tache");
		}
	}
