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
public abstract class Visiteur {
	protected JeuDeLaVie jeu;
	
	public Visiteur(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}
	
	public abstract void visiteCelluleVivante(Cellule cell);
	public abstract void visiteCelluleMorte(Cellule cell);
}
