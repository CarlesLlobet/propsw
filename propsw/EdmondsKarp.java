package propsw;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.util.Collections;

/**
 *
 * @author Mingjian Chen
 */
 public class EdmondsKarp<T> extends FordFulkerson<T>
 {

 	private ArrayList<ArrayList<Integer>> camins;
 	private HashMap<Integer, Integer> fromNode;

 	/**
 	 * Constructor de EdmondsKarp
 	 * @param nodeInicial l'id de node inicial(sink)
 	 * @param nodeDesti l'id de node desti(tail)
 	 * @param graf el graf de tipus T
 	 */
 	public EdmondsKarp(Integer nodeInicial, Integer nodeDesti, Graf<T> graf)
 	{
 		super(nodeInicial, nodeDesti, graf);
 		this.fromNode = new HashMap<Integer, Integer>();
 		this.camins = new ArrayList<ArrayList<Integer>>();
 	}

 	/**
 	 * Donat un graf i un enter, s'obte un conjunt de camins per tal que hi hagi un maxflow de n
 	 * @param graf el graf de tipus T
 	 * @param n el nombre n, ha de ser major que 0
 	 * @return Un arraylist de arraylist de enters
 	 *
 	 */
 	public ArrayList<ArrayList<Integer>> retorna_camins(Graf<T> graf, Integer n) throws IOException
 	{
 		if(n < 1) throw new IOException("n ha de ser major que 0");

 		//Graf<T> rGraf = new Graf<T>();
 		//rGraf = graf.getGrafInicial(); 		
 		ArrayList<Integer> cami = new ArrayList<Integer>();
 		
 		Integer sumFlow = 0;
 		while(((cami = dameCamino(graf)) != null)  && sumFlow <= n)
 		{			
 			Integer mfc = maxFlowCurrent(graf, fromNode);
 			if(mfc <= n)
 			{
 				camins.add(cami);
 				sumFlow += mfc;
 			}
 		}

 		return camins;
 	}

 	/**
 	 * La funció que calcula el maxFlow actual del graf
 	 * @param graf el graf de tipus T
 	 * @param fromNode un Hashmap de Integer i Integer per saber el node padre de cada node
 	 * @return un enter que es el maxFlow present
 	 */
 	private Integer maxFlowCurrent(Graf<T> graf, HashMap<Integer, Integer> fromNode) throws IOException
 	{
 		Integer path_flow = Integer.MAX_VALUE;

 		Integer u;
 		Integer idArestaUV;
 		Integer capacitatUV;
 		Double cost;

 		for (Integer v = t; v != s; v = fromNode.get(v))
        {
            u = fromNode.get(v);
            idArestaUV = graf.getIDAresta(u, v);
            capacitatUV = graf.getCapacidadAresta(idArestaUV);
            path_flow = Math.min(path_flow, capacitatUV);
        }
 		

        for (Integer v = t; v != s; v = fromNode.get(v))
        {
            u = fromNode.get(v);
            idArestaUV = graf.getIDAresta(u, v);

            capacitatUV = graf.getCapacidadAresta(idArestaUV);

            capacitatUV -= path_flow;
            cost = graf.getCosteAresta(idArestaUV);
            graf.substituirAresta(idArestaUV, capacitatUV, cost);
        }

        maxFlow += path_flow;
        return path_flow;

 	}

 	/**
 	 * La funcio BFS per buscar un cami de s fins a t, aquesta funcio sobreescriu la mateixa funcio de
 	 * la classe FordFulkerson
 	 * @param graf un graf de tipus T.
 	 * @return un arraylist de enters que passa de s a t. 
 	 *
 	 */
 	@Override
 	public ArrayList<Integer> dameCamino(Graf<T> graf) throws IOException
 	{


 		Integer V = graf.getNSize();
 		boolean visited[] = new boolean[V];
 		ArrayList<Integer> path;
 		
 		//create a queue, enqueue the vertex and mark the vertex as visited
 		Queue<Integer> queue = new LinkedList<Integer>();
 		queue.add(s);
 		fromNode.put(s, -1);
 		Boolean found = false; 
 		while(! queue.isEmpty() && (! found))
 		{
 			//remove the vertex at the head
 			Integer head = queue.poll();
 			visited[head] = true;

 			if(head == t) found = true;
 			
 			else 
 			{
	 			ArrayList<Integer> outArray = new ArrayList<Integer>();
	 			
	 			outArray = graf.getOutNodes(head);
	 			for(Integer i = 0; i < outArray.size(); ++i)
	 			{
	 				
	 				if(! visited[outArray.get(i)])
	 				{
		 			
		 				Integer idEdge = graf.getIDAresta(head, outArray.get(i));
		 				Integer capacity = graf.getCapacidadAresta(idEdge);

		 				if(capacity > 0)
		 				{
		 					if(head == s) fromNode.put(outArray.get(i), s);
		 					else fromNode.put(outArray.get(i), head);
		 					queue.add(outArray.get(i));
		 				}
		 			}
	 			}
	 		}
 		}


 		if(found)
 		{
 			// empezamos a mirar por tail
 			path = new ArrayList<Integer>();
 			Integer aux = t;

 			path.add(aux);
	 		while(fromNode.get(aux) != -1)
	 		{
	 			Integer aux_ = aux;
	 			aux = fromNode.get(aux); // obtiene el hijo
	 			path.add(aux);
	 		}
	 		Collections.reverse(path);	
	 	}
	 	else path = null;
	 	return path;
 	}

 }