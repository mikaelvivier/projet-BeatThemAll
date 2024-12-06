import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * Cette classe contient les méthodes liés au déroulement principal du jeu.
 */
@Data
@AllArgsConstructor

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
    private int tourCapacite = 0;
    private Ennemi ennemi;

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
     * Appelle la méthode déplacer().
     */
    public void demarrerLeJeu() {
        System.out.println("Ce jeu vidéoludique vous est proposé par VIVIER Mikaël et PIOCHE-THIROUX Maël\n" + "Amusez vous bien :-)");
        System.out.println("Votre personnage " + personnage.getNom() + " possède ces caractéristiques :");
        System.out.println("Points de vie : " + personnage.getPv());
        System.out.println("Force d'attaque : " + personnage.getForceAttaque());
        System.out.println("Capacité spéciale : " + personnage.getCapaciteSpeciale());
        System.out.println("Vous vous trouvez sur le lieu " + carte.getNom() + " à " + carte.getLieu());
        System.out.println("Longueur de la carte : " + carte.getLongueur());
        Logging.logger.info("Le jeu a démarré + demande infos user");
    }

    /**
     * Déplace le personnage tant que le jeu n'est pas fini.
     * Donne les informations sur la position et la vie du personnage à chaque ROUND. Arrête le programme si le Héros a gagné.
     * Appelle la méthode rencontre().
     */
    public void deplacer() {
        /*
        try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        */

            positionPerso += 1;
            System.out.println("\n");
            System.out.println("ROUND " + positionPerso + " SUR " + totalDeplacements + " !! ");
            System.out.println(personnage.getNom() + " a " + personnage.getPv() + "PV");
            Logging.logger.info("Le personnage a " + personnage.getPv() + "PV");
    }

    /**
     * Récupère un ennemi aléatoire à chaque rencontre avec la méthode rencontrerEnnemi().
     * Active le coup spécial si l'attribut entier aléatoire est égal à la position du personnage.
     */




    public boolean aGagne() {
        return positionPerso == carte.getFin();
    }

    public boolean aPerdu() {
        return (personnage.getPv() <= 0);
    }

    public void victoire(){
        System.out.println("Vous avez gagné! vous avez passé tous les niveaux. \n");
        Logging.logger.info("Le joueur a gagné");
    }
    public void defaite(){
        System.out.println("Vous avez perdu, vous n'avez plus de PV \n");
        Logging.logger.info("Le joueur a perdu");
    }


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
        Logging.logger.info("Le joueur rencontre un ennemi");
        return ennemi;
    }


    public void coupSpecial() {
        if (positionPerso == deplacementSpecial) {
            System.out.println("La capacité spéciale s'active !");
            Logging.logger.info("La capacité spéciale s'active");
            utiliseCapacite = true;
        }

    }

    @Override
    public String toString() {
        return "Jeu{" +
                "attaque=" + (attaque != null ? attaque.toString() : "null") +
                ", personnage=" + personnage.getNom() +
                ", carte=" + carte.getNom() +
                '}';
    }
}

