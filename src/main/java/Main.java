//VIVIER Mikaël, PIOCHE-THIROUX Maël FISATI 27
//Ce jeu se déroule dans l'univers de Fallout (franchise de jeu de Bethesda)


public class Main {


    public static void main(String[] args) {
        // Exécuter les différents jeux
        //jeu1();
        //jeu2();
        jeu3();
        //jeu4();
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

        //déroulement jeu 1
        jeu.demarrerLeJeu();
        while (!jeu.aGagne() && !jeu.aPerdu()) {
            jeu.deplacer();
            ennemi = jeu.rencontrerEnnemi();
            attaque.setEnnemi(ennemi);
            jeu.coupSpecial(); //vérifie si le coup spécial est activé et l'active si c'est le cas
            //combat:
            while (!attaque.ennemiVaincu() && !jeu.aPerdu()) {
                gererCombat(attaque, jeu, ennemi);
            }
        }
        if (jeu.aPerdu()) {
            jeu.defaite();
        } else {
            jeu.victoire();
        }

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

        //déroulement jeu 2
        jeu2.demarrerLeJeu();
        while (!jeu2.aGagne() && !jeu2.aPerdu()) {
            jeu2.deplacer();
            ennemi2 = jeu2.rencontrerEnnemi();
            attaque2.setEnnemi(ennemi2);
            jeu2.coupSpecial(); // Vérifie si le coup spécial est activé
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

        //Déroulement jeu 3
        jeu3.demarrerLeJeu();
        while (!jeu3.aGagne() && !jeu3.aPerdu()) {
            jeu3.deplacer();
            ennemi3 = jeu3.rencontrerEnnemi();
            attaque3.setEnnemi(ennemi3);
            jeu3.coupSpecial(); // Vérifie si le coup spécial est activé
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

        //Déroulement jeu 4
        jeu4.demarrerLeJeu();
        while (!jeu4.aGagne() && !jeu4.aPerdu()) {
            jeu4.deplacer();
            ennemi4 = jeu4.rencontrerEnnemi();
            attaque4.setEnnemi(ennemi4);
            jeu4.coupSpecial(); // Vérifie si le coup spécial est activé

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

    }

        static void gererCombat (Attaque attaque, Jeu jeu, Ennemi ennemi){
            // L'ennemi attaque
            if (ennemi.isGangster()) {
                deroulementAttaqueEnnemi(attaque, jeu);
                deroulementAttaquePersonnage(attaque, jeu);
            } else {
                deroulementAttaquePersonnage(attaque, jeu);
                deroulementAttaqueEnnemi(attaque, jeu);
            }
        }

        private static void deroulementAttaqueEnnemi (Attaque attaque, Jeu jeu){
            if (!attaque.ennemiVaincu()) {
                if (attaque.CSMatrix()) {
                    attaque.useCSMatrix();
                } else {
                    if (attaque.CSGantelets()) {
                        attaque.useCSGantelets();
                    }
                    attaque.ennemiAttaque();
                }
                jeu.aPerdu();
            }
        }

        private static void deroulementAttaquePersonnage (Attaque attaque, Jeu jeu){
            if (!jeu.aPerdu()) {
                if (attaque.CSOneShot()) {
                    attaque.useCSOneShot();
                } else {
                    if (attaque.CSHeal()) {
                        attaque.useCSHeal();
                    }
                    attaque.personnageAttaque();
                    if (attaque.ennemiVaincu()) {
                        System.out.println("L'ennemi a été vaincu");
                    }
                }
            }
        }
    }

//VIVIER Mikaël, PIOCHE-THIROUX Maël FISATI 27
//Ce jeu se déroule dans l'univers de Fallout (franchise de jeu de Bethesda)

        /*
        public class Main {
            //  @SneakyThrows
            public static void main(String[] args) {
                Logger logger = Logger.getLogger(Main.class.getName());
                FileHandler fileHandler = null;
                try {
                    fileHandler = new FileHandler("BeatThemAll.log", true);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
                logger.addHandler(fileHandler);
                logger.setLevel(Level.ALL);
                logger.warning("warning dommage");
                logger.info("L'application a démarré");
                logger.severe("severe dommage");
*/
        /*
        //createFile(); { //méthode à la mano pour créer un fichier sans sneaky thorws
            try {
                File file = new File("BeatThemAll.log");
                file.createNewFile();
            } catch (Exception e) {
                throw new RuntimeException(e); // Relance l'exception en tant que RuntimeException
            }
        }
        //Création du fichier de logs
        final Logger logger = Logger.getLogger(Main.class.getName()); // Déclaration du logger
        FileHandler fileHandler = new FileHandler("C:/Users/m.piochethiroux/Documents/GitHub/BeatThemAll.log", true);
        //fileHandler.setFormatter(new DateFormatter()); // format de logs avec la date en entete
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
        logger.info("L'application a démarré");
        */



                //Personnage personnage = new Personnage("Mael", 100, 300, 30);
        /*
        //création des cartes + niveaux
        Carte NewVegas = new Carte(2281, "Fallout-NewVegas", "Nevada", 0, 150, 150);
        Carte PointLookout = new Carte(2277, "Fallout3-PointLookout", "MaryLand", 0, 300, 300);
        Carte ThePitt = new Carte(2102, "Fallout76-ThePitt", "PittBurgh", 0, 200, 200);
        List<Carte> TableauCarte = new ArrayList(TableauCarte.add(NewVegas));
        TableauCarte.add(PointLookout);
        TableauCarte.add(ThePitt);

        //endroit de la map dans le jeu associé
        //Création des niveau pour la Carte NewVegas (id du niveau, id de la carte, nom du niveau)
        Niveau Goodspring = new Niveau(1, 2281, "Goodspring");
        Niveau BlackMountain = new Niveau(2, 2281, "Black Mountain");
        Niveau BoulterCity = new Niveau(3, 2281, "Boulter City");
        Niveau HooverDam = new Niveau(4, 2281, "Hover Dam");
        Niveau CampForlornHope = new Niveau(5, 2281, "Camp Forlorn Hope");
        Niveau Novac = new Niveau(6, 2281, "Novac");
        Niveau Nipton = new Niveau(7, 2281, "Nipton");
        Niveau Jacobstown = new Niveau(8, 2281, "Jacobstown");
        List<Carte> TableauNiveauNewVegas = new ArrayList<>();
        TableauNiveauNewVegas.add(Goodspring);
        TableauNiveauNewVegas.add(BlackMountain);
        TableauNiveauNewVegas.add(BoulterCity);
        TableauNiveauNewVegas.add(HooverDam);
        TableauNiveauNewVegas.add(CampForlornHope);
        TableauNiveauNewVegas.add(Novac);
        TableauNiveauNewVegas.add(Nipton);
        TableauNiveauNewVegas.add(Jacobstown);

        //Création des niveau pour la Carte The Point Lookout (id du niveau, id de la carte, nom du niveau)
        Niveau Lighthouse = new Niveau(17, 2277, "Lighthouse");
        Niveau JetCrashSite = new Niveau(18, 2277, "Jet Crash Site");
        Niveau SmugglersCamp = new Niveau(19, 2277, "Smuggler's Camp");
        Niveau FloodedSinkhole = new Niveau(20, 2277, "Flooded Sinkhole");
        Niveau CoastalGrotto = new Niveau(21, 2277, "Coastal Grotto");
        Niveau HerzogMine = new Niveau(22, 2277, "Herzog Mine");
        Niveau RiverboatLanding = new Niveau(23, 2277, "Riverboat Landing");
        Niveau TruckWrekage = new Niveau(24, 2277, "Truck Wrekage");
        Niveau Warehouse = new Niveau(25, 2277, "Warehouse");
        Niveau HomestaedMotel = new Niveau(26, 2277, "HomestaedMotel");
        List<Carte> TableauNiveauPointLookout = new ArrayList<>();
        TableauNiveauPointLookout.add(Steelyard);
        TableauNiveauPointLookout.add(TrainYard);
        TableauNiveauPointLookout.add(SupplyPlant);
        TableauNiveauPointLookout.add(TheMill);
        TableauNiveauPointLookout.add(AbandonedAppartements);
        TableauNiveauPointLookout.add(WernhersHideout);
        TableauNiveauPointLookout.add(Underground);
        TableauNiveauPointLookout.add(Downtown);

        //Création des niveau pour la Carte The Pitt (id du niveau, id de la carte, nom du niveau)
        Niveau Steelyard = new Niveau(9, 2102, "Steelyard");
        Niveau TrainYard = new Niveau(10, 2102, "Train Yard");
        Niveau SupplyPlant = new Niveau(11, 2102, "Supply Plan");
        Niveau TheMill = new Niveau(12, 2102, "The Mill");
        Niveau AbandonedAppartements = new Niveau(13, 2102, "Abandoned Appartements");
        Niveau WernhersHideout = new Niveau(14, 2102, "Wernher's Hideout");
        Niveau Underground = new Niveau(15, 2102, "Underground");
        Niveau Downtown = new Niveau(16, 2102, "Downtown");
        List<Carte> TableauNiveauThePitt = new ArrayList<>();
        TableauNiveauThePitt.add(TheTrainyard);
        TableauNiveauThePitt.add(TheFoundry);
        TableauNiveauThePitt.add(Uptown);
        TableauNiveauThePitt.add(DowntownPitt);
        TableauNiveauThePitt.add(TheSteelYard);
        TableauNiveauThePitt.add(TheMillPitt);
        TableauNiveauThePitt.add(Haven);
        TableauNiveauThePitt.add(WernhersRefuge);
    }

//Pour la suite pour faire les créatures : https://fallout.fandom.com/wiki/Fallout_3_creatures
//tout mes niveaux viennent de ce site (les maps de chaque jeu)


         */



