//Autor: Marcos Pérez
package propsw;

import java.util.ArrayList;

public class CapitaCtrl {
	private ArrayList<Capita> ContCap; //hashtable?
	
	public ArrayList<Capita> get_capitans(){
		//pre:
		//post: Es retorna ContCap
		return this.ContCap;
	}
	
	public void associar_galaxia(int idcap, Galaxia g){
		//pre: idcap es una id valida i g és una galaxia vàlida i les dades son consistents
		//post: g es associada a la galaxia del capita amb id idcap
	}
	
	public void exportar_galaxia(int idcap){
		//pre: idcap es una id valida
		//post:	gal és exportada a un fitxer de text
	}
	
	public void esborrar_galaxia(int idcap){
		//pre: idcap es una id valida
		//post: el contingut de gal és esborrat
	}
	
	public void consultar_galaxia(int idcap){
		//pre: idcap es una id valida
		//post:	es llista tota la informació de la galaxia del capita amb idcap
	}
	
	
	public void afegir_rebel(int idcap, Rebel r){
		//pre: idcap es una id valida i r és un Rebel vàlid
		//post: r és insertat al contenido de rebels del capita amb id idcap
	}
	
	public void esborrar_rebel(int idcap, int idreb){
		//pre: idcap i idreb son ids valides
		//post: r és esborrat del ContReb del capita amb id idcap
	}
	
	public void llistar_rebels(int idcap){
		//pre: 
		//post: Es llisten tots els rebels que estan a ContReb
		
	}
	
	public void importar_rebels(int idcap, ArrayList<Rebels> cr){
		/*pre:  idcap es una id valida
		*		cr és un conjunt de de rebels consistents amb les dades que hi ha a Capita.ContReb
		*		El capita es el que es correspon amb idcap
		*/		
	
		//post: S'inserten a Capita.ContReb els rebels que hi ha cr
	}
	
	public void exportar_rebels(){
		//pre: 
		//post: S'exporten a un arxiu txt totes les dades dels rebels a ContReb
	}	
	
	public void executar_exode(){
		//pre:
		//post:  
	}
	
	public void generar_informe(int idcap){
		//pre: hi ha èxodes per aquell capita i idcap es valid
		//post: es genera un informe amb les dades de la darrera execució de l'èxode per aquell capita
		
	}
	
	public void visualitzar_recorregut(int idcap){
		//pre: idcap es valid i existeix com a minim un èxode i no hi ha cap coll d'ampolla
		//post: es llisten tots els rebels i 
	}

		
}
