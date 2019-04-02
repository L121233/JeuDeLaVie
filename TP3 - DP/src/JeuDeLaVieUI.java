import java.awt.Graphics;

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
public class JeuDeLaVieUI implements Observateur {
	JeuDeLaVie jeu;
	
	public JeuDeLaVieUI() {
		//paint();
	}
	
	public void actualise() {
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		for(int i = 0; i < jeu.getXMax(); i++)
			for(int j = 0; j < jeu.getYMax(); j++)
				if(jeu.getGrilleXY(i, j).estVivante())
					g.fillOval(i * 3, j * 3, 3, 3);
	}
}
