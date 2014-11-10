/*
 * Autor: Marc Ronquillo
 * Grup 44 - 9.1
 */ 

package propsw;

import java.io.*;

public class GalaxiaCtrl {
	
	//Constructor
	public GalaxiaCtrl(){
		
	}
	
	//Funci� crear galaxia
	public void CrearGalaxia(String s){
		
		Galaxia gal=new Galaxia(s);
	}
	
	//Afegir Base
	public void AddBase(int id, String nom){
		
		Base b=new Base(id,nom);
		try{
			//Est� especificada com a booleana per� si fem com a graf, podem fer-la anar amb gesti� d'excepcions
			gal.addBase(b);
		}
		catch(IOException e){
			System.out.println(e);
		}
		
	}
	
	//Substituir base
	public void SubstituirBase(int id, Base b){
		gal.substituirNode(id,b);
	}
	
	//Esborrar base
	public void RemoveBase(int id){
		gal.removeBase(id);
		//Perqu� est� especificada com que retorna una base?
	}
	
	//Falta fer camins
	
	//Consultar Base
	public Base ConsultaBase(int id){
		if(int ret=gal.bases.containsKey(id)){
			return gal.bases.get(ret);
		}
		else{
		//????
		}
		
	}
	
	//Falta consultar cam�
	
	public Galaxia importGalaxia(String s){
		
	}
	
	public String exportGalaxia(Galaxia gal){
		
	}

}
