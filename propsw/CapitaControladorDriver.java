package propsw;

//@author Toni Martínez

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapitaControladorDriver {

	public static void main(String[] args) throws IOException {
		
		CapitaControlador contCap = new CapitaControlador();
		InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        intro();
        menu();
        int op = Integer.parseInt(br.readLine());
		
		while (op != 0) {
			
			switch(op) 
			{
				case 1:
					System.out.println("Es fa un login per a un usuari fixat per nosaltres. " +
							"\nQuan estigui implementada la capa de dades es fara la comprovació" +
							"\nde nom d'usuari i password amb les dades persistents.");
					contCap.login("foo", "foo");
					System.out.println("Login efectuat...");
					System.out.println("Benvingut Capita: "+contCap.getCapita().getNom());
					
					Base f0 = new Base(contCap.getGalaxia());
					f0.setNom("Arkania");
					Base f1 = new Base(contCap.getGalaxia());
					f1.setNom("Bastion");
					Base f2 = new Base(contCap.getGalaxia());
					f2.setNom("Sullust");
					Base f3 = new Base(contCap.getGalaxia());
					f3.setNom("Anoth");
					Base f4 = new Base(contCap.getGalaxia());
					f4.setNom("Kashyyyk");
					System.out.println("La teva galaxia la formen les seguents bases: ");
					for (int i = 0; i < contCap.getGalaxia().getNSize(); i++) {
						System.out.println(contCap.getGalaxia().getNode(i));
					}
					
        			break;
				case 2:
					System.out.println("Escriu el nom del rebel:");
					contCap.crearRebel(br.readLine());
					System.out.println("La teva tropa la formen els següents rebels:");
					System.out.println(contCap.llistarRebels());
					break;
				case 3:
					System.out.println("Escriu el identificador del Rebel:");
					String idRebel = br.readLine();
					System.out.println("Escriu el nou nom que li vols assignar:");
					String nom = br.readLine();
					boolean exists = contCap.modificaRebel(nom, idRebel);
					if(!exists)System.out.println("El rebel amb la id "+idRebel+" no existeix!");
					else System.out.println("S'ha modificat correctament!");
					System.out.println("La teva tropa la formen els següents rebels:");
					System.out.println(contCap.llistarRebels());
					break;
				case 4:
					System.out.println("Escriu el identificador del Rebel:");
					String idRebelE = br.readLine();
					boolean existsE = contCap.eliminarRebel(idRebelE);
					if(!existsE)System.out.println("El rebel amb la id "+idRebelE+" no existeix!");
					else System.out.println("S'ha borrat correctament!");
					System.out.println("La teva tropa la formen els següents rebels:");
					System.out.println(contCap.llistarRebels());
					
        			break;
				case 5:
					System.out.println("La teva tropa la formen els següents rebels:");
					System.out.println(contCap.llistarRebels());
					
					break;
				case 6:
					System.out.println("La teva galaxia la formen les seguents bases: ");
					for (int i = 0; i < contCap.getGalaxia().getNSize(); i++) {
						System.out.println(contCap.getGalaxia().getNode(i));
					}
					System.out.println("Especifica un identificador de una base com a base inici de l'exode:");
					int idBaseIniEx = Integer.parseInt(br.readLine());
					String k = contCap.crearExode(idBaseIniEx);
					System.out.println("S'ha creat un nou èxode amb el id "+k);
					idBaseIniEx = contCap.getGalaxia().getExode(k).getIdBaseInici();
					System.out.println("El id de la base d'inici del èxode es: "+idBaseIniEx+"" +
							"\nSi es null es perque el identificador que has posat no pertany a cap base de la galaxia.");
					System.out.println("Els identificadors dels teus èxodes són: \n"+contCap.getGalaxia().getExodes());
					break;
				case 7:
					
					System.out.println("Especifica el identificador de l'èxode que vols borrar:");
					String idExElim = br.readLine();
					boolean b = contCap.eliminarExode(idExElim);
					if(!b){
						System.out.println("No existeix cap èxode amb aquest identificador");
					}else{
						System.out.println("L'èxode s'ha esborrat correctament");
					}
					System.out.println("Els identificadors dels teus èxodes són: \n"+contCap.getGalaxia().getExodes());
					
					
        			break;
				default:
					System.out.println("Ooops! Aquest número no es una opció correcta...");
					break;
			}
			
			System.out.println("Pressiona intro per tornar al menú del driver");
			br.readLine();
			
			menu();
			op = Integer.parseInt(br.readLine());
		} 
	}
	
	
	private static void intro() 
	{
		System.out.println("----------------------------------------");
        System.out.println("|    Driver de Controlador de Capitans |");
        System.out.println("----------------------------------------");
	}

	private static void menu()
	{
		System.out.println("Opcions:");
        System.out.println("1) Fer log-in al sistema (Aquesta operació s'ha de fer la primera!)");
        
        System.out.println("--- Gestió de rebels ---");
        
        System.out.println("2) Crear un rebel");
        System.out.println("3) Modificar un rebel ja creat");
        System.out.println("4) Eliminar un rebel");
        System.out.println("5) Llistar Rebels a les ordres del capità");
        System.out.println("");
        System.out.println("--- Operacions de l'èxode ---");
        System.out.println("6) Crear un èxode");
        System.out.println("7) Eliminar èxode");
        System.out.println("");
        System.out.println("--- Operacions de l'èxode ---");
        System.out.println("0) exit");
	}

}
