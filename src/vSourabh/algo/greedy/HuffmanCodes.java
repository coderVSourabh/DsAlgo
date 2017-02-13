/**
 * 
 */
package vSourabh.algo.greedy;

import vSourabh.dataStructures.graph.BinaryMinHeap;
import vSourabh.dataStructures.graph.BinaryTree;
import vSourabh.dataStructures.node.BinaryTreeNode;

/**
 * @author Sourabh
 *
 * 		Standard Encoding will encode each character as
 * 	equal bits, hence will use more space to store everything
 * 		Prefix code will use less space based on 
 * maximum used character having less bit code.
 * example:   a = 50, b = 50, c = 5, d =5 total characters = 100
 *  			100
 *  		0	/\  1
 *  		   /  \
 *  		  50   a
 *  		  /\
 *  	0    /  \ 1
 *  		10   b
 *  		/\
 *  	0  /  \ 1
 *  	  c    d
 *  
 *  So encoding a = 1, b = 01, c = 000, d = 001;
 *  
 *  weighted external path length = 5*3 + 5*3 + 40*2 + 50*1 bits
 *  							for  d     c  	 b 		a
 *  
 *  same as Optimal Merge
 */
//TODO
public class HuffmanCodes {
	
	public void huffmanCodes(char[] arr, int[] freq) {
		BinaryTreeNode<Integer> root = huffmanEncode(freq);

		int[] codes = new int[new BinaryTree().height(root)];
		printCodes(root, 0, codes);
	}
	
	/**
	 * Time Complexity : O(nLog(n))
	 *   Because of Extract-Minimum for n-1 times 
	 * Space Complexity : O(n)
	 *   Because of creating the Heap 
	 */
	public BinaryTreeNode<Integer>  huffmanEncode(int[] freq) {
		BinaryMinHeap<BinaryTreeNode<Integer>> heap = new BinaryMinHeap<>();
		for (int i = 0; i < freq.length; i++) {
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(freq[i]);
			heap.add(freq[i], node);
		}

		while (heap.size() != 1) {
			BinaryTreeNode<Integer> l = heap.extractMin();
			BinaryTreeNode<Integer> r = heap.extractMin();
			int total = l.data + r.data;
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(total, l, r);
			heap.add(total, node);
		}
		return heap.extractMin();
	}
	
	public void printCodes(BinaryTreeNode<Integer> root, int level, int[] codes) {
		if (root == null)
			return;
		if (BinaryTree.isLeaf(root)) {
			System.out.print(root.data + " - ");
			for (int i = 0; i < level; i++) {
				System.out.print(codes[i]);
			}
			System.out.println();
		} else {
			if (root.left != null) {
				codes[level] = 0;
				printCodes(root.left, level + 1, codes);
			}
			if (root.right != null) {
				codes[level] = 1;
				printCodes(root.right, level + 1, codes);
			}
		}
	}

	
	
	
	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int freq[] = { 5, 9, 12, 13, 16, 45 };
		HuffmanCodes obj = new HuffmanCodes();
		obj.huffmanCodes(arr, freq);

	}

}
