package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
        System.out.println("7) Consultar el cami d'un rebel en particular");
        System.out.println("8) Consultar quin es el flow de l'exode");
        System.out.println("9) Consultar quin es el cost de l'exode");
        System.out.println("10) Consultar a on esta el coll d'ampolla (nomes si el resultat de la Opcio 8 > Opcio 5)");
        System.out.println("11) Afegir un nou rebel a l'exode");
        System.out.println("12) Modificar un rebel de l'exode");
        System.out.println("13) Treure un rebel de l'exode");
        System.out.println("0) exit");
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		//Es crea una base buida
		ExodeControlador c = new ExodeControlador();
		c.login(null, null);
		for (Integer i = 0; i < 10; ++i){
			c.getGalaxia().addBase(new Base (c.getGalaxia()));
			c.crearRebel(i.toString());
		}
		for (Integer i = 0; i < 9; ++i){
			c.getGalaxia().conectarNodes(i,i+1,3,3.0);
		}
		c.crearExode(5);

		
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			switch(op) 
			{
				case 1:
					c.execucio("0", 0);
					break;
				case 2:
					c.execucio("0", 1);
					break;
				case 3:
					c.execucio("0", 2);
					break;
				case 4:
					Integer r = c.getIniciExode("0");
					System.out.println("La base "+ r.toString() +" es el punt de partida de l'exode");
					break;
				case 5:
					Integer xaxi = c.getRebelsSize("0");
					System.out.println("Participen "+ xaxi.toString() +" rebels a l'exode");
					break;
				case 6:
					ArrayList<String> rebout;
					rebout = c.getRebels("0");
					System.out.println("Els seguents rebels participen a l'exode:");
					for (Integer i = 0; i < rebout.size(); ++i){
						System.out.println(rebout.get(i));	
					}
					break;
				case 7:
					System.out.println("introdueix la id del rebel:");
					ArrayList<Integer> cam = c.getCamiRebelExode("0", br.readLine());
					for (Integer i = 0; i < cam.size(); ++i){
						System.out.println(cam.get(i));
					}
					break;
				case 8:
					System.out.println("Han arribat " +c.getFlowExode("0")+ " al seu desti");
					break;
				case 9:
					System.out.println("El cost total de l'exode es de: " +c.getCostExode("0"));
					break;
				case 10:
					System.out.println("Les seguents bases formen el coll d'ampolla:");
					ArrayList<Integer> coll = c.getAmpollaExode("0");
					for (Integer i = 0; i < coll.size(); ++i){
						System.out.println(coll.get(i));
					}
					break;
				case 11:
					System.out.println("introdueix la id del rebel que vols afegir:");
					String idR = br.readLine();
					System.out.println("introdueix la base de desti del rebel:");
					c.afegirRebel("0", idR, Integer.parseInt(br.readLine()));
					break;
				case 12:
					System.out.println("introdueix la id del rebel que vols modificar:");
					String idRm = br.readLine();
					System.out.println("introdueix la nova base de desti del rebel:");
					c.afegirRebel("0", idRm, Integer.parseInt(br.readLine()));
					break;
				case 13:
					System.out.println("introdueix la id del rebel que vols treure:");
					String idRd = br.readLine();
					c.treureRebel("0", idRd);
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
