package fr.lsarribouette.qetv.bo;

/**
 * Une classe pour définir une salle de classe, dans laquelle des cours ont lieu
 * (max 21 dans l'année pour les CDA)
 * @author lsarribouette2022
 *
 */

public class Salle {
	public final int MAX_COURS = 21;
	
	private int numero;
	private int dimensionLignes;
	private int dimensionColonnes ;
	private String[][] agencement;
	
	private Cours[] coursDispense;
	private int nbCoursDispense=0;
	
	private static int nbSalles=0;
	
	/**
	 * Un constructeur de Salle
	 * @param numero
	 * @param dimensionLignes
	 * @param dimensionColonnes
	 */
	public Salle(int numero, int dimensionLignes, int dimensionColonnes) {
		this.numero=numero;
		this.dimensionLignes=dimensionLignes;
		this.dimensionColonnes=dimensionColonnes;
		this.agencement = new String[this.dimensionLignes][this.dimensionColonnes];
		
		this.coursDispense = new Cours[MAX_COURS]; 
		
		nbSalles++;
	}
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return the agencement
	 */
	public String[][] getAgencement() {
		return agencement;
	}

	/**
	 * @return the coursDispense
	 */
	public Cours[] getCoursDispense() {
		return coursDispense;
	}

	/**
	 * @return the nbCoursDispense
	 */
	public int getNbCoursDispense() {
		return nbCoursDispense;
	}

	/**
	 * Une procédure pour ajouter un nouveau cours dispensé dans une instance de salle
	 * @param i
	 */
	public void ajouterCoursDispense(Cours c) {
		if(nbCoursDispense < coursDispense.length) {
			coursDispense[nbCoursDispense] = c;
			nbCoursDispense++;
		}
	}
	
	/**
	 * Une procédure qui affiche des informations sur une instance de salle
	 * et ses cours
	 */
	public void afficherInfos() {
		System.out.println("Les cours ont lieu dans la salle numéro "+numero+" qui est agencée avec "+dimensionLignes
				+" rangées de "+dimensionColonnes+" bureaux maximum.");
		if(nbCoursDispense>0) {
			System.out.println("Les cours dispensés sont : ");
			for(int i=0; i<nbCoursDispense; i++) {
				System.out.println("   - \""+coursDispense[i]+"\""); //coursDispense.toString()
			}
		}
		System.out.println();
	}
	
	/**
	 * Une procédure qui affiche le plan d'une instance de salle
	 */
	public void afficherPlan() {
		System.out.println("Plan de la salle : ");
		for (int x=0; x < dimensionLignes; x++) {
			for (int y=0; y < dimensionColonnes; y++) {
				System.out.print("| " + agencement[x][y] + " |");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
}
