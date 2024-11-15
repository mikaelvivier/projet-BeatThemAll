import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

//VIVIER Mikaël, PIOCHE-THIROUX Maël FISATI 27
//Ce jeu se déroule dans l'univers de Fallout (franchise de jeu de Bethesda)
public class Main {
    public static void main(String[] args) {
        System.out.println("Ce jeu vidéoludique vous est proposé par VIVIER Mikaël et PIOCHE-THIROUX Maël\n"+"Amusez vous bien :-)");
        Personnage personnage=new Personnage("Mael", 100, 300, 30);

        //création des cartes + niveaux
        Carte NewVegas=new Carte(2281,"Fallout-NewVegas","Nevada",0,150,150);
        Carte PointLookout=new Carte(2277,"Fallout3-PointLookout","MaryLand",0,300,300);
        Carte ThePitt=new Carte(2102,"Fallout76-ThePitt","PittBurgh",0,200,200);
        TableauCarte = new ArrayList(TableauCarte.add(NewVegas);
        TableauCarte.add(PointLookout);
        TableauCarte.add(ThePitt));

        //endroit de la map dans le jeu associé
        //Pour la Carte NewVegas
        Niveau Goodspring=new Niveau(1,2281,"Goodspring");
        Niveau BlackMountain=new Niveau(2,2281,"Black Mountain");
        Niveau BoulterCity=new Niveau(3,2281,"Boulter City");
        Niveau HooverDam=new Niveau(4,2281,"Hover Dam");
        Niveau CampForlornHope=new Niveau(5,2281,"Camp Forlorn Hope");
        Niveau Novac=new Niveau(6,2281,"Novac");
        Niveau Nipton=new Niveau(7,2281,"Nipton");
        Niveau Jacobstown=new Niveau(8,2281,"Jacobstown");
        TableauNiveauNewVegas =  new ArrayList<>();
        TableauNiveauNewVegas.add(Goodspring);
        TableauNiveauNewVegas.add(BlackMountain);
        TableauNiveauNewVegas.add(BoulterCity);
        TableauNiveauNewVegas.add(HooverDam);
        TableauNiveauNewVegas.add(CampForlornHope);
        TableauNiveauNewVegas.add(Novac);
        TableauNiveauNewVegas.add(Nipton);
        TableauNiveauNewVegas.add(Jacobstown);

        //Pour la Carte Point Lookout
        Niveau Steelyard=new Niveau(9,2277,"Steelyard");
        Niveau TrainYard=new Niveau(10,2277,"Train Yard");
        Niveau SupplyPlant=new Niveau(11,2277,"Supply Plan");
        Niveau TheMill=new Niveau(12,2277,"The Mill");
        Niveau AbandonedAppartements=new Niveau(13,2277,"Abandoned Appartements");
        Niveau WernhersHideout=new Niveau(14,2277,"Wernher's Hideout");
        Niveau Underground=new Niveau(15,2277,"Underground");
        Niveau Downtown=new Niveau(16,2277,"Downtown");
        TableauNiveauPointLookout = new ArrayList<>();

    }

