import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Utilisation des annotations Lombok (voir explications dans la class Jeu).
 */
@Data
@AllArgsConstructor
/**
 * Cette classe contient les méthodes liés à la logique métier des affrontements entre le héro et les ennemis.
 */
public class Attaque implements CapaciteSpeciale{
    /**
     * Générateur de nombre aléatoires pour le nombre de coup du personnage.
     */
    private Random random;
    /**
     * Référence à l'objet Jeu.
     */
    private Jeu jeu;
    /**
     * Référence à l'objet Personnage.
     */
    Personnage personnage;
    /**
     * Référence à l'objet Ennemi.
     */
    Ennemi ennemi;

    Logger logger = Logger.getLogger("logger.Main");

    /**
     * Liste pour stocker les dégâts infligés par le personnage
     */
    private List<Integer> listeDegatsInfligesPersonnages = new ArrayList<>();

    private List<Integer> listeDegatsInfligesEnnemi = new ArrayList<>();

    /**
     *
     * @param jeu réfère à la class Jeu
     * @param personnage réfère à la classe Personnage
     */
    public Attaque(Jeu jeu,Personnage personnage){
        this.random=new Random();
        this.jeu=jeu;
        this.personnage=personnage;
    }

    /**
     * Le personage attaque un nombre de fois aléatoire entre 1 et 5.
     * Les PV de l'ennemi diminuent
     * Si l'ennemi est vaincu, l'afficher
     */
    public void personnageAttaque() {
            int nbAttaques = random.nextInt(5) + 1;
            System.out.println(personnage.getNom() + " attaque " + nbAttaques + " fois l'ennemi " + ennemi.getNom() + " ce qui fait une force d'attaque de " + personnage.getForceAttaque() * nbAttaques + " ! ");
            logger.info("Attaque de " + personnage.getNom() + " sur " + ennemi.getNom());
            ennemi.setPv(ennemi.getPv() - nbAttaques * personnage.getForceAttaque());
            System.out.println(ennemi.getNom() + " a " + ennemi.getPv() + " PV ");
            logger.info("PV de " + ennemi.getNom() + " après");
            listeDegatsInfligesPersonnages.add(nbAttaques * personnage.getForceAttaque()); //ajoute les dégats infligés à la liste.
            if (ennemiVaincu()) {
                System.out.println("L'ennemi a été vaincu");
            }
        }

    /**
     * L'ennemi attaque et les PV du personnage diminuent.
     */
    public void ennemiAttaque() {
             System.out.println(ennemi.getNom() + " attaque " + personnage.getNom() + ", avec une force de " + ennemi.getForceAttaque() + "! ");
             logger.info("Attaque de " + ennemi.getNom() + " sur " + personnage.getNom());
             personnage.setPv(personnage.getPv() - ennemi.getForceAttaque());
             System.out.println(personnage.getNom() + " a " + personnage.getPv() + " PV ");
             logger.info("PV de " + personnage.getNom() + " après");
             listeDegatsInfligesEnnemi.add(ennemi.getForceAttaque()); // Ajoute les dégats infligés par l'ennemi à la liste.
    }

    /**
     * Vérifie si l'ennemi a été vaincu.
     * @return true si l'ennemi à 0 PV ou moins.
     */
    public boolean ennemiVaincu(){
        return ennemi.getPv() <= 0;
    }

    //Interfaces Capacités spéciales

    /**
     * Vérifie la capacité spéciale
     * @return true si la capacité spéciale est Heal et si la capacite Speciale est active.
     */
    public boolean CSHeal(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Heal") && jeu.isUtiliseCapacite();
    }

    /**
     * Vérifie la capacité spéciale
     * @return true si la capacité spéciale est Matrix et si la capacite Speciale est active.
     */
    public boolean CSMatrix(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Matrix") && jeu.isUtiliseCapacite();
    }

    /**
     * Vérifie la capacité spéciale
     * @return true si la capacité spéciale est One Shot et si la capacite Speciale est active.
     */
    public boolean CSOneShot(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "OneShot") && jeu.isUtiliseCapacite();
    }

    /**
     * Vérifie la capacité spéciale
     * @return true si la capacité spéciale est Gantelets et si la capacite Speciale est active.
     */
    public boolean CSGantelets(){
        return Objects.equals(personnage.getCapaciteSpeciale(), "Gantelets") && jeu.isUtiliseCapacite();
    }

    /**
     * Utilise la capacité spéciale Heal.
     * Augmente les PV du personnage.
     * La capacité spéciale est ensuite désactivée.
     */
    public void useCSHeal(){
        personnage.setPv(personnage.getPv() + 20);
        System.out.println(personnage.getNom() + " se heal et a désormais " + personnage.getPv() + " PV");
        logger.info("Heal de " + personnage.getNom());
        jeu.setUtiliseCapacite(false);
    }

    /**
     * Utilise la capacité spéciale One Shot.
     * Tue directement l'ennemi.
     * La capacité spéciale est ensuite désactivée.
     */
    public void useCSOneShot() {
            System.out.println(personnage.getNom() + " utilise son coup spéciale One Shot et tue " + ennemi.getNom() + " ! ");
            logger.info("OneShot de " + personnage.getNom());
            ennemi.setPv(0);
            jeu.setUtiliseCapacite(false);
    }

    /**
     * Utilise la capacité spéciale Matrix.
     * L'ennemi n'attaque pas le personnage dans le main.
     * Marche pendant 2 tours grâce au compteur.
     * La capacité spéciale est ensuite désactivée.
     */
    public void useCSMatrix() {
            System.out.println(personnage.getNom() + " utilise son coup spéciale Matrix et esquive les coups de " + ennemi.getNom() + " ! ");
            logger.info("Matrix de " + personnage.getNom());
            jeu.setTourCapacite(jeu.getTourCapacite() + 1);
            if (jeu.getTourCapacite() >= 2) {
                jeu.setUtiliseCapacite(false); // Désactiver la capacité après 2 tours
                logger.info("Fin de la capacité Matrix");
        }
    }

    /**
     * Utilise la capacité spéciale Gantelets.
     * Le personnage gagne 20% d'attaque jusqu'à la fin du combat.
     * La capacité spéciale est ensuite désactivée.
     */
    public void useCSGantelets() {

            System.out.println(personnage.getNom() + " utilise son coup spéciale et gagne des gantelets qui lui font gagner +20% d'attaque ! ");
            logger.info("Gantelets de " + personnage.getNom());
            personnage.setForceAttaque(personnage.getForceAttaque() + 2);
            jeu.setUtiliseCapacite(false);

    }

    /**
     * @return le total des dégâts infligés par le personnage
     */
    public int getDegatsTotauxInfligesPersonnage() {
        return listeDegatsInfligesPersonnages.stream()
                .mapToInt(Integer::intValue) // Convertit les Integer en int
                .sum(); // Calcule la somme des dégâts
    }

    /**
     * @return le total des dégâts subis par le personnage
     */
    public int getDegatsTotauxSubis() {
        return listeDegatsInfligesEnnemi.stream()
                .mapToInt(Integer::intValue) // Convertit les Integer en int
                .sum(); // Calcule la somme des dégâts
    }

    @Override
    public String toString() {
        return "Attaque{" +
                "personnage=" + personnage.getNom() +
                '}';
    }

}