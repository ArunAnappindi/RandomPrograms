/**
 * 
 */
package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author 503054866
 *
 */
public class GenericGraph<T> {
	
	
	int data;
	
	 // We use Hashmap to store the edges in the graph 
    private Map<T, List<T> > map = new HashMap<>(); 
	
	
	
	public void addVertex(T source) {
		map.put(source,  new LinkedList<T>());
	}
	
	public void addEdge(T source, T destination, boolean isBirectional) {
		
		if(!map.containsKey(source)) {
			addVertex(source);
		}
		if(!map.containsKey(destination)) {
			addVertex(destination);
		}
		
		map.get(source).add(destination);
		
		if(isBirectional) {
			map.get(destination).add(source);
		}
	}
	
	
	
	public int getEdgesCount(T source) {
		return map.get(source).size();
	}

	public int getTotalEdgesCount(boolean isBidirectional) {
		int count = 0;
		for(T s: map.keySet()) {
			count += map.get(s).size();
		}
		
		if(isBidirectional) {
			count = count/2;
		}
		
		return count;
	}
	
	public boolean hasEdge(T source, T destination) {
		for(T s: map.get(source)) {
			if(s == destination) {
				return true;
			}
		}
		
		return false;
		
	}
	
	// This function gives the count of vertices 
    public void getVertexCount() 
    { 
        System.out.println("The graph has "
                           + map.keySet().size() 
                           + " vertex"); 
    }
	

	public static void main(String args[]) 
    { 
  
        // Object of graph is created. 
        GenericGraph<Integer> g = new GenericGraph<Integer>(); 
  
        // edges are added. 
        // Since the graph is bidirectional, 
        // so boolean bidirectional is passed as true. 
        g.addEdge(0, 1, true); 
        g.addEdge(0, 4, true); 
        g.addEdge(1, 2, true); 
        g.addEdge(1, 3, true); 
        g.addEdge(1, 4, true); 
        g.addEdge(2, 3, true); 
        g.addEdge(3, 4, true); 
  
        // print the graph. 
      //  System.out.println("Graph:\n"
        //                   + g.toString()); 
  
        // gives the no of vertices in the graph. 
        g.getVertexCount(); 
        
        System.out.println(g.getEdgesCount(1));
  
        // gives the no of edges in the graph. 
        System.out.println(g.getTotalEdgesCount(true)); 
  
        // tells whether the edge is present or not. 
        System.out.println(g.hasEdge(3, 4)); 
  
        // tells whether vertex is present or not 
    //    g.hasVertex(5); 
    } 

	
	
	
}
