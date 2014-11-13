/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */ 

package propsw;
import java.io.*;
import java.lang.String;
import java.util.Iterator;
import java.util.Map;
import com.google.gson.*;

public class GalaxiaControlador extends CapitaControlador {
	
	
	//Constructor
	public GalaxiaControlador(){
	}
	
	//Crear Galàxia sense arguments i amb arguments
	public Galaxia CrearGalaxia() {
		Galaxia g=new Galaxia();
		return g;
	}
	
	public Galaxia Importar(String str) {
		Galaxia galOut=new Galaxia();
		Gson gson= new Gson();
		galOut=gson.fromJson(str, Galaxia.class);
		return galOut;
	}
	
	public String Exportar() {
		 Gson gson = new Gson();
		 String galExport=gson.toJson(getGalaxia());
		 return galExport;
	}

	//Es resetejen tots els camps de galaxia
	public Galaxia reset() {
		getGalaxia().exodes.clear();
		getGalaxia().bases.clear();
		getGalaxia().algoritme=null;
		
		return getGalaxia();
	}

	public void afegirBase(String nom) {
		Base newBase=new Base(nom);
		getGalaxia().addBase(newBase);
	}

	public boolean esborrarBase(int idBase) {
		
		if(getGalaxia().bases.containsKey(idBase)){
			getGalaxia().bases.remove(idBase);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean modificarBase(int idBase, String nom) {
		
		if(getGalaxia().bases.containsKey(idBase)){
			getGalaxia.bases.put(idBase,nom);
			return true;
		}
		else{
			return false;
		}
	}

	//Crea un string amb un llistat del id i el nom de totes les bases de la galàxia
	public String llistarBases() {
		String str=new String();
		
		for (Map.Entry<String, Base> entry : getGalaxia().bases.entrySet()) {
		    str+=entry.getKey()+"\t"+toString(getGalaxia().getNodeBaseId(entry.getValue()))+"\n";
		}
		return str;
	}

	//Crea una aresta entre dues bases especificades pel seu id
	public boolean crearAdjacencia(int from, int to, int capacitat, double cost) {
		try{
		getGalaxia().conectarNodes(from,to,capacitat,cost);
		}
		catch(IOException e){
			return false;
		}
		return true;
	}

	public boolean eliminarAdjacencia(int from, int to) {
		try{
			getGalaxia().removeAresta(from,to);
		}
		catch(IOException e){
			return false;
		}
		return true;
	}

	//Genera un objecte Aresta, l'omple amb els valors de les seves variables corresponents i el retorna
	public Galaxia.Aresta getAdjacencia(int from, int to) {
		
		try{
		int idAresta=getGalaxia().getIDAresta(from,to);
		int capacitat=getGalaxia().getCapacidadAresta(idAresta);
		double cost=getGalaxia().getCosteAresta(idAresta);
		int fluxe=getGalaxia().getFlujoAresta(idAresta);
		
		getGalaxia().Aresta aresta= new getGalaxia().Aresta(capacitat,cost);
		getGalaxia().setFlujoAresta(idAresta,fluxe);
		}
		catch(IOException e){
			throw new IOException("Exception: No existeix l'id de l'aresta")
		}
		return aresta;
	}
}