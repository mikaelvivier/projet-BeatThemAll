import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Personnage{
    private String nom;
    private int pv;
    private int forceAttaque;
    private int shield;
    private int heal;
    private String capaciteSpeciale;
}




