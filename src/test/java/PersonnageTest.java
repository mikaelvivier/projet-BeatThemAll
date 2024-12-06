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
    public void setUpTest1() {
        personnage = new Personnage("Hercule", 100, 80, "OneShot"); //force d'attaque égale aux PV max de l'ennemi Catcheur
        carte = new Carte("Far West", "cow city", 10);
        attaque=new Attaque(jeu, personnage);
        jeu = new Jeu(carte, personnage, attaque);
        attaque.setJeu(jeu);

    }

    private void setUpTest2() {
        personnage = new Personnage("Vault Dweller", 50, 10, "Matrix");
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
                jeu.gererCombat(attaque, jeu, ennemi);
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
    public void testRencontre() {
        ennemi= jeu.rencontrerEnnemi();
        attaque.setEnnemi(ennemi);
        attaque.personnageAttaque();
        assertTrue(attaque.ennemiVaincu(),"L'ennemi devrait être vaincu après l'attaque.");
    }

    @Test
    public void testPersonnageMeurt(){
        setUpTest2();
        assertTrue(jeu.aPerdu());
    }

    @Test
    public void testForceAttaquePersonnage(){
        try {
            personnage.setForceAttaque(-10);
            fail("Une exception devrait être lancée pour pour une force d'attaque négative");
        } catch (IllegalArgumentException e) {
            assertEquals("La force d'attaque du personnage ne peut pas être nulle ou négative", e.getMessage());
        }
    }

    @Test
    public void testLongueurCarte(){
        try {
            carte.setLongueur(2); // Supposons que l'année ne peut pas être négative
            fail("Une exception devrait être lancée pour une longueur de carte inférieure à 3");
        } catch (IllegalArgumentException e) {
            assertEquals("La longueur de la carte est trop petite. Il faut au moins 3 niveaux.", e.getMessage());
        }
    }

    @Test
    public void capaciteSpecialeExiste(){
        try {
            personnage.setCapaciteSpeciale("Rocket"); // Supposons que l'année ne peut pas être négative
            fail("Une exception devrait être lancée pour une capacité spéciale inexistante");
        } catch (IllegalArgumentException e) {
            assertEquals("La capacité spéciale n'existe pas", e.getMessage());
        }
    }

    @Test
    public void testOneShot(){
        ennemi= jeu.rencontrerEnnemi();
        attaque.setEnnemi(ennemi);
        if (personnage.getCapaciteSpeciale().equals("OneShot")) {
            attaque.useCSOneShot();
        }
        assertTrue(attaque.ennemiVaincu(), "L'ennemi devrait être vaincu après l'utilisation de la capacité OneShot.");
    }
}



