package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Cours;
import fr.lsarribouette.qetv.bo.Salle;

public class TestCours {

	public static void main(String[] args) {
		Cours algo = new Cours("Algorithmique", "Marie");
		algo.afficher();
		
		Cours initjava = new Cours("Initiation à Java", "Julien");
		initjava.afficher();
	}
}
