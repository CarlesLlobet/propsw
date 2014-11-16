/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;

public class Base {
	
	//Paràmetres privats

	private String nom;
	private Galaxia g;
	
	//Constructors
	public Base(Galaxia g) throws IOException{
		nom= null;
		this.g = g;
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
	
	public int getId() throws IOException{
		int toRet=-1;
		for (int i = 0; i < g.getNSize(); i++) {
			if(g.getNode(i)==this){
				toRet = i;
			}
		}
		return toRet;
	}
	
}
