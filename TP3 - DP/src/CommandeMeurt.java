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
public class CommandeMeurt extends Commande {
	public CommandeMeurt(Cellule c) {
		this.cell = c; 
	}
	
	@Override
	public void executer() {
		this.cell.meurt();
	}
}
