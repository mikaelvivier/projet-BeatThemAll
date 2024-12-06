import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;
import java.util.Random;

/**
 * Cette classe contient les méthodes liés à la logique métier des affrontements entre le héro et les ennemis.
 */
@Data
@AllArgsConstructor
public class Attaque implements CapaciteSpeciale{
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
            int nbAttaques = random.nextInt(5) + 1;
            System.out.println(personnage.getNom() + " attaque " + nbAttaques + " fois l'ennemi " + ennemi.getNom() + " ce qui fait une force d'attaque de " + personnage.getForceAttaque() * nbAttaques + " ! ");

            ennemi.setPv(ennemi.getPv() - nbAttaques * personnage.getForceAttaque());
            System.out.println(ennemi.getNom() + " a " + ennemi.getPv() + " PV ");
        }

    public void ennemiAttaque() {
             System.out.println(ennemi.getNom() + " attaque " + personnage.getNom() + ", avec une force de " + ennemi.getForceAttaque() + "! ");
             personnage.setPv(personnage.getPv() - ennemi.getForceAttaque());
             System.out.println(personnage.getNom() + " a " + personnage.getPv() + " PV ");
    }

    public boolean ennemiVaincu(){
        return ennemi.getPv() <= 0;
    }

    //Interfaces Capacités spéciales
    public boolean CSHeal(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Heal") && jeu.isUtiliseCapacite();
    }

    public boolean CSMatrix(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Matrix") && jeu.isUtiliseCapacite();
    }

    public boolean CSOneShot(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "OneShot") && jeu.isUtiliseCapacite();
    }

    public boolean CSGantelets(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Gantelets") && jeu.isUtiliseCapacite();
    }

    public void useCSHeal(){

        personnage.setPv(personnage.getPv() + 20);
        System.out.println(personnage.getNom() + " se heal et a désormais " + personnage.getPv() + " PV");
        jeu.setUtiliseCapacite(false);

    }

    public void useCSOneShot() {

            System.out.println(personnage.getNom() + " utilise son coup spéciale One Shot et tue " + ennemi.getNom() + " ! ");
            ennemi.setPv(0);
            jeu.setUtiliseCapacite(false);

    }

    public void useCSMatrix() {
            System.out.println(personnage.getNom() + " utilise son coup spéciale Matrix et esquive les coups de " + ennemi.getNom() + " ! ");
            jeu.setTourCapacite(jeu.getTourCapacite() + 1);
            if (jeu.getTourCapacite() >= 2) {
                jeu.setUtiliseCapacite(false); // Désactiver la capacité après 2 tours

        }
    }

    public void useCSGantelets() {

            System.out.println(personnage.getNom() + " utilise son coup spéciale et gagne des gantelets qui lui font gagner +20% d'attaque ! ");
            personnage.setForceAttaque(personnage.getForceAttaque() + 2);
            jeu.setUtiliseCapacite(false);

    }

    @Override
    public String toString() {
        return "Attaque{" +
                "personnage=" + personnage.getNom() +
                '}';
    }

}