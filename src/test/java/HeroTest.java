import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    private Personnage hercule;
    private Attaque attaque;
    private Carte farWest;
    private Jeu jeu1;

    @BeforeEach
    public void setUp() {
        hercule = new Personnage("Hercule", 100, 50, "Matrix"); //force d'attaque égale aux PV max de l'ennemi Gangster
        farWest= new Carte("Far West", "cow city", 10);
        attaque=new Attaque(jeu1, hercule, farWest);
        jeu1= new Jeu(farWest, hercule, attaque);
        attaque.setJeu(jeu1);
    }

    @Test
    public void testRencontre() {
        jeu1.demarrerLeJeu();
        assertTrue(attaque.ennemiVaincu());
    }
}
