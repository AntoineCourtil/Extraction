package Extraction;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * <b>VueBoutons est la classe qui permet de creer l'interface des boutons.</b>
 * 
 * @author AntoineCourtil
 * @version 1.0
 */

public class VueBoutons extends JPanel implements Vue{
	/**
     * L'application d'extraction avec ses methodes
     */
	Extraction appli;
	
	/**
     * Le bouton "Fleche droite"
     */
	JButton droite;
	
	/**
     * Le bouton "Fleche gauche"
     */
	JButton gauche;
	
	/**
     * Le bouton "Choisir un fichier"
     */
	JButton choixFichier;
	
	/**
     * Le bouton "Valider"
     */
	JButton valider;
	
	/**
     * Le bouton "Annuler"
     */
	JButton annuler;
	
	/**
     * Le JPanel en lui-meme
     * (utile uniquement pour le ShowMessageDialog dans un ActionListener)
     */
	JPanel panel;
	
	/**
     * <b>Constructeur VueBoutons</b>
     * <p>Permet d'initialiser :
     * <ul><li>L'application</li>
     * <li>Les boutons</li>
     * <li>Leurs ActionListener</li>
     * <li>Et d'en creer le JPanel</li>
     * <li>Avec sa bordure</li>
     * <li>Et de l'ajouter a la liste de vue de l'application</li>
     * </ul></p>
    */	
	public VueBoutons(Extraction e){
		super();
		e.ajouterVue(this);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.appli=e;
		this.panel=this;

		this.droite = new JButton(new ImageIcon(getClass().getResource("right.png")));
		this.gauche = new JButton(new ImageIcon(getClass().getResource("left.png")));
		this.choixFichier=new JButton("Choisir un Fichier");
		this.valider=new JButton("Valider");
		this.annuler=new JButton("Annuler");

		this.droite.setAlignmentX(VueBoutons.CENTER_ALIGNMENT);
		this.gauche.setAlignmentX(VueBoutons.CENTER_ALIGNMENT);
		this.choixFichier.setAlignmentX(VueBoutons.CENTER_ALIGNMENT);
		this.valider.setAlignmentX(VueBoutons.CENTER_ALIGNMENT);
		this.annuler.setAlignmentX(VueBoutons.CENTER_ALIGNMENT);
		
		this.add(this.droite);
		this.add(Box.createRigidArea(new Dimension(0,7)));
		this.add(this.gauche);
		this.add(Box.createRigidArea(new Dimension(0,7)));
		this.add(this.choixFichier);
		this.add(Box.createRigidArea(new Dimension(0,7)));
		this.add(this.valider);
		this.add(Box.createRigidArea(new Dimension(0,7)));
		this.add(this.annuler);
		
		Border greyline = BorderFactory.createLineBorder(Color.gray);		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(greyline, "Boutons");
		this.setBorder(title);
		
		
		//---------------------------- ACTIONLISTENER --------------------------------------

		this.choixFichier.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				appli.ouvrir();
			}
		});
		
		this.droite.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				appli.addLigneChoisie();
			}
		});
		
		this.gauche.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				appli.removeLigneChoisie();
			}
		});
		
		this.annuler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				appli.annuler();
			}
		});
		
		this.valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				appli.valider();
				JOptionPane.showMessageDialog(panel,
						"Fichier bien sauvegardé",
						"Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	@Override
	public void mettreAJour() {
		// TODO Auto-generated method stub
		
	}
}
