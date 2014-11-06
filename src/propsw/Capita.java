/*
 * Autor: Marcos Pérez
 * Grup 44 - 9.1
 */

package propsw;

import java.util.HashMap;

public class Capita {

	private String id;
	private String pass = "admin";
	private Galaxia gal; 
	private HashMap<String,Rebels> ContReb; //hashtable?
	
	public Capita(String id){
		//pre: id es únic
		//post: Es crea un capitá per defecte amb id: id i contrasenya: admin 
		this.id = id;
	}
	public String get_id(){
		//pre: 
		//post: es retorna l'id del capita
		return this.id;
	}
	
	public boolean set_password(String pass){
		//pre: 
		//post: La contrasenya associada al capità s'ha canviat al valor de pass
		this.pass = pass;
	}
	
	public HashMap<String,Rebels> get_rebels(){
		//pre:
		//post: Es retorna el hashmap ContReb
	}
	
	public boolean set_rebels(HashMap<String,Rebels> cr){
		//pre: Les dades a cr són consistents amb les que hi ha a ContReb
		//post: cr s'inserta a ContReb
	}
	
	public Galaxia get_galaxia(){
		//pre:
		//post: Es retorna la galaxia 
	}
	
	public boolean set_galaxia(Galaxia g){
		//pre:
		//post: Es sobreescriu gal amb g
		
	}
	
}
