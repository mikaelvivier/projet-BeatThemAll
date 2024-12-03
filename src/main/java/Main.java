import lombok.SneakyThrows;
import javax.swing.text.DateFormatter;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

import static java.nio.file.Files.createFile;

//VIVIER Mikaël, PIOCHE-THIROUX Maël FISATI 27
//Ce jeu se déroule dans l'univers de Fallout (franchise de jeu de Bethesda)


public class Main {

 //  @SneakyThrows
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("*/GitHub/BeatThemAll.log", true);
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

        //Jeu où le héros peut gagner et perdre
        Personnage personnage = new Personnage("Vault Dweller", 150, 10, "OneShot");
        Carte carte = new Carte("Wasteland", "Nuclear Ruins", 10);
        Attaque attaque = new Attaque(null, personnage, carte);
        Jeu jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);
        jeu.demarrerLeJeu();

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

    }
}