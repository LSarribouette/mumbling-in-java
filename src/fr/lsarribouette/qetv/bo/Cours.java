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
	 * Une procédure pour ajouter un nouvel apprenant dans une instance de cours
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
	 * Une procédure pour afficher des informations sur une instance de cours
	 * et ses apprenants 
	 */
	public void afficher() {
		System.out.println("Le cours n°"+numero+" \""+libelle+"\" est dispensé par "+formateur);
		if(nbEleves>0) {
			System.out.println("Les élèves participant à ce cours sont : ");
			for(int i=0; i<nbEleves; i++) {
			System.out.println("   - "+eleve[i]); //eleve[i].toString ou bien eleve[i].afficher() ?
			}
		}
		System.out.println();
		
	}
	
	public String toString() {
		return this.libelle;
	}
}
