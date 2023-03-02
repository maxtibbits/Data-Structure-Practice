package Chapter04Questions;

/**
 * @author maxti
 * 
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, 
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node 
 * never differ by more than one.
 * 
 * Developer's Note: I believe I coded this in a previous question, but I decided to make sure I remembered it.
 * 
 * This is not the most efficient answer, but it does solve the problem!
 * 
 */
public class Q4 {

	public static void main(String[] args) {
	
		//creating non balanced tree
		BinaryTree test1 = new BinaryTree();
		
		System.out.println(test1.checkBalance());
		
		test1.insert(5);
		test1.insert(4);
		test1.insert(3);
		test1.insert(2);
		test1.insert(1);
		
		System.out.println(test1.checkBalance());
		
		//creating balanced tree
		BinaryTree test2 = new BinaryTree();
		
		test2.insert(5);
		test2.insert(3);
		test2.insert(2);
		test2.insert(4);
		test2.insert(7);
		test2.insert(6);

		
		
		System.out.println(test2.checkBalance());
	
	}
	
	private static class BinaryTree{
		
		Node head;
		
		private void insert(int value) {
			Node newNode = new Node(value);
			if (this.head == null) {
				this.head = newNode;
				return;
			}
			else {
				this.head.insert(newNode);
			}
		}
		
		private boolean checkBalance() {
			if (this.head == null) {
				System.out.println("Binary Tree not initialized!");
				return true;
			}
			
			boolean output = false;
			this.head.getHeight();
			
			output = this.head.checkBalance();
			
			return output;
			
		}
		
		private static class Node{
			int value;
			Node right;
			Node left;
			int height;
			
			private boolean checkBalance() {
				if (this.getLeft() != null && this.getRight() != null) {
					if (Math.abs(this.getLeft().returnHeight() - this.getRight().returnHeight()) > 1) {
						return false;
					}
					else {
						if (this.getLeft().checkBalance() == true && this.getRight().checkBalance() == true) {
							return true;
						}
					}
					
				}
				if (this.getRight() == null && this.getLeft() == null) {
					return true;
				}
				
				if (this.getRight() == null && this.getLeft().returnHeight() > 1) {
					return false;
				}
				else if (this.getLeft() == null && this.getRight().returnHeight() > 1) {
					return false;
				}
				else {
					return true;
				}
				
			}
			
			private int getHeight() {
				int rightHeight;
				int leftHeight;
				int height = 0;
				
				if (this.left != null) {
					leftHeight = this.left.getHeight();
				}
				else {
					leftHeight = 0;
				}
				if (this.right != null) {
					rightHeight = this.right.getHeight();
				}
				else {
					rightHeight = 0;
				}
				if (rightHeight >= leftHeight) {
					height = rightHeight + 1;
				}
				else{
					height = leftHeight + 1;
				}
				
				this.setHeight(height);
				
				return height;
			}
			
			private void setHeight(int input) {
				this.height = input;
			}
			
			private int returnHeight() {
				return this.height;
			}
			
			private void insert(Node newNode) {
				if (newNode.getValue() <= this.getValue()) {
					if (this.left == null) {
						this.setLeft(newNode);
					}
					else {
						this.getLeft().insert(newNode);
					}
				}
				else {
					if (this.right == null) {
						this.setRight(newNode);
					}
					else {
						this.getRight().insert(newNode);
					}
				}
			}
			
			public Node getRight() {
				return right;
			}

			public void setRight(Node right) {
				this.right = right;
			}

			public Node getLeft() {
				return left;
			}

			public void setLeft(Node left) {
				this.left = left;
			}

			public int getValue() {
				return value;
			}

			Node(int value){
				this.value = value;
			}
		}
	}
}
