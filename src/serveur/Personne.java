package serveur;

import java.io.Serializable;
import java.util.ArrayList;

public class Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1208899971439424986L;

	private String nom;

	private ArrayList<String> surnoms = new ArrayList<String>();;

	public Personne() {
		this.setNom("");
		this.setSurnoms(null);
	}

	public Personne(String n, ArrayList<String> s) {
		this.setNom(n);
		this.setSurnoms(s);
	}

	/**
	 * @param nouveauSurnom
	 *            the surnom to add
	 */
	public void addSurnom(String nouveauSurnom) {
		surnoms.add(nouveauSurnom);
	}

	/**
	 * @return the surnoms
	 */
	public ArrayList<String> getSurnoms() {
		return surnoms;
	}

	/**
	 * @param surnoms
	 *            the surnoms to set
	 */
	public void setSurnoms(ArrayList<String> surnoms) {
		this.surnoms = surnoms;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
