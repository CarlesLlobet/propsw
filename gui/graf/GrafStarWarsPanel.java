package gui.graf;

import java.io.IOException;
import java.util.ArrayList;

import propsw.Base;
import propsw.Graf;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class GrafStarWarsPanel extends mxGraphComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Graf<Base> graf;
	private final int INIT_X = 10;
	private final int INIT_Y = 10;
	private final int DIFF_X = 160;
	private final int DIFF_Y = 60;
	private final int TAMANY_X = 80;
	private final int TAMANY_Y = 30;
	
	private Object[] objectes;

	public GrafStarWarsPanel() {
		super(new mxGraph());
	}
	
	
	public Graf<Base> getGraf() {
		return graf;
	}

	public void setGraf(Graf<Base> graf) {
		this.graf = graf;
	}
	
	public void paintTheGraf() throws IOException{
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			objectes = new Object[graf.getNSize()];
			int idBase = 0;
			if(objectes.length>0)
				graph = paintRecursiuHelper(parent, objectes, graph, idBase, INIT_X, INIT_Y);
			//Si el objectes contiene nulos significa que el panel no ha pintado todas las bases
			//Las pintamos debajo de la primera base.
			int x = INIT_X;
			int y = INIT_Y;
			for (int i = 0; i < objectes.length; i++) {
				if(objectes[i]==null){
					y = y + DIFF_Y;
					objectes[i] = graph.insertVertex(parent, null, graf.getNode(i), x, y, TAMANY_X, TAMANY_Y);
				}
			}
		}
		finally
		{
			graph.getModel().endUpdate();
		}
		
		this.setGraph(graph);
		this.refresh();
		
	}


	private mxGraph paintRecursiuHelper(Object parent, Object[] objectes,
			mxGraph graph, int idBase, int x, int y) throws IOException {
		
		if(objectes[idBase]==null)objectes[idBase] = graph.insertVertex(parent, null, graf.getNode(idBase), x, y, TAMANY_X, TAMANY_Y);
		
		ArrayList<Integer> arr = graf.getOutNodes(idBase);
		int idBaseHelp;
		int xHelp = x + DIFF_X;
		int yHelp = y;
		int idAresta;
		for (int i = 0; i < arr.size(); i++) {
			idBaseHelp = arr.get(i);
			yHelp = yHelp + DIFF_Y;
			graph = paintRecursiuHelper(parent, objectes, graph, idBaseHelp, xHelp, yHelp);
			idAresta = graf.getIDAresta(idBase,idBaseHelp);
			graph.insertEdge(parent, null, ""+graf.getFlujoAresta(idAresta)+"/"+graf.getCapacidadAresta(idAresta)+" ["+graf.getCosteAresta(idAresta)+"]", objectes[idBase], objectes[idBaseHelp]);
		}
		
		return graph;
	}
	
	
	public void coloreaAresta(int idBaseInit, int idBaseEnd, String color){
		Object[] edge = graph.getEdgesBetween(objectes[idBaseInit], objectes[idBaseEnd]);
		graph.setCellStyles(mxConstants.STYLE_STROKECOLOR,color, edge);
	}

}
