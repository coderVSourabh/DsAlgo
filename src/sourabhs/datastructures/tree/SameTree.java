package sourabhs.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null || q == null) return p == q;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static boolean isSameTreeLoop(TreeNode p, TreeNode q) {

		if(p == null || q == null) return p == q;

		Queue<TreeNode> pq = new LinkedList<>();
		Queue<TreeNode> qq = new LinkedList<>();
		pq.offer(p);
		qq.offer(q);
		while(!pq.isEmpty() && !qq.isEmpty()) {

			if(pq.peek().val != qq.peek().val) return false;
			TreeNode temp1 = qq.poll();
			TreeNode temp2 = pq.poll();

			if(temp1.left  != null) pq.offer(temp1.left);
			if(temp2.left  != null) qq.offer(temp2.left);
			if(pq.size() != qq.size()) return false;

			if(temp1.right != null) pq.offer(temp1.right);
			if(temp2.right != null) qq.offer(temp2.right);
			if(pq.size() != qq.size()) return false;
		}
		return pq.size() == qq.size();
	}

	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(2);
		p.left.left = new TreeNode(3);
		p.right.left = new TreeNode(3);
		p.left.right = new TreeNode(3);
		p.right.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(2);
		q.left.left = new TreeNode(3);
		q.right.left = new TreeNode(3);
		q.left.right = new TreeNode(3);
		q.right.right = new TreeNode(3);
		
		System.out.println(isSameTreeLoop(p,q));
		System.out.println(isSameTree(p, q));
		
		p = new TreeNode(1);
		p.left = new TreeNode(2);
		
		q = new TreeNode(1);
		q.right = new TreeNode(2);
		System.out.println(isSameTreeLoop(p,q));
		System.out.println(isSameTree(p, q));
	}

}
