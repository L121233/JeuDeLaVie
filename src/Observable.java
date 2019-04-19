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
public interface Observable {
	public void ajouterObservateur(Observateur o);
	public void supprimerObservateur(Observateur o);
	public void notifierObservateur();
}
