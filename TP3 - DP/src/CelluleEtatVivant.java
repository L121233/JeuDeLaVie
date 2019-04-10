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
    public static CelluleEtatVivant INSTANCE;

    @Override
    public CelluleEtat vit() {
    	return this;
    }

    @Override
    public CelluleEtat meurt() {
    	return CelluleEtatMort.getInstance();
    }

    @Override
    public boolean estVivante() {
    	return true;
    }

    public static final CelluleEtatVivant getInstance() {
    	if(INSTANCE == null)
    		INSTANCE = new CelluleEtatVivant();
    	return INSTANCE;
    }
    
    @Override
    public void accepte(Visiteur visiteur, Cellule cell) {
    	visiteur.visiteCelluleVivante(cell);
    }
}
