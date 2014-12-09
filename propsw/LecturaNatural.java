package propsw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LecturaNatural {
	CapitaControlador caco;
	GalaxiaControlador gaco;
	String idCapi;
	LecturaNatural(CapitaControlador cc){
		caco = cc;
		gaco = new GalaxiaControlador(cc);
	}
	
	void llegir(String ruta) throws IOException{
		File fitxer = new File(ruta);     
	    if ( fitxer.exists() ){                                             
	        Scanner inFile = new Scanner( fitxer );
	        while ( inFile.hasNext() ){
	           String line = inFile.nextLine();   // read the next line
	           String delims = "[,:]";
	           String[] tokens = line.split(delims);
	           if (tokens[0] == "Capita"){      //"Capita:nom,password"
	        	   //tokens[1] == nom
	        	   //tokens[2] == pass
	        	   Capita c = new Capita(tokens[1]);
	        	   c.setPassword(tokens[2]);
	        	   idCapi = c.getId();
	        	   caco.afegirCapita(c);
	           }
	           else if (tokens[0] == "Nombre rebels"){ //"Nombre rebels:n"
	        	   //tokens[1] == nombre rebels   
	        	   int number = Integer.parseInt( tokens[1] );
	        	   for (int i =0; i < number; ++i){
	        		   caco.crearRebel(i+"", idCapi);
	        	   }
	        	   
	           }
	           else if (tokens[0] == "Nombre bases"){ //"Nombre bases:n"
	        	   //tokens[1] == nombre bases  
	        	   int number = Integer.parseInt( tokens[1] );
	        	   for (int i =0; i < number; ++i){
	        		   gaco.addBase(i+"", idCapi);
	        	   }
	           }
	           else if (tokens[0] == "Nova conexio"){ //"Nova conexio:a,b,c,q.q"
	        	   int from = Integer.parseInt( tokens[1] );
	        	   int to = Integer.parseInt( tokens[2] );
	        	   int capacitat = Integer.parseInt( tokens[3] );
	        	   float cost = Float.parseFloat( tokens[4] );
	        	   gaco.createAdjacency(from, to, capacitat, cost);
	           }
	        }
	        inFile.close();
	    }
	}
	
}
