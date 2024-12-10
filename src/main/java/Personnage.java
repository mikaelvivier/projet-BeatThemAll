import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilisation des annotations Lombok (voir explications dans la class Jeu).
 */

@Data
@AllArgsConstructor
/**
 * Classe représentant le Personnage.
 */
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    /**
     * Indique la capacité spéciale du personnage.
     */
    private String capaciteSpeciale;

    private Logger logger = Logger.getLogger("logger.Main");

    public Personnage(String nom, int pv, int forceAttaque, String capaciteSpeciale){
        this.nom = nom;
        this.pv = pv;
        setForceAttaque(forceAttaque);
        setCapaciteSpeciale(capaciteSpeciale);
    }

    /**
     * Renvoie une exception si la force d'attaque est inférieure à 0.
     * @param forceAttaque
     */
    public void setForceAttaque(int forceAttaque){
        if(forceAttaque < 0){
            logger.log(Level.SEVERE, "Tentative de définir la force d'attaque à une valeur négative: " + forceAttaque);
            throw new IllegalArgumentException("La force d'attaque du personnage ne peut pas être nulle ou négative");
        }
        else if (forceAttaque < 10) {
            logger.log(Level.WARNING, "Force d'attaque basse définie pour " + nom + ": " + forceAttaque);
        }
        this.forceAttaque = forceAttaque;
    }

    /**
     *  Renvoie une exception si la capacite speciale n'est pas dans la liste de capacités spéciales.
     * @param capaciteSpeciale
     */
    public void setCapaciteSpeciale(String capaciteSpeciale){
        ArrayList<String> capaciteSpeciales = new ArrayList<>();
        capaciteSpeciales.add("Heal");
        capaciteSpeciales.add("Matrix");
        capaciteSpeciales.add("OneShot");
        capaciteSpeciales.add("Gantelets");
        if (!capaciteSpeciales.contains(capaciteSpeciale)){
            logger.log(Level.SEVERE, "Tentative de définir une capacité spéciale invalide: " + capaciteSpeciale);
            throw new IllegalArgumentException("La capacité spéciale n'existe pas");
        }
        this.capaciteSpeciale = capaciteSpeciale;
    }

}






