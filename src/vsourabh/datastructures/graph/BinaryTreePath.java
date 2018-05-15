package vsourabh.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

import sourabhs.datastructures.tree.TreeNode;

public class BinaryTreePath {

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if(root != null) searchPaths(root, "", res);
		return res;
	}

	private static void searchPaths(TreeNode root, String path, List<String> res) {
		if(root.left == null && root.right == null) res.add(path);
		if(root.left != null) searchPaths(root.left, path + root.val + "->", res);
		if(root.right != null) searchPaths(root.right, path + root.val + "->", res);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		List<String> res = binaryTreePaths(root);
		
		res.forEach(s -> System.out.print(s + " "));
	}

}
