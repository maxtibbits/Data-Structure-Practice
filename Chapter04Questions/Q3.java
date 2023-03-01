package Chapter04Questions;
import java.util.*;


/**
 * @author maxti
 *
 * Given a binary tree, design an algorithm which creates a linked list 
 * of all the nodes at each depth (e.g. if you have a tree with depth D, 
 * you'll have D linked lists).
 * 
 * (This algo sets leaf nodes to have a height of 1)
 */

public class Q3 {
	
	public static void main (String[] args) {
		BinaryTree test = new BinaryTree();
		
		test.insert(5);
		test.insert(3);
		test.insert(7);
		test.insert(1);
		test.insert(4);
		test.insert(6);
		
		System.out.println(test.toString());
				
		System.out.println(test.head.getHeight());
		
		//test.llDepths();
		
		@SuppressWarnings("unused")
		ArrayList<LinkedList<Chapter04Questions.Q3.BinaryTree.Node>> list = test.llDepths(test.head);
		
		
		
		
	}

	private static class BinaryTree{
		Node head;
		
		private void insert(int input) {
			Node newNode = new Node(input);
			if (head == null) {
				this.head = newNode;
				return;
			}
			else {
				head.insert(newNode);
			}
		}
		
		private ArrayList<LinkedList<Node>> llDepths(Node x) {
			ArrayList<LinkedList<Node>> output = new ArrayList<LinkedList<Node>>();
			
			
			LinkedList<Node> current = new LinkedList<Node>();
			
			if (x != null) {
				current.add(x);
			}
			
			while (current.size() > 0) {
				output.add(current);
				LinkedList<Node> parents = current;
				
				current = new LinkedList<Node>();
				for (Node parent : parents) {
					if (parent.left != null) {
						current.add(parent.left);
					}
					if (parent.right != null) {
						current.add(parent.right);
					}
				}
			}
			
			return output;
		}
		
		@Override
		public String toString() {
			String output =  "";
			Node tmp = this.head;
			
			while (tmp != null) {
				
				output += getValueOfChildren(this.head.getLeft());
				output += this.head.getValue();
				output += getValueOfChildren(this.head.getRight());
				
				tmp = null;
			}
			
			
			return output;
		}
		
	
		
		private String getValueOfChildren(Node x) {
			if (x == null) {
				return "";
			}
			
			
			String output = getValueOfChildren(x.getLeft());
			output += "" + x.getValue();
			output += getValueOfChildren(x.getRight());
			
			
			return output;
		}
		
		private static class Node{
			int value;
			Node left = null;
			Node right = null;
			int height;
			
			Node(int value){
				this.value = value;
			}
			
			private int getValue() {
				return this.value;
			}
			
			private int getHeight() {
				int leftHeight;
				int rightHeight;
				
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

				if (leftHeight >= rightHeight) {
					this.height = leftHeight+1;
				}
				else {
					this.height = rightHeight+1;					
				}
				
				return this.height;
									
			}
			
			
			
			private void insert(Node input) {
				if (this.value >= input.getValue()) {
					if (this.left != null) {
						this.left.insert(input);
					}
					else {
						this.left = input;
					}
				}
				else {
					if (this.right != null) {
						this.right.insert(input);
					}
					else {
						this.right = input;
					}
				}
			}
			
			private Node getLeft() {
				return this.left;
			}
			
			private Node getRight() {
				return this.right;
			}
		}
	}
}
