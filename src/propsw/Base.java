/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;

public class Base {
	
	//Paràmetres privats

	private String nom;
	
	//Constructors
	public Base(Galaxia g) throws IOException{
		nom= null;
		g.afegirNode(this);
	}
	
	public Base(String nom, Galaxia g) throws IOException{
		this.nom = nom;
		g.afegirNode(this);
	}
	
	public String getNom(){
		return this.nom;
	}
	
	//Setters
	public boolean setNom(String nom){
		this.nom=nom;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub+
		return nom;
	}
	
	
}
