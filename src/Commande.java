/**
 * Classe abstraite "Commande", qui permet d'implémenter le Design Pattern éponyme.
 * Elle définit une instance protégée de la classe "Cellule", ainsi qu'un prototype
 * de fonction.
 *
 * @author KAJAK Rémi
 */
public abstract class Commande {
	protected Cellule cell;

	public abstract void executer();
}
