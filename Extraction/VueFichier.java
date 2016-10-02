package Extraction;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * <b>VueFichier est la classe qui permet de creer l'affichage des lignes du fichier ouvert.</b>
 * 
 * @author AntoineCourtil
 * @version 1.0
 */

public class VueFichier extends JPanel implements Vue {
	/**
     * L'application d'extraction avec ses methodes
     */
	Extraction appli;
	
	/**
     * La liste affichant les lignes
     */
	private JList<String> liste;
	
	/**
     * Le modele de donnees de la liste contenant les lignes
     */
	private LignesFichierAdapter model;
	
	/**
     * <b>Constructeur VueFichiers</b>
     * <p>Permet d'initialiser :
     * <ul><li>L'application</li>
     * <li>Le modele de donnees de laliste</li>
     * <li>La liste en elle-meme</li>
     * <li>Avec son ListSelectionListener</li>
     * <li>Et d'en creer le JPanel</li>
     * <li>Avec sa bordure</li>
     * <li>Et de l'ajouter a la liste de vue de l'application</li>
     * </ul></p>
    */	
	public VueFichier(Extraction e){
		super();
		e.ajouterVue(this);
		this.setPreferredSize(new Dimension(250,400));
		
		this.appli=e;
		
		this.liste = new JList<String>();
		this.liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.liste.setLayoutOrientation(JList.VERTICAL);
		
		this.model = new LignesFichierAdapter(this.appli);
		
		this.liste.setModel(this.model);
		
		JScrollPane scrollPane = new JScrollPane(this.liste);
		Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
		scrollPane.setBorder(emptyBorder);
		this.add(scrollPane);
		
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.add(Box.createVerticalGlue());
		this.setLayout(new BorderLayout());		
		scrollPane.setBackground(Color.white);
		
		this.add(scrollPane, BorderLayout.CENTER);
		
		Border greyline = BorderFactory.createLineBorder(Color.gray);		
		TitledBorder title;
		title = BorderFactory.createTitledBorder(greyline, "Elements possibles");
		this.setBorder(title);
		

		this.liste.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				appli.setLigneFichierSelected(liste.getSelectedIndex());
			}
		});
	}

	/**
     * Appel ici la fonction mettreAJour() du modele de donnees de la liste
     */    
    public void mettreAJour() {
		this.model.mettreAJour();
	}
}
