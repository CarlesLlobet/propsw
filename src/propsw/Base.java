/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

public class Base {
	
	//Paràmetres privats
	private int id;
	private String nom;
	
	//Constructors
	public Base(){
		id=-1;
		nom=null;
	}
	
	public Base(int id,String nom){
		this.id=id;
		this.nom=nom;
	}
	/*
	//Getters
	public Integer getBaseId(){
		return this.id;
	}
	
	//Setters
	public boolean setBaseId(int nouId){
		 
		this.id=nouId;
		return true;
	}
	
	public void setBaseNom(String nouNom){
		nom=nouNom;
	}*/

}
