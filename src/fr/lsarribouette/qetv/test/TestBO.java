package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Apprenant;
import fr.lsarribouette.qetv.bo.Cours;
import fr.lsarribouette.qetv.bo.Salle;

public class TestBO {

	public static void main(String[] args) {
		Apprenant lauranne = new Apprenant("Lauranne", "CDA");
		System.out.println(lauranne);
		System.out.println();
		
		Apprenant pierrick = new Apprenant("Pierrick", "D2WM");
		
		Cours algo = new Cours("Algorithmique", "Marie");
		algo.ajouterEleve(lauranne);
		algo.ajouterEleve(pierrick);
		System.out.println(algo);
		algo.afficherEleves();
		System.out.println();
		
		System.out.println(lauranne);
		lauranne.afficherCoursSuivis();
		System.out.println();
		
		Salle salle202 = new Salle(202, 4, 8);
		salle202.ajouterCoursDispense(algo);
		System.out.println(salle202);
		salle202.afficherCoursDispenses();
		salle202.afficherPlan();
	}

}
