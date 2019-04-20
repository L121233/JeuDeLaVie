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
  public static CelluleEtatMort INSTANCE;

  private CelluleEtatMort() {}

  @Override
  public CelluleEtat vit() {
  	return CelluleEtatVivant.getInstance();
  }

  @Override
  public CelluleEtat meurt() {
  	return this;
  }

  @Override
  public boolean estVivante() {
  	return false;
  }

  public static final CelluleEtatMort getInstance() {
  	if(INSTANCE == null)
  		INSTANCE = new CelluleEtatMort();
  	return INSTANCE;
  }

  @Override
  public void accepte(Visiteur visiteur, Cellule cell) {
  	visiteur.visiteCelluleMorte(cell);
  }
}
