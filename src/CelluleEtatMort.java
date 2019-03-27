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
public class CelluleEtatMort implements CelluleEtat {
    public static final CelluleEtatMort INSTANCE;

    public CelluleEtat vit() {
      return new CelluleEtatVivant.getInstance();
    }

    public CelluleEtat meurt() {
      return this;
    }

    public boolean estVivante() {
      return false;
    }

    public static final CelluleEtatMort getInstance() {
      if(INSTANCE == null)
        INSTANCE = new CelluleEtatMort();
      return INSTANCE;
    }
}
