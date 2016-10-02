package Extraction;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * <b>Extraction est la classe recensant toutes les methodes.</b>
 *  
 * @author AntoineCourtil
 * @version 1.0
 */

public class Extraction {
	/**
     * L'ArrayList regroupant l'ensemble des vues.
     */
	private ArrayList<Vue> alv;
	
	/**
     * L'objet qui recense les lignes du fichier ouvert
     */
	private LignesFichier listeFichier;
	
	/**
     * L'objet qui recenses les lignes extraites
     */
	private LignesChoisies listeChoisie;
	
	/**
     * L'index de la ligne actuellement selectionne du fichier ouvert
     */
	private int ligneFichierSelected;
	
	/**
     * L'index de la ligne actuellement selectionnee des lignes extraites
     */
	private int ligneChoisieSelected;
	
	/**
     * Le nom du fichier actuellement ouvert
     */
	private String fichierCourant;
	
	/**
     * Le chemin absolu du fichier actuellement ouvert
     */
	private String cheminCourant;
	
	
	/**
     * <b>Constructeur Extraction</b>
     * <p>Permet d'initialiser a vide la liste de vue, les lignes du fichier, les lignes extraites, les index des lignes selectionnees, le nom et le chemin du fichier courant</p>
    */
	public Extraction(){
		this.alv = new ArrayList<Vue>();
		
		this.listeFichier = new LignesFichier(this);
		this.listeChoisie = new LignesChoisies(this);

		this.ligneFichierSelected=-1;
		this.ligneChoisieSelected=-1;
		this.fichierCourant="";
		this.cheminCourant="";
	}
	
	//--------------------------------- VUES -------------------------------
	
	/**
     * Ajoute une vue a la liste des vues existantes
     * 
     * @param v
     *            La vue a ajouter.
     */
    
    public void ajouterVue(Vue v){
		this.alv.add(v);
	}

    /**
     * Sert a mettre a jour l'ensemble des vues
     * 
     */
    
    public void mettreAJour(){
		for(Vue v:this.alv){
			v.mettreAJour();
		}
	} 
	
	//--------------------------------- SETTER -------------------------------

    /**
     * Initialise l'objet contenant toutes les lignes du fichier ouvert
     * 
     * @param l
     *            La nouvelle instance de l'objet.
     */
    
    public void setListeFichier(LignesFichier l){
		this.listeFichier=l;
	}
	
    /**
     * Initialise l'objet contenant toutes les lignes selectionnees
     * 
     * @param l
     *            La nouvelle instance de l'objet.
     */
    
    public void setListeChoisies(LignesChoisies l){
		this.listeChoisie=l;
	}

    /**
     * Initialise l'index de la ligne selectionnee dans la liste du fichier ouvert
     * 
     * @param index
     *            La valeur de l'index.
     */
    
    public void setLigneFichierSelected(int index){
		this.ligneFichierSelected=index;
	}
	
    /**
     * Initialise l'index de la ligne selectionnee dans la liste des lignes selectionnees
     * 
     * @param index
     *            La valeur de l'index.
     */
    
    public void setLigneChoisieSelected(int index){
		this.ligneChoisieSelected=index;
	}
	
	//--------------------------------- GETTER -------------------------------

    /**
     * Recupere la ligne en fonction de son index
     * 
     * @param index
     *            La valeur de l'index.
     */
    
    public String getElementListeFichierAt(int index){
		return this.listeFichier.get(index);
	}
	
    /**
     * Recupere la taille de la liste du fichier ouvert
     * 
     */
    
    public int getSizeListeFichier(){
		return this.listeFichier.size();
	}
	
	/**
     * Recupere la ligne en fonction de son index
     * 
     * @param index
     *            La valeur de l'index.
     */
    
    public String getElementListeChoisieAt(int index){
		return this.listeChoisie.get(index);
	}
	
    /**
     * Recupere la taille de la liste des lignes selectionnees
     * 
     */
    
    public int getSizeListeChoisies(){
		return this.listeChoisie.size();
	}
	
    /**
     * Recupere la ligne du fichier ouvert actuellement selectionnee
     * 
     */
    
    public String getLigneFichierSelected(){
		if(this.ligneFichierSelected>=0 && this.ligneFichierSelected<this.listeFichier.size()) return this.getElementListeFichierAt(this.ligneFichierSelected);
		return "";
	}
	
    /**
     * Recupere la ligne extraite actuellement selectionnee
     * 
     */
    
    public String getLigneChoisieSelected(){
		if(this.ligneChoisieSelected>=0 && this.ligneChoisieSelected<this.listeChoisie.size()) return this.getElementListeChoisieAt(this.ligneChoisieSelected);
		return "";
	}
	
