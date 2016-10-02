package Extraction;

import javax.swing.AbstractListModel;

/**
 * <b>LignesChoisiesAdapter est la classe qui permet de construire un modele de liste.</b>
 * <p>Elle herite de AbstractListModel et implemente l'interface Vue</p>
 * 
 * @author AntoineCourtil
 * @version 1.0
 */

public class LignesChoisiesAdapter extends AbstractListModel<String> implements Vue {
	/**
     * L'application d'extraction avec ses methodes
     */
	private Extraction appli;
	
	/**
     * <b>Constructeur LignesChoisiesAdapter</b>
     * <p>Permet d'initialiser l'application</p>
    */	
	public LignesChoisiesAdapter(Extraction e){
		this.appli=e;
	}	
	
	/**
     * Renvoie l'element a l'index specifie
     * 
     * @param index
     *            L'index de la ligne a renvoyer.
     */    
    public String getElementAt(int index) {
		return this.appli.getElementListeChoisieAt(index);
	}

    /**
     * Renvoie le nombre de lignes extraites
    */    
    public int getSize() {
		return this.appli.getSizeListeChoisies();
	}

    /**
     * Met a jour le contenu de la liste
    */    
    public void mettreAJour() {
		fireContentsChanged(this, 0, this.getSize());
	}
}
