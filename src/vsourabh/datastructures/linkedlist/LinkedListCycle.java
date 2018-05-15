package vsourabh.datastructures.linkedlist;

public class LinkedListCycle {
	public static boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode slowWalker = head;
		ListNode fastRunner = head;
		
		while(fastRunner.next != null && fastRunner.next.next != null) {
			slowWalker = slowWalker.next;
			fastRunner = fastRunner.next.next;
			if(slowWalker == fastRunner) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		ListNode newNode = new ListNode(3);
		node.next.next.next = newNode;
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next = newNode;
		
		boolean res = hasCycle(node);
		System.out.println(res);
		
		newNode = new ListNode(3);
		newNode.next = new ListNode(4);
		newNode.next.next = new ListNode(5);
		newNode.next.next.next = newNode;
		
		res = hasCycle(newNode);
		System.out.println(res);
		
		
		newNode = new ListNode(3);
		newNode.next = new ListNode(4);
		newNode.next.next = new ListNode(5);
		
		res = hasCycle(newNode);
		System.out.println(res);
		
	}
}
