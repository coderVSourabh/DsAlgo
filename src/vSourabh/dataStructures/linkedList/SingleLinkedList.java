package vSourabh.dataStructures.linkedList;

import vSourabh.dataStructures.node.SingleNode;

/**
 * @author Sourabh
 *
 */

public class SingleLinkedList<T> {
	
	SingleNode<T> head;
	
	public void add(T element) {
		SingleNode<T> tmp = head;
		SingleNode<T> nd = new SingleNode<T>();
		nd.setValue(element);
		nd.setNextNode(null);
		//System.out.println("Adding element: " + element);
		/** check if the list is empty */
		if (tmp == null) {
			// since there is no element, set head node.
			head = nd;
		} else {
			while(tmp.getNextNode() != null) {
				tmp = tmp.getNextNode();
			}
			tmp.setNextNode(nd);
		}
	}
	
	public void addAfterNode(T element, T after) {
		SingleNode<T> tmp = head;
		SingleNode<T> nextNode = null;
        /** Traverse till given element */
        while(tmp != null) {
            if(tmp.compareTo(after) == 0) {
                //found the target node, add after this node
                nextNode = tmp;
                SingleNode<T> nd = new SingleNode<T>();
                nd.setValue(element);
                nd.setNextNode(tmp.getNextNode());
                //System.out.println("Adding element "+ element + " After Node: " + tmp.getValue());
                tmp.setNextNode(nd);
                break;
            }
            tmp = tmp.getNextNode();
        }
        if(nextNode == null) {
            System.out.println("Unable to find the given element...");
        }
    }
	
	public void addAtPosition(T element, int position) {
		SingleNode<T> tmp = head;
        /** Traverse till given element */
		int count = count();
		SingleNode<T> node = new SingleNode<T>();
        node.setValue(element);
		if(position <= 0 || position > count + 1) {
			 System.out.println("Not possible to insert at "+ position 
					 + " position for total count of List " + count );
			 return;
		} else if (position == 1) {
        	node.setNextNode(head.getNextNode());
        	head = node;
        } else {
        	count = 1;
            while(tmp.getNextNode() != null && count < position - 1) {
            	count++;
            	tmp = tmp.getNextNode();
            }
            //System.out.println("Adding element "+ element + " at position: " + ++count);
            node.setNextNode(tmp.getNextNode());
        	tmp.setNextNode(node);
        }
    }
	
	public void deleteHead() {
        if(head == null){
            System.out.println("Underflow...");
        }
        SingleNode<T> tmp = head;
        head = tmp.getNextNode();
        //System.out.println("Deleted Head: " + tmp.getValue());
    }
     
    public void deleteAfter(T after) {
    	SingleNode<T> tmp = head;
    	SingleNode<T> prvNode = null;
        /** Traverse till given element */
        while(tmp != null) {
            if(tmp.compareTo(after) == 0) {
                //found the target node, add after this node
                prvNode = tmp;
                tmp = prvNode.getNextNode();
                //System.out.println("Deleted: "+tmp.getValue() + " After "+ prvNode.getValue());
                prvNode.setNextNode(tmp.getNextNode());
                break;
            }
            tmp = tmp.getNextNode();
        }
        if(prvNode == null) {
            System.out.println("Unable to find the given element...after " + after);
        }
    }
    
    public void delete(T element){
    	SingleNode<T> tmp = head;
        SingleNode<T> refNode = null;
        /** Traverse till the node to be deleted */
        if (head != null && head.compareTo(element) == 0) {
        	System.out.println("Deleted: "+head.getValue());
        	head = tmp.getNextNode();
        } else if(tmp != null && tmp.getNextNode() != null) {
        	boolean nodeDeleted = false;
        	while(tmp.getNextNode() != null) {
                if(tmp.getNextNode().compareTo(element) == 0){
                    //found the target node to be deleted
                    refNode = tmp;
                    tmp = refNode.getNextNode();
                    refNode.setNextNode(tmp.getNextNode());
                    nodeDeleted = true;
                    //System.out.println("Deleted: "+tmp.getValue());
                    break;
                }
                tmp = tmp.getNextNode();
            }
        	if(!nodeDeleted) 
        		System.out.println("Unable to find the given element... " + element);
        }
    }
    
    public void deleteAtPosition(int position) {
    	SingleNode<T> tmp = head;
    	int count = count(head);
    	if(position <= 0 || position > count) {
    		System.out.println("can't delete a node at " + position 
    				+ " as the position is not available in Linked List of size " 
    				+ count);
    		return;
    	} else if(position == 1) {
    		head = head.getNextNode();
    	} else {
    		count = 1;
    		// Extra safe check (tmp.getNextNode() != null ) 
    		// can be ignored also in most case it will be true
    		while(tmp.getNextNode() != null && position - 1 > count) {
    			count++;
    			tmp = tmp.getNextNode();
    		}
    		//System.out.println("Deleted: "+tmp.getNextNode().getValue() + " at position " + ++count);
    		tmp.setNextNode(tmp.getNextNode().getNextNode());
    	}    	
    }
     
    public void print() { 
    	SingleNode<T> tmp = head;
        while(tmp != null) {
            System.out.print(tmp.getValue() + "  " );
            tmp = tmp.getNextNode();
        }
        System.out.println("\n");
    }
    
    //Recursive print
    public void print(SingleNode<T> node) {
    	if(node != null)
    		System.out.print(node.getValue() + " ");
    	else
    		return;
    	print(node.getNextNode());
    }
    
  //Recursive print
    public void printReverse(SingleNode<T> node) {
    	if(node.getNextNode() != null)
    		printReverse(node.getNextNode());
    	System.out.print(node.getValue() + " ");
    }
    
    public int count() {
    	SingleNode<T> tmp = head;
    	int count=0;
    	while(tmp != null) {
    		++count;
    		tmp = tmp.getNextNode();
    	}
    	return count;
    }
    
    // Recursive Program
    public int count(SingleNode<T> node) {
    	if (node == null)
    		return 0;
    	return 1 + count(node.getNextNode());
    }
     
    public static void main(String a[]){
        SingleLinkedList<Integer> sl = new SingleLinkedList<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(99);
        sl.add(65);
        sl.addAfterNode(76, 54);
        sl.addAfterNode(9, 3);
        sl.addAtPosition(20, 3);
        System.out.println("count: " +  sl.count());
        sl.print(sl.head);
        System.out.println(" ");
        sl.printReverse(sl.head);
        System.out.println(" ");
        sl.deleteHead();
        sl.print();
        sl.deleteAfter(76);
        sl.delete(99);
        sl.print();
        sl.deleteAtPosition(1);
        sl.print();
        sl.delete(23);
        sl.print();
         
    }
}
