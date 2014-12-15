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
	private Integer contador;
	private double cost;
	private boolean actualitzat;
	private String idExode;
	private FordFulkerson<Base> ff;
	private HashMap<Integer,ArrayList<Integer[]>> collsAmpolla;
	private HashMap<String,ArrayList<Integer>> caminsFixats;
	private boolean invalid;
	
	
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
		caminsFixats = new HashMap<String,ArrayList<Integer>>();
		invalid = false;
		setContador();
	}
	
	
	//Retorna true si el exode es invalid degut a algun dels camins fixats
	public boolean isInvalid() {
		return invalid;
	}



	// Aquest mètode fixa un camí a un rebel. Retorna true si el camí es un camí vàlid
	// Perque sigui vàlid ha de complir les seguents condicions:
	// 		- Que hi hagi connexions entre totes les arestes desde el origen fins al destí.
	// 		- Que aquestes arestes tinguin totes una capacitat >= 1
	// Si no es compleix alguna d'aquestes dues condicions aleshores:
	//		- Insereix el cami en la variable caminsFixats i modifica la variable camins per treure el cami assignat a aquell 
	//		rebel en l'anterior execució i assignar el nou camí.
	//		- Retorna false i marca l'exode com invàlid.
	// Si es compleixen aquestes condicions:
	//		- Resta 1 a la capacitat de totes les arestes del camí i suma 1 al fluxe de cada aresta del camí en el graf inicial.
	//		- En la variable camins s'afegeix el nou camí per a aquest rebel i es treu el que hi habia assignat.
	//		- En la variable caminsFixats s'afegeix el nou camí fixat per a aquest rebel
	// En el mètode execució cal afegir els camins fixats quan es fa un new de la variable camins perque tingui en compte els 
	// camins fixats.
	public boolean fixarCami(String idRebel, ArrayList<Integer> cami) throws IOException{
		boolean toRet = true;
		actualitzat = false;		
		toRet = checkCami(cami); //Es comproben les dues primeres condicions. Retorna true si es compleixen les dues
		if(toRet){
			//Si compleix les dues condicions
			int camiSize = cami.size();
			//Es fa el recorregut del camí restant 1 a cada capacitat i afegint 1 al fluxe.
			int capacidad=0;
			int idAresta =0;
			double coste = 0;
			int flujo = 0;
			for (int i = 0; i < camiSize - 1; i++) {
				idAresta = grafInicial.getIDAresta(cami.get(i),cami.get(i+1));
				capacidad = grafInicial.getCapacidadAresta(idAresta);
				coste = grafInicial.getCosteAresta(idAresta);
				flujo = grafInicial.getFlujoAresta(idAresta);
				grafInicial.substituirAresta(idAresta, capacidad-1, coste);		//Decremento la capacitat en 1
				grafInicial.setFlujoAresta(idAresta, flujo+1);					//Incremento el fluxe en 1
			}
		}
		desfixarCami(idRebel); 					//Si el rebel te un cami fixat aquest s'ha de desfixar abans...
		caminsFixats.put(idRebel, cami);		//Afegeixo el cami als camins fixats y als camins resultants
		camins.put(idRebel, cami);				//independentment de si es correcte o no el camí.
		destins.put(idRebel,cami.get(cami.size()-1));				//Actualitzem el cami del rebel per si ha cambiat
		if(!toRet)invalid = true;
		return toRet;
	}
	
	//Retorna false si el idRebel no tenia un camí fixat
	//Retorna true si aquest existeix. Si existeix a mes fa:
	//		- Treu el cami de la variable caminsFixats
	//		- Treu el cami de la variable camins
	//		- actualitza l'estat del graf inical  
	//		(només si es un camí vàlid) sumant 1 
	//		a les capacitats de les arestes del cami i restant 1 al fluxe 
	//		de les arestes de l camí.
	//		- Actualitza l'estat d'invalid en funció si hi ha algun cami fixat que 
	//		no compleix les restriccions
	public boolean desfixarCami(String idRebel) throws IOException{
		boolean toRet = false;
		ArrayList<Integer> cami = caminsFixats.get(idRebel);
		if(cami!=null){
			actualitzat = false;
			toRet = true;
			caminsFixats.remove(idRebel);
			camins.remove(idRebel);
			
			//Si el camí es un camí vàlid aleshores es fa la actualització del graf inicial
			if(checkCami(cami)){
			
				int camiSize = cami.size();
				//Es fa el recorregut del camí sumant 1 a cada capacitat i restant 1 al fluxe.
				int capacidad=0;
				int idAresta =0;
				double coste = 0;
				int flujo = 0;
				for (int i = 0; i < camiSize - 1; i++) {
					idAresta = grafInicial.getIDAresta(cami.get(i),cami.get(i+1));
					capacidad = grafInicial.getCapacidadAresta(idAresta);
					coste = grafInicial.getCosteAresta(idAresta);
					flujo = grafInicial.getFlujoAresta(idAresta);
					grafInicial.substituirAresta(idAresta, capacidad+1, coste);		//Incremento la capacitat en 1
					grafInicial.setFlujoAresta(idAresta, flujo-1);					//Decremento el fluxe en 1
				}
			}
			//Actualitzo el estat de invalid de l'exode (serà invalid si algun 
			//dels camins fixats no passa les restriccions del checkCami())
			Iterator<String> it = caminsFixats.keySet().iterator();
			String str = "";
			invalid = true;
			while(it.hasNext()){
				str = it.next();
				if(checkCami(caminsFixats.get(str))==false)invalid = true;
			}
			if(caminsFixats.keySet().size()<=0)invalid=false;
		}
		
		return toRet;
	}
	
	// Retorna true si hi ha connexio entre totes les bases del camí
	// i si la capacitat de totes les arestes es > 1
	private boolean checkCami(ArrayList<Integer> cami) {
		boolean toRet = true;
		int camiSize = cami.size();
		for (int i = 0; i < camiSize - 1; i++) {
			try {
				//Si son adjacents miro que la capacitat sigui >=1 sino retornare false
				if(toRet && grafInicial.adjacents(cami.get(i), cami.get(i+1))){
					if(grafInicial.getCapacidadAresta(grafInicial.getIDAresta(cami.get(i), cami.get(i+1)))<1){
						toRet=false;		//La capacitat de l'aresta es 0 o menor que 0
					}
				}else{
					toRet = false;			//O bé no son adjacents o bé ja habiem marcat com a false el toRet
				}
			} catch (IOException e) {
				//Hi ha una excepcio perque o bé algun dels identificadors dels 
				//nodes del cami no existeix o bé alguna parella de node contigus 
				//estan repetits. Per tant retornem false.
				toRet = false;
			}
		}
		return toRet;
	}



	/**
	 * Consulta els dest’ assignat a cada rebel.
	 * @return HashMap amb key=idRebel i value = idBase (Dest’ assignat al Rebel)
	 */
	public HashMap<String,Integer> getDestinsRebels(){
		return destins;
	}
	
	/**
	 * Nomes retorna el numero de destins dels rebels que no son amb cami fixat.
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
			if(!caminsFixats.keySet().contains(k)){
				idBase = destins.get(k);
				if(!toReturn.containsKey(idBase))toReturn.put(idBase,1);
				else{
					counter = toReturn.get(idBase)+1;
					toReturn.put(idBase,counter);							//Actualitzem el contador
				}
			}
		}
		return toReturn;
	}
	
	/** 
	 * Execuci— de l'algoritme Dijkstra
	 * @throws IOException
	 */
	//Retorna true o false si s'ha fet la execucio
	public boolean execucioDijkstra() throws IOException {
		if(!invalid){
			ff = new FFDijkstra<Base>(idBaseInici,2,galaxia);
			execucio();
		}
		return !invalid;
		
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
	//Retorna true o false si s'ha fet la execucio
	public boolean execucioDFS() throws IOException {
		if(!invalid){
			ff = new FordFulkerson<Base>();
			execucio();
		}
		return !invalid;
	}
	
	/**
	 * Execuci— de l'algoritme FordFoulkerson
	 * @throws IOException
	 */
	private void execucio() throws IOException{
		cost = 0;
		camins = new HashMap<String, ArrayList<Integer>>();				//Reinicialitzem el mapa de camins  perque farem una nova execució
		camins.putAll(caminsFixats);									//Afegim els camins fixats a mans per l'usuari
		collsAmpolla = new HashMap<Integer, ArrayList<Integer[]>>();	//Reinicialitzem els colls d'ampolla perque fem una nova execució de l'algoritme
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base();
		b.setGraf(grafInicial);
		grafInicial.afegirNode(b);
		grafResidualPostProces =  galaxia.getCopiaGraf(grafInicial);
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
		
		grafInicial.removeNode(b.getId());
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
	//Retorna true o false si s'ha fet la execucio
	public boolean execucioBFS() throws IOException {
		if(!invalid){
			ff = new EdmondsKarp<Base>(idBaseInici, 2, galaxia);
			execucio();
		}
		return !invalid;
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
		return this.contador.toString();
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
	
	
	
	public String getUltimAlgoritmeExecutat(){
		String toRet = "";
		if (ff==null){
			toRet = "No s'ha executat cap algoritme";
		}else{
			toRet = ff.getClass().getName();
		}
		return toRet;
	}


	public HashMap<String, ArrayList<Integer>> getCaminsFixats() {
		return caminsFixats;
	}
	
	public void setContador(){
		contador=cont;
	}
	
	public static void setCont(int i){
		cont=i;
	}
	
}
