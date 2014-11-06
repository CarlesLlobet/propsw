package propsw;

public class MainCtrl {
	
	//Controlador dels capitans
	private CapitaCtrl caps = new CapitaCtrl();
	
	//indica si la sessio ha estat iniciada com a capita o rebel
	private boolean capita = false;
	
	private void gestio_galaxies(){
		//pre: login com a capita 
		//post: mostra totes les opcions quant a la gestio de galaxies
	}
	
	private void gestio_rebels(){
		//pre: login com a capita 
		//post: mostra totes les opcions quant a la gestio de rebels
	}

	private void gestio_exodes(){
		//pre: login com a capita 
		//post: mostra totes les opcions quant a la gestio d'èxodes
	}

	private void executar_exode(){
		//pre: login com a capita 
		//post: permet calcular un nou èxode
	}

	private void afegir_capita(){
		//pre: login com a capita 
		//post: permet afegir un nou capita al sistema
	}

	private void mostrar_rutarebel(){
		//pre: login com a rebel
		//post: mostra la ruta assignada per al rebel que ha iniciat la sessio
	}
	

	public void reiniciar_sistema(){
		//pre:login com a capita
		//post: S'esborrent totes les dades del sistema

	}
	
	public void login(){
		//pre:
		/*post: si no hi ha cap capita definit al sistema: es registra un nou capita
		 *		si ja hi ha un o més capitans: es realitza el login
		 */	

	}
	
	public static void main(String[] args) {
		//S'encarrega de gestionar el login i mitjançant les funcions privades, permet a l'usuari
		//indicar quines tasques vol realitzar
	}	
	
}
