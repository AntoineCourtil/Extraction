package Extraction;

import javax.swing.AbstractListModel;

/**
 * <b>LignesFichierAdapter est la classe qui permet de construire un modele de liste.</b>
 * <p>Elle herite de AbstractListModel et implemente l'interface Vue</p>
 * 
 * @author AntoineCourtil
 * @version 1.0
 */

public class LignesFichierAdapter extends AbstractListModel<String> implements Vue {
	/**
     * L'application d'extraction avec ses methodes
     */
	private Extraction appli;
	
	/**
     * <b>Constructeur LignesFichierAdapter</b>
     * <p>Permet d'initialiser l'application</p>
    */	
	public LignesFichierAdapter(Extraction e){
		this.appli=e;
	}	
	
	/**
     * Renvoie l'element a l'index specifie
     * 
     * @param index
     *            L'index de la ligne a renvoyer.
     */    
    public String getElementAt(int index) {
		return this.appli.getElementListeFichierAt(index);
	}

    /**
     * Renvoie le nombre de lignes extraites
    */    
    public int getSize() {
		return this.appli.getSizeListeFichier();
	}

    /**
     * Met a jour le contenu de la liste
    */    
    public void mettreAJour() {
		fireContentsChanged(this, 0, this.getSize());
	}

}
