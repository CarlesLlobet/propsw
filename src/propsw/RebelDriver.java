//@author: Marcos Pérez
package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RebelDriver {
	
	private static void intro() 
	{
		System.out.println("------------------------");
        System.out.println("|    Driver de Rebel    |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Consultar id del rebel");
        System.out.println("2) Consultar nom del rebel"); 
        System.out.println("3) Consultar els exodes del rebel");
        System.out.println("4) Modificar nom del rebel");
        System.out.println("5) Insertar un nou exode");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		Rebel r = new Rebel();
	
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			
			switch(op) 
			{
				case 1:
        			System.out.println("El id del rebel és: " + r.getId().toString());
        			break;
				case 2:
					System.out.println("El nom del rebel es: " + r.getNom());
					break;
				case 3:
					ArrayList<Exode> ex = r.getExodes();
					System.out.println("S'han consultat els exodes del rebel: ");
					break;
				case 4:
					System.out.println("Escriu el nom del rebel: ");
					String nom = br.readLine();
					r.setNom(nom);
					System.out.println("S'ha modificat el nom del rebel");

					break;
				case 5:
					Exode ee = new Exode();
					r.insertarExode(ee);
					System.out.println("S'ha insertat un nou exode ");
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
	
	