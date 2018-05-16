package sourabhs.datastructures.linkedlist;

import sourabhs.datastructures.node.SingleNode;

/**
 * @author Sourabh
 *
 */
public class EvenOddNodesCheck {
	public static void main (String args[]) {
		SingleLinkedList<Character> s2 = new SingleLinkedList<Character>();

        System.out.println("isEven : " +EvenOddNodesCheck.isEven(s2.head));
        s2.add('a');
        s2.add('b');
        s2.add('d');
        s2.add('e');
        s2.add('f');
        s2.addAfterNode('c', 'b');
        s2.deleteAtPosition(1);
        s2.print();
        
        System.out.println("isEven : " +EvenOddNodesCheck.isEven(s2.head));
		
	}
	
	public static boolean isEven(SingleNode<?> node) {
		while(node != null && node.getNextNode() != null) {
			node = node.getNextNode().getNextNode();
		}
		
		if(node == null)
			return true;
		else 
			return false;
	}

}
