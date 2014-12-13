package propsw;

import java.io.IOException;

public class LlegirEscriureNaturalDriver {
	public static void main(String[] args) throws IOException {
		CapitaControlador cc = new CapitaControlador(); 
		LlegirEscriureNatural len = new LlegirEscriureNatural(cc);
		String ic = len.llegirCapita("provaLecturaCapi.txt");
		len.escriureCapita("provaOutCapi", ic);
		len.llegirGalaxia("provaLecturaGal.txt", ic);
		len.escriureGalaxia("provaOutGal", ic);
	}
}
