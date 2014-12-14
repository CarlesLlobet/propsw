package propsw;

//@author Toni Martï¿½nez

import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;



public class CapitaControlador {
	
	//Contenidor de capitans
	private ContenidorCapitans contCap;
	//id del capita que ha iniciat la sessio
	private String idCap = "";


	public CapitaControlador(){
		
		contCap = new ContenidorCapitans();
	}
	
	//Mï¿½tode per implementar de moment implementaciï¿½ trivial
	//Ha de chekejar si el username i el password pertanyen a un capitï¿½. Aquesta
	//informaciï¿½ estarï¿½ en un fitxer. Per fer aquesta implementaciï¿½ es necessita
	//tenir accï¿½s a la capa de dades que no estï¿½ implementada en aquesta versiï¿½.
	//Ultima versió: El metode busca de tots els capitans que hi ha en el contenidor capitans
	//busca un d'ells que coincideixi nom i password.
	//Si existeix aleshores retorna el objecte capita, sino retorna un null.
	public Capita login(String nom, String password) {
		Capita c = null;		
		Iterator<String> str = ContenidorCapitans.getHashContenidor().keySet().iterator();
		String h = "";
		boolean found = false;
		while(str.hasNext()&&!found){
			h = str.next();
			c = ContenidorCapitans.getHashContenidor().get(h);
			if(c.getNom().equals(nom)== true && c.getPassword().equals(password)==true){
				idCap = c.getId();
				found = true;
			}	
			if (!str.hasNext() && !found) c=null;
		}		
		return c;
	}

	
	//Get galaxia d'un capitï¿½ en concret.
	public Galaxia getGalaxia(String idCapita) {
		return contCap.getCapita(idCapita).getGalaxia();
	}
	//Get galaxia del capitï¿½ que ha iniciat sessiï¿½
	public Galaxia getGalaxia() {
		return contCap.getCapita(idCap).getGalaxia();
	}

	//Llista de tots els rebels que estan sota les ordres d'un capita
	public ArrayList<Rebel> llistarRebels(String idCapita) {
		return new ArrayList<Rebel>(contCap.getCapita(idCapita).getRebels().values());
	}
	
	//Llista tots els rebels que estan sota les ordres del capita que ha iniciat la sessiï¿½
	public ArrayList<Rebel> llistarRebels() {
		return new ArrayList<Rebel>(contCap.getCapita(idCap).getRebels().values());
	}

