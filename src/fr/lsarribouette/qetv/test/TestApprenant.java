package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Apprenant;

public class TestApprenant {

	public static void main(String[] args) {
        Apprenant lauranne = new Apprenant("Lauranne", "CDA");
        lauranne.afficher();
        Apprenant pierrick = new Apprenant("Pierrick", "D2WM");
        pierrick.afficher();
        System.out.println("Il y a " + Apprenant.getNbApprenants() + " apprenants dans la promo.");
    }
}
