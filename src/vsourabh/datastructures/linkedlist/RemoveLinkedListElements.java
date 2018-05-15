package vsourabh.datastructures.linkedlist;

public class RemoveLinkedListElements {

	public static ListNode removeElements(ListNode head, int val) {

		while (head != null && head.val == val) head = head.next;

		ListNode node = head;

		while(node != null && node.next != null) {
			if(node.next.val == val) node.next = node.next.next;
			else node = node.next;
		}
		return head;
	}

	public static ListNode removeElementsRec(ListNode head, int val) {
		if(head == null) return null;
		head.next = removeElementsRec(head.next, val);
		return head.val == val ? head.next : head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(6);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(6);
		
		head = removeElements(head, 6);
		print(head);
		
		head = new ListNode(1);
		head.next = new ListNode(6);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(1);
		head.next.next.next.next.next = new ListNode(6);
		
		head = removeElementsRec(head, 6);
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
