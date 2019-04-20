import java.lang.Math;
import java.util.LinkedList;
import java.util.Scanner;

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

  public JeuDeLaVie(int numVisiteur) {
    this.grille = new Cellule[xMax][yMax];
    this.initialiseGrille();
    this.commandes = new LinkedList<Commande>();
    this.observateurs = new LinkedList<Observateur>();
    this.visiteur = (numVisiteur == 1) ? new VisiteurClassique(this) : new VisiteurPlus(this);
  }

  public Visiteur getVisiteur() {
    return this.visiteur;
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
        this.grille[i][j] = (Math.random() <= 0.5)? new Cellule(i,j,CelluleEtatVivant.getInstance()) : new Cellule(i,j,CelluleEtatMort.getInstance());
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

  public int nombreCellulesVivantes() {
  	int nbCV = 0;

  	for(int i = 0; i < xMax; i++)
      for(int j = 0; j < yMax; j++)
        if(this.grille[i][j].estVivante())
          ++nbCV;

    return nbCV;
  }

  public void calculerGenerationSuivante() {
  	this.distribuerVisiteur();   // Étape n°1
  	this.executerCommandes();    // Étape n°2
  	this.notifierObservateur();  // Étape n°3
  }

	public static void main(String[] args) {
    Scanner lecture = new Scanner(System.in);
    String choixVisiteur;
    int numVisiteur = -1;

    System.out.println("Bienvenue sur le \"Jeu de la Vie\" !\n\nChoisissez d'abord le mode de génération des cellules :");
    System.out.println("\n\t1 -> Règles natives : une cellule vivante meurt si elle possède moins de deux ou plus de trois voisines vivantes ; une cellule morte naît si elle a exactement trois voisines vivantes ;");
    System.out.println("\n\t2 -> Règles personnalisées : une cellule vivante meurt si elle moins de trois, plus de huit ou exactement cinq voisines vivantes ; une cellule morte naît si elle a exactement trois, six, sept ou huit voisines vivantes.");
    System.out.println("\nEnsuite, admirez le résultat à l'oeuvre !\n");

    while(numVisiteur != 1 && numVisiteur != 2) {
      System.out.print("Votre choix : ");
      choixVisiteur = lecture.nextLine();
      numVisiteur = Integer.parseInt(choixVisiteur);

      if(numVisiteur != 1 && numVisiteur != 2)
        System.out.println("ERREUR : choix inconnu(" + choixVisiteur + "). Veuillez recommencer votre saisie !\n");
    }
		JeuDeLaVie jeu = new JeuDeLaVie(numVisiteur);
		JeuDeLaVieUI vueGraphiqueJeu = new JeuDeLaVieUI(jeu);
		JeuDeLaVieTextuel vueTexteJeu = new JeuDeLaVieTextuel(jeu);

		while(jeu.nombreCellulesVivantes() > 0) {
			jeu.calculerGenerationSuivante();
		}
    jeu.supprimerObservateur(vueGraphiqueJeu);
    jeu.supprimerObservateur(vueTexteJeu);
		System.out.println("Population disparue : toutes les cellules sont mortes !");
  }
}
