/**
 * Cette interface définit les méthodes que toutes les capacités spéciales doivent implémenter.
 */
public interface CapaciteSpeciale {
    boolean CSOneShot();
    boolean CSMatrix();
    boolean CSHeal();

    void useCSHeal();
    void useCSOneShot();
    void useCSMatrix();
}
