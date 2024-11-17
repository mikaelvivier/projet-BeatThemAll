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

