import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
import java.util.Random;
@Data
@AllArgsConstructor
public class Attaque {
    private Random random;
    private Jeu jeu;

    public void personnageAttaque(Personnage personnage, Ennemi ennemi) {
        //cas où la capacité spaciale Heal est activée
        if (Objects.equals(personnage.getCapaciteSpeciale(), "Heal") && jeu.isUtiliseCapacite()) {
            System.out.println(personnage.getNom()+ " se heal");
            personnage.setPv(personnage.getPv() + 20);
        }
        int nbAttaques = random.nextInt(5) + 1;
        for (int i = 0; i < nbAttaques; i++) {
            System.out.println(personnage.getNom() + " attaque " + ennemi.getNom());
            ennemi.setPv(ennemi.getPv() - personnage.getForceAttaque());
            if (ennemi.getPv() <= 0) {
                System.out.println("L'ennemi a été vaincu");
                return;
            }
        }
    }

    public void ennemiAttaque(Personnage personnage, Ennemi ennemi) {
        //cas où la capacité spécial Matrix est activée
        if (Objects.equals(personnage.getCapaciteSpeciale(), "Matrix") && jeu.isUtiliseCapacite()) {
            System.out.println(personnage.getNom() + " utilise son coup spéciale Matrix et esquive les coups");
            jeu.setTourCapacite(jeu.getTourCapacite() + 1);

            // Désactiver la capacité après 2 tours
            if (jeu.getTourCapacite() >= 2) {
                jeu.setUtiliseCapacite(false);
            }
        }
        else {
            personnage.setPv(personnage.getPv() - ennemi.getForceAttaque());
        }
    }

        public void combattre (Personnage personnage, Ennemi ennemi){
            if (Objects.equals(ennemi.getNom(), "Gangster")) {
                ennemiAttaque(personnage, ennemi);
                personnageAttaque(personnage, ennemi);
            } else {
                personnageAttaque(personnage, ennemi);
                ennemiAttaque(personnage, ennemi);
            }
        }
    }

