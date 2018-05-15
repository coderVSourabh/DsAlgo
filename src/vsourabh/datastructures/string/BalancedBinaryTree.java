package vsourabh.datastructures.string;

import sourabhs.datastructures.tree.TreeNode;

public class BalancedBinaryTree {

	
	
	public static boolean isBalanced(TreeNode root) {
		return dfsHeight(root) != -1;
	}
	// O(N)
	private static int dfsHeight(TreeNode node) {
		if(node == null) return 0;
		int leftHeight = dfsHeight(node.left);
		if(leftHeight == -1) return -1;
		int rightHeight = dfsHeight(node.right);
		if(rightHeight == -1) return -1;
		
		if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		else return Math.max(leftHeight, rightHeight) + 1;
	}
	
	// O(N^2)
	public static boolean isBalancedBFS(TreeNode root) {
		if(root == null) return true;
		
		int left = depth(root.left);
		int right = depth(root.right);
		return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private static int depth(TreeNode node) {
		if(node == null) return 0;
		return Math.max(depth(node.left), depth(node.right)) + 1;
	}
	
	public static void main(String[] args) {
		

	}

}
