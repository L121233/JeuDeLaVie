/**
 * Classe "Singleton", qui permet d'implémenter le Design Pattern éponyme.
 *
 * @author KAJAK Rémi
 */
public class Singleton {
  /**
   * Constructeur par défaut de la fonction rendu privé pour empêcher toute instanciation
   * à partir de la classe "Singleton".
   */
  private Singleton() {}

  /**
   * Classe statique "SingletonHolder" interne à la classe courante.
	 * Son rôle est de fournir une instance personnalisée pour la classe extérieure qui lui fera appel.
	 */
  private static class SingletonHolder {
      private final static Singleton INSTANCE = new Singleton();
  }

  /**
   * Point d'accès pour l'instance unique du Singleton.
	 *
	 * @return	Un objet qui contiendra l'instance d'une classe extérieure.
   */
  public static Singleton getInstance() {
      return SingletonHolder.INSTANCE;
  }
}
