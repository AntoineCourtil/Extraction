package Extraction;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <b>LignesChoisies est la classe qui recense les lignes extraites.</b>
 * <p>Elle possede plusieurs methodes afin de pouvoir modifier cette liste</p>
 * 
 * @author AntoineCourtil
 * @version 1.0
 */

public class LignesChoisies implements Iterable<String>{
	/**
     * L'application d'extraction avec ses methodes
     */
	Extraction appli;
	
	/**
     * La liste recensant les lignes
     */
	ArrayList<String> als;
	
	/**
     * <b>Constructeur LignesChoisies</b>
     * <p>Permet d'initialiser la liste a vide</p>
    */	
	public LignesChoisies(Extraction e){
		this.appli=e;
		this.als = new ArrayList<String>();
	}
	
	/**
     * Ajoute une ligne a la liste si cette derniere ne la contient deja pas
     * 
     * @param s
     *            La ligne a ajouter.
     */    
    public void add(String s){
		if(!this.als.contains(s)) this.als.add(s);
	}
	
    /**
     * Supprime la ligne d'index specifie
     * 
     * @param index
     *            L'index de la ligne a supprimer.
     */    
    public void remove(int index){
		this.als.remove(index);
	}
	
    /**
     * Renvoie la ligne de l'index donne
     * 
     * @param index
     *            L'index de la ligne voulue.
     */    
    public String get(int index){
		return this.als.get(index);
	}
	
    /**
     * Renvoie la taille de la liste
     * (donc ici le nombre de lignes extraites)
     * 
     */    
    public int size(){
		return this.als.size();
	}

    /**
     * Permet de rendre la classe iterable
     * (ici renvoie l'iterateur de l'ArrayList)
     * 
     */    
    public Iterator<String> iterator() {
		return this.als.iterator();
	}
}
