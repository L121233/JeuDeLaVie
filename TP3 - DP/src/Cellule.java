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
    @SuppressWarnings("unused")
	private int x, y;

    public Cellule(int x, int y, CelluleEtat etat) {
    	this.etat = etat;
    	this.x = x;
    	this.y = y;
    }

    public void vit() {
    	this.etat = etat.vit();
    }

    public void meurt() {
    	this.etat = etat.meurt();
    }

    public boolean estVivante() {
    	return this.etat.estVivante();
    }

    public int nombreVoisinesVivantes(JeuDeLaVie jeu) {
      // à completer

      return 0;
    }
}
