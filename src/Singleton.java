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
public class Singleton {
  /** Constructeur privé */
  private Singleton() {}

  /** Holder */
  private static class SingletonHolder {
      private final static Singleton INSTANCE = new Singleton();
  }

  /** Point d'accès pour l'instance unique du singleton */
  public static Singleton getInstance() {
      return SingletonHolder.INSTANCE;
  }
}
