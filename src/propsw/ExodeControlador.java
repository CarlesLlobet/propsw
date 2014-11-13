package propsw;



import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;

public class ExodeControlador extends GalaxiaControlador {
	public void execucio(String idExode, Integer tipusExec) throws IOException {
		if (tipusExec == 0){
			getGalaxia().getExode(idExode).execucioBFS();
		}
		else if (tipusExec == 1){
			getGalaxia().getExode(idExode).execucioDFS();
		}
		else if (tipusExec == 2){
			getGalaxia().getExode(idExode).execucioDijkstra();
		}
	}

	public Integer getIniciExode(String idExode) {
		return getGalaxia().getExode(idExode).getIdBaseInici(); //Exode.getBaseInici() no existeix
	}

	public ArrayList<String> getRebels(String idExode) {
		return getGalaxia().getExode(idExode).getRebels(); //Exode.getRebels() no existeix
	}

	public Integer getRebelsSize(String idExode) {
		return getGalaxia().getExode(idExode).getRebels().size();
	}

	public ArrayList<Integer> getCamiRebelExode(String idExode, String idRebel) {
		return getGalaxia().getExode(idExode).getCamiRebel(idRebel); //Exode.getCamiRebel(idR) no existeix
	}

	public Integer getFlowExode(String idExode) {
		return getGalaxia().getExode(idExode).getFlow(); ////Exode.getFlow() no existeix
	}

	public double getCostExode(String idExode) {
		return getGalaxia().getExode(idExode).getCost(); //Exode.getCost() no existeix
	}

	public ArrayList<Integer> getAmpollaExode(String idExode) {
		return getGalaxia().getExode(idExode).getAmpolla();
	}

	public boolean afegirRebel(String idExode, String idRebel, Integer idBaseDesti) {
		super.getRebel(idRebel).insertarExode(idExode);
		return getGalaxia().getExode(idExode).afegirRebel(idRebel, idBaseDesti);   //a Exode.afegirRebel(idR) li falta ...(idR, -> idBD <-)
	}

	public boolean modificarRebel(String idExode, String idRebel, Integer idBaseDesti) {
		return getGalaxia().getExode(idExode).modificarRebel(idRebel, idBaseDesti);  //Exode.modificarRebel(idR, idBD) no existeix
	}

	public boolean treureRebel(String idExode, String idRebel) {
		getRebel(idRebel).esborrarExode(idExode);           //Rebel.borrarExode() no existeix
		return getGalaxia().getExode(idExode).borrarRebel(idRebel);
	}
}