/*
 * @Author: Marcos Pérez Rubio
 * Grup 44 - 9.1
 */

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
					String n = c.getNom();
					if (n != null) System.out.println("El nom del capità és: " + n);
					else System.out.println("El capità no té cap nom assignat");
					break;
				case 5:
					HashMap<String,Rebel> cr = new HashMap<String,Rebel>();
					c.setRebels(cr);
					System.out.println("S'ha sobreescrit el contenidor de rebels" );
					break;
				case 6:
					HashMap<String,Rebel> c1 = c.getRebels();
					System.out.println("S'ha consultat el contenidor de rebels");
					break;
				case 7:
					Galaxia g = new Galaxia(c);
					System.out.println("El id de la galaxia g es " + g.getId().toString());
					c.setGalaxia(g);
					System.out.println("S'ha creat una galaxia amb id :" + g.getId().toString() + " i s'ha assignat al capità");
					break;
				case 8:
					Galaxia g1 = c.getGalaxia();
					System.out.println("S'ha consultat la galaxia amb id : " + g1.getId().toString());
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