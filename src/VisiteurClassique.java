/**
 * Classe "VisiteurClassique", qui hérite de la classe abstraite "Visiteur".
 *
 * @author KAJAK Rémi
 */
public class VisiteurClassique extends Visiteur {
	/**
	 * Constructeur par défaut de la classe courante. On fait remonter son paramètre
	 * au constructeur de la classe mère grâce à la fonction "super".
	 *
	 * @param	jeu	Une instance de la classe "JeuDeLaVie".
	 */
	public VisiteurClassique(JeuDeLaVie jeu) {
		super(jeu);
	}

	/**
	 * Cette fonction permet de déterminer les règles du passage de la cellule de
	 * vivante à morte. Si les conditions sont remplies, la commande correspondante
	 * est ajoutée à la liste de commande de la variable de la classe "JeuDeLaVie"
	 * connue par l'objet courant.
 	 *
 	 * @param	cell	Une instance de la classe "Cellule".
	 */
	@Override
	public void visiteCelluleVivante(Cellule cell) {
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(cell.estVivante() && nbVV < 2 || nbVV > 3)
			this.jeu.ajouterCommande(new CommandeMeurt(cell));
	}

	/**
	 * Cette fonction permet de déterminer les règles du passage de la cellule de
	 * morte à vivante. Si les conditions sont remplies, la commande correspondante
	 * est ajoutée à la liste de commande de la variable de la classe "JeuDeLaVie"
	 * connue par l'objet courant.
 	 *
 	 * @param	cell	Une instance de la classe "Cellule".
	 */
	@Override
	public void visiteCelluleMorte(Cellule cell) {
		int nbVV = cell.nombreVoisinesVivantes(this.jeu);

		if(!cell.estVivante() && nbVV == 3)
			this.jeu.ajouterCommande(new CommandeVit(cell));
	}
}
