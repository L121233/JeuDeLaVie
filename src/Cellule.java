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
public class Cellule {
  private CelluleEtat etat;
	private int x, y;

  public Cellule(int x, int y, CelluleEtat etat) {
  	this.etat = etat;
  	this.x = x;
  	this.y = y;
  }

  public void vit() {
  	this.etat = this.etat.vit();
  }

  public void meurt() {
    this.etat = this.etat.meurt();
  }

  public boolean estVivante() {
  	return this.etat.estVivante();
  }

  public int nombreVoisinesVivantes(JeuDeLaVie jeu) {
  	int nbVV = 0;

    for(int i = this.x-1; i <= this.x+1; i++)
      for(int j = this.y-1; j <= this.y+1; j++)
        if((i >= 0 && i < jeu.getXMax()) && (j >= 0 && j < jeu.getYMax()))
          if(this != jeu.getGrilleXY(i,j) && jeu.getGrilleXY(i,j).estVivante())
            ++nbVV;

    return nbVV;
	}

  public void accepte(Visiteur visiteur) {
  	this.etat.accepte(visiteur,this);
  }
}
