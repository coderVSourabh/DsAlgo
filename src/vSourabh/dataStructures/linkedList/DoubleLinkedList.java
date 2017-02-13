package vSourabh.dataStructures.linkedList;

import vSourabh.dataStructures.node.DoubleNode;

/**
 * @author Sourabh
 *
 */
public class DoubleLinkedList<T> {
	DoubleNode<T> head;
	
	public void add(T data) {
		DoubleNode<T> node = new DoubleNode<T>(data);
		if(head == null) {
			head = node;
		} else {
			DoubleNode<T> tmp = head;
			while(tmp.getNextNode() != null)
				tmp = tmp.getNextNode();
			tmp.setNextNode(node);
			node.setPrvNode(tmp);
		}
	}
	
	public void addAtPosition(T data, int position) {
		int count = this.count();
		DoubleNode<T> node = new DoubleNode<T>(data);
		if (position <= 0 || position > count+1 ) {
			System.out.println("Adding element is not possible in " + position + " for a List of Size " + count);
			return;
		} else if (position == 1) {
			node.setNextNode(head);
			head.setPrvNode(node);
			head = node;
		} else {
			DoubleNode<T> tmp = head;
			count = 0;
			while(tmp.getNextNode() != null && count < position - 2) {
				++count;
				tmp = tmp.getNextNode();
			}
			if(tmp.getNextNode() != null)
				tmp.getNextNode().setPrvNode(node);
			node.setNextNode(tmp.getNextNode());
			node.setPrvNode(tmp);
			tmp.setNextNode(node);
		}
	}
	
	public void print(DoubleNode<T> node) {
		if(node != null) {
			System.out.print(node.getValue() + " ");
			print(node.getNextNode());
		}
	}
		
	public void print() {
		DoubleNode<T> node = head;
		while(node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getNextNode();
		}
		System.out.println("\n");
	}
	
	public void printReverse(DoubleNode<T> node) {
		if(node != null) {
			printReverse(node.getNextNode());
			System.out.print(node.getValue() + " ");
		}
	}
	
	public void printReverse() {
		DoubleNode<T> node = head;
		while(node.getNextNode() != null)
			node = node.getNextNode();
		while (node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getPrvNode();
		}
	}
	
	public int count() {
		DoubleNode<T> tmp = head;
		int count = 0;
		while(tmp != null) {
			count++;
			tmp = tmp.getNextNode();
		}
		return count;
	}
	
	public void delete(T value) {
		DoubleNode<T> tmp = head;
		while(tmp != null) {
			if(tmp.compareTo(value) == 0) {
				if(tmp.getPrvNode() == null) {
					deleteHead();
					break;
				} else {
					tmp.getPrvNode().setNextNode(tmp.getNextNode());
					if(tmp.getNextNode() != null)
						tmp.getNextNode().setPrvNode(tmp.getPrvNode());
					break;
				}
			}
			tmp = tmp.getNextNode();
		}
		if(tmp == null)
			System.out.println("Node with value : '" + value + "' not found in List");
	}
	
	public void deleteAtPosition(int position) {
		int count = this.count();
		if (position <= 0 || position > count) {
			System.out.println("Deleting element is not possible in " + position + " for a List of Size " + count);
			return;
		} else if (position == 1) {
			deleteHead();
		} else {
			DoubleNode<T> tmp = head;
			count = 0;
			while(tmp != null && count < position - 1) {
				++count;
				tmp = tmp.getNextNode();
			}
			tmp.getPrvNode().setNextNode(tmp.getNextNode());
			if(tmp.getNextNode() != null)
				tmp.getNextNode().setPrvNode(tmp.getPrvNode());
		}
	}
	
	public void deleteHead() {
		if (head != null) {
			head = head.getNextNode();
			head.setPrvNode(null);
		} else {
			System.out.println("UnderFlow Head...");
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Character> dl = new DoubleLinkedList<Character>();
		dl.add('b');
		dl.add('c');
		dl.addAtPosition('a', 1);
		dl.add('e');
		dl.addAtPosition('f', 5);
		dl.addAtPosition('d', 4);
		dl.printReverse(dl.head);
		System.out.println("\n count = " + dl.count() +  "\n" );
		dl.print();
		
		System.out.println("\n count = " + dl.count() +  "\n" );

		dl.deleteAtPosition(4);
		dl.print();
		
		dl.delete('f');
		dl.print();
		
	}

}
