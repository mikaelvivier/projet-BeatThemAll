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
        TableauCarte = ArrayList(TableauCarte.add(NewVegas);TableauCarte.add(PointLookout);TableauCarte.add(ThePitt));

        //endroit de la map dans le jeu
        Niveau Goodspring=new Niveau(1,2281,"Goodspring");
        Niveau BlackMountain=new Niveau(2,2281,"Black Mountain");
        Niveau BoulterCity=new Niveau(3,2281,"Boulter City");
        Niveau HooverDam=new Niveau(4,2281,"Hover Dam");
        Niveau CampForlornHope=new Niveau(5,2281,"Camp Forlorn Hope");
        Niveau Novac=new Niveau(6,2281,"Novac");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");
        Niveau BlackMountain=new Niveau(2,2281,"BlackMountain");

    }

