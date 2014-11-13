package propsw;

//@author Toni Martínez

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;


public class CapitaControlador {
	
	//Contenidor de capitans
	private ContenidorCapitans contCap;
	//id del capita que ha iniciat la sessio
	private String idCap = "";


	public CapitaControlador(){
		contCap = new ContenidorCapitans();
	}
	
	//Métode per implementar de moment implementació trivial
	//Ha de chekejar si el username i el password pertanyen a un capità. Aquesta
	//informació estarà en un fitxer. Per fer aquesta implementació es necessita
	//tenir accés a la capa de dades que no està implementada en aquesta versió.
	public void login(String nom, String password) {
		Capita c = new Capita("Luke Skywalker");
		contCap.addCapita(c);
		idCap = c.getId();
	}

	
	//Get galaxia d'un capità en concret.
	public Galaxia getGalaxia(String idCapita) {
		return contCap.getCapita(idCapita).getGalaxia();
	}
	//Get galaxia del capità que ha iniciat sessió
	public Galaxia getGalaxia() {
		return contCap.getCapita(idCap).getGalaxia();
	}

	//Llista de tots els rebels que estan sota les ordres d'un capita
	public ArrayList<Rebel> llistarRebels(String idCapita) {
		return new ArrayList<Rebel>(contCap.getCapita(idCapita).getRebels().values());
	}
	
	//Llista tots els rebels que estan sota les ordres del capita que ha iniciat la sessió
	public ArrayList<Rebel> llistarRebels() {
		return new ArrayList<Rebel>(contCap.getCapita(idCap).getRebels().values());
	}

	//Crear un rebel a les ordres del capita que ha iniciat sessió
	public void crearRebel(String nomRebel) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCap).getRebels().put(r.getId(), r);
	}
	
	//Crear un rebel a les ordres d'un capità
	public void crearRebel(String nomRebel, String idCapita) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCapita).getRebels().put(r.getId(), r);
	}

	//Retorna l'objecte Rebel a les ordres del capità que ha iniciat sessió
	//que té el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no està a les ordres del capita que ha iniciat la sessió.
	public Rebel getRebel(String idRebel) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}
	
	//Retorna l'objecte Rebel a les ordres del capità que ha iniciat sessió
	//que té el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no està a les ordres del capita que ha iniciat la sessió.
	public Rebel getRebel(String idRebel, String idCapita) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}

	
	//Crear un exode a la galaxia que conté el capità que ha iniciat la sessió
	public void crearExode(int idBaseInici) {
		Exode e = new Exode();
		e.setidBaseInici(idBaseInici); 								//Posem la base d'inici, on comença l'èxode
		getGalaxia().addExode(e);									//Assignem l'èxode a la galaxia del capità que ha inicat sessió
	}

	//Crear un exode a la galaxia que conté un capità en concret
	public void crearExode(int idBaseInici, String idCapita) {
		Exode e = new Exode();
		e.setidBaseInici(idBaseInici); 									//Posem la base d'inici, on comença l'èxode
		getGalaxia(idCapita).addExode(e);								//Assignem l'èxode a la galaxia del capità.
	}

	
	//Elimina un rebel dels assignats a un capità. L'elimina tb de tots els èxodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessió 
	public boolean eliminarRebel(String idRebel) {
		Rebel j = contCap.getCapita(idCap).getRebels().remove(idRebel);		//Mètode remove de un hashmap retorna null 
																			//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCap).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCap).getExode(exodes.get(i)).getrebels().remove(j);
			}
			
		}
		
		return (j!=null);
	}
	
	
	//Elimina un rebel dels assignats a un capità. L'elimina tb de tots els èxodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessió 
	public boolean eliminarRebel(String idRebel, String idCapita) {
		Rebel j = contCap.getCapita(idCapita).getRebels().remove(idRebel);		//Mètode remove de un hashmap retorna null 
																				//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCapita).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCapita).getExode(exodes.get(i)).getrebels().remove(j);
			}
		}
		
		return (j!=null);
	}
	

	//Elimina l' èxode de la galaxia del capita que ha iniciat la sessió i actualitza el llistat  
	//de exodes de cada rebel que estaba assignat a l'èxode.
	public boolean eliminarExode(String idExode) {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia().getExode(idExode);
		if(e!=null){
			ArrayList<Rebel> laTropa = e.getrebels();
			int size = getGalaxia().getExode(idExode).getrebels().size();
			for (int i = 0; i < size; i++) {
				laTropa.get(i).getExodes().remove(idExode);							
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessió
			return true;
		}else{
			return false;
		}
	}

	
	//Elimina l' èxode de la galaxia del capita que ha iniciat la sessió i actualitza el llistat 
	//de exodes de cada rebel que estaba assignat a l'èxode.
	public boolean eliminarExode(String idExode, String idCapita) {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia(idCapita).getExode(idExode);
		if(e!=null){
			ArrayList<Rebel> laTropa = e.getrebels();
			int size = getGalaxia(idCapita).getExode(idExode).getrebels().size();
			for (int i = 0; i < size; i++) {
				laTropa.get(i).getExodes().remove(idExode);						
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessió
			return true;
		}else{
			return false;
		}
	}

	//Retorna l'objecte Capita que té l'identificador idCapita.
	public Capita getCapita(String idCapita) {
		return contCap.getCapita(idCapita);
	}

	//Retorna l'objecte Capita del capita que ha inicat la sessió.
	public Capita getCapita() {
		return contCap.getCapita(idCap);
	}
}