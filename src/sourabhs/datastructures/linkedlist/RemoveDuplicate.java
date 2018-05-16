package sourabhs.datastructures.linkedlist;

import sourabhs.datastructures.node.DoubleNode;
import sourabhs.datastructures.node.SingleNode;

/**
 * @author Sourabh
 *
 */
public class RemoveDuplicate<T> {

	public void removeDuplicateInUnsortedSingleList(SingleNode<T> head) {
		while(head != null) {
			SingleNode<T> innerNode = head;
			while(innerNode != null && innerNode.getNextNode() != null) {
				if(head.getValue().toString().equalsIgnoreCase(innerNode.getNextNode().getValue().toString())){
					innerNode.setNextNode(innerNode.getNextNode().getNextNode());
				} else
					innerNode = innerNode.getNextNode();
			}
			head = head.getNextNode();
		}
	}
	
	public void removeDuplicateInUnsortedDoubleList(DoubleNode<T> head) {
		while(head != null) {
			DoubleNode<T> innerNode = head;
			while(innerNode != null && innerNode.getNextNode() != null) {
				if(head.getValue().toString().equalsIgnoreCase(innerNode.getNextNode().getValue().toString())){
					innerNode.setNextNode(innerNode.getNextNode().getNextNode());
				} else
					innerNode = innerNode.getNextNode();
			}
			head = head.getNextNode();
		}
	}

	public void removeDuplicateInUnsortedCircularList(SingleNode<T> head) {
		if (head == null || head.getNextNode() == null)
			return;
		SingleNode<T> tmp = head;
		do {
			SingleNode<T> innerNode = tmp;
			while(innerNode.getNextNode() != head) {
				if(tmp.getValue().toString().equalsIgnoreCase(innerNode.getNextNode().getValue().toString())) {
					innerNode.setNextNode(innerNode.getNextNode().getNextNode());
				} else
					innerNode = innerNode.getNextNode();
			}
			tmp = tmp.getNextNode();
		} while(tmp.getNextNode() != head);
	}

	//TODO : Not Conpleted
	public void removeDuplicateInSortedList() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("----Singly Linked List----");
		SingleLinkedList<Double> sL = new SingleLinkedList<Double>();
		sL.add(0.11);
		sL.add(0.11);
		sL.add(0.11);
		sL.add(0.13);
		sL.add(0.11);
		sL.add(0.15);
		sL.add(0.11);
		sL.add(0.13);
		sL.add(0.11);
		sL.add(0.15);
		sL.add(0.11);
		sL.print();
		RemoveDuplicate<Double> rD = new RemoveDuplicate<Double>();
		rD.removeDuplicateInUnsortedSingleList(sL.head);
		sL.print();
		
		System.out.println("----CIRCULAR LINKED LIST----");
		CircularLinkedList<Character> cL = new CircularLinkedList<Character>();
		cL.add('a');
		cL.add('a');
		cL.add('a');
		cL.add('a');
		cL.add('b');
		cL.add('c');
		cL.add('d');
		cL.add('e');
		cL.add('d');
		cL.add('b');
		cL.add('c');
		cL.print();
		RemoveDuplicate<Character> rDCL = new RemoveDuplicate<Character>();
		rDCL.removeDuplicateInUnsortedCircularList(cL.head);
		cL.print();
		
		System.out.println("----Double Linked List----");
		DoubleLinkedList<Integer> dL = new DoubleLinkedList<Integer>();
		dL.add(1);
		dL.add(1);
		dL.add(1);
		dL.add(2);
		dL.add(2);
		dL.add(3);
		dL.add(2);
		dL.add(1);
		dL.add(4);
		dL.add(4);
		dL.print();
		RemoveDuplicate<Integer> rDdL = new RemoveDuplicate<Integer>();
		rDdL.removeDuplicateInUnsortedDoubleList(dL.head);
		dL.print();
	}
}
