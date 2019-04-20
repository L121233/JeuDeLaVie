/**
 * Classe "CelluleEtatVivant", qui implémente l'interface "CelluleEtat".
 * Elle permet d'instancier un état correspondant à celui d'une cellule vivante
 * et modifie les fonctions héritées en conséquence.
 *
 * @author KAJAK Rémi
 */
public class CelluleEtatVivant implements CelluleEtat {
  public static CelluleEtatVivant INSTANCE;

  /**
   * Constructeur de la classe courante rendu privé pour respecter la mise en oeuvre
   * du Design Pattern "Singleton".
   */
  private CelluleEtatVivant() {}

  /**
   * Cette fontion retourne l'instance de la classe courante (Singleton).
   *
   * @return L'instance de la classe "CelluleEtatVivant".
   */
  @Override
  public CelluleEtat vit() {
  	return this;
  }

  /**
   * Cette fonction permet de retourner une instance de la classe "CelluleEtatMort"
   * dans le cas où la cellule appelante doit mourir (Singleton).
   *
   * @return L'instance de la classe "CelluleEtatMort".
   */
  @Override
  public CelluleEtat meurt() {
  	return CelluleEtatMort.getInstance();
  }

  /**
   * Cette fonction permet de déterminer si l'état de la cellule est défini à vivant ou
   * à mort.
   *
   * @return  Dans cette classe, "true" est systématiquement retourné.
   */
  @Override
  public boolean estVivante() {
  	return true;
  }

  /**
   * Cette fonction permet de récupérer l'instance de la classe courante dans une classe
   * extérieure ; contrairement aux fonctions "vit" et "meurt" qui ne concernent que les
   * instances de la classe "Cellule".
   *
   * @return  L'instance de la classe courante.
   */
  public static final CelluleEtatVivant getInstance() {
  	if(INSTANCE == null)
  		INSTANCE = new CelluleEtatVivant();
  	return INSTANCE;
  }

  /**
   * Cette fonction permet au visiteur reçu en paramètre d'appliquer ses règles sur la cellule
   * concernée. Dans cette classe, il s'agit des règles de la cellule vivante.
   *
   * @param visiteur Une instance de la classe "Visiteur".
   * @param cell  Une instance de la classe "Cellule".
   */
  @Override
  public void accepte(Visiteur visiteur, Cellule cell) {
  	visiteur.visiteCelluleVivante(cell);
  }
}
