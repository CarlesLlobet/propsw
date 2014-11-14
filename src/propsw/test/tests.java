package propsw.test;

import java.io.IOException;

import propsw.*;


public class tests {

	
	public static void main(String[] args) throws IOException {
		testExode();
		
		
	}

	
	
	private static void testExode() throws IOException {
		CapitaControlador cControl = new CapitaControlador();
		cControl.login("foo", "foooooo");
		Capita c = cControl.getCapita();
		System.out.println(c.getNom()+" està connectat...");
		Galaxia g = cControl.getGalaxia();
		new Base(g);
		new Base(g);
		new Base(g);
		new Base(g);
		new Base(g);
		new Base(g);
		
		g.conectarNodes(0, 1, 5, 5.0);
		g.conectarNodes(0, 2, 7, 5.0);
		g.conectarNodes(1, 3, 2, 5.0);
		g.conectarNodes(1, 2, 1, 5.0);
		g.conectarNodes(2, 3, 9, 5.0);
		g.conectarNodes(2, 4, 4, 5.0);
		g.conectarNodes(2, 5, 3, 5.0);
		g.conectarNodes(4, 3, 2, 5.0);
		
		
		
		String idRebel0 = cControl.crearRebel("Rebel0");
		String idRebel1 = cControl.crearRebel("Rebel1");
		String idRebel2 = cControl.crearRebel("Rebel2");
		String idRebel3 = cControl.crearRebel("Rebel3");
		String idRebel4 = cControl.crearRebel("Rebel4");
		String idRebel5 = cControl.crearRebel("Rebel5");
		String idRebel6 = cControl.crearRebel("Rebel6");
		String idRebel7 = cControl.crearRebel("Rebel7");
		String idRebel8 = cControl.crearRebel("Rebel8");
		String idRebel9 = cControl.crearRebel("Rebel9");
		
		String idExode = cControl.crearExode(0);
		Exode e = g.getExode(idExode);
		
		
		

		e.afegirRebel(idRebel0, 3);
		e.afegirRebel(idRebel2, 3);
		e.afegirRebel(idRebel9, 3);
		
		e.afegirRebel(idRebel1, 4);
		e.afegirRebel(idRebel7, 4);		//No arriba correcte!
		e.afegirRebel(idRebel6, 4);
		e.afegirRebel(idRebel4, 4);
		e.afegirRebel(idRebel5, 4);
		
		e.afegirRebel(idRebel8, 5);
		e.afegirRebel(idRebel3, 5);
		
		e.execucioDFS();
		
		System.out.println(e.getFf().printMatrix(g));
		
		System.out.println("MaxFlow: "+e.getFlow());
		System.out.println("Caminos de los rebeldes: "+e.getCamins());
		
	}
	
	
	
}
