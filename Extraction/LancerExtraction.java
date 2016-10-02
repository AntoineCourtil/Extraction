package Extraction;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * <b>LancerExtraction est la classe qui connait l'application ainsi que les vues.</b>
 *  
 * @author AntoineCourtil
 * @version 1.0
 */

public class LancerExtraction extends JFrame {
	/**
     * L'application d'extraction avec ses methodes
     */
	Extraction appli;
	
	/**
     * La Vue qui affichera les lignes du fichier ouvert
     */
	VueFichier vFichier;
	
	/**
     * La Vue qui affichera les lignes selectionnees
     */
	VueSelect vSelect;
	
	/**
     * La Vue qui affiche les boutons et leurs actions
     */
	VueBoutons vBoutons;
	
	
	/**
     * <b>Constructeur LanceurExtraction</b>
     * <p>Permet de creer l'application ainsi que ses vues</p>
     * */
		
	public LancerExtraction(){
		super("Extraction de données");
		
		this.appli=new Extraction();
		this.vFichier = new VueFichier(this.appli);
		this.vBoutons = new VueBoutons(this.appli);
		this.vSelect = new VueSelect(this.appli);

		this.add(this.vFichier,BorderLayout.WEST);
		this.add(this.vBoutons,BorderLayout.CENTER);
		this.add(this.vSelect,BorderLayout.EAST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		pack() ;
		setVisible(true) ;
	}
}
