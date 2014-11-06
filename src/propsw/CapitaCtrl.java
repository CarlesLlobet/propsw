//Autor: Marcos Pérez
package propsw;

import java.util.HashMap;

public class CapitaCtrl {
	
	//Contenidor de capitans
	private HashMap<String,Capita> ContCap;
	
	//id del capita que ha iniciat la sessio
	private String idCap = "";
	
	
	public CapitaCtrl(){
		this.ContCap = new HashMap<String,Capita>();
	}
	
	public void login(int id, String s){
		//pre:
		//post: si id i string son valids: idCap ens indica el capita que ha fet login
	}
	
	public HashMap<String,Capita> get_capitans(){
		//pre:
		//post: Es retorna ContCap
		return this.ContCap;
	}
	
	public boolean afegir_capita(){
		//pre:
		//post: s'ha afegit un nou capita a ContCap
	}
	
	
	public boolean crear_galaxia(){
		//pre: 
		//post: capita.gal = new Galaxia() 
	}
	
	public boolean importar_galaxia(String s){
		//pre: s correspond a l'string d'un fitxer de text amb les dades a inicialitzar
		//post:	s'ha importat 
	}
	
	public boolean exportar_galaxia(){
		//pre: 
		//post:	gal és exportada a un fitxer de text
	}
	
	public boolean esborrar_galaxia(){
		//pre:
		//post: el contingut de capita.gal és esborrat
	}
	
	public void consultar_galaxia(){
		//pre: 
		//post:	es llista tota la informació de la galaxia del capita amb idcap
	}
	
	public void importar_rebels(String s){
		/*pre:  idcap es una id valida
		*		cr és un conjunt de de rebels consistents amb les dades que hi ha a Capita.ContReb
		*		El capita es el que es correspon amb idcap
		*/
	
		//post: S'inserten a Capita.ContReb els rebels que hi ha al fitxer de text
	}
	
	public boolean afegir_rebel(Rebel r){
		//pre: r és un Rebel vàlid
		//post: r és insertat al contenido de rebels del capita amb id idcap
	}
	
	public void esborrar_rebel(String idreb){
		//pre: idreb es ids valides
		//post: r és esborrat del ContReb del capita amb id idcap
	}
	
	public boolean llistar_rebels(){
		//pre: 
		//post: Es llisten tots els rebels que estan a ContReb
		
	}
	
	
	public boolean exportar_rebels(){
		//pre: 
		//post: S'exporten a un arxiu txt totes les dades dels rebels a ContReb
	}	
	
	
	public boolean executar_exode(){
		//pre:
		//post: S'executa un èxode
	}
	
	public boolean generar_informe(){
		//pre: 
		//post: es genera un informe amb les dades de la darrera execució de l'èxode per aquell capita
		
	}
	
	public void visualitzar_recorregut(Rebel r){
		//pre:
		//post: Es mostra la última ruta realitzada per un rebel r
	}
	
}
