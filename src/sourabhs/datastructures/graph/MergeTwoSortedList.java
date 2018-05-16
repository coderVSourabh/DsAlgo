package sourabhs.datastructures.graph;

public class MergeTwoSortedList {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode merger;
		if(l1.val < l2.val) {
			merger = l1;
			merger.next = mergeTwoLists(l1.next, l2);
		} else {
			merger = l2;
			merger.next = mergeTwoLists(l1, l2.next);
		}
		return merger;
	 }

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(3);
		a.next.next = new ListNode(4);
		
		ListNode b = new ListNode(0);
		b.next = new ListNode(2);
		b.next.next = new ListNode(4);
		
		ListNode res = mergeTwoLists(a, b);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}