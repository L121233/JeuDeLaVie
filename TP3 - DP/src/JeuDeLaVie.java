import java.lang.Math;
import java.util.LinkedList;

/**
 *
 *
 * @author KAJAK Rémi
 *
 * @version 0.1
 */

/**
 * 
 *
 */
public class JeuDeLaVie implements Observable {
    private Cellule[][] grille;
    private LinkedList<Commande> commandes;
    private LinkedList<Observateur> observateurs;
    private Visiteur visiteur;
    private int xMax = 5, yMax = xMax;

    public JeuDeLaVie() {
      this.grille = new Cellule[xMax][yMax];
      this.initialiseGrille();
      this.commandes = new LinkedList<Commande>();
      this.observateurs = new LinkedList<Observateur>();
      this.visiteur = new VisiteurClassique(this);
    }
    
    public int getXMax() {
    	return this.xMax;
    }
    
    public int getYMax() {
    	return this.yMax;
    }

    public void initialiseGrille() {
    	for(int i = 0; i < xMax; i++)
	        for(int j = 0; j < yMax; j++)
	        	this.grille[i][j] = (Math.random() <= 0.5)? new Cellule(i,j,new CelluleEtatVivant()) : new Cellule(i,j,new CelluleEtatMort());
    }
    
    public Cellule getGrilleXY(int x, int y) {
    	return this.grille[x][y];
    }
    
    public void ajouterCommande(Commande c) {
    	this.commandes.add(c);
    }
    
    public void executerCommandes() {
    	for(Commande cmd : commandes)
    		cmd.executer();
		commandes.clear();
    }
    
    public void ajouterObservateur(Observateur obs) {
    	this.observateurs.add(obs);
    }
    
    public void supprimerObservateur(Observateur obs) {
    	this.observateurs.remove(obs);
    }
    
    public void notifierObservateur() {
    	for(Observateur obs : observateurs)
    		obs.actualiserVue();
    }
    
    public void distribuerVisiteur() {
    	for(int i = 0; i < xMax; i++)
	        for(int j = 0; j < yMax; j++)
	        	this.grille[i][j].accepte(visiteur);
    }
    
    public void calculerGenerationSuivante() {
    	this.distribuerVisiteur();	// Étape n°1
    	this.executerCommandes();	// Étape n°2
    	this.notifierObservateur();	// Étape n°3
    }

    public static void main(String[] args) {
		JeuDeLaVie jeu = new JeuDeLaVie();
		JeuDeLaVieUI vueJeu = new JeuDeLaVieUI(jeu);
		
		jeu.ajouterObservateur(vueJeu);
		for(int i = 0; i < 1; i++)
			jeu.calculerGenerationSuivante();
    }
}
