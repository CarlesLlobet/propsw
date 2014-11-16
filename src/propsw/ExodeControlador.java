/*
 * @Author: Arnau Bennassar Formenti
 * Grup 44 - 9.1
 */ 

package propsw;

import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;

public class ExodeControlador extends GalaxiaControlador {
	public ExodeControlador(){
		super();
	}
	
	//Executar Exode 0 = BFS, 1 = DFS, 2 = Dijkstra
	public void execucio(String idExode, Integer tipusExec) throws IOException {
		if (tipusExec == 0){
			super.getGalaxia().getExode(idExode).execucioBFS();
		}
		else if (tipusExec == 1){
			super.getGalaxia().getExode(idExode).execucioDFS();
		}
		else if (tipusExec == 2){
			super.getGalaxia().getExode(idExode).execucioDijkstra();
		}
	}
	
	//Obte la id de la base inicial de l'exode
	public Integer getIniciExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getIdBaseInici(); 
	}
	
	//Retorna hashmap idRebel = idBaseDesti
	public HashMap<String, Integer> getRebelsExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getDestinsRebels(); 
	}
	
	//Retorna el nombre de rebels q participen a l'exode
	public Integer getRebelsSize(String idExode) {
		return super.getGalaxia().getExode(idExode).getDestinsRebels().size();
	}
	
	//Retorna idRebel = idBaseS q recorre (s'ha d'haver executat l'exode)
	public HashMap<String, ArrayList<Integer>> getCaminsExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getCamins(); 
	}
	//Retorna el nombre de rebels que arriben al seu desti (s'ha d'haver executat l'exode)
	public Integer getFlowExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getFlow(); 
	}
	
	//Retorna el cost total de fer l'exode (s'ha d'haver executat l'exode)
	public double getCostExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getCost(); 
	}
	//Retorna ??las bases?? q formen el coll d'ampolla (s'ha d'haver executat l'exode)
	public ArrayList<Integer> getAmpollaExode(String idExode) throws IOException {
		return super.getGalaxia().getExode(idExode).getAmpolla();
	}
	
	//Afegir un rebel a l'exode (i a la llista d'exodes als que participa el rebel)
	public boolean afegirRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		getRebel(idRebel).insertarExode(idExode);
		return super.getGalaxia().getExode(idExode).afegirRebel(idRebel, idBaseDesti);   
	}
	
	//Modificar la base de desti del rebel
	public void modificarRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		super.getGalaxia().getExode(idExode).modificarRebel(idRebel, idBaseDesti); 
	}
	//Eliminar el rebel de l'exode (i a la llista d'exodes als que participa el rebel)
	public boolean treureRebelExode(String idExode, String idRebel) {
		getRebel(idRebel).esborrarExode(idExode);           
		return super.getGalaxia().getExode(idExode).borrarRebel(idRebel);
	}

}
