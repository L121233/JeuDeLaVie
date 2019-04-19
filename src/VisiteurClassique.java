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
public class VisiteurClassique extends Visiteur {
	public VisiteurClassique(JeuDeLaVie jeu) {
		super(jeu);
	}

	@Override
	public void visiteCelluleVivante(Cellule cell) {
		if(cell.estVivante() && cell.nombreVoisinesVivantes(this.jeu) < 2 || cell.nombreVoisinesVivantes(this.jeu) > 3)
			this.jeu.ajouterCommande(new CommandeMeurt(cell));
	}

	@Override
	public void visiteCelluleMorte(Cellule cell) {
		if(!cell.estVivante() && cell.nombreVoisinesVivantes(this.jeu) == 3)
			this.jeu.ajouterCommande(new CommandeVit(cell));
	}
}