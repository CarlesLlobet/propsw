//@Author: Marcos Pérez
package propsw;

import java.util.ArrayList;

public class Rebel {
	private static Integer cont = 0;
	private String id;
	private String nom;
	private ArrayList<String> exodes;
	
	private boolean checkIdEx(String idEx){
		//retorna true si es pot insertar, si no false
		//Els ids dels exodes sera unics, per a la prova del RebelDriver s'ha afegit aquest metode
		//per a comprovar aquesta unicitat
		if (exodes.contains(idEx)) return false;
		else return true;
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
		if (checkIdEx(id)){
			this.exodes.add(id);
			return true;
		}
		else return false;
	}
	
	
	
}