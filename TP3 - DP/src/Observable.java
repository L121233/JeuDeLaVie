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
	public void attacheObservateur(Observateur o);
	public void detacheObservateur(Observateur o);
	public void notifieObservateur();
}
