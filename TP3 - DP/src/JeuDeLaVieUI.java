import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

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
@SuppressWarnings("serial")
public class JeuDeLaVieUI extends Canvas implements Observateur {
	private JFrame fenetre;
	private JeuDeLaVie jeu;
	
	public JeuDeLaVieUI(JeuDeLaVie j) {
		fenetre = new JFrame();
		fenetre.setSize(150,150);
		jeu = j;
	}
	
	public void actualiserVue() {
		try {
			fenetre.add(this);
			TimeUnit.SECONDS.sleep(1);
			fenetre.setVisible(true);
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {
		for(int i = 0; i < jeu.getXMax(); i++)
			for(int j = 0; j < jeu.getYMax(); j++)
				if(jeu.getGrilleXY(i, j).estVivante())
					g.fillOval(i * 20, j * 20, 15, 15);
	}
}
