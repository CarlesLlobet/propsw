//@Author: Marcos Pérez
package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContenidorCapitansDriver {
	
	private static void intro() 
	{
		System.out.println("-----------------------------------");
        System.out.println("|    Driver de Contenidor Capitans |");
        System.out.println("-----------------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Afegir un capita");
        System.out.println("2) Esborrar un capita"); 
        System.out.println("3) Consultar un capita");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		ContenidorCapitans contCap = new ContenidorCapitans();
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			
			switch(op) 
			{
				case 1:
					Capita c = new Capita();
					contCap.addCapita(c);
        			System.out.println("S'ha afegit un nou capita amb id: " + c.getId());
        			break;
				case 2:
					System.out.println("Introdueix el id del capita a esborrar: ");
					String id = br.readLine();
					boolean b = contCap.deleteCapita(id);
					if (b) System.out.println("S'ha esborrat el capita amb id: " + id);
					else System.out.println("No hi ha cap capita amb id: " + id);
					break;
				case 3:
					System.out.println("Introdueix el id del capita a consultar: ");
					String id2 = br.readLine();
					Capita c2 = contCap.getCapita(id2);
					if(c2 != null) System.out.println("S'ha consultat el capita correctameent i la seva id es : " + c2.getId());
					else System.out.println("No existeix un capita amb id: " + id2);
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
