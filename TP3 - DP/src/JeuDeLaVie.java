import java.lang.Math;
import java.util.LinkedList;
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
public class JeuDeLaVie implements Observable {
    private Cellule[][] grille;
    private LinkedList<Observateur> observateurs;
    private int xMax = 5, yMax = xMax;

    public JeuDeLaVie() {
      this.grille = new Cellule[xMax][yMax];
      this.initialiseGrille();
    }
    
    public int getXMax() {
    	return this.xMax;
    }
    
    public int getYMax() {
    	return this.yMax;
    }

    public void initialiseGrille() {
    	for(int i = 0; i < xMax; i++)
	        for(int j = 0; j < yMax; j++)
	        	this.grille[i][j] = (Math.random() <= 0.5)? new Cellule(i,j,new CelluleEtatVivant()) : new Cellule(i,j,new CelluleEtatMort());
    }
    
    public Cellule getGrilleXY(int x, int y) {
    	return this.grille[x][y];
    }
    
    public void attacheObservateur(Observateur o) {
    	this.observateurs.add(o);
    }
    
    public void detacheObservateur(Observateur o) {
    	this.observateurs.remove(o);
    }
    
    public void notifieObservateur() {
    	for(Observateur obs : observateurs)
    		obs.actualise();
    }
    
    /*public String toString() {
    	String phrase = "";
    	
    	for(int i = 0; i < xMax; i++) {
	        for(int j = 0; j < yMax; j++) {
	        	phrase += (this.getGrilleXY(i,j).estVivante()) ? "O |" : "X |";
	        }
	        phrase += "\n";
    	}
    	return phrase;
    } //*/

    public static void main(String[] args) {
    	int i = 2;
		JeuDeLaVie jeu = new JeuDeLaVie();
    	Cellule selection = jeu.getGrilleXY(i,i);

    	System.out.println(jeu);
    	System.out.println("Nombre de cellules voisines vivantes pour la cellule["+i+"]["+i+"] : " + selection.nombreVoisinesVivantes(jeu));
    } //*/
}
