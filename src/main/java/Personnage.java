import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    private int shield;
    private int heal;
    private String capaciteSpeciale;
}




