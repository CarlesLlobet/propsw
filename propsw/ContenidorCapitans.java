/*
 /*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class ContenidorCapitans {
	//HashMap que conte els capitans
	private static HashMap<String, Capita> contCap ;
	

	/**
	 * Comprova si existeix un capita amb l'id del parametre
	 * @param idCapita Id del capita a consultar
	 * @return true si existeix el capità, false altrament
	 */
	private boolean checkCapita(String idCapita){
		if (this.contCap.containsKey(idCapita)) return true;
		else return false;
	}
	
	/**
	 * Classe creadora. Inicialitza el contenidor de capitans
	 */
	public ContenidorCapitans(){
		this.contCap = new HashMap<String,Capita>();
	}
	
	/**
	 * Constructor que no inicialitza el contenidor.
	 * @param a sense ús.
	 */
	public ContenidorCapitans(boolean a){
		
	}
	
	/**
	 * Afegeix un capita al contenidor
	 * @param capita Capita a afegir al contenidor
	 * @return true després d'afegir el capita
	 */
	public static boolean addCapita(Capita capita) throws IOException{
		boolean ok=true;
		Iterator<Entry<String, Capita>> entries = contCap.entrySet().iterator();
		while (entries.hasNext()) {
		  
		  Entry<String, Capita> thisEntry = (Entry<String,Capita>) entries.next();
		  if(thisEntry.getValue().getNom()==capita.getNom())
			  ok=false;
		}
		if(ok==true){
			 contCap.put(capita.getIdNoStatic(),capita);
		}
		else{
			throw new IOException("El nom ja existeix");
		}
		return true;
	}
	
	
	/**
	 * Esborra un capita del contenidor
	 * @param idCapita Id del capita a esborrar
	 * @return true si s'ha esborrat el capita, false altrament
	 */
	public boolean deleteCapita(String idCapita) {
		if (checkCapita(idCapita)) {
			this.contCap.remove(idCapita);
			return true;
		}
		else return false;
	}

	/**
	 * Consulta el capita amb idCapita
	 * @param idCapita Id del capita a consultar
	 * @return Retorna el capita amb idCapita
	 */
	public Capita getCapita(String idCapita) {
		if (checkCapita(idCapita)){
			Capita c = contCap.get(idCapita);
			return c;
		}
		else return null;
	}
	
	/**
	 * Mètode per accedir al contenidor.
	 * @return contenidor de capitans.
	 */
	public static HashMap<String,Capita> getHashContenidor(){
		return contCap;
	}
	
	
}