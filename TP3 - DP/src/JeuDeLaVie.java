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
import java.lang.Math;

public class JeuDeLaVie {
    private Cellule[][] grille;
    private int xMax = 20, yMax = xMax;

    public JeuDeLaVie() {
      this.grille = new Cellule[xMax][yMax];
      this.initialiseGrille();
    }

    public void initialiseGrille() {
    	for(int i = 0; i < xMax; i++)
	        for(int j = 0; j < yMax; j++) {
	        	if(Math.random() <= 0.5)
	        		this.grille[i][j].vit();
	        	else
	        		this.grille[i][j].meurt();
	        }
    }

    public static void main(String[] args) {
    	@SuppressWarnings("unused")
		JeuDeLaVie jeu = new JeuDeLaVie();
    }
}
