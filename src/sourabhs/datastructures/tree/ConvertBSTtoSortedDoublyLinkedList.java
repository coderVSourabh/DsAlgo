package sourabhs.datastructures.tree;

public class ConvertBSTtoSortedDoublyLinkedList {

  TreeNode prev = null;
  public TreeNode treeToDoublyList(TreeNode node) {
    if(node == null) return null;
    TreeNode dummy = new TreeNode(0);
    prev = dummy;
    helper(node);
    // connect head and tail
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy.right;
  }

  private void helper(TreeNode cur) {
    if(cur == null) return;
    helper(cur.left);
    prev.right = cur;
    cur.left = prev;
    prev = cur;
    helper(cur.right);
  }

  public TreeNode treeToDoublyListDFS(TreeNode head) {
    if(head == null) return null;

    TreeNode left = treeToDoublyListDFS(head.left);
    TreeNode right = treeToDoublyListDFS(head.right);
    head.left = head;
    head.right = head;
    return connect(connect(left, head), right);
  }

  private TreeNode connect(TreeNode nodeA, TreeNode nodeB) {
    if(nodeA == null) return nodeB;
    if(nodeB == null) return nodeA;
    TreeNode tailA = nodeA.left;
    TreeNode tailB = nodeB.left;

    tailA.right = nodeB;
    nodeB.left = tailA;
    tailB.right = nodeA;
    nodeA.left = tailB;

    return nodeA;
  }

  public static void main(String[] args) {
    ConvertBSTtoSortedDoublyLinkedList obj = new ConvertBSTtoSortedDoublyLinkedList();
    TreeNode head = new TreeNode(4);
    head.left = new TreeNode(2);
    head.right = new TreeNode(5);
    head.left.left = new TreeNode(1);
    head.left.right = new TreeNode(3);
    TreeNode res = obj.treeToDoublyList(head);
    obj.print(res);
    System.out.println("=====================");
    head = new TreeNode(4);
    head.left = new TreeNode(2);
    head.right = new TreeNode(5);
    head.left.left = new TreeNode(1);
    head.left.right = new TreeNode(3);
    res = obj.treeToDoublyListDFS(head);
    obj.print(res);
    System.out.println("=====================");
  }

  public void print(TreeNode node) {
    TreeNode res = node;
    while(res.right.val != node.val) {
      System.out.print(res.val + " -> ");
      res = res.right;
    }
    System.out.print(res.val + "\n");
  }
}
