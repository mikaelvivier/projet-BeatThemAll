import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Data
@AllArgsConstructor
public class Personnage implements KeyListener {
    private String nom;
    private int pv;
    private int forceattaque;
    private int shield;
    private static int heal;

    /**
     * test voila
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()== KeyEvent.VK_R){
            Personnage.heal=100;
        }
    }
}

abstract class Ennemie {
    private String nom;
    private int pv;
    private int forceattaque;
    private boolean attaquedistante;
}


