import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Carte {
    private int id;
    private string nom;
    private string lieu;
    private int debut;
    private int fin;
    private int longueur;
}

public class Niveau {
    private int id;
    private int Carte id;
    private string nom;
}
    """ l'idée ici est d'avoir des niveaux dans la carte"""

