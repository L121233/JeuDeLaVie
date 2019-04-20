/**
 * Classe abstraite "Visiteur", qui permet d'implémenter le Design Pattern éponyme.
 * Elle définit une instance protégée de la classe "JeuDeLaVie", un constructeur par
 * défaut et deux prototypes de fonction.
 *
 * @author KAJAK Rémi
 */
public abstract class Visiteur {
	protected JeuDeLaVie jeu;

	/**
	 * Constructeur par défaut de la classe abstraite courante.
	 *
	 * @param	jeu	Une instance de la classe "JeuDeLaVie".
	 */
	public Visiteur(JeuDeLaVie jeu) {
		this.jeu = jeu;
	}

	public abstract void visiteCelluleVivante(Cellule cell);
	public abstract void visiteCelluleMorte(Cellule cell);
}
