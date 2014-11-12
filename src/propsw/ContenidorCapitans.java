// @Author: Marcos Pérez
package propsw;

import java.util.HashMap;

public class ContenidorCapitans {
	private HashMap<String, Capita> contCap ;

	private boolean checkCapita(String idCapita){
		if (this.contCap.containsKey(idCapita)) return true;
		else return false;
	}
	
	public ContenidorCapitans(){
		this.contCap = new HashMap<String,Capita>();
	}
	
	public boolean addCapita(Capita capita) {
		this.contCap.put(capita.getId(),capita);
		return true;
	}

	public boolean deleteCapita(String idCapita) {
		if (checkCapita(idCapita)) {
			this.contCap.remove(idCapita);
			return true;
		}
		else return false;
	}

	public Capita getCapita(String idCapita) {
		if (checkCapita(idCapita)){
			Capita c = contCap.get(idCapita);
			return c;
		}
		else return null;
	}
}