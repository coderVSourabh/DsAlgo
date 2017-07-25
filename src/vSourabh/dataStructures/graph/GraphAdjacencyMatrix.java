package vsourabh.datastructures.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/**
 * GraphAdjacencyMatrix
 *  Uses Adjacency Matrix for representing graph
 *  Pros:
 *  	Easy to Implement
 *  	Removing an edge takes O(1)
 *  	Finding Neighbour also O(1)
 *  Cons:
 *  	Consumes more space O(V^2)
 *  	Adding a Vertex is O(V^2) time
 * @author Sourabh
 *
 */
public class GraphAdjacencyMatrix {
	
	private boolean isDirectedGraph;
	private int totalVertex;
	private int[][] graph;
	
	public int[][] getGraph() {
		return graph;
	}

	public GraphAdjacencyMatrix(int size) {
		this(size, false);
	}
	
	public GraphAdjacencyMatrix(int size, boolean isDirected) {
		this.isDirectedGraph = isDirected;
		this.totalVertex = size;
		graph = new int[size][size];
		//set all values to 0 initially 
		for (int[] row: graph)
			java.util.Arrays.fill(row, 0);
	}
	
	//TODO: Can be improved using lambda function
	public void addMoreVertex(int numberOfNewVertex) {
		this.totalVertex += numberOfNewVertex;
		int arr[][] = new int[totalVertex][totalVertex];
		//Copy old value to temp array 
		int oldLength = graph.length;
		for(int i = 0; i < graph.length; i++)
			arr[i] = java.util.Arrays.copyOf(graph[i], graph.length);
		
		//Create new array of new Size and copy old data
		graph = new int[totalVertex][totalVertex];
		for(int i = 0; i < oldLength; i++)
			graph[i] = java.util.Arrays.copyOf(arr[i], totalVertex);
	}
	
	public void removeVertex(int vertex) {
		this.removeEdge(vertex);
	}
	
	public void addEdge(int vertexParent, int vertexChild, int cost) {
		if(vertexParent >= 0 && vertexParent < this.totalVertex
				&& vertexChild >= 0 && vertexChild < this.totalVertex) {
			graph[vertexParent][vertexChild] = cost;
			if(!this.isDirectedGraph)
				graph[vertexChild][vertexParent] = cost;
		}
	}
	
	public void addEdge(int vertexParent, int vertexChild) {
		this.addEdge(vertexParent, vertexChild, 1);
	}
	
	public void removeEdge(int vertex) {
		if(vertex >= 0 && vertex < this.totalVertex) {
			for(int i = 0; i<this.totalVertex; i++) {
				graph[vertex][i] = 0;
				graph[i][vertex] = 0;
			}
		}
	}
	
	public void print() {
		System.out.println("\n Total Vertexes:" + this.totalVertex);
		for(int[] row: graph) {
			System.out.println(java.util.Arrays.toString(row));
		}
	}

	@Override
	public String toString() {
		return "totalVertex=" + totalVertex + ", graph=" + java.util.Arrays.deepToString(graph) + "]";
	}
	
	public void DFSUtill(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int i = 0; i < this.totalVertex; i++)
			if (graph[vertex][i] != 0 && !visited[i])
				DFSUtill(i, visited);
	}
	
	public void DFS(int vertex) {
		System.out.print("\n Depth First Search : ");
		boolean[] visited = new boolean [this.totalVertex+1];
		this.DFSUtill(vertex, visited);
		
	}
	
	public void BFS(int vertex) {
		Set<Integer> visited = new HashSet<>();
		Deque<Integer> queue = new LinkedList<>();

		visited.add(vertex);
		queue.addLast(vertex);
		System.out.print("\n Breadth First Search : ");
		while (!queue.isEmpty()) {
			vertex = queue.removeFirst();
			System.out.print(vertex + " ");

			for(int ele = 0; ele < this.totalVertex; ele++) {
				if (!visited.contains(ele) && graph[vertex][ele] != 0) {
					queue.addLast(ele);
					visited.add(ele);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(6, false);
		g.addEdge(0, 1, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 3);
		g.addEdge(1, 3, 3);
		g.addEdge(3, 4, 6);
		g.addEdge(4, 5, 2);
		g.addEdge(2, 4, 5);
		g.addEdge(2, 5, 4);
		
		g.print();
		g.removeVertex(4);

		g.addMoreVertex(1);
		g.addEdge(2, 6, 2);
		g.addEdge(1, 6);
		
		g.print();
		
		g.DFS(0);
		
		g.BFS(0);
	

	}

}
