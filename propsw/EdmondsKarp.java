package propsw;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;

/**
 *
 * @author Mingjian Chen
 */
 public class EdmondsKarp<T> extends FordFulkerson<T> implements Serializable
 {

 	private ArrayList<ArrayList<Integer>> camins;
 	private HashMap<Integer, Integer> fromNode;
 	private HashMap<Integer, Integer> _fromNode;

 	public EdmondsKarp()
 	{

 	}

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
 		this._fromNode = new HashMap<Integer, Integer>();
 	}

 	/**
 	 * Donat un graf residual i un enter, s'obte un conjunt de camins per tal que hi hagi un maxflow de n
 	 * @param graf el graf residual de tipus T
 	 * @param n el nombre n, ha de ser major que 0
 	 * @return Un arraylist de arraylist de enters
 	 *
 	 */
 	public ArrayList<ArrayList<Integer>> retorna_camins(Graf<T> grafR, Integer n) throws IOException
 	{
 		if(n < 1) throw new IOException("n ha de ser major que 0");
	

 		ArrayList<Integer> cami = new ArrayList<Integer>();

		cami = find_Path(grafR);

 		do
 		{	
 			maxFlowCurrent(grafR);
 			/*System.out.println("cami: " + 
                                cami.toString());*/	
 			camins.add(cami);
 		}
 		while((cami = find_Path(grafR)) != null);

 		/*System.out.println("Camins: " + 
                                camins.toString());*/
	 	

 		return camins;
 	}

 	/**
 	 * La funció que calcula el maxFlow actual del graf
 	 * @param graf el graf de tipus T
 	 * @param fromNode un Hashmap de Integer i Integer per saber el node padre de cada node
 	 * @return un enter que es el maxFlow present
 	 */
 	private void maxFlowCurrent(Graf<T> graf) throws IOException
 	{
 		Integer _path_flow = Integer.MAX_VALUE;

 		Integer _u;
 		Integer _idArestaUV;
 		Integer _fluxUV;

 		for (Integer _v = t; _v != s; _v = _fromNode.get(_v))
        {
        	//System.out.println("_v actual = " + _v);
            _u = _fromNode.get(_v);
            //System.out.println("su padre _u = " + _u);
            _idArestaUV = graf.getIDAresta(_u, _v);

            _fluxUV = graf.getFlujoAresta(_idArestaUV);
            _path_flow = Math.min(_path_flow, _fluxUV);
        }
 		

        for (Integer _v = t; _v != s; _v = _fromNode.get(_v))
        {
        	//System.out.println("_v actual = " + _v);
            _u = _fromNode.get(_v);
            //System.out.println("su padre _u = " + _u);
            _idArestaUV = graf.getIDAresta(_u, _v);

            _fluxUV = graf.getFlujoAresta(_idArestaUV);

            _fluxUV -= _path_flow;
       		graf.setFlujoAresta(_idArestaUV, _fluxUV);
        }

 	}


 	/**
 	 *
 	 *
 	 *
 	 */
 	private ArrayList<Integer> find_Path(Graf<T> grafResidual) throws IOException
 	{
 		ArrayList<Integer> _path;
 		

 		Queue<Integer> _queue = new LinkedList<Integer>();
 		_queue.add(s);
 		_fromNode.put(s, -1);
 		Boolean _found = false; 

 		while(! _queue.isEmpty() && (! _found))
 		{
 			//remove the vertex at the head
 			Integer _head = _queue.poll();

 			if(_head == t) _found = true;
 			
 			else 
 			{
	 			ArrayList<Integer> _outArray = new ArrayList<Integer>();
	 			
	 			_outArray = grafResidual.getOutNodes(_head);
	 			for(Integer i = 0; i < _outArray.size(); ++i)
	 			{
	 				
	 				Integer _idEdge = grafResidual.getIDAresta(_head, _outArray.get(i));
		 			Integer flux = grafResidual.getFlujoAresta(_idEdge);
		 			//System.out.println("flux = " + flux);
	 				if(flux > 0)
	 				{
	 					if(_head == s) _fromNode.put(_outArray.get(i), s);
	 					else _fromNode.put(_outArray.get(i), _head);
	 					_queue.add(_outArray.get(i));

	 				}
	 			}
	 		}
 		}



 		if(_found)
 		{
 			// empezamos a mirar por tail
 			_path = new ArrayList<Integer>();
 			Integer aux1 = t;
 			_path.add(aux1);
	 		while(_fromNode.get(aux1) != -1)
	 		{

	 			aux1 = _fromNode.get(aux1); // obtiene el hijo
	 			_path.add(aux1);

	 		}



	 		Collections.reverse(_path);	
	 	}
	 	else _path = null;
	 	return _path;
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
	 			aux = fromNode.get(aux); // obtiene el hijo
	 			path.add(aux);
	 		}
	 		
	 		Collections.reverse(path);	
	 	}
	 	else path = null;
	 	
	 	return path;
 	}

 }