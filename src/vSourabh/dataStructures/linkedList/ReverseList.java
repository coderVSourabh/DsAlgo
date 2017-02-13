package vSourabh.dataStructures.linkedList;

import vSourabh.dataStructures.node.DoubleNode;
import vSourabh.dataStructures.node.SingleNode;

/**
 * @author Sourabh
 *
 */
public class ReverseList<T> {

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	// Adding elements at head
	public  SingleNode<T> reverseSingleLinkedList(SingleNode<T> headNode) {
		
		if(headNode == null)
			return headNode;
		
		SingleNode<T> tmpNode = headNode;
		SingleNode<T> reverseList = new SingleNode<T>();
		reverseList.setValue(tmpNode.getValue());
		tmpNode = tmpNode.getNextNode();
		while(tmpNode != null) {
			SingleNode<T> tmp = new SingleNode<T>();
			tmp.setValue(tmpNode.getValue());
			tmp.setNextNode(reverseList);
			reverseList = tmp;
			tmpNode = tmpNode.getNextNode();
		}
		return reverseList;
	}
	

	public  SingleNode<T> reverseCircularLinkedList(SingleNode<T> headNode) {
		
		if(headNode == null)
			return headNode;
		
		SingleNode<T> tmpNode = headNode;
		SingleNode<T> reverseList = new SingleNode<T>();
		
		reverseList.setValue(tmpNode.getValue());
		tmpNode = tmpNode.getNextNode();
		SingleNode<T> tail = reverseList;
		while(tmpNode != headNode) {
			SingleNode<T> tmp = new SingleNode<T>();
			tmp.setValue(tmpNode.getValue());
			tmp.setNextNode(reverseList);
			reverseList = tmp;
			tail.setNextNode(reverseList);
			tmpNode = tmpNode.getNextNode();
		}
		return reverseList;
	}
	
	public DoubleNode<T> reverseDoubleLinkedList(DoubleNode<T> headNode) {
		if(headNode == null)
			return headNode;
		
		// reverse by Adding node at starting
		DoubleNode<T> reverseList = new DoubleNode<T>(headNode.getValue());
		DoubleNode<T> tmpNode = headNode.getNextNode();
		
		while(tmpNode != null) {
			DoubleNode<T> tmp = new DoubleNode<T>(tmpNode.getValue());
			tmp.setNextNode(reverseList);
			reverseList.setPrvNode(tmp);
			reverseList = tmp;
			tmpNode = tmpNode.getNextNode();
		}	
		return reverseList;
	}

	public DoubleNode<T>  reverseBySwappingDoubleLinkedList(DoubleNode<T> headNode) {
		if(headNode == null)
			return headNode;
		
		//Reverse by swapping nodes after Head node		
		DoubleNode<T> reverseList = headNode;
		
		do {
			DoubleNode<T> tmp = new DoubleNode<T>(reverseList.getNextNode().getValue());
			reverseList.setNextNode(reverseList.getNextNode().getNextNode());	
			if(reverseList.getNextNode() != null)
				reverseList.getNextNode().setPrvNode(reverseList); 
			tmp.setNextNode(headNode);
			headNode.setPrvNode(tmp);
			tmp.setPrvNode(null);
			headNode = tmp;			
		} while(reverseList.getNextNode() != null);
		/* Java is pass by Value hence original node is not reversed,
		 *  But since we passed the reference object and did operation it
		 *  Hence the headNode is pointing to head with no node after it i.e. tail of reverse
		*/
		return headNode;
	}

	public static void main(String[] args) {
		
		System.out.println("----Singly Linked List----");
		SingleLinkedList<Double> sL = new SingleLinkedList<Double>();
		sL.add(0.11);
		sL.add(0.12);
		sL.add(0.13);
		sL.add(0.14);
		sL.add(0.15);
		sL.add(0.16);
		sL.add(0.17);
		sL.add(0.18);
		sL.add(0.19);
		sL.add(0.20);
		sL.print();
		System.out.print("Reverse Single :: ");
		SingleLinkedList<Double> sLL = new SingleLinkedList<Double>(); 
		ReverseList<Double> reverseList = new ReverseList<Double>();
		sLL.head = reverseList.reverseSingleLinkedList(sL.head);
		sLL.print();
		
		System.out.println("----DOUBLE LINKED LIST----");
		DoubleLinkedList<Double> dL = new DoubleLinkedList<Double>();
		dL.add(0.21);
		dL.add(0.22);
		dL.add(0.23);
		dL.add(0.24);
		dL.add(0.25);
		dL.add(0.26);
		dL.add(0.27);
		dL.add(0.28);
		dL.add(0.29);
		dL.add(0.30);
		dL.print();
		DoubleLinkedList<Double> dLL = new DoubleLinkedList<>();
		System.out.print("Reverse Double :: ");
		dLL.head = reverseList.reverseDoubleLinkedList(dL.head);
		dLL.print();
		
		System.out.println("----DOUBLE LINKED LIST 2----");
		DoubleLinkedList2<Double> dL2 = new DoubleLinkedList2<Double>();
		dL2.add(0.31);
		dL2.add(0.32);
		dL2.add(0.33);
		dL2.add(0.34);
		dL2.add(0.35);
		dL2.add(0.36);
		dL2.add(0.37);
		dL2.add(0.38);
		dL2.add(0.39);
		dL2.add(0.40);
		dL2.print();
		DoubleLinkedList<Double> dLL2 = new DoubleLinkedList<>();
		System.out.print("Reverse Double 2 :: ");
		dLL2.head = reverseList.reverseBySwappingDoubleLinkedList(dL2.head);
		dLL2.print();
		
		System.out.println("----CIRCULAR LINKED LIST----");
		CircularLinkedList<Double> cL = new CircularLinkedList<Double>();
		cL.add(0.41);
		cL.add(0.42);
		cL.add(0.43);
		cL.add(0.44);
		cL.add(0.45);
		cL.add(0.46);
		cL.add(0.47);
		cL.add(0.48);
		cL.add(0.49);
		cL.add(0.50);
		cL.print();
		CircularLinkedList<Double> cLL = new CircularLinkedList<Double>();
		System.out.print("Reverse Circular :: ");
		cLL.head = reverseList.reverseCircularLinkedList(cL.head);
		cLL.print();


	}

}
