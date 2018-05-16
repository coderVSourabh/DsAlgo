package sourabhs.datastructures.graph;


/**
 *  Dijkstra's Algorithm
 * @author Sourabh
 *
 */

public class Dijkstra {
	
	int findMin(int dist[], boolean visited[]) {
        int min = Integer.MAX_VALUE,  min_index = -1;
 
        for (int v = 0; v < dist.length; v++)
            if (visited[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
	
	void dijkstraGraphMatrix(int[][] graph, int startIndex) {
	    int dist[] = new int[graph.length]; 
	    boolean visited[] = new boolean[graph.length];
	    
	    int parent[] = new int[graph.length];
	 
	    for (int i = 0; i < graph.length; i++) {
	        parent[0] = -1;
	        dist[i] = Integer.MAX_VALUE;
	        visited[i] = false;
	    }
	    
	    dist[startIndex] = 0;
	 
	    for (int count = 0; count < graph.length; count++) {
	        int min = findMin(dist, visited);
	        visited[min] = true;
	        for (int j = 0; j < graph.length; j++)
	            if (!visited[j] && graph[min][j] != 0 &&
	                dist[min] + graph[min][j] < dist[j]) {
	                parent[j]  = min;
	                dist[j] = dist[min] + graph[min][j];
	            }  
	    }
	    
	    printShortestPath(dist, parent);
	}
	
	private void printPath(int parent[], int j) {
	    if (parent[j]==0)
	        return;
	 
	    printPath(parent, parent[j]);
	 
	    System.out.print("-"+j);
	}
	 
	private void printShortestPath(int dist[], int parent[]) {
	    int src = 0;
	    System.out.println("Vertex Distance Path");
	    for (int i = 1; i < dist.length; i++) {
	        System.out.print("\n" + src + "->" + i + "\t" +dist[i]+ "\t" + src );
	        printPath(parent, i);
	    }
	}


	public static void main(String[] args) {
		GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(7, false);
		g.addEdge(0, 1, 31);
		g.addEdge(1, 2, 29);
		g.addEdge(2, 0, 12);
		g.addEdge(0, 3, 16);
		g.addEdge(1, 3, 31);
		g.addEdge(3, 4, 16);
		g.addEdge(4, 5, 24);
		g.addEdge(2, 4, 15);
		g.addEdge(2, 5, 14);
		g.addEdge(2, 6, 12);
		g.addEdge(1, 6);
		
		g.print();
		
		Dijkstra shortPath = new Dijkstra();
		shortPath.dijkstraGraphMatrix(g.getGraph(), 0);

	}

}
