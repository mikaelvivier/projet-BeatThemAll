import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Surface extends JPanel implements ActionListener{
    Personnage personnage;
    Image img;
    Timer time;
    public Surface(){
        personnage=new Personnage("Moine Shaolin", 100, 300, 30);
        setFocusable(true); //Rend un composant capable de recevoir le focus clavier.
        ImageIcon i= new ImageIcon("images/bg_BTA_jungle.jpg");
        img=i.getImage();
        time=new Timer(5,this);
        time.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) { // Reaffiche l'image à chaque action.
        repaint();
    }
    public void paint(Graphics g){ // Convertit Graphics en Graphics2D.
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
    }
}
