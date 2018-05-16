package sourabhs.datastructures.string;

import sourabhs.datastructures.tree.TreeNode;

public class MinimumDepthOfBinaryTree {

	public static int minDepth(TreeNode root) {
		if(root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1; 
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(1);
		int res = minDepth(root);
		System.out.println(res);
	}

}
