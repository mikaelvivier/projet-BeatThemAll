import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Ennemi {
    private String nom;
    private int pv;
    private int forceAttaque;
    private boolean attaqueDistante;

    public void attaquer(){
        System.out.println(nom+ "attaque avec une force de "+ forceAttaque +"!");
    }
}

class Brigand extends Ennemi {
    public Brigand() {
        super("Brigand", 50,10, false);
    }
}

class Catcheur extends Ennemi {
    public Catcheur() {
        super("Catcheur", 80, 10, false);
    }
}

class Gangster extends Ennemi {
    public Gangster() {
        super("Gangster", 50, 10, true); // Gangsters ont toujours une attaque distante
    }
}

class Kamikaze extends Ennemi {
    public Kamikaze() {
        super("kamikaze", 30, 20, true); // Gangsters ont toujours une attaque distante
    }
}

