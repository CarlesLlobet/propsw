//@author: Marcos Pérez
package propsw;

import java.util.HashMap;

public class Galaxia extends Graf<Base>{
	private static Integer cont = 0;
	private String id;
	
	private HashMap<String,Exode> exodes;
	private HashMap<Integer,Base> bases;
	
	//Constructor inicialitza les variables buides	
		public Galaxia(){
			++cont;
			this.id = cont.toString();
			this.exodes = new HashMap<String,Exode>();
			this.bases = new HashMap<Integer,Base>();
			
		}
	
		public String getId(){
			return this.id;
		}
		
		//Constructor inicialitza les variables desde un String (Fitxer de text)
		public Galaxia(String s){
			
		}
		
		
		//Retorna el MaxFlow en el graph actual de bases de la Galaxia. 
		//Se li passa per parametre l'objecte èxode al cual se li assignará 
		//el fluxe.
		public int getMaxFlow(Exode e) {
			//aqui s'ha de cridar: e.getMaxFlow ja que exode conte la classe FF
		}
		
		
		//Mètodes de control de les coleccions
		
		//Afegeix un èxode a la galaxia
		public boolean addExode(Exode e){
			this.exodes.put(e.getId(), e)
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

		
		//Adaptar mètodes de la classe graph per el nostre ús. (Classe template <T> serà classe Base)
		public void afegirBase( Base node ){
			afegirNode(node);
		};
		
		public void substituirBase (Integer id, Base node){
			substituirNode(id,node);
		};
		
		public Integer getNodeBaseId( Base node ){
			return getNodeId(node);
		};
		
		public Base getNodeBase(Integer id){
			return getNode(id);
		};

}