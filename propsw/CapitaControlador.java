package propsw;

//@author Toni Mart�nez

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	
	//M�tode per implementar de moment implementaci� trivial
	//Ha de chekejar si el username i el password pertanyen a un capit�. Aquesta
	//informaci� estar� en un fitxer. Per fer aquesta implementaci� es necessita
	//tenir acc�s a la capa de dades que no est� implementada en aquesta versi�.
	//Ultima versi�: El metode busca de tots els capitans que hi ha en el contenidor capitans
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

	
	//Get galaxia d'un capit� en concret.
	public Galaxia getGalaxia(String idCapita) {
		return contCap.getCapita(idCapita).getGalaxia();
	}
	//Get galaxia del capit� que ha iniciat sessi�
	public Galaxia getGalaxia() {
		String idCap = this.idCap;
		return contCap.getCapita(idCap).getGalaxia();
	}

	//Llista de tots els rebels que estan sota les ordres d'un capita
	public ArrayList<Rebel> llistarRebels(String idCapita) {
		return new ArrayList<Rebel>(contCap.getCapita(idCapita).getRebels().values());
	}
	
	//Llista tots els rebels que estan sota les ordres del capita que ha iniciat la sessi�
	public ArrayList<Rebel> llistarRebels() {
		return new ArrayList<Rebel>(contCap.getCapita(idCap).getRebels().values());
	}

	//Crear un rebel a les ordres del capita que ha iniciat sessi�
	public String crearRebel(String nomRebel) {
		Rebel r = new Rebel(nomRebel);
		contCap.getCapita(idCap).getRebels().put(r.getId(), r);
		return r.getId();
	}
	
	//Crear un rebel a les ordres d'un capit�
	public String crearRebel(String nomRebel, String idCapita) {
		if(nomRebel != null){
			Rebel r = new Rebel(nomRebel);
			contCap.getCapita(idCapita).getRebels().put(r.getId(), r);
			return r.getId();
		}
		else{
			Rebel r = new Rebel();
			contCap.getCapita(idCapita).getRebels().put(r.getId(), r);
			return r.getId();
		}
	}

	//Retorna l'objecte Rebel a les ordres del capit� que ha iniciat sessi�
	//que t� el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no est� a les ordres del capita que ha iniciat la sessi�.
	public Rebel getRebel(String idRebel) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}
	
	//Retorna l'objecte Rebel a les ordres del capit� que ha iniciat sessi�
	//que t� el idRebel passat per parametre. Retorna null si aquell rebel no existeix
	//o si que existeix pero no est� a les ordres del capita que ha iniciat la sessi�.
	public Rebel getRebel(String idRebel, String idCapita) {
		return contCap.getCapita(idCap).getRebels().get(idRebel);
	}

	
	//Crear un exode a la galaxia que cont� el capit� que ha iniciat la sessi�
	public String crearExode(int idBaseInici) throws IOException {
		Exode e = new Exode(getGalaxia());
		e.setIdBaseInici(idBaseInici); 								//Posem la base d'inici, on comen�a l'�xode
		getGalaxia().addExode(e);									//Assignem l'�xode a la galaxia del capit� que ha inicat sessi�
		return e.getIdExode();
	}

	//Crear un exode a la galaxia que cont� un capit� en concret
	public String crearExode(int idBaseInici, String idCapita) throws IOException {
		Exode e = new Exode(getGalaxia());
		e.setIdBaseInici(idBaseInici); 									//Posem la base d'inici, on comen�a l'�xode
		getGalaxia(idCapita).addExode(e);								//Assignem l'�xode a la galaxia del capit�.
		return e.getIdExode();
	}

	
	//Elimina un rebel dels assignats a un capit�. L'elimina tb de tots els �xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessi� 
	public boolean eliminarRebel(String idRebel) {
		Rebel j = contCap.getCapita(idCap).getRebels().remove(idRebel);		//M�tode remove de un hashmap retorna null 
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
	
	
	//Elimina un rebel dels assignats a un capit�. L'elimina tb de tots els �xodes als que ha estat afegit. 
	//Retorna false si aquell rebel no ha estat assignat al capita que ha iniciat sessi� 
	public boolean eliminarRebel(String idRebel, String idCapita) {
		Rebel j = contCap.getCapita(idCapita).getRebels().remove(idRebel);		//M�tode remove de un hashmap retorna null 
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
	

	//Elimina l' �xode de la galaxia del capita que ha iniciat la sessi� i actualitza el llistat  
	//de exodes de cada rebel que estaba assignat a l'�xode.
	public boolean eliminarExode(String idExode) throws IOException {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia().getExode(idExode);
		if(e!=null){
			ArrayList<String> laTropa = e.getRebels();
			int size = getGalaxia().getExode(idExode).getRebels().size();
			for (int i = 0; i < size; i++) {
				getCapita().getRebels().get(laTropa.get(i)).getExodes().remove(idExode);
			}
			
			getGalaxia().removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessi�
			return true;
		}else{
			return false;
		}
	}

	
	//Elimina l' �xode de la galaxia del capita que ha iniciat la sessi� i actualitza el llistat 
	//de exodes de cada rebel que estaba assignat a l'�xode.
	public boolean eliminarExode(String idExode, String idCapita) throws IOException {
		
		//Per a cada rebel se li elimina el exode si el tenia assignat
		Exode e = getGalaxia(idCapita).getExode(idExode);
		if(e!=null){
			ArrayList<String> laTropa = e.getRebels();
			int size = getGalaxia(idCapita).getExode(idExode).getRebels().size();
			for (int i = 0; i < size; i++) {
				getCapita(idCapita).getRebels().get(laTropa.get(i)).getExodes().remove(idExode);
			}
			getGalaxia(idCapita).removeExode(idExode);								//Eliminem l'exode de la galaxia del capita que ha iniciat la sessi�
			return true;
		}else{
			return false;
		}
	}

	//Retorna l'objecte Capita que t� l'identificador idCapita.
	public Capita getCapita(String idCapita) {
		return contCap.getCapita(idCapita);
	}

	//Retorna l'objecte Capita del capita que ha inicat la sessi�.
	public Capita getCapita() {
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
	
	public boolean modificaRebel(String idCapita, String nom, String idRebel){
		Rebel r = getCapita(idCapita).getRebels().get(idRebel); 
		if(r!=null){
			r.setNom(nom);
			return true;
		}else{
			return false;
		}
	}
	
	public String getNomRebel(String idCapita, String idRebel) throws IOException{
		return contCap.getCapita(idCapita).getRebels().get(idRebel).getNom();
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
	
	
	//Aquesta funci�, donat un array de strings de ids , el passa a int per a ordenarlo i torna a transformarlo a int
	public ArrayList<String> ordenarArrayString(ArrayList<String> a){
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (String s : a){
			aux.add(Integer.parseInt(s));
		}
		Collections.sort(aux);
		a.clear();
		for (Integer i : aux){
			a.add(String.valueOf(i));
		}
		return a;
	}
	

	//Retorna un array d'strings dels rebels del capita
	public ArrayList<String> arrayListRebelsOrd(){
		ArrayList<String> rebels = new ArrayList<String>(getCapita().getRebels().keySet());
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (String s : rebels){
			r.add(Integer.parseInt(s));
		}
		Collections.sort(r);
		rebels.clear();
		for (Integer i : r){
			rebels.add(String.valueOf(i));
		}
		return rebels;
	}
	
	//Aquesta funcion retorna un arraylist amb els ids de tots els capitans que hi ha al sistema ordenats
	public ArrayList<String> arrayListCapOrd(){
		return ordenarArrayString(new ArrayList<String>(contCap.getHashContenidor().keySet()));
	}
	
	
	//Aquesta funci� retorna un array amb tots els ids dels exodes per la galaxia del capita ordenats
	public ArrayList<String> arrayListExodesOrd(){
		return ordenarArrayString(new ArrayList<String>(getCapita().getGalaxia().getExodes()));
	}
	
	//Per al string idReb, cerca tots els exodes als quals el rebel participa i retorna un arraylist de idExode ordenat.
	//AIXO FIJO QUE VA A EXODE - 
	public ArrayList<String> arrayListExodesOrdReb(String idReb){
		ArrayList<String> llistexodes= new ArrayList<String>(getCapita().getGalaxia().getExodes());		
		ArrayList<String> exodes = new ArrayList<String>();
		for(String s : llistexodes){
			if (getCapita().getGalaxia().getExode(s).getRebels().contains(idReb)){
				exodes.add(s);
			}
		}
		//Ho ordenem:
		return ordenarArrayString(exodes);
	}
	
	public ArrayList<String> arrayListExodesOrdReb(String idcap, String idReb){
		ArrayList<String> llistexodes= new ArrayList<String>(getCapita(idcap).getGalaxia().getExodes());		
		ArrayList<String> exodes = new ArrayList<String>();
		for(String s : llistexodes){
			if (getCapita(idcap).getGalaxia().getExode(s).getRebels().contains(idReb)){
				exodes.add(s);
			}
		}
		//Ho ordenem:
		return ordenarArrayString(exodes);
	}
	
	
	/**
	 * Carrega el fitxer binari que cont� el contenidor de capitans
	 * @throws Exception
	 */
	public void importarContenidorCapitans() throws Exception{
		LlegirEscriure lle=new LlegirEscriure();
		lle.importar();
	}
	
	/**
	 * Exporta el fitxer binari que cont� el contenidor de capitans
	 * @throws Exception
	 */
	public void exportarContenidorCapitans() throws Exception{
		LlegirEscriure lle=new LlegirEscriure();
		lle.exportar();
	}
	
	/**
	 * Esborra el fitxer binari que cont� el contenidor de capitans, esborra
	 * el hashmap contenidor i fa un logout del capit� actual
	 * @throws IOException
	 */
	public void resetSistema() throws IOException{
		LlegirEscriure lle=new LlegirEscriure();
		lle.eliminarFitxer();
		ContenidorCapitans.getHashContenidor().clear();
		
		setContRebel(0);
		ExodeControlador.setCont(0);
		setCont(0);
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
	
	/**
	 * Actualitza el contador de ids de Capitans.
	 * @param i valor enter al qual es posar� el contador de ids.
	 */
	public static void setCont(int i){
		Capita.setCont(i);
	}
	
	/**
	 * Actualitza el contador de ids de Rebels.
	 * @param i valor enter al qual es posar� el contador de ids.
	 */
	public static void setContRebel(int i){
		Rebel.setCont(i);
	}
	
	
	public void setIdCap(String idCap){
		this.idCap = idCap;
	}
}