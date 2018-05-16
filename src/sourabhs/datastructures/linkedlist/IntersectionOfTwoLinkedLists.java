package sourabhs.datastructures.linkedlist;

public class IntersectionOfTwoLinkedLists {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		
		ListNode a = headA;
		ListNode b = headB;
		// If Both Intersects, then meeting point will be intersection node after second iteration
		// If Both doesn't intersects,  both will meet at tail of each list which is null
		while(a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
	
	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		nodeA.next = new ListNode(2);
		nodeA.next.next = new ListNode(3);
		nodeA.next.next.next = new ListNode(4);
		nodeA.next.next.next.next = new ListNode(5);
		nodeA.next.next.next.next.next = new ListNode(6);
		
		ListNode nodeB = new ListNode(0);
		nodeB.next = new ListNode(1);
		nodeB.next.next = new ListNode(2);
		nodeB.next.next.next = nodeA.next.next;
		
		ListNode res = getIntersectionNode(nodeA, nodeB);
		System.out.println(res.val);
		
		res = getIntersectionNode(nodeA, new ListNode(0).next = new ListNode(1));
		System.out.println(res == null);
	}
}
