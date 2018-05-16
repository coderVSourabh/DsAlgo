package sourabhs.datastructures.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

	public static TreeNode invertTreeDFS(TreeNode root) {
		if(root == null) return null;
		TreeNode left = root.left, right = root.right;
		root.left = invertTreeDFS(right);
		root.right = invertTreeDFS(left);
		return root;
	}

	public static TreeNode invertTreeDfsLoop(TreeNode root) {
		if(root == null) return null;
		Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();	
        	TreeNode left = node.left;
        	node.left = node.right;
        	node.right = left;
        	
        	if(node.left != null)
        		stack.push(node.left);
        	if(node.right != null)
        		stack.push(node.right);
        }
        return root;
	}
	// Level order traversal O(n)
	public static TreeNode invertTreeBfs(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();	
        	TreeNode left = node.left;
        	node.left = node.right;
        	node.right = left;
        	
        	if(node.left != null)
        		queue.offer(node.left);
        	if(node.right != null)
        		queue.offer(node.right);
        }
        return root;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(12);
		root.right = new TreeNode(24);
		root.left.left = new TreeNode(14);
		root.left.right = new TreeNode(16);
		root.right.left = new TreeNode(26);
		root.right.right = new TreeNode(28);
		
		root = invertTreeDFS(root);
		print(root);
		System.out.println();
		
		root = invertTreeDfsLoop(root);
		print(root);
		System.out.println();
		
		root = invertTreeBfs(root);
		print(root);
		System.out.println();
	}
	
	private static void print(TreeNode root) {
		if(root == null) return;
		System.out.print(root.val + " ");
		
		print(root.left);		
		print(root.right);
	}
}
