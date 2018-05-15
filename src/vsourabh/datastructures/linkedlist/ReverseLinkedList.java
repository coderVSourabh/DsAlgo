package vsourabh.datastructures.linkedlist;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while(head!= null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	public static ListNode reverseListRec(ListNode head) {
		return reverseHelper(head, null);
	}
	private static ListNode reverseHelper(ListNode head, ListNode newHead) {
		if(head == null) return null;
		ListNode next = head.next;
		head.next= newHead;
		reverseHelper(next, head);
		return newHead;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(6);
		print(head);
		
		head = reverseList(head);
		print(head);
		
		head = reverseListRec(head);
		print(head);
	}
	
	public static void print(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("\n");
			
	}
}
