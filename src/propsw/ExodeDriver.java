// Autor: Albert Tost

package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExodeDriver {
	
	private static void intro() 
	{
		System.out.println("------------------------");
        System.out.println("|    Driver de Exode    |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Consultar destins");
        System.out.println("2) Execucio algoritme amb Dijkstra"); 
        // retornar graf residual: string s = grafresidual.print matriu i systemout de string s
        System.out.println("3) Execucio algoritme amb DFS");
        System.out.println("4) Execucio algoritme amb BFS");
        System.out.println("5) Afegir Rebel");
        System.out.println("6) Modificar Rebel");
        System.out.println("7) Borrar Rebel");
        System.out.println("8) Consultar colls d'Ampolla");
        System.out.println("9) Borrar Rebel");
        System.out.println("10) Consultar identificador de la base d'inici");
        System.out.println("11) Modificar identificador de la base d'inici");
        System.out.println("12) Consultar rebels");
        System.out.println("13) Modificar rebels");
        System.out.println("14) Consultar cost");
        System.out.println("15) Modificar cost");
        System.out.println("16) Consultar flow");
        System.out.println("17) Modificar flow");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		//Es crea un Exode
		Exode b = new Exode();
	
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			switch(op) 
			{
				case 1:
        			System.out.println("El id de la base es: " + b.getId().toString());
        			break;
				case 2:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 3:
					System.out.println("Introdueix el nou nom per a la base: ");
					String n = br.readLine();
					b.setNom(n);
					break;
				case 4:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 5:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 6:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 7:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 8:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 9:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 10:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 11:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 12:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 13:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 14:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 15:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 16:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
					break;
				case 17:
					String nom = b.getNom();
					if (nom != null) System.out.println("El nom de la base es: " + b.getNom());
					else System.out.println("La base no té cap nom assignat");
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