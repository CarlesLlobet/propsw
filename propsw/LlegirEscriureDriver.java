package propsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LlegirEscriureDriver {
	private static void intro()
	{
	System.out.println("------------------------------------");
	System.out.println("| Driver de Controlador de Galaxia |");
	System.out.println("------------------------------------");
	}
	private static void menu()
	{
	System.out.println("Opcions:");
	System.out.println("1) Crear una gal�xia");
	System.out.println("2) Resetejar la Gal�xia");
	System.out.println("3) Afegir una base");
	System.out.println("4) Esborrar una base");
	System.out.println("5) Modificar una base");
	System.out.println("6) Llistar totes les bases");
	System.out.println("7) Crear una adjac�ncia");
	System.out.println("8) Modificar els valors d'una adjac�ncia");
	System.out.println("9) Eliminar una adjac�ncia");
	System.out.println("10) Obtenir una adjac�ncia");
	System.out.println("11) Llistar �xodes");
	System.out.println("12) Exportar");
	System.out.println("13) Importar");
	System.out.println("14) Esborrar fitxer");
	//System.out.println("11) Login");
	System.out.println("0) exit");
	}
	public static void main(String[] args) throws IOException {
	
	//Es crea un capit� a trav�s de la gal�xia del qual es far�n totes les operacions
	//Es crea una inst�ncia de classe Galaxia
		Capita capita=new Capita();
	CapitaControlador capi=new CapitaControlador();
	capi.inicialitzar();
	
	GalaxiaControlador gControl=new GalaxiaControlador(capi);
	LlegirEscriure lle=new LlegirEscriure();
	
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader (isr);
	String s;
	Integer i;
	int from,to,capacitat,fluxe;
	double cost;
	intro();
	menu();
	int op = Integer.parseInt(br.readLine());
	while (op != 0) {
		switch(op)
		{
			/*case 1:
					if(gControl.createGalaxia()!=null){
						System.out.println("S'ha creat una nova gal�xia satisfact�riament.");
					}
					else{
						System.out.println("Hi ha hagut algun problema creant una nova gal�xia.");
					}
					break;*/
			case 2:
					gControl.resetGalaxia();
					break;
			case 3:
					System.out.println("Introdueix el nou nom per a la base: ");
					s = br.readLine();
					try{
						gControl.addBase(s);
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 4:
					System.out.println("Introdueix la ID de la base que es vol eliminar: ");
					s = br.readLine();
					int a=Integer.parseInt(s);
					
					try{
					gControl.deleteBase(a);
					}
					catch(IOException e){
					
						System.out.println(e);
					}
					
					break;
			case 5:
					System.out.println("Introdueix la ID de la base a modificar:");
					s = br.readLine();
					int p=Integer.parseInt(s);
					System.out.println("Introdueix el nou nom:");
					s = br.readLine();
					try {
					gControl.setBase(p, s);
					}
					catch(IOException e){
						System.out.println(e);
					}
					
					break;
			case 6:
					System.out.println("Bases existents:");
					try{
					System.out.println(gControl.listBases());
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 7:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					System.out.println("Introdueix la capacitat del tram:");
					s = br.readLine();
					capacitat=Integer.valueOf(s);
					System.out.println("Introdueix el cost del tram:");
					s = br.readLine();
					cost=Double.parseDouble(s);
					
					try{
						gControl.createAdjacency(from, to, capacitat, cost);
						System.out.println("L'adjac�ncia s'ha creat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 8:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					System.out.println("Introdueix la capacitat del tram:");
					s = br.readLine();
					capacitat=Integer.valueOf(s);
					System.out.println("Introdueix el cost del tram:");
					s = br.readLine();
					cost=Double.parseDouble(s);
					
					try{
						gControl.setAdjacency(from, to, capacitat, cost);
						System.out.println("L'adjac�ncia s'ha actualitzat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
					
			case 9:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					try{
						gControl.deleteAdjacencia(from, to);
						System.out.println("L'adjac�ncia s'ha eliminat correctament.");
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 10:
					System.out.println("Introdueix l'ID de la Base A (inici tram)");
					s = br.readLine();
					from=Integer.valueOf(s);
					System.out.println("Introdueix l'ID de la Base B (final tram)");
					s = br.readLine();
					to=Integer.valueOf(s);
					try{
						Galaxia.Aresta ar=new Galaxia.Aresta();
						ar=gControl.getAdjacency(from, to);
						int idAresta=gControl.getGalaxia().getIDAresta(from,to);
						capacitat=gControl.getGalaxia().getCapacidadAresta(idAresta);
						cost=gControl.getGalaxia().getCosteAresta(idAresta);
						fluxe=gControl.getGalaxia().getFlujoAresta(idAresta);
						System.out.println("S'ha obtingut l'aresta satisfact�riament.");
						System.out.println("ID :"+idAresta);
						System.out.println("Capacitat: "+capacitat);
						System.out.println("Cost: "+cost);
						System.out.println("Fluxe: "+fluxe);
					}
					catch(IOException e){
						System.out.println(e);
					}
					break;
			case 11:
					System.out.println("�xodes existents:");
					System.out.println(gControl.listExodes());
					break;
			case 12:
					try{
						lle.exportar();
					}
					catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
			case 13:
					try{
						lle.importar();
					}
					catch(Exception e){
						e.printStackTrace();
					}
					break;
			case 14:
					try{lle.eliminarFitxer();}
					catch(Exception e){
						e.printStackTrace();
					}
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
