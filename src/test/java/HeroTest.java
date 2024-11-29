import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HeroTest {
    private Personnage hercule;
    private Attaque attaque;
    private Carte farWest;
    private Jeu jeu1;
    private Random random;

    @BeforeEach
    public void setUp() {
        hercule = new Personnage("Hercule", 100, 50, "Matrix");
        farWest= new Carte("Far West", "cow city", 10);
        attaque=new Attaque(jeu1, hercule);
        jeu1= new Jeu(farWest, hercule, attaque);
        attaque.setJeu(jeu1);
    }

    @Test
    public void testRencontre() {
        jeu1.deplacer();
        assertNotNull(jeu1);
    }
}
