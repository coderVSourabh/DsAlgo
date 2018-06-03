package sourabhs.datastructures.tree;

public class ClosestBinarySearchTreeValue {

	public static int closestValue(TreeNode root, double target) {
		int l = root.val, r = root.val;
		TreeNode curr = root;
		while(curr != null) {
			if(curr.val < target) {
				l = curr.val;
				curr = curr.right;
			} else {
				r = curr.val;
				curr = curr.left;
			}
		}
		return Math.abs(target - l) < Math.abs(r - target) ? l : r;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		int res = closestValue(root, 4.66D);
		System.out.println(res);
	}

}
