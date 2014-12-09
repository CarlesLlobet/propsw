// Autor: Albert Tost

package propsw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

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
        System.out.println("3) Execucio algoritme amb DFS");
        System.out.println("4) Execucio algoritme amb BFS");
        System.out.println("5) Afegir Rebel");
        System.out.println("6) Modificar Rebel");
        System.out.println("7) Borrar Rebel");
        System.out.println("8) Consultar identificador d'exode");
        System.out.println("9) Consultar identificador de la base d'inici");
        System.out.println("10) Modificar identificador de la base d'inici");
        System.out.println("11) Consultar rebels");
        System.out.println("12) Mirar si esta actualitzat l'exode");
        System.out.println("13) Consultar el cami d'un determinat rebel amb idRebel");
        System.out.println("14) Consulta el graf inicial");
        System.out.println("15) Consulta la galaxia");
        System.out.println("16) Consulta FordFoulkerson");
        System.out.println("0) exit");
	}
	
	public static void main(String[] args) throws IOException {

		
		//Es crea una Galaxia
		
		Galaxia g = new Galaxia(new Capita());
		
		llegeixFitxerTest(g);
		
		
		
		
		
		Rebel rebel0 = new Rebel("Rebel0");
		Rebel rebel1 = new Rebel("Rebel1");
		Rebel rebel2 = new Rebel("Rebel2");
		Rebel rebel3 = new Rebel("Rebel3");
		Rebel rebel4 = new Rebel("Rebel4");
		Rebel rebel5 = new Rebel("Rebel5");
		Rebel rebel6 = new Rebel("Rebel6");
		Rebel rebel7 = new Rebel("Rebel7");
		Rebel rebel8 = new Rebel("Rebel8");
		Rebel rebel9 = new Rebel("Rebel9");
		
		g.getCapita().getRebels().put(rebel0.getId(), rebel0);
		g.getCapita().getRebels().put(rebel1.getId(), rebel1);
		g.getCapita().getRebels().put(rebel2.getId(), rebel2);
		g.getCapita().getRebels().put(rebel3.getId(), rebel3);
		g.getCapita().getRebels().put(rebel4.getId(), rebel4);
		g.getCapita().getRebels().put(rebel5.getId(), rebel5);
		g.getCapita().getRebels().put(rebel6.getId(), rebel6);
		g.getCapita().getRebels().put(rebel7.getId(), rebel7);
		g.getCapita().getRebels().put(rebel8.getId(), rebel8);
		g.getCapita().getRebels().put(rebel9.getId(), rebel9);
		
		//Es crea l'èxode
		Exode e = new Exode(g);
		//Es posa una base d'inici
		e.setIdBaseInici(0);

//		e.afegirRebel(rebel0.getId(), 3);
//		e.afegirRebel(rebel2.getId(), 3);
//		e.afegirRebel(rebel9.getId(), 3);
//		
//		e.afegirRebel(rebel1.getId(), 4);
//		e.afegirRebel(rebel7.getId(), 4);		
//		e.afegirRebel(rebel6.getId(), 4);
//		e.afegirRebel(rebel4.getId(), 4);
//		e.afegirRebel(rebel5.getId(), 4);
//		
//		e.afegirRebel(rebel8.getId(), 5);
//		e.afegirRebel(rebel3.getId(), 5);
			
	
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
				case 2: 
					System.out.println("Execució Dijkstra: ");
					e.execucioDijkstra();
					System.out.println("La matriu flux/capacitat del graf residual despres de l'execució es :\n"+e.getFf().printMatrix(e.getGrafResidual()));
					System.out.println("El numero de rebels que arriben al seu destí són: "+e.getFlow());
					System.out.println("Els camins assignats als rebels son:\n "+e.getCamins());
					System.out.println("Les arestes que fa coll d'ampolla són: ");
					HashMap<Integer, ArrayList<Integer[]>> arr = e.getCollsAmpolla();
					Iterator<Integer> itArr = arr.keySet().iterator();
					while(itArr.hasNext()){
						Integer i = itArr.next();
						System.out.println("Per als rebels que tenen com a destí la base "+i);
						ArrayList<Integer[]> lista =  arr.get(i);
						for (Integer[] integers : lista) {
							System.out.println(integers[0]+","+integers[1]);
						}
					}
					System.out.println("El cost total del trajecte es: "+e.getCost());
					break;
				case 3: //FALTA FER
					System.out.println("Execució FordFulkerson amb DFS: ");
					e.execucioDFS();
					System.out.println("La matriu flux/capacitat del graf residual despres de l'execució es :\n"+e.getFf().printMatrix(e.getGrafResidual()));
					System.out.println("El numero de rebels que arriben al seu destí són: "+e.getFlow());
					System.out.println("Els camins assignats als rebels son:\n "+e.getCamins());
					System.out.println("Les arestes que fa coll d'ampolla són: ");
					HashMap<Integer, ArrayList<Integer[]>> arr2 = e.getCollsAmpolla();
					Iterator<Integer> itArr2 = arr2.keySet().iterator();
					while(itArr2.hasNext()){
						Integer i = itArr2.next();
						System.out.println("Per als rebels que tenen com a destí la base "+i);
						ArrayList<Integer[]> lista =  arr2.get(i);
						for (Integer[] integers : lista) {
							System.out.println(integers[0]+","+integers[1]);
						}
					}
					System.out.println("El cost total del trajecte es: "+e.getCost());
					break;
				case 4:
					System.out.println("Execució Edmond Karp: ");
					e.execucioBFS();
					System.out.println("La matriu flux/capacitat del graf residual despres de l'execució es :\n"+e.getFf().printMatrix(e.getGrafResidual()));
					System.out.println("El numero de rebels que arriben al seu destí són: "+e.getFlow());
					System.out.println("Els camins assignats als rebels son: \n"+e.getCamins());
					System.out.println("Les arestes que fa coll d'ampolla són: ");
					HashMap<Integer, ArrayList<Integer[]>> arr3 = e.getCollsAmpolla();
					Iterator<Integer> itArr3 = arr3.keySet().iterator();
					while(itArr3.hasNext()){
						Integer i = itArr3.next();
						System.out.println("Per als rebels que tenen com a destí la base "+i);
						ArrayList<Integer[]> lista =  arr3.get(i);
						for (Integer[] integers : lista) {
							System.out.println(integers[0]+","+integers[1]);
						}
					}
					System.out.println("El cost total del trajecte es: "+e.getCost());
					break;
				case 5:
					System.out.println("La teva galaxia la formen les seguents bases: ");
					for (int i = 0; i < g.getNSize(); i++) {
						System.out.println(g.getNode(i));
					}
					Rebel r = new Rebel("RebelX");
					g.getCapita().getRebels().put(r.getId(), r);
					System.out.println("Indica el idBaseDesti del idRebel que vols afegir: ");
					Integer idBaseAfegir = Integer.parseInt(br.readLine());
					Boolean afegit = e.afegirRebel(r.getId(), idBaseAfegir);
					if (afegit) System.out.println("S'ha afegit el rebel");
					else System.out.println("No s'ha afegit el rebel");
					break;
				case 6:
					System.out.println("Indica el idRebel que vols modificar: ");
					String idRebelMod = br.readLine();
					System.out.println("Indica el idBaseDesti del idRebel que vols afegir: ");
					Integer idBaseModificar = Integer.parseInt(br.readLine());
					e.modificarRebel(idRebelMod, idBaseModificar);
					System.out.println("Comprobar que s'ha modificat be: " + e.getDestinsRebels());
					break;
				case 7:
					System.out.println("Indica el rebel que vols borrar: ");
					String rebelBorrarConversio = br.readLine();
					Boolean borrat = e.borrarRebel(rebelBorrarConversio);
					if (borrat) System.out.println("S'ha borrat el rebel");
					else System.out.println("El rebel no existia");
					break;
				case 8:
					System.out.println("L'identificador de l'exode es: " + e.getIdExode());
					break;
				case 9:
					System.out.println("L'identificador de la base d'inici es: " + e.getIdBaseInici());
					break;
				case 10:
					System.out.println("La teva galaxia la formen les seguents bases: ");
					for (int i = 0; i < g.getNSize(); i++) {
						System.out.println(g.getNode(i));
					}
					System.out.println("Indica la base que vols modificar: ");
					Integer baseMod = Integer.parseInt(br.readLine());
					e.setIdBaseInici(baseMod);
					System.out.println("He cambiat la nova base d'inici a: " + e.getIdBaseInici());
					break;
				case 11:
					System.out.println("Els rebels d'aquest exode son: " + e.getRebels());
					break;
				case 12:
					Boolean act = e.isActualitzat();
					if (act) System.out.println("SI esta actualitzat.");
					else System.out.println("NO esta actualitzat.");
					break;
				
				
				
				
				case 13:
					System.out.println("Escriu l'identificador del Rebel que vols llistar el seu camí");
					String identificador = br.readLine();
					System.out.println("El camí assignat al rebel " + identificador + "es: " + e.getCamiRebel(identificador));
					break;
				case 14:
					System.out.println("El graf inicial es: \n" + e.getFf().printMatrix(e.getGrafInicial()));
					break;
				case 15:
					System.out.println("La galaxia es: \n" + e.getFf().printMatrix(e.getGalaxia()));
					break;		
				case 16:
					System.out.println("El FordFoulkerson es: " + e.getFf());
					break;	
				default:
					System.out.println("No existeix aquesta opcio");
					break;
			}
			menu();
			op = Integer.parseInt(br.readLine());
		}
	}

	private static void llegeixFitxerTest(Galaxia g) throws IOException {
		//Ejecucion del fichero test.ff del mismo directorio donde esta la classe FordFoulkerson
				Scanner s = new Scanner(new File("test.exode"));
				String line = "";
				String[] nums;
				
				int from = 0;
				int capacitat = 0;
				
				//El graf tindrà tants nodes com linies tingui el fitxer. (La matriu ha de ser per força sempre una matriu
				//quadrada!).
				while(s.hasNextLine()){
					s.nextLine();
					new Base("Arkania "+from,g);
					from++;
				}
				from =0;
				s = new Scanner(new File("test.ff"));
				//Construim les connexions del graf
				while(s.hasNextLine()){
					line = s.nextLine();
					nums = line.split("\\t");
					for (int i = 0; i < nums.length; i++) {
						if(!nums[i].equalsIgnoreCase("0")){
							capacitat = Integer.parseInt(nums[i]);
							
							g.conectarNodes(from, i, capacitat, 5.0);
						}
					}
					from++;
				}
		
	}
}