package jeux;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Table  {

    ArrayList<Cartes> carteTable ;
    ArrayList<Cartes> packets ;
    Distributeur distributeur;
    Joueur PC;
    Joueur PR;

    Table() {
        carteTable = new ArrayList<Cartes>();
        packets = new ArrayList<Cartes>();

        for (int i = 1; i <= 12; i++) {
            // Remplissage du packets
            if (i != 8 && i != 9) {
                packets.add(new Cartes("gre3", i, "image//" + i + "g.png"));
                packets.add(new Cartes("sif", i, "image//" + i + "s.png"));
                packets.add(new Cartes("tbay9", i, "image//" + i + "t.png"));
                packets.add(new Cartes("flous", i, "image//" + i + "d.png"));
            }
        }

    }

    

}
