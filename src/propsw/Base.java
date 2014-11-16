/*
 * Autor:Marcos Pérez
 * Grup 44 - 9.1
 */

package propsw;

import java.io.IOException;

public class Base {
	
	//Paràmetres privats

	private String nom = null;
	private Galaxia g;
	
	//Constructors
	public Base(Galaxia g) throws IOException{
		this.g = g;
		g.afegirNode(this);
	}
	
	public Base(String nom, Galaxia g) throws IOException{
		this.nom = nom;
		this.g = g;
		g.afegirNode(this);
	}
	
	public String getNom(){
		return this.nom;
	}
	
	//Setters
	public boolean setNom(String nom){
		this.nom=nom;
		return true;
	}

	@Override
	public String toString() {
		String res = new String();
		try {
			 res = nom + "\t-\t" + Integer.toString(getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int getId() throws IOException{
		int toRet=-1;
		for (int i = 0; i < g.getNSize(); i++) {
			if(g.getNode(i)==this){
				toRet = i;
			}
		}
		return toRet;
	}
	
}
