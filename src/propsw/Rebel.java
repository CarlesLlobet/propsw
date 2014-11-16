/*
 * Autor: Marcos Pérez
 * Grup 44 - 9.1
 */

package propsw;

import java.util.ArrayList;

public class Rebel {
	

	private static Integer cont = 0;
	private String id;
	private String nom;
	private ArrayList<String> exodes;
	
	private boolean checkIdEx(String idEx){
		//retorna true si existeix un exode a l'arraylist, false altrament
		if (exodes.contains(idEx))  return true;
		else return false;
	}
	
	
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
	
	public ArrayList<String> getExodes(){
		return this.exodes;
	}
	
	//SETTERS
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}
	
	public boolean insertarExode(String id){
		if (checkIdEx(id) == false){
			System.out.println("Insertat exode: " + id);
			this.exodes.add(id);
			return true;
		}
		else return false;
	}
	
	public boolean esborrarExode(String id){
		if (checkIdEx(id)){
			this.exodes.remove(id);
			return true;
		}
		else return false;
	}	
	
	@Override
	public String toString() {

		return id+"\t-\t"+nom;
	}
}