//@Author: Marcos Pérez
package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CapitaDriver {
	
	private static void intro() 
	{
		System.out.println("------------------------");
        System.out.println("|    Driver de Capità   |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Canviar la contrasenya del capita");
        System.out.println("2) Canviar el nom del capita"); 
        System.out.println("3) Consultar id capita");
        System.out.println("4) Consultar nom capita");
        System.out.println("5) Afegir contenidor de rebels");
        System.out.println("6) Consultar contenidor de rebels");
        System.out.println("7) Associar Galaxia");
        System.out.println("8) Consultar galaxia");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		
		Capita c = new Capita();	
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			
			switch(op) 
			{
				case 1:
        			System.out.println("Introdueix la nova contrasenya: ");
        			String pass = br.readLine();
					c.setPassword(pass);
        			break;
				case 2:
					System.out.println("Introdueix el nom del capità: ");
					String nom = br.readLine();
					c.setNom(nom);
					break;
				case 3:
					System.out.println("El id del capità és : " + c.getId());
					break;
				case 4:
					System.out.println("El nom del capità és: " + c.getNom());
					break;
				case 5:
					//AFEGIR CONTENIDOR REBELS
					HashMap<String,Rebel> cr = new HashMap<String,Rebel>();
					c.setRebels(cr);
					System.out.println("S'ha sobreescrit el contenidor de rebels " );
					break;
				case 6:
					//CONSULTAR CONTENIDOR REBELS
					System.out.println("Es consulta el contenidor de rebels: ");
					HashMap<String,Rebel> c1 = c.getRebels();
					break;
				case 7:
					//ASSOCIAR GALAXIA
					Galaxia g = new Galaxia();
					c.setGalaxia(g);
					System.out.println("S'ha sobreescrit la galaxia");
					break;
				case 8:
					//CONSULTAR GALAXIA
					System.out.println("Es consulta la galaxia : ");
					Galaxia g1 = c.getGalaxia();
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