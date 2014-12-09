/*
 * @Author: Albert Tost
 * Grup 44 - 9.1
 */ 
package propsw;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Exode implements Serializable{
	private Integer idBaseInici;
	private HashMap<String,ArrayList<Integer>> camins;
	private HashMap<String,Integer> destins;
	private Graf<Base> grafResidualPostProces;
	private Graf<Base> grafResidualPreProces;
	private Graf<Base> grafInicial;
	private Galaxia galaxia;
	private Integer flow;
	private static Integer cont = 0;
	private double cost;
	private boolean actualitzat;
	private String idExode;
	private FordFulkerson<Base> ff;
	private HashMap<Integer,ArrayList<Integer[]>> collsAmpolla;
	
	
	/**
	 * Crea un Exode de la galaxia g.
	 * @param g
	 * @throws IOException
	 */
	public Exode(Galaxia g) throws IOException{
		++cont;
		this.idExode = cont.toString();
		grafInicial = g.getCopiaGraf();
		galaxia = g;
		destins = new HashMap<String, Integer>();
		camins = new HashMap<String, ArrayList<Integer>>();
		collsAmpolla = new HashMap<Integer, ArrayList<Integer[]>>();
		
	}
	
	
	/**
	 * Consulta els dest’ assignat a cada rebel.
	 * @return HashMap amb key=idRebel i value = idBase (Dest’ assignat al Rebel)
	 */
	public HashMap<String,Integer> getDestinsRebels(){
		return destins;
	}
	
	/**
	 * Consulta del numero de rebels que van a cada un dels destins.
	 * @return Retorna hashMap amb key = idBase (cada un dels destins) i value = numero de rebels que van a aquell dest’.
	 */
	public HashMap<Integer,Integer> getDestinsResum() {
		//Cada rebel té un destí assignat. Es fa una llista 
		//dels diferents destins sense repeticions
		HashMap<Integer,Integer> toReturn = new HashMap<Integer, Integer>();
		
		Iterator<String> keys = destins.keySet().iterator();
		String k = "";
		Integer idBase= null;
		int counter;
		while(keys.hasNext()){
			k = keys.next();
			idBase = destins.get(k);
			if(!toReturn.containsKey(idBase))toReturn.put(idBase,1);
			else{
				counter = toReturn.get(idBase)+1;
				toReturn.put(idBase,counter);							//Actualitzem el contador
			}
		}
		return toReturn;
	}
	
	/** 
	 * Execuci— de l'algoritme Dijkstra
	 * @throws IOException
	 */
	public void execucioDijkstra() throws IOException {
		ff = new FFDijkstra<Base>(idBaseInici,2,galaxia);
		execucio();
		
	}
	
	/**
	 * Consulta els camins de cada rebel des de l'origen al seu dest’.
	 * @return HashMap on key = id del Rebel i el value es un ArrayList amb les bases que marquen el cam’ en ordre.
	 */
	public HashMap<String, ArrayList<Integer>> getCamins() {
		return camins;
	}
	
	/**
	 * Execuci— de l'algoritme DFS i emplena la variable camins assignant un cam’ a cada rebel assignat a l'éxode.
	 * @throws IOException
	 */
	public void execucioDFS() throws IOException {
		ff = new FordFulkerson<Base>();
		execucio();
	}
	
	/**
	 * Execuci— de l'algoritme FordFoulkerson
	 * @throws IOException
	 */
	private void execucio() throws IOException{
		cost = 0;
		camins = new HashMap<String, ArrayList<Integer>>();				//Reinicialitzem el mapa de camins  perque farem una nova execució
		collsAmpolla = new HashMap<Integer, ArrayList<Integer[]>>();	//Reinicialitzem els colls d'ampolla perque fem una nova execució de l'algoritme
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base(galaxia);
		grafResidualPostProces =  galaxia.getCopiaGraf();
		HashMap<Integer,Integer> destinsResum = getDestinsResum();
		ArrayList<Integer> dests = new ArrayList<Integer>(destinsResum.keySet());
		int sizeDests = dests.size();
		for (int i = 0; i < sizeDests; i++){
			//LA CAPACITAT DE LA ARESTA QUE VA AL SUMIDERO ES EL NUMERO DE REBELS QUE VAN A AQUELL DESTÍ!!!!!!!
			grafResidualPostProces.conectarNodes(dests.get(i), b.getId(), destinsResum.get(dests.get(i)), Double.MIN_VALUE);
		}
		grafResidualPostProces = ff.findMaxFlow(grafResidualPostProces, idBaseInici, b.getId());
		flow = ff.getMaxFlow();					//El numero de rebels que arriben als seus destins.
		grafResidualPreProces = galaxia.getCopiaGraf(grafResidualPostProces);
		//Surten "n=flow" rebels de l'origen ....
		generaCamins(grafResidualPostProces,idBaseInici, new ArrayList<Integer>(), flow, destinsResum);			//El post-processament del graf residual
		galaxia.removeNode(b.getId());
		actualitzat = true;
	}

	
	/**
	 * Donat un graf residual, recursivament, el va recorrent desde el node inicial fins al sumidero
	   en funci— del fluxe assignat a cada aresta i al final del recorregut assigna 
	   camins als rebels en funci— del fluxe resultant i del dest’ que tenien assignat.
	 * @param g
	 * @param idBase
	 * @param camino
	 * @param numRebels
	 * @param destinsResum
	 * @throws IOException
	 */
	private void generaCamins(Graf<Base> g, int idBase, ArrayList<Integer> camino, int numRebels, HashMap<Integer, Integer> destinsResum) throws IOException {
		ArrayList<Integer> newCamino = new ArrayList<Integer>(camino);
		newCamino.add(idBase);
		ArrayList<Integer> nodesOut = g.getOutNodes(idBase);
		int size = nodesOut.size();
		boolean b = false;
		for (Integer integer : nodesOut) {
			if(g.getFlujoAresta(g.getIDAresta(idBase,integer))>0)b=true;			//S'activa a true només si té com a minim un flux positiu en cualsevol aresta.
		}
		if(size<=0 || !b){
			//Si no tŽ arestes de sortida vol dir que hem arribat al sumidero. Assignem el camí a
			//"n=numRebels" que encara no tinguin assignat cap camí
			assignaRebels(newCamino,numRebels,g,destinsResum);
			return;
		}
		int i = 0, fHelp, flujo = Integer.MAX_VALUE;
		while (i < size && numRebels>0) {
			//Donada una base uns rebels marxaran cap a unes bases y uns altres cap a unes altres,
			//En funcio del flux que ha calculat el graf residual per cada aresta de sortida de la base.
			fHelp = g.getFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)));			//No tenemos en cuenta las restroarestas
			if(fHelp>0){
				flujo = Math.min(numRebels, fHelp);
				if(flujo>0){
					generaCamins(g,nodesOut.get(i),newCamino,flujo,destinsResum);
					g.setFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)), g.getFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)))-flujo);			//Actualizamos el flujo para marcar que pasamos por la arista. Asi en otra rama de la recursividad aseguramos que no pasen mas rebeldes por esta arista que los que marca realmente el flujo.
				}
				numRebels = numRebels-flujo;
			}
			i++;
		}
	}
	
	
	/**
	 * Assigna el cam’ als rebels que tenen el dest’ igual que la penœltima posici— del array camino
	   (la œltima es el sumidero). NomŽs assigna camins a rebels que no tenen encara cap cam’ assignat.
	 * @param camino
	 * @param numRebels
	 * @param g
	 * @param destinsResum
	 * @throws IOException
	 */
	private void assignaRebels(ArrayList<Integer> camino, int numRebels, Graf<Base> g, HashMap<Integer, Integer> destinsResum) throws IOException {
		Iterator<String> it = destins.keySet().iterator();
		camino.remove(camino.size()-1);
		//Es computen el colls d'ampolla
		for (int i = 0; i < camino.size()-1; i++) {
			if(g.getCapacidadAresta(g.getIDAresta(camino.get(i),camino.get(i+1)))<=0){
				Integer[] aresta = new Integer[2];
				aresta[0] = camino.get(i);
				aresta[1] = camino.get(i+1);
				ArrayList<Integer[]> collsAmpollaDesti = collsAmpolla.get(camino.get(camino.size()-1));
				if(collsAmpollaDesti==null)collsAmpollaDesti=new ArrayList<Integer[]>();
				collsAmpollaDesti.add(aresta);
				collsAmpolla.put(camino.get(camino.size()-1),collsAmpollaDesti);
			}
			//Computem la suma dels costs de tots els rebels que passen per aquell camí.
			cost =cost + g.getCosteAresta(g.getIDAresta(camino.get(i),camino.get(i+1)))*numRebels;
		}
		while(it.hasNext() && numRebels>0){
			String idRebel =it.next();
			//Només si encara queden rebels per assignar, si el destí es coincident 
			//i si el rebel encara no té assignat encara cap camí
			if(numRebels>0 && destins.get(idRebel) == camino.get(camino.size()-1) && !camins.containsKey(idRebel)){
				camins.put(idRebel, camino);
				numRebels--;
				Integer i =destinsResum.get(camino.get(camino.size()-1));
				i = i-1;
				destinsResum.put(camino.get(camino.size()-1), i);
				if(i==0){
					//El destí ha aconseguit obtenir tots els rebels que tenia assignat per tant per aqui no hi ha coll d'ampolla
					collsAmpolla.remove(camino.get(camino.size()-1));
				}
			}
		}
	}

	
	/**
	 * Execuci— de l'algoritme EdmondKarp
	 * @throws IOException
	 */
	public void execucioBFS() throws IOException {
		ff = new EdmondsKarp<Base>(idBaseInici, 2, galaxia);
		execucio();
	}
	
	//S'afegeix un rebel a l'exode només si aquest forma part de la tropa del capitˆ
	/**
	 * Afegeix un rebel a l'exode nomŽs si aquest forma part de la tropa del capitˆ.
	 * @param idRebel
	 * @param idBaseDesti
	 * @return Retorna false si no forma part dels rebels del capitˆ 
	 		perque no s'haura afegit la inserci—.
	 */
	public boolean afegirRebel(String idRebel, Integer idBaseDesti) {
		Rebel r = galaxia.getCapita().getRebels().get(idRebel);
		if(r!=null){
			destins.put(idRebel, idBaseDesti);
			actualitzat = false;			//S'ha afegit un nou rebel per tant l'exode ha de tornarse a executar. El reustat esta desactualitzat
			return true;
		}else{
			//Si no forma part dels rebels del capità aleshores no s'afegeix i retorna false perque no s'ha produit la inserció
			return false;
		}
	}
	
	
	/**
	 * Modifica la base dest’ del rebel. Es marca com a desactualitzat el rebel.
	 * @param idRebel
	 * @param idBaseDesti
	 */
	public void modificarRebel(String idRebel,Integer idBaseDesti) {
		destins.put(idRebel, idBaseDesti);
		actualitzat = false;		
	}

	/**
	 * Borra un rebel del exode i marca com a desactualitzat el exode.
	 * @param idRebel
	 * @return Retorna true si existia el rebel assignat al exode o false en cas contrari.
	 */
	public boolean borrarRebel(String idRebel) {
		Integer r = destins.remove(idRebel);
		actualitzat = false;
		return (r!=null);
	}

	// Getters i setters
	
	/**
	 * Consulta del FordFoulkerson.
	 * @return Retorna l'objecte de la classe FordFoulkerson.
	 */
	public FordFulkerson<Base> getFf() {
		return ff;
	}
	
	/**
	 * Consulta del identificador de l'éxode.
	 * @return String identificador de l'éxode.
	 */
	public String getIdExode(){
		return idExode;
	}
	
	/**
	 * Consulta de l'identificador de la base d'inici.
	 * @return Integer identificador base inici.
	 */
	public Integer getIdBaseInici() {
		return idBaseInici;	
	}
	
	/**
	 * Modifica l'identificador de la base d'inici.
	 * @param idBaseInici
	 * @return Retorna false si la base no existeix dins de la galˆxia.
	 * @throws IOException
	 */
	public boolean setIdBaseInici(Integer idBaseInici) throws IOException {
		Base r = galaxia.getNode(idBaseInici);
		if(r!=null){
			this.idBaseInici = idBaseInici;
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Consulta dels rebels de l'éxode.
	 * @return ArrayList<String> dels destins dels rebels.
	 */
	public ArrayList<String> getRebels() {
		return new ArrayList<String>(destins.keySet());
	}

	/**
	 * Consulta el cost
	 * @return Double del cost.
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * Consulta del flow
	 * @return Integer del flow.
	 */
	public Integer getFlow() {
		return flow;
	}
	
	/**
	 * Consulta si l'éxode estˆ actualitzat o no.
	 * @return Booleˆ amb true si estˆ actualitzat i false si no n'estˆ.
	 */
	public boolean isActualitzat() {
		return actualitzat;
	}

	/**
	 * Consulta els colls d'ampolla.
	 * @return HashMap en el qual es mostren els colls d'ampolla.
	 */
	public HashMap<Integer, ArrayList<Integer[]>> getCollsAmpolla() {
		return collsAmpolla;
	}

	/**
	 * Consulta el cam’ d'un determinat rebel amb identificador idRebel.
	 * @param idRebel
	 * @return ArrayList<Integer> que indica les bases que passa el rebel amb idRebel.
	 */
	public ArrayList<Integer> getCamiRebel(String idRebel) {
		ArrayList<Integer> cami = camins.get(idRebel);
		return cami;
	}

	//Retorna els identificadors de les arestes que son colls d'ampolla
	/**
	 * Consulta els identificadors de les arestes colls d'ampolla.
	 * @return ArrayList<Integer> amb els identificadors de les arestes que s—n colls d'ampolla.
	 * @throws IOException
	 */
	public ArrayList<Integer> getAmpolla() throws IOException {
		HashMap<Integer,Object> toReturn = new HashMap<Integer,Object>();
		Iterator<Integer> it = collsAmpolla.keySet().iterator();
		while(it.hasNext()){
			ArrayList<Integer[]> ca = collsAmpolla.get(it.next());
			for (Integer[] integers : ca) {
				toReturn.put(galaxia.getIDAresta(integers[0], integers[1]), "");
			}
		}
		return new ArrayList<Integer>(toReturn.keySet());
	}

	/**
	 * Consulta identificadors de les bases que s—n coll
	 * @return Retorna els identificadors de les bases (Integer[0]=from , Integer[1]=to)
	           de les arestes que s—n colls d'ampolla.
	 * @throws IOException
	 */
	public ArrayList<Integer[]> getAmpollaIdBases() throws IOException {
		HashMap<String,Integer[]> toReturn = new HashMap<String,Integer[]>();
		Iterator<Integer> it = collsAmpolla.keySet().iterator();
		while(it.hasNext()){
			ArrayList<Integer[]> ca = collsAmpolla.get(it.next());
			for (Integer[] integers : ca) {
				toReturn.put(integers[0]+","+integers[1],integers);
			}
		}
		return new ArrayList<Integer[]>(toReturn.values());
	}

	/**
	 * Consulta el graf inicial.
	 * @return Graf<Base> inicial abans de l'execuci— de l'algoritme.
	 */
	public Graf<Base> getGrafInicial() {
		return grafInicial;
	}

	/**
	 * Consulta la galˆxia.
	 * @return objecte de tipus Galaxia.
	 */
	public Galaxia getGalaxia() {
		return galaxia;
	}
	
	/**
	 * Consulta el graf residual.
	 * @return Graf<Base> residual desprŽs d'executar l'algoritme.
	 */
	public Graf<Base> getGrafResidual() {
		return grafResidualPreProces;
	}
	
	public boolean checkearCamino(ArrayList<Integer> camino){
		boolean ret = false;
		
		return ret;
	}
	
}
