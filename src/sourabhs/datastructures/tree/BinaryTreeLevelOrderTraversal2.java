package sourabhs.datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

	//DFS O(n)
	public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null) return res;
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			int level = queue.size();
			List<Integer> list = new LinkedList<>();
			for(int i =0; i<level; i++) {
				if(queue.peek().left != null)  queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				list.add(queue.poll().val);
			}
			res.add(0, list);
		}
		return res;
	}
	
	//BFS or level order O(n)
	public static List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        levelMakerUtil(res, root, 0);
        return res;
    }
	
	private static void levelMakerUtil(List<List<Integer>> res, TreeNode root, int level)  {
		if(root == null) return;
		if(level >= res.size())
			res.add(0, new LinkedList<>());
		levelMakerUtil(res, root.left, level+1);
		levelMakerUtil(res, root.right, level+1);
		res.get(res.size() - level - 1).add(root.val);
	}

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		List<List<Integer>> res = levelOrderBottomDFS(tree);
		res.forEach( list -> {
			System.out.print("[ ");
			list.forEach( num -> System.out.print(num + " "));
			System.out.println("]");
		});
		
		
		res = levelOrderBottomDFS(tree);
		res.forEach( list -> {
			System.out.print("[ ");
			list.forEach( num -> System.out.print(num + " "));
			System.out.println("]");
		});
	}

}
