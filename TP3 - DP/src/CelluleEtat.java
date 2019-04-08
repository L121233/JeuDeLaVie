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
public interface CelluleEtat {
    public CelluleEtat vit();
    public CelluleEtat meurt();
    public boolean estVivante();
    public void accepte(Visiteur visiteur, Cellule cell);
}
