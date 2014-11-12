package propsw;

import java.util.ArrayList;
import java.util.HashMap;


public class Exode {
	private int idBaseInici;
	private ArrayList<Rebel> rebels;
	private HashMap<String,ArrayList<Integer>> camins;
	private HashMap<String,Integer> destins;
	private Graf<Base> grafResidual;
	private Graf<Base> grafInicial;
	private int flow;
	private static Integer cont = 0;
	private double cost;
	private boolean actualitzat;
	private String idExode;
	private FordFulkerson ff;
	//public Galaxia MISSING;
	//public FordFoulkerson MISSING;
	
	
	public Exode(){
		++cont;
		this.idExode = cont.toString();
	}

	public ArrayList<Integer> getDestins() {
		return null;
	}

	public void execucioDijkstra() {
	}

	public void execucioDFS() {
	}

	public void execucioBFS() {
	}

	public boolean afegirRebel(String idRebel) {
		return false;
	}
	
	public void modificarRebel(String idRebel,Integer idBaseDesti) {
		destins.put(idRebel, idBaseDesti);
	}

	public boolean borrarRebel(String idRebel) {
		return false;
	}

	public ArrayList<Integer> getAmpolla() {
		return null;
	}
	
	// Getters i setters COMPROBAR QUINS NECESITO I QUINS NO
	
	public Integer getidBaseInici() {
		return idBaseInici;	
	}

	public void setidBaseInici(Integer idBaseInici) {
		this.idBaseInici = idBaseInici;
	}

	public ArrayList<Rebel> getrebels() {
		return rebels;
	}

	public void setRebels(ArrayList<Rebel> rebels) {
		this.rebels = rebels;
	}

	public Double getcost() {
		return cost;
	}

	public void setcost(Double cost) {
		this.cost = cost;
	}
	
	public Integer getflow() {
		return flow;
	}
	
	public void setflow(Integer flow) {
		this.flow = flow;
	}

}