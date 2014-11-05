/*
 * Autor: Marcos Pérez
 * Grup 44 - 9.1
 */

package propsw;

import java.util.ArrayList;

public class Capita {

	private int id;
	private String pass = "admin";
	private Galaxia gal; 
	private ArrayList<Rebels> ContReb; //hashtable?
	
	public Capita(int id){
		//pre: id es únic
		//post: Es crea un capitá per defecte amb id: id i contrasenya: admin 
		this.id = id;
	}
	public int get_id(){
		//pre: 
		//post: es retorna l'id del capita
		return this.id;
	}
	
	public void set_password(String pass){
		//pre: 
		//post: La contrasenya associada al capità s'ha canviat al valor de pass
		this.pass = pass;
	}
	
	public ArrayList<Rebels> get_rebels(){
		//pre:
		//post: Es retorna l'ArrayList ContReb
	}
	
	public void set_rebels(ArrayList<Rebels> cr){
		//pre: Les dades a cr són consistents amb les que hi ha a ContReb
		//post: cr s'inserta a ContReb
	}
	
	public Galaxia get_galaxia(){
		//pre:
		//post: Es retorna la galaxia 
	}
	
	public void set_galaxia(Galaxia g){
		//pre:
		//post: Es sobreescriu gal amb g
		
	}
	
}
