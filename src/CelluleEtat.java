/**
 * Interface "CelluleEtat", qui définit les prototypes de quatre fonctions.
 *
 * @author KAJAK Rémi
 */
public interface CelluleEtat {
  public CelluleEtat vit();
  public CelluleEtat meurt();
  public boolean estVivante();
  public void accepte(Visiteur visiteur, Cellule cell);
}
