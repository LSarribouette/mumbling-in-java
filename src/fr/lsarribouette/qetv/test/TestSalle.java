package fr.lsarribouette.qetv.test;

import fr.lsarribouette.qetv.bo.Salle;

public class TestSalle {

	public static void main(String[] args) {
		Salle salle202 = new Salle(202, 4, 8);
		salle202.afficherInfos();
		salle202.afficherPlan();
	}

}
