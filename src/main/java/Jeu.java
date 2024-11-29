import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Jeu {
    private Carte carte;
    private int positionPerso;
    private int totalDeplacements;
    private Random random;
    private int deplacementSpecial;
    private boolean utiliseCapacite;
    private int tourCapacite = 0;
    private Personnage personnage;
    private Ennemi ennemi;
    private Attaque attaque;

    public Jeu(Carte carte, Personnage personnage, Attaque attaque) {
        this.carte=carte;
        this.positionPerso= carte.getDebut();
        int totalDeplacements= carte.getLongueur();
        this.random=new Random();
        this.deplacementSpecial=random.nextInt(totalDeplacements);
        this.utiliseCapacite =false;
        this.personnage=personnage;
        this.attaque=attaque;
    }

    public void deplacer() {
        positionPerso += 1;
        if (aGagne()) {
            System.out.println("Vous avez gagné! vous avez passé tous les niveaux. ");
            System.exit(0);
            return;
        }
        System.out.println("Position actuelle du joueur est à " + positionPerso + " sur " + totalDeplacements);
        //vérification aléatoire pour le coup spécial
        rencontre();
    }


    public void rencontre(){
        Ennemi nouvelEnnemi=rencontrerEnnemi(); //pour avoir le log "Vous rencontrez un (ennemi)"
        attaque.setEnnemi(nouvelEnnemi);
        if (positionPerso==deplacementSpecial){
            coupSpecial();
        }
        attaque.combattre();
        }


    private boolean aGagne(){
        return positionPerso>=carte.getFin();
    }

    public boolean aPerdu(){
        return(personnage.getPv()<0);
    }


    public Ennemi rencontrerEnnemi() {
        int rand = random.nextInt(3) + 1;
        Ennemi ennemi = null;
        switch (rand) {
            case 1:
                ennemi = new Brigand();
                break;
            case 2:
                ennemi = new Catcheur();
                break;
            case 3:
                ennemi = new Gangster();
                break;
        }
        System.out.println("Vous rencontrez un " + ennemi.getNom());
        return ennemi;
    }

    private void coupSpecial(){
        System.out.println("La capacité spéciale s'active !");
        utiliseCapacite =true;
    }

}

