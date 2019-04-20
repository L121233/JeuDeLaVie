import java.awt.*;
import java.awt.event.*;

import java.util.concurrent.TimeUnit;
/**
 * Classe "JeuDeLaVieUI", qui implémente l'interface "Observateur". Son rôle est
 * de générer une interface graphique qui représentera chaque génération de cellules
 * créées et leur évolution.
 * L'utilisation de la classe "Frame" est obligatoire pour réaliser cette tâche.
 *
 * @author KAJAK Rémi
 */
public class JeuDeLaVieUI extends Canvas implements Observateur {
	private Frame fenetre;
	private JeuDeLaVie jeu;

	/**
	 * Constructeur par défaut de la classe courante. Fermer l'observateur graphique
	 * pendant son exécution permet d'interrompre le programme.
	 *
	 * @param	jeu	Une instance de la classe "JeuDeLaVie".
	 */
	public JeuDeLaVieUI(JeuDeLaVie jeu) {
		this.fenetre = (jeu.getVisiteur() instanceof VisiteurClassique) ? new Frame("Classique") : new Frame("Plus");
		this.fenetre.setSize(150,150);
		this.fenetre.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.jeu = jeu;
		this.jeu.ajouterObservateur(this);
	}

	/**
	 * Cette fonction permet d'afficher la population de cellules dans la fenêtre
	 * définie lors de l'instanciation de l'objet courant. La vue s'actualise toutes
	 * les secondes à partir du moment où elle est appelée.
	 */
	public void actualiserVue() {
		try {
			this.fenetre.add(this);
			TimeUnit.SECONDS.sleep(1);
			this.fenetre.setVisible(true);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Cette fonction permet de représenter les cellules vivantes dans la fenêtre
	 * d'affichage sous forme de ronds noirs. Son appel est géré automatiquement
	 * par la classe "Frame".
	 */
	public void paint(Graphics g) {
		for(int i = 0; i < jeu.getXMax(); i++)
			for(int j = 0; j < jeu.getYMax(); j++)
				if(jeu.getGrilleXY(i, j).estVivante())
					g.fillOval(i * 20, j * 20, 15, 15);
	}
}
