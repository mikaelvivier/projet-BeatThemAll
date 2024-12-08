import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilisation des annotations Lombok (voir explications dans la class Jeu).
 */
@Data
@AllArgsConstructor

/**
 * Cette classe représente la carte du jeu.
 */
public class Carte {
    private String nom;
    private String lieu;
    private int debut;
    private int fin;
    private int longueur;
    private Logger logger = Logger.getLogger("logger.Main");

    /**
     * Le début et la fin n'ont pas besoin d'être indiqués.
     * @param nom
     * @param lieu
     * @param longueur
     */
    public Carte(String nom, String lieu, int longueur) {
        this.nom = nom;
        this.lieu = lieu;
        this.debut=0;
        this.fin=longueur;
        setLongueur(longueur);

    }

    /**
     * Renvoie une exception si la longueur de la carte est inférieure à 3.
     * @param longueur
     */
    public void setLongueur(int longueur) {
        if (longueur<6){
            logger.log(Level.WARNING, "Carte petite. " + getLongueur());
        }
        if(longueur<3){
            logger.log(Level.SEVERE, "Tentative de définir une carte trop petite. " + getLongueur());
            throw new IllegalArgumentException("La longueur de la carte est trop petite. Il faut au moins 3 niveaux.");
        }
        this.longueur = longueur;
    }
}

/*
public class TableauCarte {
    private List<Carte> cartes; // Liste pour stocker les objets Carte

    // Constructeur : initialise une liste vide
    public TableauCarte() {
        this.cartes = new ArrayList<>();
    }
    */




