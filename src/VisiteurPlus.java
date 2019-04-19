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
public class VisiteurPlus extends Visiteur {
	public VisiteurPlus(JeuDeLaVie jeu) {
		super(jeu);
	}

	@Override
	public void visiteCelluleVivante(Cellule cell) {
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(cell.estVivante() && (nbVV < 3 || nbVV > 8 || nbVV == 5))
			this.jeu.ajouterCommande(new CommandeMeurt(cell));
	}

	@Override
	public void visiteCelluleMorte(Cellule cell) {
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(!cell.estVivante() && (nbVV == 3 || nbVV == 6 || nbVV == 7 || nbVV == 8))
			this.jeu.ajouterCommande(new CommandeVit(cell));
	}
}
