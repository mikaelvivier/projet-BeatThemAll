import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    private String capaciteSpeciale;
}