	//Crear un rebel a les ordres del capita que ha iniciat sessiï¿½
	public String crearRebel(String nomRebel) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCap).getRebels().put(r.getId(), r);
		return r.getId();
	}
	
	//Crear un rebel a les ordres d'un capitï¿½
	public String crearRebel(String nomRebel, String idCapita) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCapita).getRebels().put(r.getId(), r);
		return r.getId();
	}

	//Retorna l'objecte Rebel a les ordres del capitï¿½ que ha iniciat sessiï¿½
	//que tï¿½ el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no estï¿½ a les ordres del capita que ha iniciat la sessiï¿½.
	public Rebel getRebel(String idRebel) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}
	
	//Retorna l'objecte Rebel a les ordres del capitï¿½ que ha iniciat sessiï¿½
	//que tï¿½ el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no estï¿½ a les ordres del capita que ha iniciat la sessiï¿½.
	public Rebel getRebel(String idRebel, String idCapita) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}

	
	//Crear un exode a la galaxia que contï¿½ el capitï¿½ que ha iniciat la sessiï¿½
	public String crearExode(int idBaseInici) throws IOException {
		Exode e = new Exode(getGalaxia());
		e.setIdBaseInici(idBaseInici); 								//Posem la base d'inici, on comenï¿½a l'ï¿½xode
		getGalaxia().addExode(e);									//Assignem l'ï¿½xode a la galaxia del capitï¿½ que ha inicat sessiï¿½
		return e.getIdExode();
	}

	//Crear un exode a la galaxia que contï¿½ un capitï¿½ en concret
	public String crearExode(int idBaseInici, String idCapita) throws IOException {
		Exode e = new Exode(getGalaxia());
		e.setIdBaseInici(idBaseInici); 									//Posem la base d'inici, on comenï¿½a l'ï¿½xode
		getGalaxia(idCapita).addExode(e);								//Assignem l'ï¿½xode a la galaxia del capitï¿½.
		return e.getIdExode();
	}

	
	//Elimina un rebel dels assignats a un capitï¿½. L'elimina tb de tots els ï¿½xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessiï¿½ 
	public boolean eliminarRebel(String idRebel) {
		Rebel j = contCap.getCapita(idCap).getRebels().remove(idRebel);		//Mï¿½tode remove de un hashmap retorna null 
																			//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCap).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCap).getExode(exodes.get(i)).getRebels().remove(j);
			}
			
		}
		
		return (j!=null);
	}
	
	
	//Elimina un rebel dels assignats a un capitï¿½. L'elimina tb de tots els ï¿½xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessiï¿½ 
	public boolean eliminarRebel(String idRebel, String idCapita) {
		Rebel j = contCap.getCapita(idCapita).getRebels().remove(idRebel);		//Mï¿½tode remove de un hashmap retorna null 
																				//si no hi ha cap Rebel associat amb el seu id
		if((j!=null)){
			ArrayList<String> exodes = getGalaxia(idCapita).getExodes();									
			int size = exodes.size();
			//Per a cada exode de la galaxia es borra el rebel que tenia assignat.
			for (int i = 0; i < size; i++) {
				getGalaxia(idCapita).getExode(exodes.get(i)).getRebels().remove(j);
			}
		}
		
		return (j!=null);
	}
	

	//Elimina l' ï¿½xode de la galaxia del capita que ha iniciat la sessiï¿½ i actualitza el llistat  
	//de exodes de cada rebel que estaba assignat a l'ï¿½xode.
	public boolean eliminarExode(String idExode) throws IOException {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia().getExode(idExode);
		if(e!=null){
			ArrayList<String> laTropa = e.getRebels();
			int size = getGalaxia().getExode(idExode).getRebels().size();
			for (int i = 0; i < size; i++) {
				getCapita().getRebels().get(laTropa.get(i)).getExodes().remove(idExode);
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessiï¿½
			return true;
		}else{
			return false;
		}
	}

	
	//Elimina l' ï¿½xode de la galaxia del capita que ha iniciat la sessiï¿½ i actualitza el llistat 
	//de exodes de cada rebel que estaba assignat a l'ï¿½xode.
	public boolean eliminarExode(String idExode, String idCapita) throws IOException {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia(idCapita).getExode(idExode);
		if(e!=null){
			ArrayList<String> laTropa = e.getRebels();
			int size = getGalaxia(idCapita).getExode(idExode).getRebels().size();
			for (int i = 0; i < size; i++) {
				getCapita(idCapita).getRebels().get(laTropa.get(i)).getExodes().remove(idExode);
			}
			getGalaxia(idCapita).removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessiï¿½
			return true;
		}else{
			return false;
		}
	}

	//Retorna l'objecte Capita que tï¿½ l'identificador idCapita.
	public Capita getCapita(String idCapita) {
		return contCap.getCapita(idCapita);
	}

	//Retorna l'objecte Capita del capita que ha inicat la sessiï¿½.
	public Capita getCapita() {
		System.out.println("ID CAP ES :" + idCap);
		return contCap.getCapita(idCap);
	}
	//Retorna un false si no existeix el rebel amb el idRebel passat
	public boolean modificaRebel(String nom, String idRebel){
		Rebel r = getCapita().getRebels().get(idRebel); 
		if(r!=null){
			r.setNom(nom);
			return true;
		}else{
			return false;
		}
	}
	
	
	public void canviContra(String s){
		getCapita().setPassword(s);
	}
	
	public void logOut(){
		idCap=null;
		try {
			exportarContenidorCapitans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void afegirCapita(Capita c) throws IOException{
		contCap.addCapita(c);
	}
	
	public void afegirCapita(String s) throws IOException{
		System.out.println("Agegim un capita amb nom " + s);
		Capita c  = new Capita(s);
		System.out.println("I id: " + c.getId());
		contCap.addCapita(c);
	}
	
	public void inicialitzar() throws Exception{
		File file=new File("./bd.dat");
		if(file.exists() && file.length() != 0){
			System.out.println("EXISTE EL ARCHIVO");
			LlegirEscriure lle=new LlegirEscriure();
			lle.importar();
		}
		else{
			System.out.println("NO EXISTE EL ARCHIVO, LO CREAMOS");
			if (file.length() == 0) file.delete();
			Capita c = new Capita("admin");
			contCap.addCapita(c);
			idCap = c.getId();
			file.createNewFile();
		}
	}
	
	/**
	 * Carrega el fitxer binari que conté el contenidor de capitans
	 * @throws Exception
	 */
	public void importarContenidorCapitans() throws Exception{
		LlegirEscriure lle=new LlegirEscriure();
		lle.importar();
	}
	
	/**
	 * Exporta el fitxer binari que conté el contenidor de capitans
	 * @throws Exception
	 */
	public void exportarContenidorCapitans() throws Exception{
		LlegirEscriure lle=new LlegirEscriure();
		lle.exportar();
	}
	
	/**
	 * Esborra el fitxer binari que conté el contenidor de capitans, esborra
	 * el hashmap contenidor i fa un logout del capità actual
	 * @throws IOException
	 */
	public void resetSistema() throws IOException{
		LlegirEscriure lle=new LlegirEscriure();
		lle.eliminarFitxer();
		ContenidorCapitans.getHashContenidor().clear();
	}
	

	public void escriureCont(){
		System.out.println("CONTENIDOR CAPITA");
		Set<String> set = contCap.getHashContenidor().keySet();
		int i = 1;
		for (String s : set){
			System.out.println("User " + String.valueOf(i) + ": " + contCap.getCapita(s).getNom());
			++i;
		}		
	}
	
	public boolean checkCapitaNom(String s){
		System.out.println("S ES: " + s);
		Capita c = null;		
		Iterator<String> str = ContenidorCapitans.getHashContenidor().keySet().iterator();
		String h = "";
		boolean found = false;
		while(str.hasNext()&&!found){
			h = str.next();
			c = ContenidorCapitans.getHashContenidor().get(h);
			System.out.println("Nom Capita: " + c.getNom());
			System.out.println("Pass capita: " + c.getPassword());
			if(c.getNom().equals(s)){
				found = true;
			}			
		}		
		return found;
	}
	
	public void deleteCapita(){
		contCap.deleteCapita(idCap);
		logOut();
	}
}