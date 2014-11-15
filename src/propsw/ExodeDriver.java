// Autor: Albert Tost

package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

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
        System.out.println("9) Consultar identificador d'exode");
        System.out.println("10) Consultar identificador de la base d'inici");
        System.out.println("11) Modificar identificador de la base d'inici");
        System.out.println("12) Consultar rebels");
        System.out.println("13) ");//alguna funcio
        System.out.println("14) Consultar cost");
        System.out.println("15) Modificar cost");
        System.out.println("16) Consultar flow");
        System.out.println("17) Modificar flow");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {
		//Es crea un Exode
		Exode e = new Exode(null);
	
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			switch(op) 
			{
				case 1:
        			System.out.println("Els destins dels rebels son: " + e.getDestinsRebels().toString());
        			break;
				case 2: //com ferlo
					FFDijkstra<String> algoritme = new FFDijkstra<String>();
					Graf<String> graf = new Graf<String>();
					execucioBFS();
					 // com feru
					System.out.println("Graf residual desprŽs d'executar FF amb Dijkstra: " + grafR);
					break;
				case 3: //com ferlo
					FordFulkerson<String> algoritme1 = new FordFulkerson<String>();
					Graf<String> graf1 = new Graf<String>();
					Graf<String> grafResidual = algoritme1.findMaxFlow(graf1,0,5);
					String grafR1 = algoritme1.printMatrix(grafResidual); // com feru
					System.out.println("Graf residual desprŽs d'executar FF amb DFS: " + grafR1);
					break;
				case 4://com ferlo
					Graf<String> grafR = ff.printMatrix(grafResidual);
					System.out.println("Graf residual desprŽs d'executar FF amb BFS: " + grafR);
					break;
				case 5:
					System.out.println("Indica el idRebel que vols afegir: ");
					Integer idRebelConversio = Integer.parseInt(br.readLine());
					String idRebelAfegir = Integer.toString(idRebelConversio);
					System.out.println("Indica el idBaseDesti del idRebel que vols afegir: ");
					Integer idBaseAfegir = Integer.parseInt(br.readLine());
					Boolean afegit = e.afegirRebel(idRebelAfegir, idBaseAfegir);
					if (afegit) System.out.println("S'ha afegit el rebel");
					else System.out.println("No s'ha afegit el rebel");
					break;
				case 6:
					System.out.println("Indica el idRebel que vols modificar: ");
					Integer idRebelModConversio = Integer.parseInt(br.readLine());
					String idRebelModificar = Integer.toString(idRebelModConversio);
					System.out.println("Indica el idBaseDesti del idRebel que vols afegir: ");
					Integer idBaseModificar = Integer.parseInt(br.readLine());
					e.modificarRebel(idRebelModificar, idBaseModificar);
					System.out.println("Comprobar que s'ha modificat be: " + e.getRebels());
					break;
				case 7:
					System.out.println("Indica el rebel que vols borrar: ");
					Integer rebelBorrarConversio = Integer.parseInt(br.readLine());
					String rebelBorrar = Integer.toString(rebelBorrarConversio);
					Boolean borrat = e.borrarRebel(rebelBorrar);
					if (borrat) System.out.println("S'ha borrat el rebel");
					else System.out.println("El rebel no existia");
					break;
				case 8:
					System.out.println("Els colls d'ampolla son: " + e.getCollsAmpolla());
					break;
				case 9:
					System.out.println("L'identificador de l'exode es: " + e.getIdExode());
					break;
				case 10:
					System.out.println("L'identificador de la base d'inici es: " + e.getIdBaseInici());
					break;
				case 11:
					System.out.println("Indica la base que vols modificar: ");
					Integer baseMod = Integer.parseInt(br.readLine());
					e.setIdBaseInici(baseMod);
					System.out.println("He cambiat la nova base d'inici a: " + e.getIdBaseInici());
					break;
				case 12:
					System.out.println("Els rebels d'aquest exode son: " + e.getRebels());
					break;
				case 13:
					
					break;
				case 14:
					System.out.println("El cost es: " + e.getCost());
					break;
				case 15:
					System.out.println("Indica el coste que quieres modificar: ");
					Double coste = Double.parseDouble(br.readLine());
					e.setCost(coste);
					break;
				case 16://FALTA A PARTIR DAQUI
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