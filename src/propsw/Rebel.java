//@Author: Marcos Pérez
package propsw;

import java.util.ArrayList;

public class Rebel {
	private static Integer cont = 0;
	private String id;
	private String nom;
	private ArrayList<String> exodes;
	
	public Rebel(){
		++cont;
		this.id = cont.toString();
		this.exodes = new ArrayList<String>();
		this.nom = null;
	}
	
	public Rebel(String nom){
		++cont;
		this.id = cont.toString();
		this.nom = nom;
		this.exodes = new ArrayList<String>();
	}
	
	//GETTERS
	public String getId(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public ArrayList<Exode> getExodes(){
		return this.exodes;
	}
	
	//SETTERS
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}
	
	public boolean insertarExode(String id){
		this.exodes.add(id);
		return true;
	}
	
	
	
}