package vsourabh.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * GraphAdjacencyList
 * Uses Adjacency List for Graph representation
 * Pros:
 * 		Save space O(V+E) or worst case O(V^2)
 * 		Adding or removing a vertex is easier
 * Cons:
 * 		Queries to find neighbour can be O(V)
 * 
 * @author Sourabh
 * 
 * 
 */
public class GraphAdjacencyList {
	
	private class Edge {
		public int edgeCost;
		public int vertex;
		
		public Edge(int vertex, int edgePrice) {
			this.vertex = vertex;
			edgeCost = edgePrice;
		}
	}
	
	
	private boolean isDirectedGraph;
	private int totalVertex;
	private Map<Integer, List<Edge>> graph = new HashMap<>();
	
	public GraphAdjacencyList(int totalVertexes) {
		this(totalVertexes, false);
	}
	
	public GraphAdjacencyList(int initVertex, boolean isDirected) {
		this.isDirectedGraph = isDirected;
		this.totalVertex = initVertex;
		for(int v = 1; v <= totalVertex; v++) {
			graph.put(v, new LinkedList<>());
		}
	}
	
	public void addVertex() {
		totalVertex += 1;
		graph.put(totalVertex, new LinkedList<>());
	}
	
	public void removeVertex(int vertex) {
		this.removeEdge(vertex);
		
	}
	
	public void addEdge(int vertexParent, int vertexChild, int edgeCost) {
		if(vertexParent > totalVertex && vertexChild > totalVertex)
			return;
		List<Edge> edgeList = graph.get(vertexParent);
		Edge edge = new Edge(vertexChild, edgeCost);
		edgeList.add(edge);
		if(!isDirectedGraph) {
			edgeList = graph.get(vertexChild);
			edge = new Edge(vertexParent, edgeCost);
			edgeList.add(edge);
		}
	}
	
	public void removeEdge(int vertex) {
		List<Edge> edgeList = graph.get(vertex);
		for(Edge edge : edgeList) {
			edge.edgeCost = Integer.MAX_VALUE;
			
			if(!isDirectedGraph) {
				List<Edge> tempEdge = graph.get(edge.vertex);
				for(Edge temp : tempEdge) {
					if(temp.vertex == vertex) {
						temp.edgeCost = Integer.MAX_VALUE;
						break;
					}
				}
			}
			
		}
	}
	
	public void print() {
		 /* //Old way to iterate Map
		    Iterator<Entry<Integer, List<Edge>>> it = graph.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<Integer,List<Edge>> currPos = it.next();
		        System.out.print("Vertex:"+ currPos.getKey());
		        List<Edge> edgeList = currPos.getValue();
		        for(Edge edge : edgeList) {
		        	if(edge.edgeCost != Integer.MAX_VALUE)
		        		System.out.print("| Edge:" + edge.vertex + " cost: " + edge.edgeCost);
		        }
		        System.out.println("\n");
		        it.remove(); 
		    }*/
		
		//Iterate using forEach Lambda expressions
		graph.forEach((vertex, edgeList)-> {
			 System.out.print("Vertex:"+ vertex);
			 edgeList.forEach((edge) -> { 
		        	if(edge.edgeCost != Integer.MAX_VALUE)
		        		System.out.print("| Edge:" + edge.vertex 
		        				+ " cost: " + edge.edgeCost);
		        });
			 System.out.println("");
		});
		
	}
	

	public void DFSUtil(int vertex, boolean visited[]) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		List<Edge> edgeList = graph.get(vertex);
		edgeList.forEach((edge) -> { 
			if (!visited[edge.vertex] && edge.edgeCost != Integer.MAX_VALUE)
				DFSUtil(edge.vertex, visited);
		
		});
	}

	/**
	 * Time Complexity: O(V+E) 
	 * We take a node and put any one neighbour into the stack
	 * Pop until stack is empty
	 * 
	 * Stack : Last-In-First-Out
	 */
	public void DFS(int vertex)  {
		
		System.out.print("\n Depth First Search : ");
		
		boolean visited[] = new boolean[totalVertex+1];
		// Loop if some part of Graph for disconnected Graph
		/*for (int i = 1; i <= totalVertex; ++i)
			if (!visited[i])
				DFSUtil(i, visited);*/
		DFSUtil(vertex, visited);
	}
	
	/**
	 * Time Complexity: O(V+E) 
	 * We take a node add the unvisited neighbours into Queue
	 * Stop when Queue is empty
	 * 
	 * Queue: First-In-First-Out
	 */
	public void BFS(int vertex) {
		
		System.out.print("\n Breadth First Search : ");
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		visited.add(vertex);
		queue.add(vertex);
		while (queue.size() != 0) {
			vertex = queue.poll();
			System.out.print(vertex + " ");

			List<Edge> edgeList = graph.get(vertex);
			edgeList.forEach((edge) -> {
				if (!visited.contains(edge.vertex) && edge.edgeCost != Integer.MAX_VALUE) {
					queue.add(edge.vertex);
					visited.add(edge.vertex);
				}
			});
			
		}
		
	}
	
	
	
	public static void main(String vars[]) {
		GraphAdjacencyList g = new GraphAdjacencyList(6, false);
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 1, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 4, 3);
		g.addEdge(4, 5, 6);
		g.addEdge(5, 6, 2);
		g.addEdge(3, 5, 5);
		g.addEdge(3, 6, 4);
		
		g.removeVertex(4);

		g.addVertex();
		g.addEdge(3, 7, 2);
		g.addEdge(2, 7, 1);
		
		g.print();
		
		System.out.println("\n\n");
		
		g.DFS(5);
		
		g.BFS(1);
	}
}

