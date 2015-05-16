
package jeux;

import java.util.ArrayList;


public class Joueur {
    
    String nomJoueur;
    ArrayList <Cartes> carteJoueur;
    Table table;
    Distributeur distributeur;

    Joueur(String nomJoueur,Table T,Distributeur dist){
        this.nomJoueur=nomJoueur;
        this.table=T;
        this.distributeur=dist;
        carteJoueur=new ArrayList <Cartes> ();
    }
    Joueur(){}
    // ajoueter la carte de l'indice ind au carte table
    void deposer(int ind){

        table.carteTable.add(carteJoueur.get(ind));
        carteJoueur.remove(ind);
    }
    
    /*supprimer la dernier carte du packets 
     ajouter la carte supprimer au carte joueur */
    void prend(){
        if(table.packets.size()==0){
            distributeur.ramasser();}
        
        carteJoueur.add(table.packets.get(table.packets.size()-1));
        table.packets.remove(table.packets.size()-1);
    }
    
    //retourne un tableau qui contient les cartes autoriser au joueur 
    ArrayList <Cartes> recherche(int numero, String type){
        
        ArrayList <Cartes> listChoix =new ArrayList <Cartes> ();
        
        for(int i=0; i<carteJoueur.size(); i++){
            if(numero == carteJoueur.get(i).numCarte){
                listChoix.add(carteJoueur.get(i));
            }
            if(type == carteJoueur.get(i).typeCarte){
                
                    listChoix.add(carteJoueur.get(i));
            } 
        }
        return listChoix;
    }
    //retourne la mellieur carte  selon le nombre et le type du carte_table
    Cartes choix(int numero, String type){
        ArrayList <Cartes> listChoix=recherche(numero,type) ;
        ArrayList <Cartes> listNum =new ArrayList <Cartes> ();
        ArrayList <Cartes> listTp =new ArrayList <Cartes> ();
        Cartes cChoix=new Cartes();
        cChoix.numCarte=0;
       
        
        
        for(int i=0; i<listChoix.size(); i++){
            if(listChoix.get(i).numCarte==numero){
                listNum.add(listChoix.get(i));
                
            }
            else{
                
                listTp.add(listChoix.get(i));
            }
        }
        //
        if(listNum.size()==0){
             if(listTp.size()!=0){
            for(int i=0; i<listTp.size(); i++){
                if(listTp.get(i).numCarte==10){
                    cChoix=listTp.get(i);
                    break;
                }
            }    
            if(cChoix.numCarte!=10){
                if(listTp.get(0).numCarte!=7 || listTp.size()==1)
                    cChoix=listTp.get(0);
                else
                    cChoix=listTp.get(1);
            }
             }
             else{
             System.out.println("aucun cartes a jouer");
             }
        }
        else{
            int maxTp=0;
            int nbr;
            for(int i=0; i<listNum.size(); i++){
                nbr=0;
                for(int j=0; j<carteJoueur.size(); j++){
                    if(listNum.get(i).typeCarte==carteJoueur.get(j).typeCarte)
                        nbr++;
                }
                if(nbr>=maxTp){
                    maxTp=nbr;
                    if(maxTp<listTp.size()){
                        for(int k=0; k<listTp.size(); k++){
                            if(listTp.get(k).numCarte==10){
                            cChoix=listNum.get(k);
                            break;
                            }
                        }    
                        if(cChoix.numCarte!=10){
                            if(listTp.get(0).numCarte!=7 || listTp.size()==1)
                                cChoix=listNum.get(0);
                            else
                                cChoix=listNum.get(1);
                        }
                    }
                    else   
                        cChoix=listNum.get(i);
                }
            }
        }
        
        return cChoix;
    }                 
       //cette  methode return true si le joueur poser une carte et false sinom
    boolean jouer(String sType,int sNumero,boolean prener){
        boolean jou=false;
         //liste des joueur apres la methode
        ArrayList <Cartes> R=recherche(sNumero,sType);
    if(!prener){
       if(sNumero!=1 && sNumero!=2){
            if(R.size()==0){
                prend();
                System.out.println("joueur prend");
            }
            else{
                deposer(carteJoueur.indexOf(choix(sNumero,sType)));
                System.out.println("joueur depôser");
                jou=true;
            }
       }
       else{
       if(sNumero==1){
       for(int i=0; i<R.size(); i++){
           if(R.get(i).numCarte==1){
           deposer(carteJoueur.indexOf(R.get(i)));
           jou=true;
           break;
           }
           if(R.get(i).numCarte==2 && R.get(i).typeCarte==sType){
           deposer(carteJoueur.indexOf(R.get(i)));
           jou=true;
           break;
           }
        }
       if(!jou){
       prend();
       }
       }
       if(sNumero==2){
       for(int i=0; i<R.size(); i++){
           if(R.get(i).numCarte==2){
           deposer(carteJoueur.indexOf(R.get(i)));
           jou=true;
           break;
           }
           if(R.get(i).numCarte==1 && R.get(i).typeCarte==sType){
           deposer(carteJoueur.indexOf(R.get(i)));
           jou=true;
           break;
           }
        }
       if(!jou){
            prend();
            prend();
            
            }
       }
       
       }
    }else{
                if(R.size()==0){
                prend();
                System.out.println("joueur prend");
            }
            else{
                deposer(carteJoueur.indexOf(choix(sNumero,sType)));
                System.out.println("joueur depôser");
                jou=true;
            }
    }
        
        
        
        
       return jou;
    }


}

        

    
    
    
