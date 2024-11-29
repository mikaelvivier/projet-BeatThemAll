import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
import java.util.Random;
@Data
@AllArgsConstructor
public class Attaque {
    private Random random;
    private Jeu jeu;
    Personnage personnage;
    Ennemi ennemi;
    public Attaque(Jeu jeu,Personnage personnage){
        random=new Random();
        this.jeu=jeu;
        this.personnage=personnage;
    }


    public void personnageAttaque() {
        //cas où la capacité spaciale Heal est activée
        if (Objects.equals(personnage.getCapaciteSpeciale(), "Heal") && jeu.isUtiliseCapacite()) {
            System.out.println(personnage.getNom()+ " se heal");
            personnage.setPv(personnage.getPv() + 20);
        }
        int nbAttaques = random.nextInt(5) + 1;
        System.out.println(personnage.getNom() + " attaque " + nbAttaques + " fois l'ennemi " + ennemi.getNom());

            ennemi.setPv(ennemi.getPv() - nbAttaques* personnage.getForceAttaque());
            if (ennemi.getPv() <= 0) {
                System.out.println("L'ennemi a été vaincu");
                return;
            }
    }


    public void ennemiAttaque() {
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
        if(jeu.aPerdu()){
            System.out.println("Vous avez perdu, vous n'avez plus de PV");
            System.exit(0); //termine le programme
        }
    }

        public void combattre (){
            if (Objects.equals(ennemi.getNom(), "Gangster")) {
                ennemiAttaque();
                personnageAttaque();
            } else {
                personnageAttaque();
                ennemiAttaque();
            }
        }
    }

