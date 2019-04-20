import java.lang.Math;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe "JeuDeLaVie", qui implémente l'interface "Observable" et qui intègre
 * tous les Design Patterns développés dans ce projet.
 *
 * @author KAJAK Rémi
 */
public class JeuDeLaVie implements Observable {
  private Cellule[][] grille;
  private LinkedList<Commande> commandes;
  private LinkedList<Observateur> observateurs;
  private Visiteur visiteur;
  private int xMax = 5, yMax = xMax;

  /**
   * Constructeur par défaut de la classe courante.
   *
   * @param numVisiteur Un entier strictement positif (soit 1, soit 2).
   */
  public JeuDeLaVie(int numVisiteur) {
    this.grille = new Cellule[xMax][yMax];
    this.initialiseGrille();
    this.commandes = new LinkedList<Commande>();
    this.observateurs = new LinkedList<Observateur>();
    this.visiteur = (numVisiteur == 1) ? new VisiteurClassique(this) : new VisiteurPlus(this);
  }

  /**
   * Getter de la variable "visiteur".
   *
   * @return  L'instance d'une des sous-classes de l'interface "Visiteur".
   */
  public Visiteur getVisiteur() {
    return this.visiteur;
  }

  /**
   * Getter de la variable "xMax".
   *
   * @return  La valeur entière du "xMax" de l'objet courant.
   */
  public int getXMax() {
  	return this.xMax;
  }

  /**
   * Getter de la variable "yMax".
   *
   * @return  La valeur entière du "yMax" de l'objet courant.
   */
  public int getYMax() {
  	return this.yMax;
  }

  /**
   * Cette fonction permet d'initialiser chaque case de la matrice avec l'instance
   * d'une cellule vivante ou d'une cellule morte.
   */
  public void initialiseGrille() {
  	for(int i = 0; i < xMax; i++)
      for(int j = 0; j < yMax; j++)
        this.grille[i][j] = (Math.random() <= 0.5)? new Cellule(i,j,CelluleEtatVivant.getInstance()) : new Cellule(i,j,CelluleEtatMort.getInstance());
  }

  /**
   * Cette fonction permet de renvoyer l'instance de la cellule dont les coordonnées
   * ont été renseignées dans les paramètres.
   *
   * @param x Un entier strictement positif, compris entre 0 et la variable "xMax".
   * @param y Un entier strictement positif, compris entre 0 et la variable "yMax".
   *
   * @return  L'instance de la classe "Cellule" voulue
   */
  public Cellule getGrilleXY(int x, int y) {
  	return this.grille[x][y];
  }

  /**
   * Cette fonction permet d'ajouter une nouvelle commande à la liste de commandes
   * de l'objet courant.
   *
   * @param c Une instance d'une des sous-classes de la classe abstraite "Commande".
   */
  public void ajouterCommande(Commande c) {
  	this.commandes.add(c);
  }

  /**
   * Cette fonction permet d'exécuter toutes les commandes présentes dans la liste
   * de commandes de l'objet courant. Une fois la tâche effectuée, cette liste est purgée.
   */
  public void executerCommandes() {
  	for(Commande cmd : commandes)
      cmd.executer();
		commandes.clear();
  }

  /**
   * Cette fonction permet d'ajouter un nouvel observateur dans la liste des observateurs
   * de l'objet courant.
   *
   * @param obs Une instance d'une des sous-classes de l'interface "Observateur".
   */
  @Override
  public void ajouterObservateur(Observateur obs) {
  	this.observateurs.add(obs);
  }

  /**
   * Cette fonction permet de retirer un observateur de la liste des observateurs de
   * l'objet courant.
   *
   * @param obs Une instance d'une des sous-classes de l'interface "Observateur".
   */
  @Override
  public void supprimerObservateur(Observateur obs) {
  	this.observateurs.remove(obs);
  }

  /**
   * Cette fonction permet d'actualiser la vue de tous les observateurs présents dans
   * la liste d'observateurs de l'objet courant.
   */
  @Override
  public void notifierObservateur() {
  	for(Observateur obs : observateurs)
  		obs.actualiserVue();
  }

  /**
   * Cette fonction permet de faire passer à chaque cellule de la matrice le visiteur
   * de l'objet courant. Ainsi, chacune d'elles évoluera selon si elle respecte ses
   * règles ou non.
   */
  public void distribuerVisiteur() {
  	for(int i = 0; i < xMax; i++)
      for(int j = 0; j < yMax; j++)
        this.grille[i][j].accepte(visiteur);
  }

  /**
   * Cette fonction permet de déterminer combien de cellules vivantes se trouvent dans
   * la matrice de l'objet courant.
   *
   * @return  Le nombre de cellules vivantes, compris entre 0 et la taille de la matrice
   *          au carré.
   */
  public int nombreCellulesVivantes() {
  	int nbCV = 0;

  	for(int i = 0; i < xMax; i++)
      for(int j = 0; j < yMax; j++)
        if(this.grille[i][j].estVivante())
          ++nbCV;

    return nbCV;
  }

  /**
   * Cette fonction permet de générer une nouvelle génération de cellules à chaque cycle.
   * Elle appelle, dans le bon ordre :
   *  - la distribution du visiteur courant à toutes les cellules de la matrice ;
   *  - l'exécution de toutes les commandes reçues grâce aux indications du visiteur ;
   *  - l'actualisation de l'affichage des observateurs.
   */
  public void calculerGenerationSuivante() {
  	this.distribuerVisiteur();   // Étape n°1
  	this.executerCommandes();    // Étape n°2
  	this.notifierObservateur();  // Étape n°3
  }

  /**
   * Cette fonction permet de tester l'ensemble des fonctionnalités définies dans ce projet.
   * Un menu textuel indique à l'utilisateur quel visiteur doit être sélectionné, puis une
   * nouvelle instance de la classe "JeuDeLaVie" - ainsi que deux observateurs distincts -
   * est créée. S'en suit alors l'évolution de la population de cellules jusqu'à son extinction.
   */
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
    System.exit(0);
  }
}
