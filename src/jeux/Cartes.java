
package jeux;


import java.awt.Button;
import java.awt.Image;
import javax.swing.*;


public class Cartes extends JButton{
    
    String typeCarte;
    int numCarte;
    ImageIcon imgFace;
    static ImageIcon imgDos;
    Cartes(){
        super();
        this.imgDos = new ImageIcon("image//dos.png");
        Image img = imgDos.getImage();
        Image newimgDos = img.getScaledInstance(230, 310,  java.awt.Image.SCALE_SMOOTH);
        this.imgDos = new ImageIcon(newimgDos);
        aficheDos();}
    Cartes(String typeCarte, int numCarte,String urlF){
        super();
        this.typeCarte=typeCarte;
        this.numCarte=numCarte;
        this.imgFace = new ImageIcon(urlF);
        Image img = imgFace.getImage();
        Image newimgFace = img.getScaledInstance(84, 131,  java.awt.Image.SCALE_SMOOTH);
        this.imgFace = new ImageIcon(newimgFace);
        
        this.imgDos = new ImageIcon("image//dos.png");
        img = imgDos.getImage();
        Image newimgDos = img.getScaledInstance(84, 131,  java.awt.Image.SCALE_SMOOTH);
        this.imgDos = new ImageIcon(newimgDos);
        aficheDos();
        
    }
 
    //affichage de la face du carte
    void aficheface(){
    setIcon(imgFace);
    }
    //affichage de le dos du carte
    void aficheDos(){
    setIcon(imgDos);
    }
    private Cartes carteCliquee;
}
