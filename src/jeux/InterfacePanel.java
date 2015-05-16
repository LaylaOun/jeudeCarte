/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 *
 * @author aziz
 */
public class InterfacePanel extends JPanel{
    
        //element de linterface
    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan3;
    private JPanel panPC;
    private JPanel panPR;
    private JPanel panT;
    private JLabel LCartTable;
    Cartes C1; 
    Cartes C2;
    Cartes C3;
    Cartes C4;
    //element du jeu
    private Joueur PC;
    private Joueur PR;
    private Table T;
    private Distributeur dist;
    public int ii;
    private boolean prener;
    
   

   
    InterfacePanel(){ 
        super();
        setBounds(100,100,200,200);
        prener=false;
//initialisation des element du jeu
        T= new Table();
        PC= new Joueur("PC",T,dist);
        PR= new Joueur("PR",T,dist);
        dist= new Distributeur(T,PC,PR);
//creation des element de linterface
        LCartTable= new JLabel();
        pan1=new JPanel();
        pan2=new JPanel();
        pan3=new JPanel();
        panPR=new JPanel();
        panPC=new JPanel();
        panT=new JPanel();
//cart de choix
        C1= new Cartes("gre3", 7, "image//" + 7+ "g.png");
        C2= new Cartes("sif", 7, "image//" + 7 + "s.png");
        C3= new Cartes("tbay9", 7, "image//" + 7 + "t.png");
        C4= new Cartes("flous", 7, "image//" + 7 + "d.png");

        dist.melanger(T.packets);
        dist.destribuer();
        paintPanel();

        tourjr();
}
// tour d'utilisateur 
    void tourjr(){
        boolean joue=false;
    //creation des evenement des carte de joueur "PC"
        final ArrayList <Cartes> recherch=PR.recherche(T.carteTable.get(T.carteTable.size()-1).numCarte,T.carteTable.get(T.carteTable.size()-1).typeCarte);
        for(int i=0; i<PC.carteJoueur.size(); i++){
         PC.carteJoueur.get(i).aficheface();
    }
    
    int sNumero=T.carteTable.get(T.carteTable.size()-1).numCarte;
    String sType=T.carteTable.get(T.carteTable.size()-1).typeCarte;

       
    if(!prener){
        if(sNumero==1){
            for(int i=0; i<recherch.size(); i++){
                if(recherch.get(i).numCarte==1){
                   joue=true;
                    break;
                }
                if(recherch.get(i).numCarte==2 && recherch.get(i).typeCarte==sType){
                    joue=true;
                    break;
                }
            }
            
            if(!joue){
                PR.prend();
                prener=true;
                paintPanel();
                tourpc();
                paintPanel();
            }
       }
        
        if(sNumero==2){
            for(int i=0; i<recherch.size(); i++){
                if(recherch.get(i).numCarte==2){
                    joue=true;
                    break;
                }
            if(recherch.get(i).numCarte==1 && recherch.get(i).typeCarte==sType){
                joue=true;
                break;
           }
        }
            
            if(!joue){
                PR.prend();
                PR.prend();
                prener=true;
                paintPanel();
                tourpc();
                paintPanel();
            }
        }
    }      
//creation des evenement de packet
  
    T.packets.get(T.packets.size()-1).addActionListener(new ActionListener(){
    @Override
        public void actionPerformed(ActionEvent e) {
        
        PR.prend();
        pan1.remove(PR.carteJoueur.get(PR.carteJoueur.size()-1));
        PR.carteJoueur.get(PR.carteJoueur.size()-1).removeActionListener(this);
        tourpc();
        paintPanel();
    }});

// ajouter l'action au carte d'utilisateur
    for(ii=0; ii<PR.carteJoueur.size(); ii++){

        PR.carteJoueur.get(ii).addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //PR.deposer(ii);
                    for(int i=0; i<recherch.size(); i++){
                        if ((Cartes) e.getSource()==recherch.get(i) ){
                            for(int j=0; j<PR.carteJoueur.size(); j++){
                                if ((Cartes) e.getSource()==PR.carteJoueur.get(j) ){
                                    T.carteTable.add(PR.carteJoueur.get(j));
                                    panPR.remove(PR.carteJoueur.get(j));
                                    PR.carteJoueur.remove(PR.carteJoueur.get(j));
                           
                                    tourpc();
                                    paintPanel();
                                }
                            }
                        }
                    }
            }
        });
    }
}
    
    //le tour du systeme PC
    void tourpc(){

        boolean jou=PC.jouer(T.carteTable.get(T.carteTable.size()-1).typeCarte,T.carteTable.get(T.carteTable.size()-1).numCarte,prener);
        if(jou){
            panPC.remove(T.carteTable.get(T.carteTable.size()-1));
        }else{
            prener=true;
        }
        tourjr();
        paintPanel();
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
         paintPanel();
    }
   
public void paintPanel(){
    //creation des element de l'interface
    FlowLayout f=new FlowLayout();
    setLayout(f);

//le packet
    pan1.add(T.packets.get(T.packets.size()-1));
// interface du jeu
    GridLayout LJ=new GridLayout(3,1);
    pan2.setLayout(LJ);
    pan2.add(panPC);
    pan2.add(panT);
    pan2.add(panPR);
    
    for(int i=0; i<PC.carteJoueur.size(); i++){
        panPC.add(PC.carteJoueur.get(i));
    }

    panT.add(LCartTable);
    LCartTable.setIcon(T.carteTable.get(T.carteTable.size()-1).imgFace);
    for(int i=0; i<PR.carteJoueur.size(); i++){
        panPR.add(PR.carteJoueur.get(i));
        PR.carteJoueur.get(i).aficheface();
    }
// inteface de choix
    GridLayout LC=new GridLayout(4,1);
    pan3.setLayout(LC);
    pan3.add(C1);
    pan3.add(C2);
    pan3.add(C3);
    pan3.add(C4);
    C1.aficheface();
    C2.aficheface();
    C3.aficheface();
    C4.aficheface();
    add(pan1);
    add(pan2);
    add(pan3);
    repaint();
}

    

}


