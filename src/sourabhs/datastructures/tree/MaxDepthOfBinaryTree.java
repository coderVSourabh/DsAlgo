package sourabhs.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
	}

	// Depth First Search
	public static int maxDepthLoopDFS(TreeNode root) {
		if(root == null) return 0;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(max, temp);
			if(node.left != null) {
				stack.push(node.left);
				value.push(temp+1);
			}
			if(node.right != null) {
				stack.push(node.right);
				value.push(temp+1);
			}
		}
		return max;
	}

	// Breadth First Search
	public static int maxDepthLoopBFS(TreeNode root) {
		if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int count = 0;
		while(! queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			count++;
		}
		return count;
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
		root.right.right.left.left = new TreeNode(5);
		root.right.right.left.left.right = new TreeNode(6);
		
		System.out.println(maxDepth(root));
		System.out.println(maxDepthLoopBFS(root));
		System.out.println(maxDepthLoopDFS(root));
	}

}
