import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonnageTest {
    private Personnage personnage;
    private Attaque attaque;
    private Carte carte;
    private Jeu jeu;
    private Ennemi ennemi;

    @BeforeEach
    /**
     * Met en place un jeu qui correspond au test 1 : La force d'attaque du personnage est égale aux PV max de l'ennemi Catcheur.
     * Ce set up sera utilisé pour tous les autres tests.
     */
    public void setUpTest1() {
        personnage = new Personnage("Hercule", 100, 80, "OneShot");
        carte = new Carte("Far West", "cow city", 10);
        attaque=new Attaque(jeu, personnage);
        jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);

    }

    /**
     * Met en place un jeu qui correspond au test 2 : Les PV du personnage sont égaux à 0.
     */
    private void setUpTest2() {
        personnage = new Personnage("Vault Dweller", 0, 10, "Matrix");
        carte = new Carte("Wasteland", "Nuclear Ruins", 10);
        attaque=new Attaque(jeu, personnage);
        jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);
        jeu.demarrerLeJeu();
        while (!jeu.aGagne() && !jeu.aPerdu()) {
            jeu.deplacer();
            ennemi = jeu.rencontrerEnnemi();
            attaque.setEnnemi(ennemi);
            jeu.coupSpecial(); //vérifie si le coup spécial est activé et l'active si c'est le cas
            //combat:
            while (!attaque.ennemiVaincu() && !jeu.aPerdu()) {
                Main.gererCombat(attaque, jeu, ennemi);
            }
        }
        if (jeu.aGagne()) {
            jeu.victoire();
        }
        else{
            jeu.defaite();
        }
    }

    @Test
    /**
     * Ce test vérifie que l'ennemi est toujours vaincu si le personnage a la même force d'attaque que les PV max d'un attaquant (le catcheur a 80 PV).
     */
    public void testRencontre() {
        ennemi= jeu.rencontrerEnnemi();
        attaque.setEnnemi(ennemi);
        attaque.personnageAttaque();
        assertTrue(attaque.ennemiVaincu(),"L'ennemi devrait être vaincu après l'attaque.");
    }

    @Test
    /**
     * Ce test vérifier que le personnage meurt bien s'il a 0 PV.
     */
    public void testPersonnageMeurt(){
        setUpTest2();
        assertTrue(jeu.aPerdu());
    }

    @Test
    /**
     * Ce test vérifie que la force d'attaque du personnage ne peut pas être inférieure ou égale à 0, ni être réduite.
     */
    public void testForceAttaquePersonnage(){
        try {
            personnage.setForceAttaque(-10);
            fail("Une exception devrait être lancée pour pour une force d'attaque négative");
        } catch (IllegalArgumentException e) {
            assertEquals("La force d'attaque du personnage ne peut pas être nulle ou négative", e.getMessage());
        }
    }

    @Test
    /**
     * Ce test vérifie que la longueur de la carte ne puisse pas être inférieure à 3.
     */
    public void testLongueurCarte(){
        try {
            carte.setLongueur(2); // Supposons que l'année ne peut pas être négative
            fail("Une exception devrait être lancée pour une longueur de carte inférieure à 3");
        } catch (IllegalArgumentException e) {
            assertEquals("La longueur de la carte est trop petite. Il faut au moins 3 niveaux.", e.getMessage());
        }
    }

    @Test
    /**
     * Ce test vérifie que la capacité spéciale ne puisse pas être vrai si elle n'est pas dans la liste de la méthode Personnage.setCapaciteSpeciale().
     */
    public void capaciteSpecialeExistePas(){
        try {
            personnage.setCapaciteSpeciale("Rocket"); // Supposons que l'année ne peut pas être négative
            fail("Une exception devrait être lancée pour une capacité spéciale inexistante");
        } catch (IllegalArgumentException e) {
            assertEquals("La capacité spéciale n'existe pas", e.getMessage());
        }
    }

    @Test
    /**
     * Ce test vérifie que l'ennemi est bien vaincu après la méthode One Shot.
     */
    public void testOneShot(){
        ennemi= jeu.rencontrerEnnemi();
        attaque.setEnnemi(ennemi);
        if (personnage.getCapaciteSpeciale().equals("OneShot")) {
            attaque.useCSOneShot();
        }
        assertTrue(attaque.ennemiVaincu(), "L'ennemi devrait être vaincu après l'utilisation de la capacité OneShot.");
    }
}



