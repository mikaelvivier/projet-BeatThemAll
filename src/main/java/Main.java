import java.io.IOException;
import java.util.logging.*;

//VIVIER Mikaël, PIOCHE-THIROUX Maël FISATI 27
//Ce jeu se déroule dans l'univers de Fallout (franchise de jeu de Bethesda)
//Le joueur incarne un personnage qui doit traverser une carte en affrontant des ennemis.
//Le personnage a des points de vie et une force d'attaque. Il peut utiliser des coups spéciaux.
//Pour consulter les logs, ouvrir le fichier BeatThemAll.log



public class Main {

    public static void main(String[] args) {

        // Charge la configuration de logging
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            // En cas d'erreur, affiche la trace de l'exception.
            e.printStackTrace();
        }

        // Crée un logger nommé "logger.Main" pour enregistrer les messages de log.
        Logger logger = Logger.getLogger("logger.Main");

        // Ajout du FileHandler
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("BeatThemAll.log");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        /**
         * Choisir le jeu à lancer ici :
         */

        jeu1();
        jeu2();
        jeu3();
        jeu4();
    }


    public static void jeu1() {
        /**
         * Jeu 1 : Cooper Howard à Wasteland.
         */
        Personnage personnage = new Personnage("Cooper Howard", 150, 10, "OneShot");
        Carte carte = new Carte("Wasteland", "Nuclear Ruins", 10);
        Jeu jeu = new Jeu(carte, personnage, null);
        Attaque attaque = new Attaque(jeu, personnage);
        jeu.setAttaque(attaque);
        Ennemi ennemi;
        Logger logger = Logger.getLogger("logger.Main");

        //déroulement jeu 1
        /**
         * Démarre le jeu et gère les déplacements, les rencontres d'ennemis et les combats jusqu'à la victoire ou la défaite du personnage.
         */
        jeu.demarrerLeJeu();
        logger.info("Début du jeu 1");
        while (!jeu.aGagne() && !jeu.aPerdu()) { // Tant que le personnage n'a pas atteint la fin de la carte et a ses PV supérieurs à 0.
            jeu.deplacer();
            ennemi = jeu.rencontrerEnnemi();
            attaque.setEnnemi(ennemi); // L'ennemi change à chaque déplacement.
            jeu.coupSpecial(); //vérifie si le coup spécial est activé et l'active si c'est le cas
            //combat:
            while (!attaque.ennemiVaincu() && !jeu.aPerdu()) { //Tant que l'ennemi a ses PV supérieurs à 0 et que le personnage n'a pas perdu.
                gererCombat(attaque, jeu, ennemi); //Le combat démarre. gérerCombat() se trouve en bas du Main.
            }
        }
        if (jeu.aPerdu()) {
            jeu.defaite(); // Affiche le message de défaite.
        } else {
            jeu.victoire(); // Affiche le message de victoire.
        }
        recap(attaque, personnage); //Récapitulatif des dégats infligés et subis
        System.out.println("\n");
        logger.info("Fin du jeu 1");
    }

    public static void jeu2() {
        /**
         * Jeu 2 : Rogue Survivor dans les ruines.
         */
        Personnage personnage2 = new Personnage("Rogue Survivor", 120, 20, "Matrix");
        Carte carte2 = new Carte("Ruins", "Tech Lab", 15);
        Jeu jeu2 = new Jeu(carte2, personnage2, null);
        Attaque attaque2 = new Attaque(jeu2, personnage2);
        jeu2.setAttaque(attaque2);
        Ennemi ennemi2;
        Logger logger = Logger.getLogger("logger.Main");

        logger.info("Début du jeu 2");

        //déroulement jeu 2
        jeu2.demarrerLeJeu();
        while (!jeu2.aGagne() && !jeu2.aPerdu()) {
            jeu2.deplacer();
            ennemi2 = jeu2.rencontrerEnnemi();
            attaque2.setEnnemi(ennemi2);
            jeu2.coupSpecial();
            //combat:
            while (!attaque2.ennemiVaincu() && !jeu2.aPerdu()) {
                gererCombat(attaque2, jeu2, ennemi2);
            }
        }
        if (jeu2.aPerdu()) {
            jeu2.defaite();
        } else {
            jeu2.victoire();
        }
        recap(attaque2, personnage2);
        System.out.println("\n");
        logger.info("Fin du jeu 2");
    }

    public static void jeu3() {
        /**
         * Jeu 3: Un habitant de Vault dans un bunker
         */
        Personnage personnage3 = new Personnage("Vault inhabitant", 90, 5, "Heal");
        Carte carte3 = new Carte("Bunker", "Vault tech shelter", 3);
        Jeu jeu3 = new Jeu(carte3, personnage3, null);
        Attaque attaque3 = new Attaque(jeu3, personnage3);
        jeu3.setAttaque(attaque3);
        Ennemi ennemi3;
        Logger logger = Logger.getLogger("logger.Main");

        logger.info("Début du jeu 3");

        //Déroulement jeu 3
        jeu3.demarrerLeJeu();
        while (!jeu3.aGagne() && !jeu3.aPerdu()) {
            jeu3.deplacer();
            ennemi3 = jeu3.rencontrerEnnemi();
            attaque3.setEnnemi(ennemi3);
            jeu3.coupSpecial();
            //combat:
            while (!attaque3.ennemiVaincu() && !jeu3.aPerdu()) {
                gererCombat(attaque3, jeu3, ennemi3);
            }
        }
        if (jeu3.aPerdu()) {
            jeu3.defaite();
        } else {
            jeu3.victoire();
        }
        recap(attaque3, personnage3);
        System.out.println("\n");
        logger.info("FIN du jeu 3");
    }

    public static void jeu4() {
        /**
         * Jeu 4: Lee Moldaver dans une usine.
         */
        Personnage personnage4 = new Personnage("Lee Moldaver", 100, 12, "Gantelets");
        Carte carte4 = new Carte("Supply Plant", "Los Angeles", 10);
        Jeu jeu4 = new Jeu(carte4, personnage4, null);
        Attaque attaque4 = new Attaque(jeu4, personnage4);
        jeu4.setAttaque(attaque4);
        Ennemi ennemi4;
        Logger logger = Logger.getLogger("logger.Main");

        //Déroulement jeu 4
        jeu4.demarrerLeJeu();
        while (!jeu4.aGagne() && !jeu4.aPerdu()) {
            jeu4.deplacer();
            ennemi4 = jeu4.rencontrerEnnemi();
            attaque4.setEnnemi(ennemi4);
            jeu4.coupSpecial();

            // combat:
            while (!attaque4.ennemiVaincu() && !jeu4.aPerdu()) {
                gererCombat(attaque4, jeu4, ennemi4);
            }
        }
        if (jeu4.aPerdu()) {
            jeu4.defaite();
        } else {
            jeu4.victoire();
        }
        recap(attaque4, personnage4);
        System.out.println("\n");
        logger.info("FIN du jeu 4");
    }

    /**
     * Déroulement du combat.
     * Si l'ennemi peut tirer à distance, il attaque d'abord. Autrement, le personnage attaque d'abord.
     * @param attaque
     * @param jeu
     * @param ennemi
     */
        static void gererCombat (Attaque attaque, Jeu jeu, Ennemi ennemi){
            // L'ennemi attaque
            if (ennemi.isAttaqueDistante()) {
                deroulementAttaqueEnnemi(attaque, jeu);
                deroulementAttaquePersonnage(attaque, jeu);
            } else {
                deroulementAttaquePersonnage(attaque, jeu);
                deroulementAttaqueEnnemi(attaque, jeu);
            }
        }

    /**
     * Déroulement de l'attaque de l'ennemi.
     *
     * @param attaque
     * @param jeu
     */
    private static void deroulementAttaqueEnnemi (Attaque attaque, Jeu jeu){
            if (!attaque.ennemiVaincu()) { // Si l'ennemi n'est pas vaincu
                if (attaque.CSMatrix()) { // Si le coup spéciale Matrix est activé, l'ennemi n'attaque pas.
                    attaque.useCSMatrix();
                } else {
                    attaque.ennemiAttaque(); // Autrement l'ennemi attaque.
                }
                jeu.aPerdu(); // Vérifie si le personnage a perdu.
            }
        }

    /**
     * Déroulement de l'attaque du personnage.
     * @param attaque
     * @param jeu
     */
    private static void deroulementAttaquePersonnage (Attaque attaque, Jeu jeu){
            if (!jeu.aPerdu()) { // Si le personnage n'a pas perdu.
                if (attaque.CSOneShot()) { // Si le coup spéciale One Shot est activé, l'ennemi meurt et la méthode se termine.
                    attaque.useCSOneShot();
                } else {
                    if (attaque.CSHeal()) { // Si le coup spéciale Heal est activé, donne +20PV.
                        attaque.useCSHeal();
                    }
                    if (attaque.CSGantelets()) { // SI le coup spéciale Gantelets est activé, donne +20% d'attaque
                        attaque.useCSGantelets();
                    }
                    attaque.personnageAttaque(); // Le personnage attaque.
                }
            }
        }

    /**
     * Récapitulatif des dégats
     * @param attaque
     * @param personnage
     */
    private static void recap(Attaque attaque, Personnage personnage){
        degatsTotauxInfligesPersonnage(attaque, personnage);
        degatsTotauxSubis(attaque);
    }

    /**
     * Donne un résumé des dégats infligés et les dégats totaux infligés.
     * @param attaque
     * @param personnage
     */
    private static void degatsTotauxInfligesPersonnage(Attaque attaque, Personnage personnage){
        System.out.println("Résumé des dégats infligés : "+ attaque.getListeDegatsInfligesPersonnages() );
        System.out.println("Dégats totaux infligés de " + personnage.getNom() + " : " + attaque.getDegatsTotauxInfligesPersonnage());
    }

    /**
     * Donne un résumé des dégats subis et les dégats totaux subis.
     * @param attaque
     */
    private static void degatsTotauxSubis(Attaque attaque){
        System.out.println("Résume des dégats subis : " + attaque.getListeDegatsInfligesEnnemi());
        System.out.println("Dégats totaux subis : " + attaque.getDegatsTotauxSubis());
    }
}




