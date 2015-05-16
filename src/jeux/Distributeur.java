
package jeux;
import java.util.ArrayList;




public class Distributeur {
    Table table;
    Joueur PC;
    Joueur PR;
    Distributeur(Table table,Joueur PC,Joueur PR){
    this.table=table;
    this.PC=PC;
    this.PR=PR;
    
    }
    
     //melanger les cartes du packets
    void melanger(ArrayList<Cartes> list){
        
        java.util.Collections.shuffle(list);
        
       
    }
    
     // destribuer les Cartes  cartes a chaque joueur
    void destribuer(){
        for(int i=0; i<4; i++){
            PC.carteJoueur.add(table.packets.get(0));
            table.packets.remove(0);
            PR.carteJoueur.add(table.packets.get(0));
            table.packets.remove(0);
        }
        for(int i=0; i<20; i++){
            if(table.packets.get(i).numCarte!=1 && table.packets.get(i).numCarte!=2 
            && table.packets.get(i).numCarte!=7 && table.packets.get(i).numCarte!=10){
                table.carteTable.add(table.packets.get(i));
                table.packets.remove(i);
                break;
            }
        }
    }
    //ramaser les cartes du cartes table lorsque la liste du packets est vide
    void ramasser(){
        table.carteTable.addAll(table.packets);
        table.packets.remove(table.packets.size()-1);
        for(int i=0; i<table.carteTable.size()-1; i++){
            table.carteTable.remove(0);
        }
        
    }
    
    
}
