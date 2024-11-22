import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carte {
    private String nom;
    private String lieu;
    private int debut;
    private int fin;
    private int longueur;

    public Carte(String nom, String lieu, int longueur) {
        this.nom = nom;
        this.lieu = lieu;
        this.debut=0;
        this.fin=longueur;
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




