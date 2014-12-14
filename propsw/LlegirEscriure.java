/*
 /*
 * @Author: Marc Ronquillo González
 * Grup 44 - 9.1
 */


package propsw;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class LlegirEscriure {

	private HashMap<String, Capita> contCap;
	ContenidorCapitans cp;
	String path="./bd.dat";
	
	/**
	 * Constructor que inicialitza una variable ContenidorCapitans i la usa per accedir al hashmap, 
	 * que es fa servir per tenir una còpia del hashmap a la classe amb la que treballar.
	 */
	public LlegirEscriure(){
		cp=new ContenidorCapitans(true);
		contCap=ContenidorCapitans.getHashContenidor();
	}
	
	/**
	 * Crida al mètode llegir
	 * @throws Exception
	 */
	public void importar() throws Exception{
		llegir(path);
	}
	
	/**
	 * Importa els objectes que hi havia al fitxer i els afegeix al contenidor de capitans
	 * @param fitxer path del fitxer
	 * @throws Exception
	 */
	public void llegir(String fitxer) throws Exception{
		System.out.println("ESTAMOS LEYENDO");
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fitxer));
		Capita aux=(Capita) ois.readObject();
		
		while (aux!=null){
			ContenidorCapitans.addCapita(aux);
			aux = null;
			try{
				aux =(Capita) ois.readObject();
			}catch(EOFException e){
				aux=null;
			}
		}
		ois.close();
		CapitaControlador.setCont(ContenidorCapitans.getHashContenidor().size()+1);
	
	}
	
	/**
	 * Crida al mètode escriure
	 * @throws Exception
	 */
	public void exportar() throws IOException{
		
		escriure(path);
	}
	
	/**
	 * Escriu al path els objectes continguts al contenidor de capitans.
	 * @param fitxer  path del fitxer
	 * @throws Exception
	 */
	public void escriure(String fitxer) throws IOException{
		
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(fitxer));
		
		Iterator<Entry<String, Capita>> entries = contCap.entrySet().iterator();
		
		while (entries.hasNext()) {
		  Entry<String, Capita> thisEntry = (Entry<String,Capita>) entries.next();
		  System.out.println("Escribimos: "+ thisEntry.getValue().getNom());
		  oos.writeObject(thisEntry.getValue());
		}
		oos.close();
	}
	
	/**
	 * Elimina el fitxer de base de dades
	 * @throws IOException
	 */
	public void eliminarFitxer() throws IOException{
		File file=new File("./bd.dat");
		if(file.exists())
			file.delete();
		else{
			throw new IOException("El programa no té base de dades per eliminar.");
		}
	}
}