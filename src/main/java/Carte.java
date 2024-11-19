import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
//javax.swing.* fournit un ensemble de composants graphiques pour créer des interfaces utilisateur (UI)

@Data
@AllArgsConstructor
public class Carte {
    private int id;
    private String nom;
    private String lieu;
    private int debut;
    private int fin;
    private int longueur;

}
public class TableauCarte {
    private List<Carte> cartes; // Liste pour stocker les objets Carte

    // Constructeur : initialise une liste vide
    public TableauCarte() {
        this.cartes = new ArrayList<>();
    }
}



