/*
 * @Author: Marc Ronquillo González
 * Grup 44 - 9.1
 */ 

package propsw;
import java.io.*;
import java.lang.String;

public class GalaxiaControlador extends CapitaControlador {
	
	CapitaControlador capiControl;
	/**
	 * Constructor d'un objecte GalaxiaControlador.
	 */
	public GalaxiaControlador(){
		capiControl=new CapitaControlador();
		capiControl.login("a", "b");
		
	}
	
	/**
	 * Crea un objecte de la classe Galaxia.
	 * @return Objecte Galaxia instanciat
	 */
	public Galaxia createGalaxia() {
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
		Base newBase=new Base(nom,getGalaxia());
		getGalaxia().addBase(newBase);
	}

	/**
	 * S'esborra la base amb la id indicada al paràmetre
	 * @param idBase id de la Base a esborrar
	 * @return Booleà que indica si l'identificador de la base es correspon amb una base existent.
	 */
	public boolean deleteBase(Integer idBase) {
		
		String idStr=idBase.toString();
		if(getGalaxia().getBase(idStr)!=null){
			getGalaxia().removeBase(idStr);
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Es canvia el nom a la Base indicada
	 * @param idBase identificador de la Base a editar
	 * @param nom Nou nom que prendrà la base
	 * @return Booleà que indica si l'identificador de la base es correspon amb una base existent.
	 */
	public boolean setBase(Integer idBase, String nom) {
		
		String str=idBase.toString();
		
		if(getGalaxia().getBase(str)!=null){
			getGalaxia().getBase(str).setNom(nom);
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Llistat de totes les bases de la Galàxia
	 * @return String que conté l'id i el nom de totes les bases de la Galàxia actual.
	 */
	public String listBases() {
		String str;
		str=getGalaxia().getBaseHash().toString();
		return str;
	}

	/**
	 * Crea una aresta entre dues bases
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @param capacitat Valor de capacitat que prendrà 
	 * @param cost
	 * @throws IOException
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
	 * @throws IOException
	 */
	public void setAdjacency(int from, int to, int capacitat, double cost)throws IOException{
		
		int idAresta=getGalaxia().getIDAresta(from,to);
		getGalaxia().substituirAresta(idAresta, capacitat, cost);
	}

	/**
	 * S'elimina un tram entre dues bases.
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @throws IOException
	 */
	public void deleteAdjacencia(int from, int to) throws IOException{
		
		getGalaxia().removeAresta(from,to);
	}

	/**
	 * Retorna la aresta demanada del graf
	 * @param from identificador de la Base de la qual ha de partir l'adjacència.
	 * @param to identificador de la Base a la qual ha d'anar a parar l'adjacència.
	 * @return objecte aresta demanat
	 * @throws IOException
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
	
	@Override
	public Galaxia getGalaxia(){
		return capiControl.getGalaxia();
	}
	
	@Override
	public Capita getCapita(){
		return capiControl.getCapita();
	}
}