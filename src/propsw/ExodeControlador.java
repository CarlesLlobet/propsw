package propsw;



import java.lang.String;
import java.util.ArrayList;

public class ExodeControlador extends GalaxiaControlador {
	public void execucio(String idExode, Integer tipusExec) {
		if (tipusExec == 0){
			super.getGalaxia().getExode(idExode).execucioBFS();
		}
		else if (tipusExec == 1){
			super.getGalaxia().getExode(idExode).execucioDFS();
		}
		else if (tipusExec == 2){
			super.getGalaxia().getExode(idExode);.execucioDijkstra();
		}
	}

	public Integer getIniciExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getBaseInici(); //Exode.getBaseInici() no existeix
	}

	public ArrayList<Integer> getRebels(String idExode) {
		return super.getGalaxia().getExode(idExode).getRebels(); //Exode.getRebels() no existeix
	}

	public Integer getRebelsSize(String idExode) {
		return super.getGalaxia().getExode(idExode).getRebels().size();
	}

	public ArrayList<Integer> getCamiRebelExode(String idExode, String idRebel) {
		return super.getGalaxia().getExode(idExode).getCamiRebel(idRebel); //Exode.getCamiRebel(idR) no existeix
	}

	public Integer getFlowExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getFlow(); ////Exode.getFlow() no existeix
	}

	public double getCostExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getCost(); //Exode.getCost() no existeix
	}

	public ArrayList<Integer> getAmpollaExode(String idExode) {
		return super.getGalaxia().getExode(idExode).getAmpolla();
	}

	public boolean afegirRebel(String idExode, String idRebel, Integer idBaseDesti) {
		super.getRebel(idRebel).insertarExode(idExode);
		return super.getGalaxia().getExode(idExode).afegirRebel(idRebel, idBaseDesti);   //a Exode.afegirRebel(idR) li falta ...(idR, -> idBD <-)
	}

	public boolean modificarRebel(String idExode, String idRebel, Integer idBaseDesti) {
		return super.getGalaxia().getExode(idExode).setRebel(idRebel, idBaseDesti);  //Exode.setRebel(idR, idBD) no existeix
	}

	public boolean treureRebel(String idExode, String idRebel) {
		super.getRebel(idRebel).borrarExode(idExode);           //Rebel.borrarExode() no existeix
		return super.getGalaxia().getExode(idExode).borrarRebel(idRebel);
	}
}