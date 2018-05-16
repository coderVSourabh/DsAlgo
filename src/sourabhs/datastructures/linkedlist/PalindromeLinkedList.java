package sourabhs.datastructures.linkedlist;

public class PalindromeLinkedList {

	public static boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast != null) // ODD Nodes
			slow = slow.next;
		
		slow = reverse(slow);
		fast = head;
		while(slow != null) {
			if(fast.val != slow.val)
				return false;
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}
	
	private static ListNode reverse(ListNode node) {
		ListNode prev = null;
		while(node != null) {
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(1);
		
		boolean res = isPalindrome(head);
		System.out.println(res);
		
		head = new ListNode(1);
		head.next = new ListNode(1);
		
		res = isPalindrome(head);
		System.out.println(res);
		
		head = new ListNode(1);
		head.next = new ListNode(3);
		
		res = isPalindrome(head);
		System.out.println(res);

	}

}
