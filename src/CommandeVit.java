/**
 *
 *
 * @author KAJAK Rémi
 *
 * @version 0.1
 */

/**
 * 
 */
public class CommandeVit extends Commande {
	public CommandeVit(Cellule c) {
		this.cell = c; 
	}
	
	@Override
	public void executer() {
		this.cell.vit();
	}
}
