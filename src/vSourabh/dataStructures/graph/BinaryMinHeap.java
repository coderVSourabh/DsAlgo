/**
 * 
 */
package vsourabh.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sourabh
 * 
 * Data structure to support following operations
 * Time Complexity:
 * extracMin - O(Log(n))
 * addToHeap - O(Log(n))
 * containsKey - O(1)
 * decreaseKey - O(Log(n))
 * getKeyWeight - O(1)
 *
 * Combination of Binary heap and Hash Map
 *        16
 *        /\
 * 		14  10
 *      /\   /\
 * 	   8  7 9 3
 * Array Representaiton: 16,14,10,8,7,9,3
 * 
 * 
 */
//TODO
public class BinaryMinHeap<T> {
	private List<Node> heapNodes = new ArrayList<>();
    private Map<T,Integer> nodePosition = new HashMap<>();
        
    public class Node {
        int weight;
        T key;
    }
    
    public boolean containsData(T key){
        return nodePosition.containsKey(key);
    }
    
    /**
     * Add new Key and weight to heap
     * 
     */
    public void add(int weight,T key) {
        Node node = new Node();
        node.weight = weight;
        node.key = key;
        heapNodes.add(node);
        int currentSize = heapNodes.size() - 1;
        int parentIndex = (currentSize - 1) / 2;
        nodePosition.put(node.key, currentSize);

        while (parentIndex >= 0) {
            Node parentNode = heapNodes.get(parentIndex);
            Node currentNode = heapNodes.get(currentSize);
            if (parentNode.weight > currentNode.weight) {
                swap(parentNode,currentNode);
                updatePositionMap(parentNode.key,currentNode.key,parentIndex,currentSize);
                currentSize = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }
    
    public T min() {
        return heapNodes.get(0).key;
    }

    public boolean isEmpty() {
        return heapNodes.size() == 0;
    }
    
    public void decrease(T data, int newWeight){
        Integer position = nodePosition.get(data);
        heapNodes.get(position).weight = newWeight;
        int parent = (position -1 )/2;
        while(parent >= 0){
            if(heapNodes.get(parent).weight > heapNodes.get(position).weight){
                swap(heapNodes.get(parent), heapNodes.get(position));
                updatePositionMap(heapNodes.get(parent).key,heapNodes.get(position).key,parent,position);
                position = parent;
                parent = (parent-1)/2;
            }else{
                break;
            }
        }
    }
    
    public Integer getWeight(T key) {
        Integer position = nodePosition.get(key);
        if( position == null ) {
            return null;
        } else {
            return heapNodes.get(position).weight;
        }
    }
    
    public Node extractMinNode() {
    	int size = heapNodes.size() - 1;
    	Node minNode = new Node();
    	minNode.key = heapNodes.get(0).key;
    	minNode.weight = heapNodes.get(0).weight;
    	
    	// Last Node Value to First node
    	heapNodes.get(0).key = heapNodes.get(size).key;
    	heapNodes.get(0).weight = heapNodes.get(size).weight;
    	
    	nodePosition.remove(minNode.key);
    	nodePosition.remove(heapNodes.get(0).key);
    	nodePosition.put(heapNodes.get(0).key, 0);
    	heapNodes.remove(size);
    	size--;
    	
    	int currentIndex = 0;
    	while(true) {
    		int left = 2 * currentIndex  + 1;
    		int right = 2 * currentIndex + 2;
    		if(left > right)
    			break;
    		if(right > size)
    			right = left;
    		
    		int smallerIndex = heapNodes.get(left).weight <= heapNodes.get(left).weight ? left : right;
    		
    		if(heapNodes.get(currentIndex).weight > heapNodes.get(smallerIndex).weight) {
    			swap(heapNodes.get(currentIndex), heapNodes.get(smallerIndex));
    			updatePositionMap(heapNodes.get(currentIndex).key, heapNodes.get(smallerIndex).key, currentIndex, smallerIndex);
                currentIndex = smallerIndex;
    		} else {
    			break;
    		}
    	}
    	return minNode;
    }
    
    
    public T extractMin() {
		Node node = this.extractMinNode();
		return node.key;
	}
    
    private void printPositionMap(){
        System.out.println(nodePosition);
    }

    private void swap(Node nodeA , Node nodeB) {
    	int weight = nodeA.weight;
    	T key = nodeA.key;
    	
    	nodeA.key = nodeB.key;
    	nodeA.weight = nodeB.weight;
    	
    	nodeB.key = key;
    	nodeB.weight = weight;
    }
    
    private void updatePositionMap(T keyA, T keyB, int pos1, int pos2){
        nodePosition.remove(keyA);
        nodePosition.remove(keyB);
        nodePosition.put(keyA, pos1);
        nodePosition.put(keyB, pos2);
    }
    
    public void printHeap() {
    	System.out.println("\n");
        for(Node node : heapNodes) {
            System.out.println(node.weight + " " + node.key);
        }
    }
    
    public int size(){
        return heapNodes.size();
    }
    
	public static void main(String[] args) {
		BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
        heap.add(3, "Tushar");
        heap.printHeap();
        heap.add(4, "Anil");
        heap.printHeap();
        heap.add(8, "Vijay");
        heap.printHeap();
        heap.add(10, "Pramila");
        heap.printHeap();
        heap.add(5, "Roy");
        heap.printHeap();
        heap.add(6, "NTF");
        heap.printHeap();
        heap.add(2,"Sid");
        
        System.out.println("Heap:");
        heap.printHeap();
        
        heap.decrease("Pramila", 1);
        System.out.println("\n New Heap:"); 
        heap.printHeap();
        heap.printPositionMap();

	}
}
