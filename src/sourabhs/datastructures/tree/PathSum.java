package sourabhs.datastructures.tree;

public class PathSum {

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		else if(sum-root.val == 0 && root.left == null && root.right == null) return true;
		else return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);

		boolean res = hasPathSum(root, 22);
		System.out.println(res);

		res = hasPathSum(root, 18);
		System.out.println(res);

	}

}
