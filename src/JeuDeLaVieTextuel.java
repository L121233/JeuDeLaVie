/**
 * Classe "JeuDeLaVieTextuel", qui implémente l'interface "Observateur".
 *
 * @author KAJAK Rémi
 */
public class JeuDeLaVieTextuel implements Observateur {
	private JeuDeLaVie jeu;
  private int numGeneration;

	/**
	 * Constructeur par défaut de la classe courante.
	 *
	 * @param	jeu	Une instance de la classe "JeuDeLaVie".
	 */
	public JeuDeLaVieTextuel(JeuDeLaVie jeu) {
		this.jeu = jeu;
		this.jeu.ajouterObservateur(this);
    this.numGeneration = 0;
	}

	/**
	 * Cette fonction permet d'incrémenter la valeur de l'entier affilié à l'objet instancié,
	 * ainsi que d'afficher les informations de la génération de cellules courantes sous forme
	 * textuelle, directement dans le terminal de contrôle.
	 */
	public void actualiserVue() {
      ++this.numGeneration;
      System.out.println("Génération n°" + this.numGeneration + ", " + this.jeu.nombreCellulesVivantes() + " cellules vivantes !");
	}
}
