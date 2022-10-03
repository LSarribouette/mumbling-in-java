package fr.lsarribouette.mumblinginjava;

import java.util.Scanner;

public class MumblingInJava {
	
	public static final int DIM1 = 4;
	public static final int DIM2 = 8;
	
	public static void main(String[] args) {
		
		
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
		
		afficheClasse();

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


