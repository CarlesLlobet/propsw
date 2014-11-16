
package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExodeControladorDriver {
	
	private static void intro() 
	{
		System.out.println("------------------------");
        System.out.println("|    Driver de ExodeControlador    |");
        System.out.println("------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("Executar l'Exode (aixo genera un possible cami per tots els rebels possibles):");
        System.out.println("1) Executar l'Exode fent servir l'algoritme BFS");
        System.out.println("2) Executar l'Exode fent servir l'algoritme DFS"); 
        System.out.println("3) Executar l'Exode fent servir l'algoritme Dijkstra");
        System.out.println("4) Consultar quina es la base inicial de l'exode");
        System.out.println("5) Consultar cuants rebels participen a l'exode");
        System.out.println("6) Consultar quins rebels participen a l'exode");
        System.out.println("7) Consultar els camins dels rebels");    
        System.out.println("8) Consultar quin es el flow de l'exode");
        System.out.println("9) Consultar quin es el cost de l'exode");
        System.out.println("10) Consultar a on esta el coll d'ampolla (nomes si el resultat de la Opcio 8 > Opcio 5)");
        System.out.println("11) Afegir un nou rebel a l'exode");
        System.out.println("12) Modificar un rebel de l'exode");
        System.out.println("13) Treure un rebel de l'exode");
        System.out.println("0) exit");
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		ExodeControlador c = new ExodeControlador();
		c.login("foo", "foooooo");
	//	Capita cc = c.getCapita();
	//	Galaxia g = c.getGalaxia();
		new Base(c.getGalaxia());
		new Base(c.getGalaxia());
		new Base(c.getGalaxia());
		new Base(c.getGalaxia());
		new Base(c.getGalaxia());
		new Base(c.getGalaxia());
	
		
		c.getGalaxia().conectarNodes(0, 1, 5, 5.0);
		c.getGalaxia().conectarNodes(0, 2, 7, 5.0);
		c.getGalaxia().conectarNodes(1, 3, 2, 5.0);
		c.getGalaxia().conectarNodes(1, 2, 1, 5.0);
		c.getGalaxia().conectarNodes(2, 3, 9, 5.0);
		c.getGalaxia().conectarNodes(2, 4, 4, 5.0);
		c.getGalaxia().conectarNodes(2, 5, 3, 5.0);
		c.getGalaxia().conectarNodes(4, 3, 2, 5.0);

		String idExode = c.crearExode(0);

		
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
        while (op != 0) {
			switch(op) 
			{
				case 1: //Executar
					c.execucio(idExode, 0);
					break;
					
				case 2: // Executar
					c.execucio(idExode, 1);
					break;
					
				case 3: // Executar
					c.execucio(idExode, 2);
					break;
					
				case 4:
					System.out.println("La base "+ c.getIniciExode(idExode) +" es el punt de partida de l'exode");
					break;
					
				case 5: //Consultar nombre rebels de l'exode
					System.out.println("Participen "+ c.getRebelsSize(idExode) +" rebels a l'exode " + idExode);
					break;
					
				case 6: //Consultar els rebels de l'exode
					System.out.println("S'indica idRebel = BaseDesti"+c.getRebelsExode(idExode));
					break;
					
				case 7: //Consultar els camins dels rebels de l'exode
					System.out.println("Camins dels rebels: "+c.getCaminsExode(idExode));
					break;
					
				case 8: //Consultar el flow de l'exode
					System.out.println("Han arribat " +c.getFlowExode(idExode)+ " al seu desti");
					break;
					
				case 9: //Consultar el cost de l'exode
					System.out.println("El cost total de l'exode es de: " +c.getCostExode(idExode));
					break;
					
				case 10: //Consultar el coll d'ampolla
					ArrayList<Integer> coll = c.getAmpollaExode(idExode);
					if (coll.size() <= 0)System.out.println("NO tenim coll d'ampolla");
					else System.out.println("Les seguents bases formen el coll d'ampolla: " + coll);
					break;
					
				case 11: //afegir un rebel a l'exode
					String idR = c.crearRebel("Rebel0");
					System.out.println("El rebel amb id: "+ idR +" S'afegira, ");
					System.out.println("introdueix la base de desti del rebel:");
					c.afegirRebelExode(idExode, idR, Integer.parseInt(br.readLine()));
					
					break;
					
				case 12: //modificar un rebel de l'exode
					System.out.println("introdueix la id del rebel que vols modificar:");
					String idRm = br.readLine();
					System.out.println("introdueix la nova base de desti del rebel:");
					c.modificarRebelExode(idExode, idRm, Integer.parseInt(br.readLine()));
					break;
					
				case 13: //Treure rebel de l'exode
					System.out.println("introdueix la id del rebel que vols treure:");
					String idRd = br.readLine();
					c.treureRebelExode(idExode, idRd);
					break;
					
				default:
					System.out.println("No existeix aquesta opci�");
					break;
			}
			menu();
			op = Integer.parseInt(br.readLine());
		}
	}
}
