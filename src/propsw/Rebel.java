/*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */


package propsw;

import java.util.ArrayList;

public class Rebel {
	
	//Contador que s'utilitza per assignar una id al rebel
	private static Integer cont = 0;
	
	//Id del rebel
	private String id;
	
	//Nom del rebel
	private String nom;
	
	//ArrayList amb les ids dels exodes als quals ha participat el rebel
	private ArrayList<String> exodes;
	
	/**
	 * Funcio privada que s'encarrega de verificar si el rebel ha participat a l'exode
	 * @param idEx Id del exode a consultar
	 * @return Retorna true si el rebel ha participat a l'exode, false altrament
	 */
	private boolean checkIdEx(String idEx){
		if (exodes.contains(idEx))  return true;
		else return false;
	}
	
	/**
	 * Classe constructora del rebel
	 */
	public Rebel(){
		++cont;
		this.id = cont.toString();
		this.exodes = new ArrayList<String>();
		this.nom = null;
	}
	
	/**
	 * Classe constructora del rebel, al qual se li assigna el nom passat per parametre
	 * @param nom Nom a assignar al rebel
	 */
	public Rebel(String nom){
		++cont;
		this.id = cont.toString();
		this.nom = nom;
		this.exodes = new ArrayList<String>();
	}
	
	/**
	 * Consulta l'id del rebel
	 * @return Retorna l'id del rebel 
	 */
	public String getId(){
		return this.id;
	}
	
	/**
	 * Consulta el nom del rebel
	 * @return Retorna el nom del rebel
	 */
	public String getNom(){
		return this.nom;
	}
	 
	/**
	 * Consulta el ArrayList amb les ids dels exodes als quals ha participat el rebel
	 * @return ArrayList<String> amb les ids dels rebels
	 */
	public ArrayList<String> getExodes(){
		return this.exodes;
	}
	
	/**
	 * Canvia el nom del rebel
	 * @param nom Nom a associar al rebel
	 * @return true despres d'associarlo
	 */
	public boolean setNom(String nom){
		this.nom = nom;
		return true;
	}
	
	/**
	 * Inserta un exode al ArrayList del rebel
	 * @param id Id de l'exode al qual ha participat el rebel
	 * @return true si s'ha pogut insertar l'exode, false altrament
	 */
	public boolean insertarExode(String id){
		if (checkIdEx(id) == false){
			System.out.println("Insertat exode: " + id);
			this.exodes.add(id);
			return true;
		}
		else return false;
	}
	
	/**
	 * Esborra el exode del rebel
	 * @param id Id de l'exode a esborrar
	 * @return Retorna true si s'ha esborrat el exode, false altrament
	 */
	public boolean esborrarExode(String id){
		if (checkIdEx(id)){
			this.exodes.remove(id);
			return true;
		}
		else return false;
	}	
	
	/**
	 * Prepara un string amb la id i el nom del rebel
	 * @return String amb la id i el nom del rebel
	 */
	@Override
	public String toString() {
		return id+"\t-\t"+nom;
	}
}