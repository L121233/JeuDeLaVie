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

    public void vit() {
      this.etat = etat.vit();
    }

    public void meurt() {
      this.etat = etat.meurt();
    }

    public boolean estVivante() {
      return (this.etat instanceof CelluleEtatVivant);
    }
}
