import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
@AllArgsConstructor
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    private int shield;
    static int heal;
    Image imgPerso;

    public Personnage(String moineShaolin, int pv, int forceAttaque, int shield){
        ImageIcon icone=new ImageIcon("images/bebe_moine.png");
        imgPerso= icone.getImage();
    }
    /**
     * test voila
     * @param e the event to be processed
     */

}




