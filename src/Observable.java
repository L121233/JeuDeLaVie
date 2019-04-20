/**
 * Interface "Observable", qui permet d'implémenter le Design Pattern "Observateur".
 * Elle définit trois prototypes de fonctions qui vont compléter la fonction "actualiserVue"
 * de l'interface "Observateur". 
 *
 * @author KAJAK Rémi
 */
public interface Observable {
	public void ajouterObservateur(Observateur o);
	public void supprimerObservateur(Observateur o);
	public void notifierObservateur();
}
