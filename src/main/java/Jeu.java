import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Jeu {
    private Carte carte;
    private int positionPerso;
    private Random random;
    private int deplacementSpecial;
    private boolean utiliseCapacite;
    private int tourCapacite = 0;

    public Jeu(Carte carte) {
        this.carte=carte;
        this.positionPerso= carte.getDebut();
        int totalDeplacements= carte.getLongueur();
        this.deplacementSpecial=random.nextInt(totalDeplacements);
        this.utiliseCapacite =false;
    }

    public void deplacer(){
        int mouvement =1;
        positionPerso+=mouvement;
        if (positionPerso> carte.getFin()){
            positionPerso-=carte.getFin();
        }
        System.out.println("Position actuelle du joueur: " + positionPerso);
        //vérification aléatoire pour le coup spécial
        if (positionPerso==deplacementSpecial){
            coupSpecial();
        }
    }

    public boolean estTermine(){
        return positionPerso>=carte.getFin();
    }

    public void gagne(){
        if (estTermine()){
            System.out.println("Vous avez gagné");
        }
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
