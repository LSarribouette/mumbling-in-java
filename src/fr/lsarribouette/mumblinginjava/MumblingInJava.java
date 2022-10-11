package fr.lsarribouette.mumblinginjava;

import java.util.Scanner;

public class MumblingInJava {
	
	private static boolean testing = false;	
	
	static Scanner console;
	
	public static final int DIM1 = 4;
	public static final int DIM2 = 8;
	private static String[][] classePositions = new String[DIM1][DIM2];
	public static final int MAXTENTATIVES = 3;
	private static int tentatives;
	
	public static void main(String[] args) {
		
		String prenomJoueur;
		boolean valide = false;
		int ligne;
		int colonne;
		String monVoisinDroite;
		String monVoisinGauche;
		String monVoisinDevant;
		String monVoisinDerriere;
		boolean guessDroite = false;
		boolean guessGauche = false;
		boolean guessDevant = false;
		boolean guessDerriere = false;
		int nbTrouve = 0;
		String voirPlanClasse = "";
		
		console = new Scanner(System.in);
		
		initClassePositions(classePositions);
		
		blabla();
		
		//---Saisie
		System.out.println("Prêt ? Alors commence par me donner ton prénom :");
		prenomJoueur = console.nextLine();
		
		//---Répéter jusqu'à avoir un nom d'élève
		do {
			valide = estUnEleve(prenomJoueur);
			if (!valide) {
				System.out.println("Ce prénom ne fait pas partie de la classe ! Saisis un autre prénom :");
				prenomJoueur = console.nextLine();
			}
		} while (!valide);
		System.out.printf("Bienvenue %s !%n", prenomJoueur);
		
		//---Donner la position dans la classe
		ligne = estEnPosition(prenomJoueur,'x');
		colonne = estEnPosition(prenomJoueur, 'y');
		if (testing) System.out.printf("Ta position dans la classe est [%d][%d].%n", ligne, colonne);

		//---Calcul des voisins
		monVoisinDroite = donneVoisin(1, ligne, colonne);
		monVoisinGauche = donneVoisin(2, ligne, colonne);
		monVoisinDevant = donneVoisin(3, ligne, colonne);
		monVoisinDerriere = donneVoisin(4, ligne, colonne);
		
		//---Devinette des voisins
		guessDroite = compareVoisin(1, monVoisinDroite);
		if (!guessDroite) {
			System.out.println("Tu n'as pas trouvé !! C'est "+monVoisinDroite+", bien sûr.");
		} else {
			nbTrouve++;
		}
		
		guessGauche = compareVoisin(2, monVoisinGauche);
		if (!guessGauche) {
			System.out.println("Tu n'as pas trouvé !! C'est "+monVoisinGauche+", bien sûr.");
		} else {
			nbTrouve++;
		}
		
		guessDevant = compareVoisin(3, monVoisinDevant);
		if (!guessDevant) {
			System.out.println("Tu n'as pas trouvé !! C'est "+monVoisinDevant+", bien sûr.");
		} else {
			nbTrouve++;
		}
		
		guessDerriere = compareVoisin(4, monVoisinDerriere);
		if (!guessDerriere) {
			System.out.println("Tu n'as pas trouvé !! C'est "+monVoisinDerriere+", bien sûr.");
		} else {
			nbTrouve++;
		}
		
		//---Résultats
		System.out.println("Tu as réussi à deviner "+nbTrouve+" de tes voisins.");
		
		//---Choix d'afficher la classe
		System.out.println("Si tu souhaites afficher le plan de classe, saisis \"oui\". " 
				+ "Sinon, merci d'avoir joué ! :)");
		voirPlanClasse = console.nextLine();
		if (voirPlanClasse.equals("oui")) {
			afficheClasse();
		}
		
		console.close();
		
	}
	
	private static void initClassePositions(String[][] unTableauADeuxDims) {
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
				 classePositions[2][2] = "Brahim";
				 classePositions[2][3] = "Mickaël";
				 classePositions[2][4] = "";
				 classePositions[2][5] = "Jonathan";
				 classePositions[2][6] = "Lucie";
				 classePositions[2][7] = "Rémi";
				 classePositions[3][0] = "";
				 classePositions[3][1] = "Théo";
				 classePositions[3][2] = "Kantin";
				 classePositions[3][3] = "Romain";
				 classePositions[3][4] = "";
				 classePositions[3][5] = "Nicolas";
				 classePositions[3][6] = "Xavier A";
				 classePositions[3][7] = "";
	}
	
