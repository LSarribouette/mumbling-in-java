package fr.lsarribouette.mumblinginjava;

import java.util.Scanner;

public class MumblingInJava {
	
	public static final int DIM1 = 4;
	public static final int DIM2 = 8;
	
	public static void main(String[] args) {
		
		String prenomJoueur;
		String[][] classePositions = new String[DIM1][DIM2];
		// je remplis mon tableau (sans les distanciels)
		 classePositions[0][0] = "Thibault";
		 classePositions[0][1] = "Quentin";
		 classePositions[0][2] = "Pierrick";
		 classePositions[0][3] = "Laura";
		 classePositions[0][4] = "";
		 classePositions[0][5] = "Hélène";
		 classePositions[0][6] = "Déana";
		 classePositions[0][7] = "Xavier F";
		 classePositions[1][0] = "Akim";
		 classePositions[1][1] = "Thomas";
		 classePositions[1][2] = "";
		 classePositions[1][3] = "";
		 classePositions[1][4] = "";
		 classePositions[1][5] = "Marie";
		 classePositions[1][6] = "Lauranne";
		 classePositions[1][7] = "Bruno";
		 classePositions[2][0] = "Bastien";
		 classePositions[2][1] = "Thibaut";
		 classePositions[2][2] = "";
		 classePositions[2][3] = "Mickaël";
		 classePositions[2][4] = "";
		 classePositions[2][5] = "Jonathan";
		 classePositions[2][6] = "Lucie";
		 classePositions[2][7] = "";
		 classePositions[3][0] = "";
		 classePositions[3][1] = "Théo";
		 classePositions[3][2] = "Kantin";
		 classePositions[3][3] = "Romain";
		 classePositions[3][4] = "";
		 classePositions[3][5] = "Nicolas";
		 classePositions[3][6] = "Xavier A";
		 classePositions[3][7] = "";
		int ligne = -1;
		int colonne = -1;
		String voisinDroite;
		String voirPlanClasse;
		
		Scanner console = new Scanner(System.in);
		
		//Blabla
		System.out.println("QUI EST TON VOISIN ?");
		System.out.println("Bienvenu.e dans ce petit jeu, l'objectif est simple : "
				+ "te rappeler -- deviner ? -- le nom de ton ou tes voisins.");
		System.out.println("Quelques infos : ");
		System.out.println("- le plan de la classe est celui du vendredi 30 septembre");
		System.out.println("- on peut avoir au maximum 4 voisins : un à droite, "
				+ "un à gauche, un devant et un derrière");
		System.out.println("- un poste vide ou une allée, ce n'est pas un voisin.");
		System.out.println("(!) Il y a \"Xavier F\" et \"Xavier A\"");
		System.out.println();
		
		//Saisie
		System.out.println("Prêt ? Alors commence par me donner ton prénom :");
		//prenomJoueur = console.nextLine();
		prenomJoueur = "Thomas";
		
		//Répéter jusqu'à avoir un nom d'élève
		do {
			//Position du joueur
			for (int i=0; i < DIM1; i++) {
				for (int j=0; j < DIM2; j++) {
					if(prenomJoueur == classePositions[i][j]) {
						ligne = i;
						colonne = j;
						System.out.println("la ligne est " + ligne + " et la colonne est " + colonne);
						}
					}
				}
		} while (ligne == -1);
		
		//Cherche voisin de droite (i; j+1)
		if (colonne < DIM2-1) {
			voisinDroite = classePositions[ligne][colonne+1];
			if (classePositions[ligne][colonne+1] == "") {
				System.out.println("Tu as un vide à ta droite.");
			} else {
				System.out.println("Ton voisin à droite est "+voisinDroite);
			}
		} else {
			System.out.println("Tu n'as pas de voisin à droite.");
		}
		
		
		
		//Choix d'afficher la classe
		System.out.println("Si tu souhaites afficher le plan de classe, saisis \"oui\". " 
				+ "Sinon, merci d'avoir joué ! :)");
		voirPlanClasse = console.nextLine();
		if (voirPlanClasse.equals("oui")) {
			afficheClasse();
		}
		
		console.close();
		
	}
	public static void afficheClasse() {
		String[][] classe = new String[DIM1][DIM2];
			// je remplis mon tableau (sans les distanciels)
		classe[0][0] = "Thibault";
		classe[0][1] = "Quentin ";
		classe[0][2] = "Pierrick";
		classe[0][3] = "Laura   ";
		classe[0][4] = "        ";
		classe[0][5] = "Hélène  ";
		classe[0][6] = "Déana   ";
		classe[0][7] = "Xavier F";
		classe[1][0] = "Akim    ";
		classe[1][1] = "Thomas  ";
		classe[1][2] = "        ";
		classe[1][3] = "        ";
		classe[1][4] = "        ";
		classe[1][5] = "Marie   ";
		classe[1][6] = "Lauranne";
		classe[1][7] = "Bruno   ";
		classe[2][0] = "Bastien ";
		classe[2][1] = "Thibaut ";
		classe[2][2] = "        ";
		classe[2][3] = "Mickaël ";
		classe[2][4] = "        ";
		classe[2][5] = "Jonathan";
		classe[2][6] = "Lucie   ";
		classe[2][7] = "        ";
		classe[3][0] = "        ";
		classe[3][1] = "Théo    ";
		classe[3][2] = "Kantin  ";
		classe[3][3] = "Romain  ";
		classe[3][4] = "        ";
		classe[3][5] = "Nicolas ";
		classe[3][6] = "Xavier A";
		classe[3][7] = "        ";
		
		System.out.println();
		for (int i=0; i < DIM1; i++) {
			for (int j=0; j < DIM2; j++) {
				System.out.print("| " + classe[i][j] + " |");
			}
			System.out.println();
		}
	}

}


