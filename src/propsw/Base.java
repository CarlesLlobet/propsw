/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */

package propsw;

public class Base {
	
	//Paràmetres privats
	private Integer id;
	private String nom;
	
	//Constructors
	public Base(){
		id=new Integer(-1);
		nom=new String();
	}
	
	public Base(int id,String nom){
		this.id=new Integer(id);
		this.nom=nom;
	}
	
	//Getters
	public Integer getBaseId(){
		return this.id;
	}
	
	//Setters
	public boolean setBaseId(int nouId){
		/*El comprobar si l'id ja existeix s'ha de fer des de la classe Galaxia, 
		 * que tindrà el hashmap amb totes les bases
		 */
		this.id=nouId;
		return true;
	}
	
	public void setBaseNom(String nouNom){
		this.nom=nouNom;
	}

}
