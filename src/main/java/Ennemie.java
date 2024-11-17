import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Ennemie {
    private String nom;
    private int pv;
    private int forceattaque;
    private boolean attaquedistante;
}
class Brigands extends Ennemie {}

class Catcheurs extends Ennemie {}

class Gangsters extends Ennemie {}


