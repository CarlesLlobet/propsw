/*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */

package propsw;

import java.io.Serializable;
import java.util.HashMap;

public class Capita implements Serializable{
	//Contador que s'utiltiza per assignar la id al capita
	private static Integer cont = 0;
	
	//Id del capita
	private String id;
	
	//contrasenya del capità
	private String pass = "admin";
	
	//Galaxia del capità
	private Galaxia gal;
	
	//Nom del capità
	private String nom;
	
	//HashMap que conté tots els rebels del capità: idRebel, Rebel
	private HashMap<String,Rebel> ContReb;
	
	/**
	 * Constructor d'un objecte Capita.
	 */
	public Capita(){
		++cont;
		this.id = cont.toString();
		this.nom = "admin";
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia(this);
	}

	/**
	 * Constructor d'un objecte Capita amb el nom
	 * @param nom Nom assignat al capità
	 */
	public Capita(String nom){
		++cont;
		this.id = cont.toString();
		this.nom = nom;
		this.ContReb = new HashMap<String,Rebel>();
		this.gal = new Galaxia(this);
	}

	/**
	 * Canvia la contrasenya del capità
	 * @param pass Contrasenya que s'assigna al capita
	 * @return Retorna true al afegir la contrasenya
	 */
	public boolean setPassword(String pass){
		this.pass = pass;
		return true;
	}
	
	public String getPassword(){
		return pass;
		
	}
	
	/**
	 * Assigna un nom al capità
	 * @param nom Nom que s'assigna al capità
	 * @return Retorna true després d'assignar el nom
	 */
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}

	/**
	 * Substitueix el contenidor de rebels pel que es passa per paràmetre
	 * @param cr Contenidor de rebels que s'assigna al capità
	 * @return Retorna true després d'assignar el contenidor de rebels
	 */
	public boolean setRebels(HashMap<String,Rebel> cr){
		this.ContReb = cr;
		return true;
	}

	/**
	 * Assigna una galaxia al capità
	 * @param g Galaxia que s'ha d'assignar al capità
	 * @return Retorna true després d'assignar la galaxia al capita
	 */
	public boolean setGalaxia(Galaxia g){
		this.gal = g;
		return true;
	}
			
	/**
	 * Consulta la id del capità
	 * @return Retorna la id del capità
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Consulta el nom del capità
	 * @return Retorna el nom del capità
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Consulta el contenidor de rebels
	 * @return Retorna el HashMap Contenidor de rebels
	 */
	public HashMap<String,Rebel> getRebels(){
		return this.ContReb;
	}
	
	/**
	 * Consulta la galaxia del capità
	 * @return Retorna la galaxia del capità
	 */
	public Galaxia getGalaxia(){
		return this.gal;
	}
	
	public static void augmentarContador(){
		cont=cont+1;
	}
}
