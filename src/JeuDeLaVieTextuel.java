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
public class JeuDeLaVieTextuel implements Observateur {
	private JeuDeLaVie jeu;
  private int numGeneration;

	public JeuDeLaVieTextuel(JeuDeLaVie jeu) {
		this.jeu = jeu;
		this.jeu.ajouterObservateur(this);
    this.numGeneration = 0;
	}

	public void actualiserVue() {
      ++this.numGeneration;
      System.out.println("Génération n°" + this.numGeneration + ", " + this.jeu.nombreCellulesVivantes() + " cellules vivantes !");
	}
}
