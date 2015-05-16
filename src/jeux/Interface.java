/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeux;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author 
 */
public class Interface extends JFrame implements ActionListener{
    
        private final JMenuBar menuBar = new JMenuBar();
	private final JMenu fichierMenu = new JMenu();
	private final JMenuItem JouerMenu = new JMenuItem();
	private final JMenuItem RetourMenu = new JMenuItem();
	private final JMenuItem quitterMenu = new JMenuItem();
	
	private final JMenu     AideMenu = new JMenu();
	private final JMenuItem RegleJeux = new JMenuItem();
        
        private   InterfacePanel panneau =null;
        
        private JTabbedPane jTabbedPane=null;
       
        JPanel panel=new JPanel();
        
        public Interface() {
            super();
       	    setBounds(150, 100,1000,600);
	    setTitle("Jekxckxk ");
	
            jTabbedPane=new JTabbedPane();
	
            jTabbedPane.add("Accueil",panel);	
	    getContentPane().add(jTabbedPane);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    
             try {
		creerMenu();
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
        private void creerMenu() throws Exception {

		// construction du menu
		setJMenuBar(menuBar);	
		menuBar.add(fichierMenu);
		fichierMenu.setText("Fichier");
		fichierMenu.add(JouerMenu);
		JouerMenu.addActionListener((ActionListener) this);
		JouerMenu.setText("Jouer");
		fichierMenu.addSeparator();

		
		fichierMenu.add(quitterMenu);
		quitterMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//quitter();
				
			}
		});
		quitterMenu.setText("Quitter");
		
		menuBar.add(AideMenu);
		AideMenu.setText("Aide");
		AideMenu.add(RegleJeux);
		RegleJeux.setText("Régle du jeux");
		RegleJeux.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//regle de jeu
			}
		});
}
        public void actionPerformed(ActionEvent cliqueMenu) {
		if (cliqueMenu.getSource().equals(JouerMenu)){    
                    
                    panneau=new InterfacePanel();
                    jTabbedPane.add("jeu",panneau);
	            jTabbedPane.setSelectedComponent(panneau);
	            getContentPane().add(jTabbedPane);
                }
        }

        public static void main(String args[]){
		try {
		    Interface frame = new Interface();
	            frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
