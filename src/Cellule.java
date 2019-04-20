/**
 * Classe "Cellule", implémente le Design Pattern "État". Dans le cas présent,
 * ce DP permet de déterminer si une cellule est vivante ou morte.
 *
 * @author KAJAK Rémi
 */
public class Cellule {
  private CelluleEtat etat;
	private int x, y;

  /**
   * Constructeur par défaut de la classe courante.
   *
   * @param x Un entier strictement positif pour une coordonnée horizontale.
   * @param y Un entier strictement positif pour une coordonnée verticale.
   * @param etat  Une instance d'une des sous-classes de l'interface "CelluleEtat".
   */
  public Cellule(int x, int y, CelluleEtat etat) {
  	this.etat = etat;
  	this.x = x;
  	this.y = y;
  }

  /**
   * Cette fonction permet de retourner une instance de la classe "CelluleEtatVivant" (Singleton).
   */
  public void vit() {
  	this.etat = this.etat.vit();
  }

  /**
   * Cette fonction permet de retourner une instance de la classe "CelluleEtatMort" (Singleton).
   */
  public void meurt() {
    this.etat = this.etat.meurt();
  }

  /**
   * Cette fonction permet de déterminer si une cellule est vivante ou non grâce à son état courant.
   *
   * @return  "true" si la cellule est vivante, "false" sinon.
   */
  public boolean estVivante() {
  	return this.etat.estVivante();
  }

  /**
   * Cette fonction permet de retourner le nombres de cellules voisines vivantes de la cellule instanciée.
   *
   * @param jeu Une instance de la classe "JeuDeLaVie".
   *
   * @return  Le nombre de cellules vivantes détectées (entre 0 et 8).
   */
  public int nombreVoisinesVivantes(JeuDeLaVie jeu) {
  	int nbVV = 0;

    for(int i = this.x-1; i <= this.x+1; i++)
      for(int j = this.y-1; j <= this.y+1; j++)
        if((i >= 0 && i < jeu.getXMax()) && (j >= 0 && j < jeu.getYMax()))
          if(this != jeu.getGrilleXY(i,j) && jeu.getGrilleXY(i,j).estVivante())
            ++nbVV;

    return nbVV;
	}

  /**
   * Cette fonction permet de passer à l'état courant un visiteur et la cellule elle-même.
   *
   * @param visiteur  Une instance d'une des sous-classes de la classe abstraite "Visiteur".
   */
  public void accepte(Visiteur visiteur) {
  	this.etat.accepte(visiteur,this);
  }
}