	//--------------------------------- ADDER -------------------------------

    /**
     * Ajoute a la liste des lignes extraites la ligne actuellement selectionne dans la liste du fichier ouvert
     * Puis met a jour les vues
     * 
     */
    
    public void addLigneChoisie(){
		if(this.ligneFichierSelected>=0 && this.ligneFichierSelected<this.listeFichier.size()){
			this.listeChoisie.add(this.getLigneFichierSelected());
			this.listeFichier.remove(this.ligneFichierSelected);
		}
		this.mettreAJour();
	}
	
	//--------------------------------- REMOVER -------------------------------

    /**
     * Supprime la ligne actuellement selectionne dans la liste des lignes extraites
     * Puis met a jour les vues
     * 
     */
    
    public void removeLigneChoisie(){
		if(this.ligneChoisieSelected>=0 && this.ligneChoisieSelected<this.listeChoisie.size()){
			this.listeFichier.add(this.getLigneChoisieSelected());
			this.listeChoisie.remove(this.ligneChoisieSelected);
		}
		this.mettreAJour();
	}
	
	//---------------------------- CHOISIR FICHIER --------------------------
	
    /**
     * Permet de selectionner un fichier dans l'explorateur pour le lire
     * 
     */
    
    public void ouvrir(){
    	JFileChooser explorer = new JFileChooser();
    	explorer.setCurrentDirectory(new File("."));
    	explorer.setDialogTitle("Ouvrir un fichier txt");
    	 
    	String ouvrir = new String("Ouvrir");
    	int resultatEnregistrer = explorer.showDialog(explorer, ouvrir); 
    	if (resultatEnregistrer == JFileChooser.APPROVE_OPTION){
    	    String fichier = explorer.getSelectedFile().getAbsolutePath();
    	    
    	    if (fichier.lastIndexOf(".") > 0) {
    	    	String extension=fichier.substring(fichier.lastIndexOf("."));
    	    	if(extension.equals(".txt")){
    	    		this.cheminCourant=explorer.getSelectedFile().getAbsolutePath();
    	    		this.fichierCourant=fichier;
    	    		this.lire(fichier);
    	    	}
    	    }
    	}
    }
    
    /**
     * Lit un fichier specifique en fonction de son chemin
     * Puis initialise la liste en fonction de ses lignes
     * 
     */
    
    public void lire(String fichier){
    	FileReader flot ;
    	BufferedReader flotFiltre ;
    	LignesFichier liste = new LignesFichier(this);
    	try {
	    	flot = new FileReader(fichier) ;
	    	flotFiltre = new BufferedReader(flot) ;
	    	
	    	String ligne = flotFiltre.readLine() ;	    	
	    	
	    	while (ligne != null) {
	    		liste.add(ligne);
		    	ligne = flotFiltre.readLine() ;
	    	}
	    	
	    	this.setListeFichier(liste);
	    	this.mettreAJour();
    	}
    	catch (IOException e){}
    }
	
	//--------------------------------- ECRIRE -------------------------------

    /**
     * Permet de reecrire le fichier actuellement ouvert avec les lignes qui ne lui ont pas ete extraites
     * Actuellement non utilisee
     * 
     */
    
    public void ecrireFichier(){
    	File f = new File (this.cheminCourant);
    	
    	try
    	{
    	    FileWriter fw = new FileWriter (f);

    	    for(String ligne: this.listeFichier){
        		fw.write(ligne);
    	        fw.write ("\r\n");
        	}
    	 
    	    fw.close();
    	}
    	catch (IOException exception)
    	{
    	    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
    	}
    }
    
    /**
     * Permet d'ecrire un nouveau fichier avec les lignes qui ont ete extraites
     * 
     */
    
    public void ecrireExtract(){
    	File f = new File (this.cheminCourant+".extract");
    	
    	try
    	{
    	    FileWriter fw = new FileWriter (f);

    	    for(String ligne: this.listeChoisie){
        		fw.write(ligne);
    	        fw.write ("\r\n");
        	}
    	 
    	    fw.close();
    	}
    	catch (IOException exception)
    	{
    	    System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
    	}
    }
	
	//--------------------------------- ANNULER -------------------------------
	
    /**
     * Efface les lignes extraites et reinitialise la liste des lignes du fichier ouvert en le relisant
     * 
     */
    
    public void annuler(){
		this.lire(this.fichierCourant);
		this.listeChoisie = new LignesChoisies(this);
		this.mettreAJour();
	}
	
	//--------------------------------- VALIDER -------------------------------
	
    /**
     * Appel la fonction d'ecriture
     * 
     */
    
    public void valider(){
		//this.ecrireFichier();
		this.ecrireExtract();
	}
	
	
	
}
