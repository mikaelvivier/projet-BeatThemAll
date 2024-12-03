import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    private Personnage personnage;
    private Attaque attaque;
    private Carte carte;
    private Jeu jeu;

    @BeforeEach
    public void setUpTest1() {
        personnage = new Personnage("Hercule", 100, 80, "Matrix"); //force d'attaque égale aux PV max de l'ennemi Catcheur
        carte = new Carte("Far West", "cow city", 10);
        attaque=new Attaque(jeu, personnage, carte);
        jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);
    }

    private void setUpTest2() {
        personnage = new Personnage("Vault Dweller", 0, 10, "OneShot");
        carte = new Carte("Wasteland", "Nuclear Ruins", 10);
        attaque=new Attaque(jeu, personnage, carte);
        jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);
    }

    @Test
    public void testRencontre() {
        jeu.demarrerLeJeu();
        attaque.personnageAttaque();
        assertTrue(attaque.ennemiVaincu(),"L'ennemi devrait être vaincu après l'attaque.");
    }

    @Test
    public void testHeroMeurt(){
        setUpTest2();
        jeu.demarrerLeJeu();
        assertTrue(jeu.aPerdu());
    }


}
