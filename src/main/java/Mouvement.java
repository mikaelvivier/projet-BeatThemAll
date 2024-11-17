import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@AllArgsConstructor
@Data
public class Mouvement implements KeyListener {
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
