/*
 * Autor: Marcos Pérez
 * Grup 44 - 9.1
 */

package propsw;

import java.util.ArrayList;
import java.util.HashMap;

public class Galaxia extends Graf<Base>{
	private static Integer cont = 0;
	private String id;
	
	private HashMap<String,Exode> exodes;
	private HashMap<Integer,Base> bases;
	private Capita capita;
	
	//Constructor inicialitza les variables buides	
		public Galaxia(Capita c){
			++cont;
			this.id = cont.toString();
			this.exodes = new HashMap<String,Exode>();
			this.bases = new HashMap<Integer,Base>();
			capita = c;
			
		}
	
		public Capita getCapita() {
			return capita;
		}

		public void setCapita(Capita capita) {
			this.capita = capita;
		}

		public String getId(){
			return this.id;
		}

		//Retorna el MaxFlow en el graph actual de bases de la Galaxia. 
		//Se li passa per parametre l'objecte èxode al cual se li assignará 
		//el fluxe.
		public int getMaxFlow(Exode e) {
			//aqui s'ha de cridar: e.getMaxFlow ja que exode conte la classe FF
			return e.getFlow();
		}
		
		//Mètodes de control de les coleccions

		
		//Afegeix un èxode a la galaxia
		public boolean addExode(Exode e){
			this.exodes.put(e.getIdExode(), e);
			return true;
			//operacio getId() a la classe exode
		}
		
		//Retorna un èxode abans guardat en la galaxia que té assignat el ID en especial
		public Exode getExode(String s) {
			return this.exodes.get(s);
		}

		//Elimina un èxode abans guardat en la galaxia que té assignat el ID en especial. Retorna el Exode eliminat
		public Exode removeExode(String s) {
			Exode e = this.exodes.get(s);
			this.exodes.remove(s);
			return e;
		}
		
		//Afegeix una Base a la galaxia
		public boolean addBase(Base e){
			this.bases.put(e.getId(),e);
			return true;
		}
		
		//Retorna una Base abans guardada en la galaxia que té assignada el ID en especial
		public Base getBase(String s){
			return this.bases.get(s);
		}

		//Elimina una Base abans guardat en la galaxia que té assignat el ID en especial. Retorna la Base eliminada
		public Base removeBase(String s){
			Base b = this.bases.get(s);
			this.bases.remove(s);
			return b;
		}

		public HashMap<String,Exode> getExodesHash(){
			return this.exodes;
		}
		
		public HashMap<Integer,Base> getBaseHash(){
			return this.bases;
		}
		
		public ArrayList<String> getExodes(){
			return new ArrayList<String>(exodes.keySet());
		}
		

}