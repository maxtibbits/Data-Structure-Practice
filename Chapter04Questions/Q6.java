package Chapter04Questions;

/**
 * @author maxti
 * Write an algorithm to find the "next" node (i.e., in-order successor) 
 * of a given node in a binary search tree. You may assume that each node 
 * has a link to its parent.
 * 
 * *Needs to be tested*
 */

public class Q6 {

	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("unused")
	private Node findInOrder(Node x) {
		
		
		if (x == null) {
			return null;
		}
		
		if (x.right == null) {
			if (x.parent.left == x) {
				return x.parent;
			}
			else {
				Node tmp = x;
				while (tmp != tmp.parent.left) {
					if (tmp.parent == null) {
						return x;
					}
					tmp = tmp.parent;
				}
				
				return tmp.parent;
				
			}
		}
		else {
			if (x.right.left == null) {
				return x.right;
			}
			else {
				Node tmp = x.right;
				while (tmp.left != null) {
					tmp = tmp.left;
				}
				return tmp;
			}
			
		}
		
	}
	
	private static class Node{
		Node parent;
		Node left;
		Node right;
	}
}
