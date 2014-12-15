/*
 * @Author: Arnau Bennassar Formenti
 * Grup 44 - 9.1
 */ 

package propsw;

import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;

public class ExodeControlador{
	CapitaControlador capi;
	/**
	 * Constructor d'un objecte ExodeControlador.
	 */
	public ExodeControlador(CapitaControlador cc){
		capi = cc;
	}
	
	/**
	 * Executa l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @param tipusExec: indica l'algoritme a utilitzar, 0 per BFS, 1 per DFS, 2 per Dijkstra
	 */
	public void execucio(String idExode, Integer tipusExec) throws IOException {
		if (tipusExec == 0){
			capi.getGalaxia().getExode(idExode).execucioBFS();
		}
		else if (tipusExec == 1){
			capi.getGalaxia().getExode(idExode).execucioDFS();
		}
		else if (tipusExec == 2){
			capi.getGalaxia().getExode(idExode).execucioDijkstra();
		}
	}
	
	/**
	 * Consultar la base inicial de l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna la id de la base de inici de l'exode
	 */
	public Integer getIniciExode(String idExode) {
		return capi.getGalaxia().getExode(idExode).getIdBaseInici(); 
	}
	
	/**
	 * Consultar els rebels que participen a l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna per a cada rebel la id de la base que te asignada com a desti
	 */
	public HashMap<String, Integer> getRebelsExode(String idExode) {
		return capi.getGalaxia().getExode(idExode).getDestinsRebels(); 
	}
	
	/**
	 * Consultar la quantitat de rebels que participen a l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna nombre de rebels que participen a l'exode
     */
	public Integer getRebelsSize(String idExode) {
		return capi.getGalaxia().getExode(idExode).getDestinsRebels().size();
	}
	
	/**
	 * Consultar els camins que duen a terme els diferents rebels a l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna els camins (llista de id's de base) de cada rebel
	 */
	public HashMap<String, ArrayList<Integer>> getCaminsExode(String idExode) {
		return capi.getGalaxia().getExode(idExode).getCamins(); 
	}
	
	/**
	 * Consultar el nombre de rebels que arriben al seu desti
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna el flow de l'exode
	 */
	public Integer getFlowExode(String idExode) {
		return capi.getGalaxia().getExode(idExode).getFlow(); 
	}
	
	/**
	 * Consultar el cost de dur a terme l'exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna el cost total de fer l'exode
	 */
	public double getCostExode(String idExode) {
		return capi.getGalaxia().getExode(idExode).getCost(); 
	}
	
	/**
	 * Consultar els posibles colls d'ampolla
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @return Retorna els identificadors de les arestes que son colls d'ampolla
	 * @throws IOException
	 */
	public ArrayList<Integer> getAmpollaExode(String idExode) throws IOException {
		return capi.getGalaxia().getExode(idExode).getAmpolla();
	}
	
	/**
	 * Afegir un Rebel d'un Exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @param idRebel: identificador del rebel que es vol modificar
	 * @param idBaseDesti: identificador de la base a la cual a d'intentar arribar el rebel 
	 * @return retorna cert si s'esborra satisfactoriament el Rebel de l'exode, fals altrament
	 */
	public boolean afegirRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		capi.getRebel(idRebel).insertarExode(idExode);
		return capi.getGalaxia().getExode(idExode).afegirRebel(idRebel, idBaseDesti);   
	}
	
	/**
	 * Modifica un Rebel d'un Exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @param idRebel: identificador del rebel que es vol modificar
	 * @param idBaseDesti: identificador de la nova base a la cual a d'intentar arribar el rebel 
	 */
	public void modificarRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		capi.getGalaxia().getExode(idExode).modificarRebel(idRebel, idBaseDesti); 
	}
	
	/**
	 * Treu un Rebel d'un Exode
	 * @param idExode: identificador d'un exode creat pel capita actual
	 * @param idRebel: identificador del rebel que es vol eliminar
	 * @return retorna cert si s'esborra satisfactoriament el Rebel de l'exode, fals altrament 
	 */
	public boolean treureRebelExode(String idExode, String idRebel) {
		capi.getRebel(idRebel).esborrarExode(idExode);           
		return capi.getGalaxia().getExode(idExode).borrarRebel(idRebel);
	}
	
	//Fixa un cami d'un rebel a un èxode.
	public boolean fixarCamiExode(String idExode, String idRebel, ArrayList<Integer> camiBases) throws IOException{
		return capi.getGalaxia().getExode(idExode).fixarCami(idRebel, camiBases);
	}
	
	//Desfixa un cami d'un rebel a un èxode.
	public boolean desfixarCamiExode(String idExode, String idRebel) throws IOException{
		return capi.getGalaxia().getExode(idExode).desfixarCami(idRebel);
	}

	//Retorna true si el exode es invàlid. Si es invalid no es pot fer cap execució.
	//Es invalid si algun dels camins fixats no conpleix les restriccions:
	//	- Totes bases del cami han de tenir aresta amb la base seguent del camí
	//	- Totes les arestes han de tenir capacitat < 
	public boolean isExodeInvalid(String idExode) throws IOException{
		return capi.getGalaxia().getExode(idExode).isInvalid();
	}
	
	//Retorna els camins fixats on el key es el identificador del rebel y el arraylist 
	//de integers es el camí
	public HashMap<String,ArrayList<Integer>> getCaminsFixatsExode(String idExode){
		return capi.getGalaxia().getExode(idExode).getCaminsFixats();
	}
	
	//Retorna el nome de la classe de l'ultim algoritme executat. 
	public String getUltimAlgoritmeExode(String idExode) throws IOException{
		return capi.getGalaxia().getExode(idExode).getUltimAlgoritmeExecutat();
	}
	
	/**
	 * Actualitza el contador de ids de Exodes.
	 * @param i valor enter al qual es posarà el contador de ids.
	 */
	public static void setCont(int i){
		Exode.setCont(i);
	}
	
	
	public Graf<Base> getGrafResidual(String idExode) throws IOException{
		return capi.getGalaxia().getExode(idExode).getGrafResidualNet();
	}
}
