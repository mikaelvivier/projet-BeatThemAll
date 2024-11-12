import lombok.AllArgsConstructor;
import lombok.Data;

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

