package fr.lsarribouette.qetv.bo;

import java.time.LocalDate;

/**
 * Une classe pour définir un cours, pour lequel il y a des participants
 * (max 24 par cours)
 * @author lsarribouette2022
 *
 */
public class Cours {
	public final int MAX_APPRENANTS = 24;
	
	private String libelle;
	private int numero;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String formateur;
	
	private Apprenant[] eleve;
	private int nbEleves=0;
	
	private static int nbCours=0;
	
	
	/**
	 * Un constructeur de Cours
	 * @param libelle
	 * @param formateur
	 */
	public Cours(String libelle, String formateur) {
		this.libelle=libelle;
		this.formateur=formateur;
		
		this.eleve= new Apprenant[MAX_APPRENANTS]; 
		
		nbCours++;
		this.numero=nbCours;
	}
	
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	public String toString() { //todo : ajouter dates
		return "Le cours n°"
				+ numero
				+ " \""+libelle+"\" est dispensé par "
				+ formateur;		
	}
	
	/**
	 * Une procédure pour ajouter un nouvel Apprenant dans une instance de Cours
	 * (association bidirectionnelle)
	 * @param a
	 */
	public void ajouterEleve(Apprenant a) {
		if(nbEleves < eleve.length) {
			eleve[nbEleves] = a;
			nbEleves++;
		}
		a.ajouterCoursSuivis(this);
	}
	
	/**
	 * Une procédure pour afficher le nombre d'instances Apprenant liées à une instance de Cours
	 */
	public void afficherEleves() {
		if(nbEleves>0) {
			System.out.println("Les élèves participant à ce cours sont : ");
			for(int i=0; i<nbEleves; i++) {
			System.out.println("   - "+eleve[i].getPrenom());
			}
		}
		System.out.println();
	}
}
