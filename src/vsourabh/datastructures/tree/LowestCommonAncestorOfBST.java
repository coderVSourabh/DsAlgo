package vsourabh.datastructures.tree;

public class LowestCommonAncestorOfBST {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val){
			return lowestCommonAncestor(root.left, p, q);
		}else if(root.val < p.val && root.val < q.val){
			return lowestCommonAncestor(root.right, p, q);
		}else{
			return root;
		}
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

		TreeNode res = lowestCommonAncestor(root, root.left, root.right);
		System.out.println(res.val);

		res = lowestCommonAncestor2(root, root.left, root.right);
		System.out.println(res.val);
		
		res = lowestCommonAncestor(root, root.left.right, root.left);
		System.out.println(res.val);

		res = lowestCommonAncestor2(root, root.left.right, root.left);
		System.out.println(res.val);

		res = lowestCommonAncestor(root, root.right.right, root.right.left);
		System.out.println(res.val);
		
		res = lowestCommonAncestor(root, root.right.right, root.right.left);
		System.out.println(res.val);
	}
}
