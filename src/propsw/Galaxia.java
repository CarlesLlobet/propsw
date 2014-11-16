/*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Galaxia extends Graf<Base>{

	//Contador que s'utilitza per assignar la id de la galaxia
	private static Integer cont = 0;

	//Id de la galaxia
	private String id;
	
	//HashMap amb tots els exodes que s'han realitzat a la galaxia
	private HashMap<String,Exode> exodes;
	
	//Capita associat a la galaxia
	private Capita capita;
	
	/**
	 * Consulta si hi existeix un exode amb la id del paràmatre
	 * @param id Correspon a la id del exode
	 * @return Retorna true si hi ha un exode amb aquesta id, false altrament
	 */
	private boolean checkExode(String id){
		return exodes.containsKey(id);
	}
	
	/**
	 * Crea una galaxia assignada al capita c
	 * @param c Capita al que s'associa la galaxia
	 */
	public Galaxia(Capita c){
		++cont;
		this.id = cont.toString();
		this.exodes = new HashMap<String,Exode>();
		capita = c;
	}
	
	/**
	 * Consulta el capita associat a la galaxia
	 * @return Retorna el capita de la galaxia
	 */
	public Capita getCapita() {
		return capita;
	}

	//Possiblement prescindible?
	/**
	 * Assigna un capita a la galaxia
	 * @param capita Capita que s'associa a la galaxia
	 */
	public void setCapita(Capita capita) {
		this.capita = capita;
	}

	/**
	 * Consulta el id de la galaxia
	 * @return Retorna el id de la galaxia
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * Crea una copia del graf passat per parametre
	 * @param bG graf del que fer la copia
	 * @return toReturn retorna una copia del graf passat per parametre 
	 * @throws IOException
	 */
	public Graf<Base> getCopiaGraf(Graf<Base> bG) throws IOException{
		Graf<Base> toReturn = new Graf<Base>();
		//Afegim els nodes en el graf Copia
		for (int j = 0; j < bG.getNSize(); j++) {
			toReturn.afegirNode(bG.getNode(j));
		}
		
		//Connectem els nodes
		for (int j = 0; j < bG.getNSize(); j++) {
			ArrayList<Integer> al = bG.getOutNodes(j);
			for (Integer integer : al) {
				int idAresta = bG.getIDAresta(j, integer);
				//Posem mateix capacitat mateix cost i mateix fluxe
				toReturn.conectarNodes(j, integer, bG.getCapacidadAresta(idAresta), bG.getCosteAresta(idAresta));
				toReturn.setFlujoAresta(toReturn.getIDAresta(j, integer), bG.getFlujoAresta(idAresta));
			}
		}
		
		
		return toReturn;
	}
	
	/**
	 * Crea una copia del graf de la galaxia
	 * @return toReturn retorna una copia del graf de la galaxia 
	 * @throws IOException
	 */
	public Graf<Base> getCopiaGraf() throws IOException{
		Graf<Base> toReturn = new Graf<Base>();
		//Afegim els nodes en el graf Copia
		for (int j = 0; j < this.getNSize(); j++) {
			toReturn.afegirNode(this.getNode(j));
		}
		
		//Connectem els nodes
		for (int j = 0; j < this.getNSize(); j++) {
			ArrayList<Integer> al = this.getOutNodes(j);
			for (Integer integer : al) {
				int idAresta = getIDAresta(j, integer);
				//Posem mateix capacitat mateix cost i mateix fluxe
				toReturn.conectarNodes(j, integer, getCapacidadAresta(idAresta), getCosteAresta(idAresta));
				toReturn.setFlujoAresta(toReturn.getIDAresta(j, integer), getFlujoAresta(idAresta));
			}
		}
		
		
		return toReturn;
	}

	/**
	 * Guarda un exode ocorregut a la galaxia
	 * @param e Exode a afegir
	 * @return Retorna true al afegir el exode.
	 */
	//Mètodes de control de les coleccions		
	//Afegeix un èxode a la galaxia
	public boolean addExode(Exode e){
		this.exodes.put(e.getIdExode(), e);
		return true;
		//operacio getId() a la classe exode
	}
		
	/**
	 * Consulta un exode segons la id
	 * @param s
	 * @return Retorna el exode amb id s
	 */
	public Exode getExode(String s) {
		return this.exodes.get(s);
	}
	
	/**
	 * Esborra el exode de la galaxia segons id
	 * @param s Id del exode a esborrar
	 * @return Retorna el exode esborrat
	 * @throws IOException
	 */
	public Exode removeExode(String s) throws IOException{
		if(! checkExode(s)) 
			throw new IOException("El exode no existeix.");
		else {
			Exode e = this.exodes.get(s);
			this.exodes.remove(s);
			return e;
		}
	}
	
	/**
	 * Esborra una base de la galaxia
	 * @param id Id de la base a esborrar
	 * @return Retorna la base esborrada
	 * @throws IOException
	 */
	public Base removeBase(int id) throws IOException{
		Base b = getNode(id);
		removeNode(id);
		return b;
	}
	
	/**
	 * Consulta una base de la galaxia segons id
	 * @param id Id de la base a retornar
	 * @return Retorna la base consultada
	 * @throws IOException
	 */
	public Base getBase(int id) throws IOException{
		return this.getNode(id);
	}

	/**
	 * Retorna la id de la base passada per parametre
	 * @param b Base de la qual volem saber la id
	 * @return retorna la id de la base b
	 * @throws IOException
	 */
	public int getBaseId(Base b) throws IOException{
		return getNodeId(b);
	}

	/**
	 * Consulta el HashMap dels exodes que han succeit a la galaxia
	 * @return HashMap exodes
	 */
	public HashMap<String,Exode> getExodesHash(){
		return this.exodes;
	}
	
	/**
	 * Genera un ArrayList de les bases que hi ha a la galaxia
	 * @return ArrayList de les bases de la galaxia
	 * @throws IOException
	 */
	public ArrayList<Base> getBaseArray() throws IOException{
		ArrayList<Base> ab = new ArrayList<Base>();
		for (int i =0 ; i < this.getNSize(); ++i){
			ab.add(i,this.getNode(i));
		}
		return ab;
	}
	
	/**
	 * Retorna un ArrayList amb les strings dels exodes que hi ha hagut a la galaxia-
	 * @return ArrayList<String> amb les ids dels exodes
	 */
	public ArrayList<String> getExodes(){
		return new ArrayList<String>(exodes.keySet());
	}			
}
