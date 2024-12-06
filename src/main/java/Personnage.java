import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    private String capaciteSpeciale;

    public void setForceAttaque(int forceAttaque){
        if(forceAttaque < 0){
            throw new IllegalArgumentException("La force d'attaque du personnage ne peut pas être nulle ou négative");
        }
        this.forceAttaque = forceAttaque;
    }

    public void setCapaciteSpeciale(String capaciteSpeciale){
        ArrayList<String> capaciteSpeciales = new ArrayList<>();
        capaciteSpeciales.add("Heal");
        capaciteSpeciales.add("Matrix");
        capaciteSpeciales.add("OneShot");
        capaciteSpeciales.add("Gantelets");
        if (!capaciteSpeciales.contains(capaciteSpeciale)){
            throw new IllegalArgumentException("La capacité spéciale n'existe pas");
        }
        this.capaciteSpeciale = capaciteSpeciale;
    }

}






