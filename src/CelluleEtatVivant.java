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
public class CelluleEtatVivant implements CelluleEtat {
    public static final CelluleEtatVivant INSTANCE;

    public CelluleEtat vit() {
      return this;
    }

    public CelluleEtat meurt() {
      return new CelluleEtatMort.getInstance();
    }

    public boolean estVivante() {
      return true;
    }

    public static final CelluleEtatVivant getInstance() {
      if(INSTANCE == null)
        INSTANCE = new CelluleEtatVivant();
      return INSTANCE;
    }
}
