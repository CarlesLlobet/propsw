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
        System.out.println("6) Esborrar exode");
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
					String n = r.getNom();
					if (n != null) System.out.println("El nom del rebel es: " + n);
					else System.out.println("El rebel no té cap nom assignat");
					break;
				case 3:
					ArrayList<String> ex = r.getExodes();
					if (ex.size() > 0) {
						System.out.println("Els exodes del rebel son: ");
						for(int i = 0; i < ex.size(); ++i){
							System.out.println("Exode " + ex.get(i));
						}
					}
					else System.out.println("El rebel no té cap èxode assignat");
					break;
				case 4:
					System.out.println("Escriu el nom del rebel: ");
					String nom = br.readLine();
					r.setNom(nom);
					System.out.println("S'ha modificat el nom del rebel");

					break;
				case 5:
					System.out.println("Escriu la id de l'exode a guardar: ");
					String idExode = br.readLine();
					boolean b = r.insertarExode(idExode);
					if (b) System.out.println("S'ha insertat un nou exode amb id " + idExode);
					else System.out.println("Ja existeix un exode amb id: " + idExode);
					break;
				case 6:
					System.out.println("Escriu la id de l'exode a esborrar: ");
					String idExode2 = br.readLine();
					boolean b2 = r.esborrarExode(idExode2);
					if (b2) System.out.println("S'ha esborrat l'exode amb id " + idExode2);
					else System.out.println("No existeix cap exode amb id: " + idExode2);
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
	
	