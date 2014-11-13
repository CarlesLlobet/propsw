/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;

public class Base {
	
	//ParÓmetres privats
	private static Integer cont = 0;
	private Integer id;
	private String nom;
	
	//Constructors
	public Base(Galaxia g) throws IOException{
		id=new Integer(cont);
		nom= null;
		g.addBase(this);
		g.afegirNode(this);
		++cont;
	}
	
	public Base(String nom, Galaxia g) throws IOException{
		this.id = new Integer(cont);
		this.nom = nom;
		g.afegirBase(this);
		g.afegirNode(this);
		++cont;
	}
	
	//Getters
	public Integer getId(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	//Setters
	public boolean setNom(String nom){
		this.nom=nom;
		return true;
	}
}
