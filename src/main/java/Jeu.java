import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

/**
 * Cette classe contient les méthodes liés au déroulement principal du jeu.
 */
@Data
@AllArgsConstructor

public class Jeu {
    /** Référence à la classe Carte, représentant la carte du jeu. */
    private Carte carte;

    /** Position actuelle du personnage sur la carte. */
    private int positionPerso;

    /** Longueur totale de la carte. */
    private int totalDeplacements;

    /** Générateur de nombres aléatoires pour la rencontre d'ennemi et le coup spécial.  */
    private Random random;

    /** Indice du déplacement spécial, déterminé aléatoirement. */
    private int deplacementSpecial;

    /** Indique si la capacité spéciale a été utilisée. */
    private boolean utiliseCapacite;

    /** Référence au personnage. */
    private Personnage personnage;

    /** Référence à l'objet Attaque. */
    private Attaque attaque;
    private int tourCapacite = 0;
    private Ennemi ennemi;

    /**
     *
     * @param carte Réfère à la classe Carte
     * @param personnage Réfère à la classe Personnage
     * @param attaque Réfère à la classe Attaque
     */
    public Jeu(Carte carte, Personnage personnage, Attaque attaque) {
        this.carte=carte;
        this.positionPerso= carte.getDebut();
        this.totalDeplacements= carte.getLongueur();
        this.random=new Random();
        this.deplacementSpecial=random.nextInt(totalDeplacements-1); //deplacementSpecial s'activera aléatoirement lors d'un déplacement en fonction de la longueur de la carte.
        this.utiliseCapacite =false;
        this.personnage=personnage;
        this.attaque=attaque;
    }

    /**
     * // Donne les caractéristiques du personnage et de la carte.
     * Appelle la méthode déplacer().
     */
    public void demarrerLeJeu(){
        System.out.println("Ce jeu vidéoludique vous est proposé par VIVIER Mikaël et PIOCHE-THIROUX Maël\n" + "Amusez vous bien :-)");
        System.out.println("Votre personnage " + personnage.getNom() + " possède ces caractéristiques :");
        System.out.println("Points de vie : " + personnage.getPv());
        System.out.println("Force d'attaque : " + personnage.getForceAttaque());
        System.out.println("Capacité spéciale : " + personnage.getCapaciteSpeciale());
        System.out.println("Vous vous trouvez sur le lieu " + carte.getNom() + " à " + carte.getLieu());
        System.out.println("Longueur de la carte : " + carte.getLongueur());
        deplacer();
    }

    /**
     * Déplace le personnage tant que le jeu n'est pas fini.
     * Donne les informations sur la position et la vie du personnage à chaque ROUND. Arrête le programme si le Héros a gagné.
     * Appelle la méthode rencontre().
     */
    public void deplacer() {
        while (!aGagne()) {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            positionPerso += 1;
            System.out.println("\n");
            System.out.println("ROUND " + positionPerso + " SUR " + totalDeplacements + " !! ");
            System.out.println(personnage.getNom() + " a " + personnage.getPv() +"PV");
            //vérification aléatoire pour le coup spécial
            rencontre();
        }

        System.out.println("Vous avez gagné! vous avez passé tous les niveaux. ");
        System.exit(0);
    }

    /**
     *  Récupère un ennemi aléatoire à chaque rencontre avec la méthode rencontrerEnnemi().
     *  Active le coup spécial si l'attribut entier aléatoire est égal à la position du personnage.
     */
    public void rencontre(){
        Ennemi nouvelEnnemi=rencontrerEnnemi();
        attaque.setEnnemi(nouvelEnnemi);
        if (positionPerso==deplacementSpecial){
            coupSpecial();
        }
        attaque.combattre();
        }


    private boolean aGagne(){
        return positionPerso>=carte.getFin();
    }

    public boolean aPerdu(){
        return(personnage.getPv()<0);
    }


    public Ennemi rencontrerEnnemi() {
        int rand = random.nextInt(4) + 1;
        Ennemi ennemi = null;
        switch (rand) {
            case 1:
                ennemi = new Brigand();
                break;
            case 2:
                ennemi = new Catcheur();
                break;
            case 3:
                ennemi = new Gangster();
                break;
            case 4:
                ennemi= new Kamikaze();
                break;
        }
        System.out.println("Vous rencontrez un " + ennemi.getNom() + " avec "+ ennemi.getPv()+ " PV" + " et " + ennemi.getForceAttaque() + " de force d'attaque");
        return ennemi;
    }

    private void coupSpecial(){
        System.out.println("La capacité spéciale s'active !");
        utiliseCapacite =true;
    }

}

