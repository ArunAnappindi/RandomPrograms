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
public class CycleInUndirectedGraph {

	boolean isCyclePres = false;
	int parent = -1;
	private Map<Integer, LinkedList<Integer>> map;

	public CycleInUndirectedGraph(int v) {
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
		map.get(destinationVertex).add(sourceVertex);
	}

	boolean isCyclic() {

		HashMap<Integer, Boolean> intVisitedMap = new HashMap<Integer, Boolean>();

		map.forEach((k, v) -> {
			System.out.println("Key: " + k + ", Value: " + v);

			LinkedList<Integer> adj = (LinkedList<Integer>) v;
			if (!intVisitedMap.containsKey(parent)) {
				intVisitedMap.put(parent, true);
			}
			for (int j = 0; j < adj.size(); j++) {
				if (parent != adj.get(j)) {
					if (!intVisitedMap.containsKey(adj.get(j))) {
						intVisitedMap.put(adj.get(j), true);
					} else {
						isCyclePres = true;
					}
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
		CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

		CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");
	}

}
