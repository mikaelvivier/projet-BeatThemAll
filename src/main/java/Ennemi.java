import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * Utilisation des annotations Lombok (voir explications dans la class Jeu).
 */
@Data
@AllArgsConstructor

/**
 * Classe abstraite représentant un ennemi dans le jeu.
 */
public abstract class Ennemi {
    private String nom;
    private int pv;
    private int forceAttaque;
    /**
     * Ce boolean est true si l'ennemi est un Gangster, lui permettant d'attaquer avant le personnage dans le main.
     */
    private boolean attaqueDistante;

}

/**
 * Le Brigand hérite de la classe Ennemi.
 * Capacités basiques.
 */
class Brigand extends Ennemi {
    public Brigand() {
        super("Brigand", 50,10, false);
    }
}

/**
 * Le Catcheur hérite de la classe Ennemi.
 * Il a plus de PV.
 */
class Catcheur extends Ennemi {
    public Catcheur() {
        super("Catcheur", 80, 10, false);
    }
}

/**
 * Le Gangster hérite de la classe Ennemi.
 * Il attaque à distance.
 */
class Gangster extends Ennemi {
    public Gangster() {
        super("Gangster", 50, 10, true); // Gangsters ont toujours une attaque distante
    }
}

/**
 * Le Kamikaze hérite de la classe Ennemi.
 * Il a moins de PV mais attaque plus fort.
 */
class Kamikaze extends Ennemi {
    public Kamikaze() {
        super("kamikaze", 40, 20, false); // Gangsters ont toujours une attaque distante
    }
}

