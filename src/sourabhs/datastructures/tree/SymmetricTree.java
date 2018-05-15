package sourabhs.datastructures.tree;

import java.util.Stack;

public class SymmetricTree {

	/*
	 // Common Mistake will check only left and right of parent node not whole tree
	 public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		else if(root.left == null || root.right == null) return root.left == root.right;
		else return root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right);
	}*/
	
	public static boolean isSymmetricRec(TreeNode root) {
		return root == null || isSymmetricRecUtil(root.left, root.right);
	}
	private static boolean isSymmetricRecUtil(TreeNode l, TreeNode r) {
		if(l == null || r == null) return l == r;
		return l.val == r.val && isSymmetricRecUtil(l.left, r.right) && isSymmetricRecUtil(l.left, r.right);
	}
	
	public static boolean isSymmetricLoop(TreeNode root) {
		if(root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode left, right;
		if(root.left != null) {
			if(root.right == null) return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if(root.right != null) {
			return false;
		}
		
		while(!stack.isEmpty()) {
			if(stack.size()%2 != 0) return false;
			left = stack.pop();
			right = stack.pop();
			if(left.val != right.val) return false;
			
			if(left.left != null) {
				if(right.right == null) return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if(right.right != null) {
				return false;
			}
			
			if(left.right != null) {
				if(right.left == null) return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if(right.left != null) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		root.right.right = new TreeNode(3);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(4);
		
		System.out.println(isSymmetricLoop(root));
		System.out.println(isSymmetricRec(root));
	}

}
