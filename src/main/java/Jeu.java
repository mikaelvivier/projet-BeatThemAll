import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.logging.Logger;

/**
 *  *  Utilisation des annotations Lombok :
 *
 *  * - @Data : Génère automatiquement les méthodes getter, setter,
 *  *   toString, equals, et hashCode pour tous les champs de la classe.
 *  *
 *  * - @AllArgsConstructor : Crée un constructeur qui prend un argument
 *  *   pour chaque champ de la classe, permettant une initialisation complète.
 *  *
 *  * Ces annotations simplifient le code en réduisant le besoin
 *  * d'écrire manuellement des méthodes répétitives, améliorant ainsi
 *  * la lisibilité et la maintenabilité du code.
 *  */

@Data
@AllArgsConstructor
/**
 * Cette classe contient les méthodes liés au déroulement principal du jeu.
 */
public class Jeu {
    /**
     * Référence à la classe Carte, représentant la carte du jeu.
     */
    private Carte carte;

    /**
     * Position actuelle du personnage sur la carte.
     */
    private int positionPerso;

    /**
     * Longueur totale de la carte.
     */
    private int totalDeplacements;

    /**
     * Générateur de nombres aléatoires pour la rencontre d'ennemi et le coup spécial.
     */
    private Random random;

    /**
     * Indice du déplacement spécial, déterminé aléatoirement.
     */
    private int deplacementSpecial;

    /**
     * Indique si la capacité spéciale a été utilisée.
     */
    private boolean utiliseCapacite;

    /**
     * Référence au personnage.
     */
    private Personnage personnage;

    /**
     * Référence à l'objet Attaque.
     */
    private Attaque attaque;
    /**
     * Compteur pour la capacité spéciale Matrix qui dure 2 tours.
     */
    private int tourCapacite = 0;
    /**
     * Référence à l'objet ennemi.
     */
    private Ennemi ennemi;

    Logger logger = Logger.getLogger("logger.Main");

    /**
     * @param carte      Réfère à la classe Carte
     * @param personnage Réfère à la classe Personnage
     * @param attaque    Réfère à la classe Attaque
     */
    public Jeu(Carte carte, Personnage personnage, Attaque attaque) {
        this.carte = carte;
        this.positionPerso = carte.getDebut();
        this.totalDeplacements = carte.getLongueur();
        this.random = new Random();
        this.deplacementSpecial = random.nextInt(totalDeplacements); //deplacementSpecial s'activera aléatoirement lors d'un déplacement en fonction de la longueur de la carte.
        this.utiliseCapacite = false;
        this.personnage = personnage;
        this.attaque = attaque;
    }

    /**
     * // Donne les caractéristiques du personnage et de la carte.
     */
    public void demarrerLeJeu() {
        System.out.println("Ce jeu vidéoludique vous est proposé par VIVIER Mikaël et PIOCHE-THIROUX Maël\n" + "Amusez vous bien :-)");
        System.out.println("Votre personnage " + personnage.getNom() + " possède ces caractéristiques :");
        System.out.println("Points de vie : " + personnage.getPv());
        System.out.println("Force d'attaque : " + personnage.getForceAttaque());
        System.out.println("Capacité spéciale : " + personnage.getCapaciteSpeciale());
        System.out.println("Vous vous trouvez sur le lieu " + carte.getNom() + " à " + carte.getLieu());
        System.out.println("Longueur de la carte : " + carte.getLongueur());
        logger.info("Le jeu a démarré + demande infos user");
    }

    /**
     * Donne les informations sur la position et la vie du personnage à chaque ROUND.
     */
    public void deplacer() {

        try {
                Thread.sleep(7000);  //Permet une attente entre chaque déplacement. L'enlever si génant.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            positionPerso += 1;
            System.out.println("\n");
            System.out.println("ROUND " + positionPerso + " SUR " + totalDeplacements + " !! ");
            System.out.println(personnage.getNom() + " a " + personnage.getPv() + "PV");
            logger.info("Le personnage a " + personnage.getPv() + "PV");
    }

    /**
     * Vérifie si le personnage a atteint la fin de la carte.
     *
     * @return true si le personnage a gagné en atteignant la position finale de la carte, false sinon.
     */
    public boolean aGagne() {
        return positionPerso == carte.getFin();
    }

    /**
     * Vérifie si le personnage a perdu la partie.
     *
     * @return true si les points de vie du personnage sont inférieurs ou égaux à zéro, false sinon.
     */
    public boolean aPerdu() {
        return (personnage.getPv() <= 0);
    }

    /**
     * Affiche un message indiquant que le joueur a gagné la partie.
     *
     */
    public void victoire(){
        System.out.println("Vous avez gagné! vous avez passé tous les niveaux. \n");
        logger.info("Le joueur a gagné");
    }

    /**
     * Affiche un message indiquant que le joueur a perdu la partie.
     *
     */
    public void defaite(){
        System.out.println("Vous avez perdu, vous n'avez plus de PV \n");
        logger.info("Le joueur a perdu");
    }

    /**
     * Génère un ennemi au hasard avec Random et indique ses caractéristiques dans le terminal.
     * @return l'objet ennemi
     */
    public Ennemi rencontrerEnnemi() {
        int rand = random.nextInt(4) + 1;
        Ennemi ennemi = switch (rand) {
            case 1 -> new Brigand();
            case 2 -> new Catcheur();
            case 3 -> new Gangster();
            case 4 -> new Kamikaze();
            default -> null;
        };
        System.out.println("Vous rencontrez un " + ennemi.getNom() + " avec " + ennemi.getPv() + " PV" + " et " + ennemi.getForceAttaque() + " de force d'attaque");
        logger.info("Le joueur rencontre un ennemi");
        return ennemi;
    }


    /**
     * Si la position du personnage est égale à l'indice du déplacement spécial, déterminé aléatoirement, utiliseCapacite est vrai.
     */
    public void coupSpecial() {
        if (positionPerso == deplacementSpecial) {
            System.out.println("La capacité spéciale s'active !");
            logger.info("La capacité spéciale s'active");
            utiliseCapacite = true;
        }

    }


    public String toString() {
        return "Jeu{" +
                "attaque=" + (attaque != null ? attaque.toString() : "null") +
                ", personnage=" + personnage.getNom() +
                ", carte=" + carte.getNom() +
                '}';
    }
}

