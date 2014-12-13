package propsw;

import java.io.IOException;

public class LlegirEscriureNaturalDriver {
	public static void main(String[] args) throws IOException {
		CapitaControlador cc = new CapitaControlador(); 
		LlegirEscriureNatural len = new LlegirEscriureNatural(cc);
		String ic = len.llegirCapita("prova.txt");
		len.escriureCapita("provaOut", ic);
		len.llegirGalaxia("provag.txt", ic);
		len.escriureGalaxia("provaOutg", ic);
	}
}
