/*
 * @Author: Marc Ronquillo González
 * Grup 44 - 9.1
 */ 

package propsw;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;

public class GalaxiaControlador{
	
	CapitaControlador capiControl;
	
	/**
	 * Constructor d'un objecte GalaxiaControlador.
	 */
	public GalaxiaControlador(){
		
	}
	
	/**
	 * Crea un objecte de la classe Galaxia.
	 * @return Objecte Galaxia instanciat
	 */
	public Galaxia createGalaxia() {
		new CapitaControlador();
		Galaxia g=new Galaxia(getCapita());
		return g;
	}

	/**
	 * Es borren tots els camps de l'objecte Galaxia actual.
	 * @return Objecte de la classe Galaxia resetejat
	 */
	public Galaxia resetGalaxia() {
		
		Galaxia g = new Galaxia(getCapita());
		getCapita().setGalaxia(g);
	
		return g;
	}

	/**
	 * Afegeix una Base a la Galaxia
	 * @param nom nom de la Base afegida
	 * @throws IOException
	 */
	public void addBase(String nom) throws IOException{
		new Base(nom,getGalaxia());
	}

	/**
	 * S'esborra la base amb la id indicada al paràmetre
	 * @param idBase id de la Base a esborrar
	 * @return Booleà que indica si l'identificador de la base es correspon amb una base existent.
	 * @throws IOException si id no existeix
	 */
	public void deleteBase(int idBase) throws IOException{
		
			getGalaxia().removeBase(idBase);
		
	}

	/**
	 * Es canvia el nom a la Base indicada
	 * @param idBase identificador de la Base a editar
	 * @param nom Nou nom que prendrà la base
	 * @return Booleà que indica si l'identificador de la base es correspon amb una base existent.
	 * @throws IOException si id no existeix
	 */
	public void setBase(int idBase, String nom) throws IOException{
		
			getGalaxia().getBase(idBase).setNom(nom);
		
	}

	/**
	 * Llistat de totes les bases de la Galàxia
	 * @return String que conté l'id i el nom de totes les bases de la Galàxia actual.
	 * @throws IOException si id no existeix
	 */
	public String listBases() throws IOException{
		
		String str;
		ArrayList <Base> bases=getGalaxia().getBaseArray();
		str=bases.toString();
		return str;
	}

	/**
	 * Crea una aresta entre dues bases
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @param capacitat Valor de capacitat que prendrà 
	 * @param cost
	 * @throws IOException si id no existeix
	 */
	public void createAdjacency(int from, int to, int capacitat, double cost) throws IOException{
		
		getGalaxia().conectarNodes(from,to,capacitat,cost);
	}
	
	/**
	 * Modifica els valors de cost i capacitat d'un tram entre dues bases.
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @param capacitat Valor actualitzat de capacitat del tram
	 * @param cost valor actualitzat de cost del tram 
	 * @throws IOException si id no existeix
	 */
	public void setAdjacency(int from, int to, int capacitat, double cost)throws IOException{
		
		int idAresta=getGalaxia().getIDAresta(from,to);
		getGalaxia().substituirAresta(idAresta, capacitat, cost);
	}

	/**
	 * S'elimina un tram entre dues bases.
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @throws IOException si id no existeix
	 */
	public void deleteAdjacencia(int from, int to) throws IOException{
		
		getGalaxia().removeAresta(from,to);
	}

	/**
	 * Retorna la aresta demanada del graf
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @return objecte aresta demanat
	 * @throws IOException si id no existeix
	 */
	public Galaxia.Aresta getAdjacency(int from, int to) throws IOException {
		
		int idAresta=getGalaxia().getIDAresta(from,to);
		int capacitat=getGalaxia().getCapacidadAresta(idAresta);
		double cost=getGalaxia().getCosteAresta(idAresta);
		int fluxe=getGalaxia().getFlujoAresta(idAresta);
		
		Galaxia.Aresta aresta= new Galaxia.Aresta(capacitat,cost);
		getGalaxia().setFlujoAresta(idAresta,fluxe);

		return aresta;
	}
	
	/**
	 * Llista els exodes existents per la Galàxia
	 * @return un string amb els ids dels èxodes
	 */
	public String listExodes(){
		String sRet=getGalaxia().getExodes().toString();
		return sRet;
	}
	
	/**
	 * @Override
	 */
	public Galaxia getGalaxia(){
		return capiControl.getGalaxia();
	}
	
	/**
	 * @Override
	 */
	public Capita getCapita(){
		return capiControl.getCapita();
	}
	
}