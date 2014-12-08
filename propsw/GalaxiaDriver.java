/*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */

package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GalaxiaDriver {
	private static void intro() 
	{
		System.out.println("------------------------");
        System.out.println("|    Driver de Base    |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Consultar id de la Galaxia");
        System.out.println("2) Consultar capita de la galaxia"); 
        System.out.println("3) Afegir un exode a la galaxia");
        System.out.println("4) Esborrar un exode de la galaxia");
        System.out.println("5) Afegir una base a la galaxia");
        System.out.println("6) Esborrar una base de la galaxia");
        System.out.println("7) Consultar una base de la galaxia");
        System.out.println("8) Consultar la id d'una base de la galaxia");
        System.out.println("9) Consultar tots els exodes de la galaxia");
        System.out.println("10) Consultar les ids de tots els exodes de la galaxia");
        System.out.println("11) Consultar les bases de la galaxia");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		
		Capita c = new Capita("Luke");
		Galaxia g = new Galaxia(c);
		
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
        
        while (op != 0){
        	switch(op){
        		case 1:
        			System.out.println("El id de la galaxia és: " + g.getId());
        			break;
        		case 2:
        			System.out.println("El capita de la galaxia es diu: " + c.getNom() + " i la seva id es: " + c.getId());
        			break;
        		case 3:
        			Exode ex = new Exode(g);
        			g.addExode(ex);
        			System.out.println("S'ha afegit el exode amb id: " + ex.getIdExode());
        			break;
        		case 4:
        			try{
	        			System.out.println("Introdueix la id del exode a esborrar");
	        			String id = br.readLine();
	       				Exode ex1 = g.removeExode(id);
	       				System.out.println("S'ha esborrat l'exode amb id :" + id);
        			}
        			catch(IOException e){
        				System.out.println(e);
        			}
        			break;        			
        		case 5:
        			//Aquesta opcio, no esta implementada a galaxia pero serveix per a testejar l'eliminacio de les bases
        			System.out.println("Indica un nom per a la base");
        			String nom = br.readLine();
        			Base b = new Base(nom,g);
        			System.out.println("S'ha afegit la base correctament, el seu nom es : " + b.getNom() + " i la seva id es " + g.getBaseId(b));
        			break;
        		case 6:
        			try{
        				System.out.println("Indica la id de la base a esborrar:");
            			Integer id2 = Integer.parseInt(br.readLine());
            			g.removeBase(id2);
            			System.out.println("Base esborrada correctament");
        			}
        			catch(IOException e){
        				System.out.println(e);
        			}
        			break;
        		case 7:
        			try{
        				System.out.println("Indica la id de la base a consultar:");
        				Integer id3 = Integer.parseInt(br.readLine());
            			Base b1 = g.getBase(id3);
            			System.out.println("Base consultada, el seu nom es: " + b1.getNom());
        			}
        			catch(IOException e){
        				System.out.println(e);
        			}        			
        			break;  
        		case 8:
        			try{
        				//Generem un numero aleatori per a seleccionar qualsevol base de la galaxia
        				//Consultem aquesta base
        				Random rand = new Random();
        				int id = rand.nextInt(g.getNSize() + 1); 
        				Base b3 = g.getBase(id);
        				System.out.println("La id de la base es: " + g.getBaseId(b3));
        			}
        			catch (IOException e) {
        				System.out.println(e);
					}
        			break;  
        		case 9:
        			HashMap<String,Exode> hm = g.getExodesHash();
        			System.out.println("S'ha consultat el hashmap que emmagatzema els exodes");
        			break;
        		case 10:
        			ArrayList<String> exodes = g.getExodes();
        			System.out.println("Llistat d'exodes: ");
        			for (int i = 0; i < exodes.size(); ++i){
        				System.out.println("Exode " + exodes.get(i));
        			}
        			break;
        		case 11:
        			ArrayList<Base> bases = g.getBaseArray();
        			for (int i = 0; i < bases.size(); ++i){
        				System.out.println("Id Base: " + i + " Nom base: " + bases.get(i).getNom());
        			}
        			break;  
        		default:
        			System.out.println("No existeix aquesta opció");
        			break;
        	}
        	menu();
			op = Integer.parseInt(br.readLine());
        }
	}
}
