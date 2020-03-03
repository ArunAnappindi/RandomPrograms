/**
 * 
 */
package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Arun
 *
 */
public class CycleInDirectedGraph {

	boolean isCyclePres = false;
	int parent = -1;
	private Map<Integer, LinkedList<Integer>> map;

	public CycleInDirectedGraph(int v) {
		map = new HashMap<Integer, LinkedList<Integer>>();
	}

	public void addVertex(Integer source) {
		map.put(source, new LinkedList<Integer>());
	}

	/**
	 * Since this is a undirected Graph, we will have to add source and destination
	 * for each other respectively
	 * 
	 * @param sourceVertex
	 * @param destinationVertex
	 */
	public void addEdge(int sourceVertex, int destinationVertex) {

		if (!map.containsKey(sourceVertex)) {
			addVertex(sourceVertex);
		}

		if (!map.containsKey(destinationVertex)) {
			addVertex(destinationVertex);
		}

		map.get(sourceVertex).add(destinationVertex);
	}

	boolean isCyclic() {

		HashMap<Integer, Boolean> intVisitedMap = new HashMap<Integer, Boolean>();

		map.forEach((k, v) -> {
			System.out.println("Key: " + k + ", Value: " + v);
			LinkedList<Integer> adj = (LinkedList<Integer>) v;
			if (!intVisitedMap.containsKey(k)) {
				intVisitedMap.put(k, true);
			}
			for (int j = 0; j < adj.size(); j++) {
				if (intVisitedMap.containsKey(adj.get(j))) {
					isCyclePres = true;
				}
			}
			parent = k;
		});

		return isCyclePres;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CycleInDirectedGraph graph = new CycleInDirectedGraph(5);
		 graph.addEdge(0, 1); 
	        graph.addEdge(0, 2); 
	        graph.addEdge(1, 2); 
	        graph.addEdge(2, 0); 
	        graph.addEdge(2, 3); 
	        graph.addEdge(3, 3); 
	          
	        if(graph.isCyclic()) 
	            System.out.println("Graph contains cycle"); 
	        else
	            System.out.println("Graph doesn't "
	                                    + "contain cycle"); 
	}

}
