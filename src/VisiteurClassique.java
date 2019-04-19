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
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(cell.estVivante() && nbVV < 2 || nbVV > 3)
			this.jeu.ajouterCommande(new CommandeMeurt(cell));
	}

	@Override
	public void visiteCelluleMorte(Cellule cell) {
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(!cell.estVivante() && nbVV == 3)
			this.jeu.ajouterCommande(new CommandeVit(cell));
	}
}
