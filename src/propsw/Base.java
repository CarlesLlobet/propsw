/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;

public class Base {
	
	//Paràmetres privats
	private static Integer cont = 0;
	private Integer id;
	private String nom;
	
	//Constructors
	public Base(Galaxia g) throws IOException{
		
		id=new Integer(cont);
		
		nom= null;
		
		g.afegirBase(this);
		g.afegirNode(this);
		++cont;
	}
	
	public Base(int id,String nom){
		++cont;
		this.id=new Integer(cont);
		this.nom=nom;
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