	private static void blabla() {
		System.out.println("QUI EST TON VOISIN ?");
		System.out.println("Bienvenu.e dans ce petit jeu, l'objectif est simple : "
				+ "te rappeler -- deviner ? -- le nom de ton ou tes voisins.");
		System.out.println("Quelques infos : ");
		System.out.println("- le plan de la classe est celui du lundi 10 octobre,");
		System.out.println("- les covidés sont considérés sur place (ils ont leur ordi après tout),");
		System.out.println("- on peut avoir au maximum 4 voisins : un à droite, "
				+ "un à gauche, un devant et un derrière");
		System.out.println("- un poste vide ou une allée, ce n'est pas un voisin.");
		System.out.println("(!) Il y a \"Xavier F\" et \"Xavier A\"");
		System.out.println();
	}

	private static boolean estUnEleve(String saisie) {
		// parcourt chaque case du tableau et cherche si la saisie est un prénom de la classe
		// retourne vrai si c'est le cas
		boolean res = false;
		for (int i=0; i<DIM1; i++) {
			for (int j=0; j<DIM2; j++) {
				if(saisie.equalsIgnoreCase(classePositions[i][j])) {
					res = true;
				} 
			}
		}
		return res;
	}
	
	private static int estEnPosition(String saisie, char choixCoord) {
		// parcourt chaque case du tableau et cherche les coordonnées de la position du prénom saisi
		// retourne au choix la ligne (x) ou la colonne (y)
		int x=0;
		int y=0;
		char coordRetournee = choixCoord;
		for (int i=0; i<DIM1; i++) {
			for (int j=0; j<DIM2; j++) {
				if(saisie.equalsIgnoreCase(classePositions[i][j])) {
					x = i;
					y = j;
				} 
			}
		}
		return (coordRetournee=='x') ? x : y;
	}
	
	private static String donneVoisin(int quelVoisin, int quelX, int quelY) {
		String voisin = "";
		
		switch (quelVoisin) {
		// à droite
		case 1 :
			if (quelY < DIM2-1 && !classePositions[quelX][quelY+1].equals("")) {
				voisin = classePositions[quelX][quelY+1];
				if (testing) System.out.println("Ton voisin à droite est "+voisin+".");
			} else {
				voisin = "nope";
				if (testing) System.out.println("Tu n'as pas de voisin à droite.");
			}
			break;
		// à gauche
		case 2 :
			if (quelY > 0 && !classePositions[quelX][quelY-1].equals("")) {
				voisin = classePositions[quelX][quelY-1];
				if (testing) System.out.println("Ton voisin à gauche est "+voisin+".");
			} else {
				voisin = "nope";
				if (testing) System.out.println("Tu n'as pas de voisin à gauche.");
			}
			break;
		// devant
		case 3 :
			if (quelX > 0 && !classePositions[quelX-1][quelY].equals("")) {
				voisin = classePositions[quelX-1][quelY];
				if (testing) System.out.println("Ton voisin devant est "+voisin+".");
			} else {
				voisin = "nope";
				if (testing) System.out.println("Tu n'as pas de voisin devant.");
			}
			break;
		// derrière
		case 4 :
			if (quelX < DIM1-1 && !classePositions[quelX+1][quelY].equals("")) {
				voisin = classePositions[quelX+1][quelY];
				if (testing) System.out.println("Ton voisin derrière est "+voisin+".");
			} else {
				voisin = "nope";
				if (testing) System.out.println("Tu n'as pas de voisin derrière.");
			}
			break;
		default : System.out.println("Erreur : choix du voisin incorrect, il doit être entre 1 et 4.");
		}		
		return voisin;
	}
	
	private static boolean compareVoisin(int quelVoisin, String quelComp) {
		boolean aTrouve = false;
		String texte = "";
		String guess = "";
		tentatives = 1;
		
		switch (quelVoisin) {
		case 1 : texte = "à droite";
			break;
		case 2 : texte = "à gauche";
			break;
		case 3 : texte = "devant";
			break;
		case 4 : texte = "derrière";
			break;
		}
		
		do {
			System.out.println("Quel est ton voisin "+texte+" ? ("+tentatives+" sur "+MAXTENTATIVES+" tentatives) Tape \"nope\" si tu n'en as pas.\"");
			guess = console.nextLine();
			if (guess.equalsIgnoreCase(quelComp)) {
				System.out.println("Bravo ! Tu as trouvé en "+tentatives+" tentatives.");
				aTrouve = true;
			} else {
				System.out.println("Eh non...");
			}
			tentatives++;
		} while (tentatives<=MAXTENTATIVES && !aTrouve);
		
		return aTrouve;
	}
	
	private static void afficheClasse() {
		// affiche le plan de la classe
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
		classe[2][2] = "Brahim  ";
		classe[2][3] = "Mickaël ";
		classe[2][4] = "        ";
		classe[2][5] = "Jonathan";
		classe[2][6] = "Lucie   ";
		classe[2][7] = "Rémi    ";
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


