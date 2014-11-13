//Autor: Albert Tost

package propsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Exode {
	private Integer idBaseInici;
	private ArrayList<String> rebels;
	private HashMap<String,ArrayList<Integer>> camins;
	private HashMap<String,Integer> destins;
	private Graf<Base> grafResidual;
	private Graf<Base> grafInicial;
	private Galaxia galaxia;
	private Integer flow;
	private static Integer cont = 0;
	private double cost;
	private boolean actualitzat;
	private String idExode;
	private FordFulkerson<Base> ff;
	
	

	
	
	public Exode(Galaxia g){
		++cont;
		this.idExode = cont.toString();
		grafInicial = g;
		galaxia = g;
		
		destins = new HashMap<String, Integer>();
		camins = new HashMap<String, ArrayList<Integer>>();
	}
	
	
	//Retorna un HashMap amb key=idRebel i value = idBase (Destí assignat al Rebel)
	public HashMap<String,Integer> getDestinsRebels(){
		return destins;
	}

	
	//Retorna un hashMap amb key = idBase (cada un dels destíns) i value = numero de rebels que van a aquell destí 
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

	public void execucioDijkstra() throws IOException {
		//TODO execucioDijkstra falta importar codi del altre grup.
		ff = new FFDijkstra<Base>();
		
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base();
		
		grafResidual = grafInicial; 
		grafResidual.afegirNode(b);
		
		HashMap<Integer,Integer> destinsResum = getDestinsResum(); 
		
		ArrayList<Integer> dests = new ArrayList<Integer>(destinsResum.keySet());
		int sizeDests = dests.size();
		for (int i = 0; i < sizeDests; i++){
			//LA CAPACITAT DE LA ARESTA QUE VA AL SUMIDERO ES EL NUMERO DE REBELS QUE VAN A AQUELL DESTÍ!!!!!!!
			grafResidual.conectarNodes(dests.get(i), b.getId(), destinsResum.get(dests.get(i)), Double.MIN_VALUE);
		}
		
		
		grafResidual = ff.findMaxFlow(grafResidual, idBaseInici, b.getId());
		flow = ff.getMaxFlow();
		generaCamins(ff.getCaminos());
	}
	
	
	//Retorna un HashMap on la key es el id del Rebel y el value 
	//es un ArrayList amb les bases que marquen el camí en ordre 
	//desde l'origen al destí
	public HashMap<String, ArrayList<Integer>> getCamins() {
		return camins;
	}


	// Executa el FF-DFS i emplena la variable camins assignant un camí a cada rebel assignat a l'exode.
	public void execucioDFS() throws IOException {
		ff = new FordFulkerson<Base>();
		
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base();
		
		grafResidual = grafInicial; 
		grafResidual.afegirNode(b);
		
		HashMap<Integer,Integer> destinsResum = getDestinsResum(); 
		
		ArrayList<Integer> dests = new ArrayList<Integer>(destinsResum.keySet());
		int sizeDests = dests.size();
		for (int i = 0; i < sizeDests; i++){
			//LA CAPACITAT DE LA ARESTA QUE VA AL SUMIDERO ES EL NUMERO DE REBELS QUE VAN A AQUELL DESTÍ!!!!!!!
			grafResidual.conectarNodes(dests.get(i), b.getId(), destinsResum.get(dests.get(i)), Double.MIN_VALUE);
		}
		
		
		grafResidual = ff.findMaxFlow(grafResidual, idBaseInici, b.getId());
		flow = ff.getMaxFlow();
		generaCamins(ff.getCaminos());
		
	}

	//Donat un llistat de camins amb el seu flow màxim que se li pot assignar, quest mètode 
	//emplena la variable camins que assigna a cada rebel el seu camí en l'èxode.
	private void generaCamins(ArrayList<Pair<Integer, ArrayList<Integer>>> caminos) {
		 
		int size = caminos.size();
		int maxFlowCamino;
		ArrayList<Integer> camino;
		int destino;
		for (int i = 0; i < size; i++) {
			maxFlowCamino = caminos.get(i).getX();
			camino = caminos.get(i).getY();
			camino.remove(camino.size()-1);							//Eliminem el sumidero que es una base que hem utilitzat per fer el càlcul del maxFlow
			destino = camino.get(camino.size()-1);			
			
			
			Iterator<String> rebels = destins.keySet().iterator();
			String idRebel = "";
			
			//Recorrem el hashMap de destins i anem buscant rebels que tenien assignat aquell destí.
			//Per cada un que trobem li assignem el cami i el guardem en la variable camins, sempre i quan
			//el nombre de rebels trobats per aquell destí sigui menor al maxFlowCamino assignat per aquell camí. 
			while(rebels.hasNext() && maxFlowCamino>0){
				idRebel = rebels.next();
				if(destins.get(idRebel)==destino && maxFlowCamino>0){
					camins.put(idRebel, camino);
					maxFlowCamino--;	//Decrementem el maxFlow d'aquest camí pk ja li hem assignat un rebel
				}
			}
		}
	}

	public FordFulkerson<Base> getFf() {
		return ff;
	}


	public String getIdExode(){
		return idExode;
	}
	
	
	public void execucioBFS() throws IOException {
		//TODO execucioBFS Importar codi de laltre grup
		ff = new EdmondsKarp<Base>(flow, flow, grafInicial);
		
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base();
		
		grafResidual = grafInicial; 
		grafResidual.afegirNode(b);
		
		HashMap<Integer,Integer> destinsResum = getDestinsResum(); 
		
		ArrayList<Integer> dests = new ArrayList<Integer>(destinsResum.keySet());
		int sizeDests = dests.size();
		for (int i = 0; i < sizeDests; i++){
			//LA CAPACITAT DE LA ARESTA QUE VA AL SUMIDERO ES EL NUMERO DE REBELS QUE VAN A AQUELL DESTÍ!!!!!!!
			grafResidual.conectarNodes(dests.get(i), b.getId(), destinsResum.get(dests.get(i)), Double.MIN_VALUE);
		}
		
		
		grafResidual = ff.findMaxFlow(grafResidual, idBaseInici, b.getId());
		flow = ff.getMaxFlow();
		generaCamins(ff.getCaminos());
		
	}
	
	//S'afegeix un rebel a l'exode només si aquest forma part de la tropa del capità
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
	
	//Modifica la base destí del rebel. Es marca com a desactualitzat el rebel
	public void modificarRebel(String idRebel,Integer idBaseDesti) {
		destins.put(idRebel, idBaseDesti);
		actualitzat = false;		
	}

	//Borra un rebel del exode i marca com a desactualitzat el exode. Retorna true si existia el rebel 
	//assignat al exode o false en cas contrari.
	public boolean borrarRebel(String idRebel) {
		Integer r = destins.remove(idRebel);
		actualitzat = false;
		return (r!=null);
	}

	public ArrayList<Integer> getAmpolla() {
		//retornara el conjunt d'arestes que fa coll d'ampolla
		//TODO a fer el metode per detectar colls d'ampolla
		return null;
	}
	
	// Getters i setters
	
	public Integer getIdBaseInici() {
		return idBaseInici;	
	}

	public void setIdBaseInici(Integer idBaseInici) {
		this.idBaseInici = idBaseInici;
	}

	public ArrayList<String> getRebels() {
		return rebels;
	}

	public void setRebels(ArrayList<String> rebels) {
		this.rebels = rebels;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Integer getFlow() {
		return flow;
	}
	
	public void setFlow(Integer flow) {
		this.flow = flow;
	}

}