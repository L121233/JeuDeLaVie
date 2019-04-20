/**
 * Classe "CommandeMeurt", qui hérite de la classe abstraite "Commande".
 * Elle détermine les commandes réalisées pour une cellule vouée à mourir.
 *
 * @author KAJAK Rémi
 */
public class CommandeVit extends Commande {
	/**
	 * Cette fonction permet d'attribuer une cellule existante à la variable de type
	 * "Cellule" de la classe mère.
	 *
	 * @param	c	Une instance de la classe "Cellule".
	 */
	public CommandeVit(Cellule c) {
		this.cell = c;
	}

	/**
	 * Cette fonction permet d'exécuter la commande pour la cellule concernée. Ici, il
	 * s'agit de la commande du passage de l'état de la cellule de mort à vivant.
	 */
	@Override
	public void executer() {
		this.cell.vit();
	}
}
