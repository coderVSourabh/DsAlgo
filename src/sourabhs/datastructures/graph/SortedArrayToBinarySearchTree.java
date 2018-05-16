package sourabhs.datastructures.graph;

import sourabhs.datastructures.tree.TreeNode;

public class SortedArrayToBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] a) {
		if(a == null || a.length == 0) return null;
		return helper(a, 0, a.length -1);
	}
	
	private static TreeNode helper(int[] a, int low, int high) {
		if(low > high) return null;
		int mid = low + (high-low)/2;
		TreeNode node = new TreeNode(a[mid]);
		node.left = helper(a, low, mid -1);
		node.right = helper(a, mid + 1, high);
		return node;
	}

	public static void main(String[] args) {
		TreeNode root = SortedArrayToBinarySearchTree.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
		printTree(root);
	}
	 public static void printTree(TreeNode root) {
		 System.out.print(root.val + " ");
		 if(root.left != null)
			 printTree(root.left);
		 if(root.right != null)
			 printTree(root.right);
	 }

}
