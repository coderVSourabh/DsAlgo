package vsourabh.datastructures.linkedlist;

import vsourabh.datastructures.node.DoubleNode;

public class DoubleLinkedList2<T> {
	DoubleNode<T> head;
	DoubleNode<T> tail;

	public void add(T data) {
		DoubleNode<T> node = new DoubleNode<T>(data);
		if(head == null) {
			head = tail = node;
		} else if(head.getNextNode() == null) {
			head.setNextNode(node);
			node.setPrvNode(head);
			tail = node;
		} else {
			tail.setNextNode(node);
			node.setPrvNode(tail);
			tail = node;
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
		} else if (position == count+1) {
			tail.setNextNode(node);
			node.setPrvNode(tail);
			tail = node;
		} else {
			DoubleNode<T> tmp = head;
			count = 0;
			while(tmp.getNextNode() != null && count < position - 2) {
				++count;
				tmp = tmp.getNextNode();
			}
			node.setNextNode(tmp.getNextNode());
			node.setPrvNode(tmp);
			node.getNextNode().setPrvNode(node);
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
	
	public void printReverse() {
		DoubleNode<T> node = tail;
		while(node != null) {
			System.out.print(node.getValue() + " ");
			node = node.getPrvNode();
		}
		System.out.println("\n");
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
				} else if (tmp.getNextNode() == null) {
					deleteTail();
					break;
				} else {
					tmp.getNextNode().setPrvNode(tmp.getPrvNode());
					tmp.getPrvNode().setNextNode(tmp.getNextNode());
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
		} else if (position == count) {
			deleteTail();
		} else {
			DoubleNode<T> tmp = head;
			count = 0;
			while(tmp.getNextNode() != null && count < position - 1) {
				++count;
				tmp = tmp.getNextNode();
			}
			tmp.getPrvNode().setNextNode(tmp.getNextNode());
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
	
	public void deleteTail() {
		if (tail != null) {
			tail = tail.getPrvNode();
			tail.setNextNode(null);
		} else {
			System.out.println("UnderFlow Tail...");
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList2<Character> dl = new DoubleLinkedList2<Character>();
		dl.add('b');
		dl.add('c');
		dl.addAtPosition('a', 1);
		dl.add('e');
		dl.addAtPosition('f', 5);
		dl.addAtPosition('d', 4);
		dl.printReverse();
		System.out.println("\n count = " + dl.count() +  "\n" );
		dl.print(dl.head);
		
		System.out.println("\n count = " + dl.count() +  "\n" );

		dl.deleteAtPosition(4);
		dl.print();
		
		dl.delete('f');
		dl.print();
	}

}
