package sourabhs.datastructures.tree;

import java.util.*;

/**
 * Time Complexity: O(N) where N is number of nodes
 * Space Complexity: O(N) due to recursion
 */
public class SerializeAndDeserializeBinaryTree {

  private final String EMPTY_NODE = "#";
  public String serialize(TreeNode node) {
    List<String> list = new ArrayList<>();
    serializeHelper(node, list);
    return String.join(",", list);
  }

  private void serializeHelper(TreeNode node, List<String> list) {
    if(node == null) {
      list.add(EMPTY_NODE);
      return;
    }
    list.add(String.valueOf(node.val));
    serializeHelper(node.left, list);
    serializeHelper(node.right, list);
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();
    if(val.equals(EMPTY_NODE)) return null;

    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = deserializeHelper(queue);
    root.right = deserializeHelper(queue);
    return root;
  }

  public static void main(String[] args) {
    SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    String serialized = obj.serialize(root);
    System.out.println(serialized);
    TreeNode deserialzed = obj.deserialize(serialized);
    obj.print(deserialzed);
    System.out.println("=====================");
    root = new TreeNode(21);
    root.left = new TreeNode(32);
    root.right = new TreeNode(54);
    root.left.left = new TreeNode(43);
    root.right.right = new TreeNode(65);
    serialized = obj.serialize(root);
    System.out.println(serialized);
    deserialzed = obj.deserialize(serialized);
    obj.print(deserialzed);
    System.out.println("=====================");
    root = new TreeNode(45);
    root.left = new TreeNode(56);
    root.right = new TreeNode(68);
    serialized = obj.serialize(root);
    System.out.println(serialized);
    deserialzed = obj.deserialize(serialized);
    obj.print(deserialzed);
  }
  public void print(TreeNode node) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(node);
    while(!q.isEmpty()) {
      TreeNode temp = q.poll();
      System.out.print(temp.val + " ");
      if(temp.left != null) q.offer(temp.left);
      if(temp.right != null) q.offer(temp.right);
    }
    System.out.print("\n");
  }
}
