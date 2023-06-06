package Chapter04Questions;

/**
 * 
 * @author maxti
 *
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. 
 * 
 * NOTE: This is not necessarily a binary search tree.
 * 
 */

public class Q8 {

	Node head;
	
	public Node starterFunction(Node x, Node y) {
		if (!found(head, x) || !found(head, y)) {
			System.out.println("Error! At least one node is not in the tree!");
			return null;
		}
		return firstCommonAncestor(head, x, y);
	}
	
	public Node firstCommonAncestor(Node head, Node x, Node y) {
		if (head == null || head == x || head == y) {
			return head;
		}
		
		boolean xFoundOnLeft = found(head.left, x);
		boolean yFoundOnLeft = found(head.left, y);
		
		if (xFoundOnLeft != yFoundOnLeft) {
			return head;
		}
		
		Node nextNode = xFoundOnLeft ? head.left : head.right;
		return firstCommonAncestor (nextNode, x, y);
		
	}
	
	boolean found (Node head, Node x) {
		if (head == null) {
			return false;
		}
		if (head == x) {
			return true;
		}
		return found(head.left, x) || found (head.right, x);
		
	}
	
	private static class Node{
		Node left;
		Node right;
	}
}
