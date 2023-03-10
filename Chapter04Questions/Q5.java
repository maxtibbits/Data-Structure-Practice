package Chapter04Questions;

/**
 * @author maxti
 *
 * Implement a function to check if a binary tree is a binary search tree.
 * 
 * Requirements:
 * 	1. Balanced
 * 	2. All nodes to the right are bigger, nodes to left are smaller
 * 	3. No duplicate entries
 * 	4. All subtrees are also binary search trees
 * 
 * 	****Work in progress****
 */
public class Q5 {

	public static void main(String[] args) {
	
		
	}
	
	
	@SuppressWarnings("unused")
	private class BinaryTree{
	
		Node head;
		
		private void insert(int input) {
			Node newNode = new Node(input);
			if (this.head == null) {
				this.head = newNode;
				return;
			}
			else {
				this.head.insert(newNode);
			}
			
		}
		
		private boolean checkBST(Node x) {
			return checkBST(x, null, null);
		}
		
		private boolean checkBST(Node x, Integer min, Integer max) {
			if (x == null) {
				return true;
			}
			if((min != null && x.getValue() <= min) || (max != null && x.getValue() > max)) {
				return false;
			}
			
			if (!checkBST(x.getLeft(), min, x.getValue()) || !checkBST(x.getRight(), x.getValue(), max)) {
				return false;
			}
			
			return true;
		}
		
		private class Node{
			int value;
			Node left, right;
			
			private Node(int input) {
				this.value = input;
			}
			
			private void insert(Node x) {
				if (x.getValue() <= this.getValue()) {
					if (this.getLeft() == null) {
						this.setLeft(x);
					}
					else {
						this.getLeft().insert(x);
					}
				}
				else {
					if (this.getRight() == null) {
						this.setRight(x);
					}
					else {
						this.getRight().insert(x);
					}
				}
			}
						
			public Node getLeft() {
				return left;
			}
			public void setLeft(Node left) {
				this.left = left;
			}
			public Node getRight() {
				return right;
			}
			public void setRight(Node right) {
				this.right = right;
			}
			public int getValue() {
				return value;
			}
		}
	}
}
