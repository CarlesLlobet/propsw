package propsw;


import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;

public class CapitaControlador {
	
	//Contenidor de capitans
	private HashMap<String,Capita> contCap;
	//id del capita que ha iniciat la sessio
	private String idCap = "";


	public CapitaControlador(){
		
	}
	public void login(String nom, String password) {
	}

	public Galaxia getGalaxia(int idCapita) {
		return null;
	}

	public ArrayList<Rebel> llistarRebels() {
		return null;
	}

	public void crearRebel(String nom) {
	}

	public Rebel getRebel(String idRebel) {
		return null;
	}

	public void crearExode(int idBaseInici) {
	}

	public boolean eliminarRebel(String idRebel) {
		return false;
	}

	public boolean eliminarExode(String idExode) {
		return false;
	}

	public Capita getCapita(String idCapita) {
		return null;
	}
}