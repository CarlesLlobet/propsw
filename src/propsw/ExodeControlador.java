package propsw;

import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;

public class ExodeControlador extends GalaxiaControlador {
	public ExodeControlador(){
		super();
	}
	public void execucio(String idExode, Integer tipusExec) throws IOException {
		if (tipusExec == 0){
			super.getGalaxia().getExode(idExode).execucioBFS();
		}
		else if (tipusExec == 1){
			super.getGalaxia().getExode(idExode).execucioDFS();
		}
		else if (tipusExec == 2){
			super.getGalaxia().getExode(idExode).execucioDijkstra();
		}
	}

	public Integer getIniciExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getIdBaseInici(); //Exode.getBaseInici() no existeix
	}

	public HashMap<String, Integer> getRebelsExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getDestinsRebels(); //Exode.getRebels() no existeix
	}

	public Integer getRebelsSize(String idExode) {
		return super.getGalaxia().getExode(idExode).getDestinsRebels().size();
	}

	public HashMap<String, ArrayList<Integer>> getCaminsExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getCamins(); //Exode.getCamiRebel(idR) no existeix
	}

	public Integer getFlowExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getFlow(); ////Exode.getFlow() no existeix
	}

	public double getCostExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getCost(); //Exode.getCost() no existeix
	}

	public ArrayList<Integer> getAmpollaExode(String idExode) throws IOException {
		return super.getGalaxia().getExode(idExode).getAmpolla();
	}

	public boolean afegirRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		getRebel(idRebel).insertarExode(idExode);
		return super.getGalaxia().getExode(idExode).afegirRebel(idRebel, idBaseDesti);   //a Exode.afegirRebel(idR) li falta ...(idR, -> idBD <-)
	}

	public void modificarRebelExode(String idExode, String idRebel, Integer idBaseDesti) {
		super.getGalaxia().getExode(idExode).modificarRebel(idRebel, idBaseDesti);  //Exode.modificarRebel(idR, idBD) no existeix
	}

	public boolean treureRebelExode(String idExode, String idRebel) {
		getRebel(idRebel).esborrarExode(idExode);           //Rebel.borrarExode() no existeix
		return super.getGalaxia().getExode(idExode).borrarRebel(idRebel);
	}

}
