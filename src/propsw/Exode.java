package propsw;

import java.util.ArrayList;


public class Exode {
	public int idBaseInici;
	public ArrayList<Rebel> rebels;
	public int camins;
	public int destins;
	public Graf<Base> grafResidual;
	public Graf<Base> grafInicial;
	public int flow;
	public static Integer cont = 0;
	public double cost;
	public boolean actualitzat;
	public String idExode;
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

	public boolean borrarRebel(String idRebel) {
		return false;
	}

	public ArrayList<Integer> getAmpolla() {
		return null;
	}
}