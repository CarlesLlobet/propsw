package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.google.gson.*;

public class GalaxiaControladorDriver {
	
	private static void intro()
	{
	System.out.println("------------------------");
	System.out.println("| Driver de Controlador de Galaxia |");
	System.out.println("------------------------");
	}
	private static void menu()
	{
	System.out.println("Comentari: Ja que la galàxia es crea inicialment buida, s'afegeix l'opció setGalaxia del capità, que rep un fitxer que ha sigut sortida de l'opció exportar");
	System.out.println("Opcions:");
	System.out.println("1) Crear una galàxia");
	System.out.println("2) Importar una galàxia");
	System.out.println("3) Exportar una galàxia");
	System.out.println("4) Fer un reset de tots els atributs");
	System.out.println("5) Afegir una base");
	System.out.println("6) Esborrar una base");
	System.out.println("7) Modificar una base");
	System.out.println("8) Llistar totes les bases");
	System.out.println("9) Crear una adjacència");
	System.out.println("10) Eliminar una adjacència");
	System.out.println("11) Obtenir una adjacència");
	System.out.println("12) SetGalaxia");
	System.out.println("0) exit");
	}
	public static void main(String[] args) throws IOException {
	//Es crea una galaxia buida
	Galaxia gal=new Galaxia();
	Capita.setGalaxia(gal);
	GalaxiaControlador
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
			default:
					System.out.println("No existeix aquesta opció");
					break;
	}
	menu();
	op = Integer.parseInt(br.readLine());
	}
	}
	}
}