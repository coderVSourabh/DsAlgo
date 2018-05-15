package vsourabh.datastructures.math;

import vsourabh.datastructures.node.SingleNode;

/**
 * @author Sourabh
 * 
 * LeetCode:
 * You are given two non-empty linked lists 
 * representing two non-negative integers. 
 * The digits are stored in reverse order 
 * and each of their nodes contain a single 
 * digit. Add the two numbers and return it 
 * as a linked list.
 * 
 * You may assume the two numbers do not contain
 * any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

	public SingleNode<Integer> addTwoNumbers(SingleNode<Integer> l1, SingleNode<Integer> l2) {
		SingleNode<Integer> c1 = l1;
		SingleNode<Integer> c2 = l2;
		SingleNode<Integer> sentinel = new SingleNode<>(0);
		SingleNode<Integer> d = sentinel;
		Integer sum = 0;
		while (c1 != null || c2 != null) {
			sum /= 10;
			if (c1 != null) {
				sum = sum + c1.getValue();
				c1 = c1.getNextNode();
			}
			if (c2 != null) {
				sum += c2.getValue();
				c2 = c2.getNextNode();
			}
			d.setNextNode(new SingleNode<>(sum % 10));
			d = d.getNextNode();
		}
		if (sum / 10 == 1)
			d.setNextNode(new SingleNode<>(1));
		return sentinel.getNextNode();
	}

	public static void main(String[] args) {
		AddTwoNumbers obj = new AddTwoNumbers();
		SingleNode<Integer> l1 = new SingleNode<>(2);
		SingleNode<Integer> l1a = new SingleNode<>(4);
		SingleNode<Integer> l1b = new SingleNode<>(3);
		l1.setNextNode(l1a);
		l1a.setNextNode(l1b);

		SingleNode<Integer> l2 = new SingleNode<>(5);
		SingleNode<Integer> l2a = new SingleNode<>(6);
		SingleNode<Integer> l2b = new SingleNode<>(4);
		l2.setNextNode(l2a);
		l2a.setNextNode(l2b);

		SingleNode<Integer> result = obj.addTwoNumbers(l1, l2);
		while(result != null) {
			System.out.print(result.getValue() + " ");
			result = result.getNextNode();
		}
	}
}
