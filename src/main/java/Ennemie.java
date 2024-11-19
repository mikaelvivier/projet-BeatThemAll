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

class Brigands extends Ennemie {
    public Brigands(String nom, int pv, int forceattaque, boolean attaquedistante) {
        super(nom, pv, forceattaque, attaquedistante);
    }
}

class Catcheurs extends Ennemie {
    public Catcheurs(String nom, int pv, int forceattaque, boolean attaquedistante) {
        super(nom, pv, forceattaque, attaquedistante);
    }
}

class Gangsters extends Ennemie {
    public Gangsters(String nom, int pv, int forceattaque) {
        super(nom, pv, forceattaque, true); // Gangsters ont toujours une attaque distante
    }
}

