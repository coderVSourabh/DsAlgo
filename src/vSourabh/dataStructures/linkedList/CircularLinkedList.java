package vsourabh.datastructures.linkedlist;

import vsourabh.datastructures.node.SingleNode;

/**
 * @author Sourabh
 *
 */
public class CircularLinkedList<T> {
	SingleNode<T> head;
	
	public void add(T data) {
		SingleNode<T> node = new SingleNode<T>();
		node.setNextNode(null);
		node.setValue(data);
		if(head == null) {
			head = node;
			head.setNextNode(head);
		} else {
			SingleNode<T> tmp = head;
			while(tmp.getNextNode() != head)
				tmp = tmp.getNextNode();
			tmp.setNextNode(node);
			node.setNextNode(head);
		}
	}
	
	public void addAtPosition(T data, int position) {
		int count = this.count();
		SingleNode<T> node = new SingleNode<T> ();
		node.setValue(data);
		if (position <= 0 || position > count+1 ) {
			System.out.println("Adding element is not possible in " 
		             + position + " for a List of Size " + count);
			return;
		} else if (position == 1) {
			if(count == 1)
				node.setNextNode(node);
			else {
				SingleNode<T> tmp = head.getNextNode();
				while(tmp.getNextNode() != head)
					tmp = tmp.getNextNode();
				tmp.setNextNode(node);
				node.setNextNode(head);
			}
			head = node;
				
		} else {
			SingleNode<T> tmp = head.getNextNode();
			count = 1;
			while(tmp.getNextNode() != null && count < position - 2) {
				++count;
				tmp = tmp.getNextNode();
			}
			node.setNextNode(tmp.getNextNode());
			tmp.setNextNode(node);
		}
	}
	
	public void print() {
		SingleNode<T> tmp = head;
		if(head != null) {
			System.out.print(head.getValue() + " ");
			tmp = head.getNextNode();
		}
		while(tmp != head) {
			System.out.print(tmp.getValue() + " ");
			tmp = tmp.getNextNode();
		}
		System.out.println("\n");
	}
	
	/*public void printReverse() {
		
	}*/
	
	public int count() {
		SingleNode<T> tmp = head;
		int count = 0;
		if(head != null) {
			++ count;
			tmp = head.getNextNode();
		}
		while(tmp != head) {
			++ count;
			tmp = tmp.getNextNode();
		}
		return count;
	}
	
	public void delete(T value) {
		SingleNode<T> tmp = head;
        boolean nodeDeleted = false;
        /** Traverse till the node to be deleted */
        if (head != null && head.compareTo(value) == 0) {
        	deleteHead();
        	nodeDeleted = true;
        } else {
        	tmp = head;
        	while(tmp.getNextNode() != head) {
                if(tmp.getNextNode().compareTo(value) == 0){
                    tmp.setNextNode(tmp.getNextNode().getNextNode());
                    nodeDeleted = true;
                    break;
                }
                tmp = tmp.getNextNode();
            }
        }
        if(!nodeDeleted) 
    		System.out.println("Unable to find the given element... " + value);
	}

	public void deleteAtPosition(int position) {
		int count = this.count();
		if (position <= 0 || position > count) {
			System.out.println("Deleting element is not possible in " + position + " for a List of Size " + count);
			return;
		} else if (position == 1) {
			deleteHead();
		} else {
			SingleNode<T> tmp = head;
			count = 1;
			while(tmp.getNextNode() != head && count < position - 1) {
				++count;
				tmp = tmp.getNextNode();
			}
			tmp.setNextNode(tmp.getNextNode().getNextNode());
		}
	
	}
	
	public void deleteHead() {
		if(head == null)
            System.out.println("Underflow...");
        else if(head.getNextNode() == head)
        	head = null;
        else {
        	SingleNode<T> node = head.getNextNode();
        	while (node.getNextNode() != head) {
        		node = node.getNextNode();
        	}
        	head = head.getNextNode();
        	node.setNextNode(head);
        }
	}
	
	public static void main(String[] args) {
		CircularLinkedList<Character> cL = new CircularLinkedList<Character>();
		cL.add('b');
		cL.print();
		cL.add('c');
		cL.print();
		cL.addAtPosition('a', 1);
		cL.print();
		cL.add('e');
		cL.print();
		cL.addAtPosition('f', 5);
		cL.addAtPosition('d', 4);
		cL.print();
		System.out.println("\n count = " + cL.count() +  "\n" );
		cL.print();
		
		System.out.println("\n count = " + cL.count() +  "\n" );

		cL.deleteAtPosition(6);
		cL.print();
		
		cL.delete('d');
		cL.print();

	}

}
