package vsourabh.datastructures.graph;

import java.util.Deque;
import java.util.LinkedList;

import vsourabh.datastructures.node.BinaryTreeNode;

/**
 * @author Sourabh
 *
 */
public class BinaryTree {
	
	private BinaryTreeNode<Integer> root;
	
	public void insert(int data) {
		
		if (null == root) {
			root = new BinaryTreeNode<Integer>(data);
			return;
		}
		
		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		BinaryTreeNode<Integer> temp = root;
		queue.addLast(temp);
		while (!queue.isEmpty()) {
			temp = queue.removeFirst();
			if (temp.left == null) {
				temp.left = new BinaryTreeNode<Integer>(data);
				return;
			} else {
				queue.addLast(temp.left);
			}

			if (temp.right == null) {
				temp.right = new BinaryTreeNode<Integer>(data);
				return;
			} else {
				queue.addLast(temp.right);
			}
		}
	}

	BinaryTreeNode<Integer> delete(BinaryTreeNode<Integer> node) {
		if (null == node) {
			return node;
		}
		node.left = delete(node.left);
		node.right = delete(node.right);
		node = null;
		return node;
	}

	public static void inOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}
	
	public static void preOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void postOrder(BinaryTreeNode<Integer> node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public void levelOrder(BinaryTreeNode<Integer> node) {
		if (null == node) {
			System.out.println("Empty");
			return;
		}
		
		Deque<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.removeFirst();
			System.out.print(cur.data + " ");

			if (cur.left != null) {
				queue.addLast(cur.left);
			}
			if (cur.right != null) {
				queue.addLast(cur.right);
			}
		}
		System.out.println();
	}

	public static int size(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}
	
	public int height(BinaryTreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static boolean isLeaf(BinaryTreeNode<Integer> root) {
		return root.left == null && root.right == null;
	}

	public static boolean isFullNode(BinaryTreeNode<Integer> root) {
		return root.left != null && root.right != null;
	}

	public static boolean isHalfNode(BinaryTreeNode<Integer> root) {
		return (root.left != null && root.right == null) || (root.left == null && root.right != null);
	}
	
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		obj.insert(4);
		obj.insert(5);
		obj.insert(6);
		obj.insert(7);
		obj.levelOrder(obj.root);
		obj.root = obj.delete(obj.root);
		obj.levelOrder(obj.root);
		
		BinaryTree.preOrder(obj.root);

	}

}
