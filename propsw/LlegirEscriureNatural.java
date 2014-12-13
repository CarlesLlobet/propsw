package propsw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LlegirEscriureNatural {
	CapitaControlador caco;
	GalaxiaControlador gaco;
	String idCapi;
	LlegirEscriureNatural(CapitaControlador cc){
		caco = cc;
		gaco = new GalaxiaControlador(cc);
	}
	
	public void llegirCapita(String ruta) throws IOException{		
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
	           else if (tokens[0] == "Conexio"){ //"Conexio:a,b,c,q.q"
	        	   int from = Integer.parseInt( tokens[1] );
	        	   int to = Integer.parseInt( tokens[2] );
	        	   int capacitat = Integer.parseInt( tokens[3] );
	        	   float cost = Float.parseFloat( tokens[4] );
	        	   gaco.createAdjacency(from, to, capacitat, cost, idCapi);
	           }
	        }
	        inFile.close();
	    }
	}
	
	public void llegirGalaxia(String ruta, String idCapita) throws IOException{
		idCapi = idCapita;
		File fitxer = new File(ruta);     
	    if ( fitxer.exists() ){                                             
	        Scanner inFile = new Scanner( fitxer );
	        gaco.resetGalaxia(idCapi);
	        while ( inFile.hasNext() ){
	           String line = inFile.nextLine();   // read the next line
	           String delims = "[,:]";
	           String[] tokens = line.split(delims);
	          if (tokens[0] == "Nombre bases"){ //"Nombre bases:n"
	        	   //tokens[1] == nombre bases  
	        	   int number = Integer.parseInt( tokens[1] );
	        	   for (int i =0; i < number; ++i){
	        		   gaco.addBase(i+"", idCapi);
	        	   }
	           }
	           else if (tokens[0] == "Conexio"){ //"Conexio:a,b,c,q.q"
	        	   int from = Integer.parseInt( tokens[1] );
	        	   int to = Integer.parseInt( tokens[2] );
	        	   int capacitat = Integer.parseInt( tokens[3] );
	        	   float cost = Float.parseFloat( tokens[4] );
	        	   gaco.createAdjacency(from, to, capacitat, cost, idCapi);
	           }
	        }
	        inFile.close();
	    }
	}
	
	//SI EL FITXER JA EXISTEIX SOBRESCRIURA!
	public void escriureCapita(String outFileName, String idCapita) throws IOException{
		idCapi = idCapita;
		Capita c = caco.getCapita(idCapi);
        java.io.PrintStream ps = new java.io.PrintStream( outFileName+".txt" );
        ps.println("Capita:"+c.getNom()+","+c.getPassword());
        ps.println("Nombre rebels:"+Integer.toString( c.getRebels().size() ));
        int nBases = c.getGalaxia().getBaseArray().size();
        ps.println("Nombre bases:"+Integer.toString( nBases ));
        for(int i = 0; i < nBases; ++i){
            for(int j = 0; j < nBases; ++i){
            	if (gaco.existsAdjacency(i, j)){
            		ps.println("Conexio:"+ Integer.toString(i) +","+ Integer.toString(j) +","+ Integer.toString(gaco.getCapacitatAdjacency(i, j)) +","+ Double.toString(gaco.getCostAdjacency(i, j)));
            	}
            }
        }
        ps.close();		
	}
	
	//SI EL FITXER JA EXISTEIX SOBRESCRIURA!
	public void escriureGalaxia(String outFileName, String idCapita) throws IOException{
		idCapi = idCapita;
		Capita c = caco.getCapita(idCapi);
        java.io.PrintStream ps = new java.io.PrintStream( outFileName+".txt" );
        int nBases = c.getGalaxia().getBaseArray().size();
        ps.println("Nombre bases:"+Integer.toString( nBases ));
        for(int i = 0; i < nBases; ++i){
            for(int j = 0; j < nBases; ++i){
            	if (gaco.existsAdjacency(i, j)){
            		ps.println("Conexio:"+ Integer.toString(i) +","+ Integer.toString(j) +","+ Integer.toString(gaco.getCapacitatAdjacency(i, j)) +","+ Double.toString(gaco.getCostAdjacency(i, j)));
            	}
            }
        }
        ps.close();		
	}
}