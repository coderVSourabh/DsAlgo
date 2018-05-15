package vsourabh.datastructures.linkedlist;

public class DeleteNodeInLinkedList {

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		
		print(head);
		deleteNode(head.next.next);
		print(head);
	}
	
	static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println("\n");
	}
}
