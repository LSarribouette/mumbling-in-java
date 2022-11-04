package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Apprenant;

public class TestApprenant {

	public static void main(String[] args) {
        Apprenant lauranne = new Apprenant("Lauranne", "CDA");
        System.out.println(lauranne);
        Apprenant pierrick = new Apprenant("Pierrick", "D2WM");
        System.out.println(pierrick);
        System.out.println("Il y a " + Apprenant.getNbApprenants() + " apprenants dans la promo.");
    }
}
