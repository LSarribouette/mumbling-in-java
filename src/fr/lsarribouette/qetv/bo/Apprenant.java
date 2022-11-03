package fr.lsarribouette.qetv.bo;

/**
 * Une classe pour définir un apprenant, qui suit des cours auxquels il est inscrit (selon sa promo)
 * et qui a une position dans une salle
 * @author lsarribouette2022
 *
 */
public class Apprenant {
	public final int NB_COURS_D2WM = 15;
	public final int NB_COURS_CDA = 21;
	
    private String prenom;
    private String promo;
    
    private Cours[] coursSuivis;
    private int nbCoursSuivis=0;
    
    private static int nbApprenants=0;
    
    public Apprenant(String prenom, String promo) {
        this.prenom=prenom;
        if (promo == "D2WM" || promo == "CDA") {
            this.promo=promo;
            if (promo == "D2WM") {
            	coursSuivis = new Cours[NB_COURS_D2WM];
            }
            if (promo == "CDA") {
            	coursSuivis = new Cours[NB_COURS_CDA];
            }
        }
        
        
        nbApprenants++;
    }
    
    public void ajouterCoursSuivis(Cours c) {
    	if(nbCoursSuivis < coursSuivis.length) {
			coursSuivis[nbCoursSuivis] = c;
			nbCoursSuivis++;
		}
    }
    
    public static int getNbApprenants() {
        return nbApprenants;
    }
    
    /**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the promo
	 */
	public String getPromo() {
		return promo;
	}

	/**
	 * @param promo the promo to set
	 */
	public void setPromo(String promo) {
		this.promo = promo;
	}

	/**
	 * Une procédure pour afficher des informations sur une instance d'apprenant
	 */
	public void afficher() {
        System.out.println("L'apprenant.e " + prenom + " est dans la promo " + promo);
        if(nbCoursSuivis>0) {
        	System.out.println("Il/elle suit les cours : ");
        	for(int i=0; i<nbCoursSuivis; i++) {
        		System.out.println("   - "+coursSuivis[i]);
        	}
        	System.out.println();
        }
    }
    
    public String toString() {
    	return this.prenom;
    }
}
