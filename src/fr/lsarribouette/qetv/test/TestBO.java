package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Apprenant;
import fr.lsarribouette.qetv.bo.Cours;
import fr.lsarribouette.qetv.bo.Salle;

public class TestBO {

	public static void main(String[] args) {
		Apprenant lauranne = new Apprenant("Lauranne", "CDA");
		lauranne.afficher();
		System.out.println();
		
		Apprenant pierrick = new Apprenant("Pierrick", "D2WM");
		
		Cours algo = new Cours("Algorithmique", "Marie");
		algo.ajouterEleve(lauranne);
		algo.ajouterEleve(pierrick);
		algo.afficher();
		System.out.println();
		
		lauranne.afficher();
		System.out.println();
		
		Salle salle202 = new Salle(202, 4, 8);
		salle202.ajouterCoursDispense(algo);
		salle202.afficherInfos();
		salle202.afficherPlan();
	}

}
