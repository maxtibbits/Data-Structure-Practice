package chapter02Questions;


/**
 * 
 * @author maxti
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 */

public class q5 {
	
	public static void main(String[] args) {
		LinkedList n1 = new LinkedList();
		
		//Create 913
		
		n1.insert(9);
		n1.insert(9);
		n1.insert(9);
		
		//create 9999999
		LinkedList n2 = new LinkedList();
		n2.insert(9);
		n2.insert(9);
		n2.insert(9);
		n2.insert(9);
		n2.insert(9);
		n2.insert(9);
		n2.insert(9);
		
		System.out.println(n1.toString());
		System.out.println(n2.toString());
		
		LinkedList n3 = new LinkedList();
		n3.addition(n1.head, n2.head);
		System.out.println(n3.toString());
	
	}
	
	private static class LinkedList{
		Node head;
	//	Node tail;
		
		//Insertion At Head
		private void insert(int value) {
			Node newNode = new Node(value);
			if (this.head == null) {
				this.head = newNode;
				//this.tail = newNode;
				return;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
			}
			System.out.println(value + " inserted!");	
		}
		
		private void addition(Node n1, Node n2) {
			boolean stored10 = false;
			int sum = n1.getValue() + n2.getValue();
			int stored10value = 0;
			
			if (sum >= 10) {
				stored10value = (sum - sum%10)/10;
				sum = sum%10;
				stored10 = true;
			}

			if (n1.getNext() != null && n2.getNext() != null) {
				addition(n1.getNext(), n2.getNext(), stored10, stored10value);
				this.insert(sum);
			}
			
			if (n1.getNext() == null && n2.getNext() != null) {
				addition(n2.getNext(), stored10, stored10value);
				this.insert(sum);
			}
		
			if (n1.getNext() != null && n2.getNext() == null) {
				addition(n1.getNext(), stored10, stored10value);
				this.insert(sum);
			}
			
			if (n1.getNext() == null && n2.getNext() == null && stored10 == true) {
				this.insert(stored10value);
				this.insert(sum);
			}
			
			System.out.println("The sum for this recursion is:" + sum);			

		}
		
		private void addition(Node n1, Node n2, boolean stored10, int stored10value) {
			int sum = n1.getValue() + n2.getValue();
			if(stored10 == true) {
				sum += stored10value;
				stored10 = false;
				stored10value = 0;
			}
			
			if (sum >= 10) {
				stored10value = (sum - sum%10)/10;
				sum = sum%10;
				stored10 = true;
			}
			
			
			System.out.println("The sum for this recursion is:" + sum);			
			
			if (n1.getNext() != null && n2.getNext() != null) {
				addition(n1.getNext(), n2.getNext(), stored10, stored10value);
			}
			
			if (n1.getNext() == null && n2.getNext() != null) {
				addition(n2.getNext(), stored10, stored10value);
			}
		
			if (n1.getNext() != null && n2.getNext() == null) {
				addition(n1.getNext(), stored10, stored10value);
			}
			
			if (n1.getNext() == null && n2.getNext() == null && stored10 == true) {
				this.insert(stored10value);
			
			}
			
			this.insert(sum);
			
		}
		
		private void addition(Node n, boolean stored10, int stored10value) {
			int sum = n.getValue();
			if (stored10 == true) {
				sum += stored10value;
				stored10 = false;
				stored10value = 0;
			}
			if (sum >= 10) {
				stored10value = (sum - sum%10)/10;
				sum = sum%10;
				stored10 = true;
			}
			if(n.getNext() != null) {
				addition(n.getNext(),stored10,stored10value);
			}
			
			if(n.getNext() == null && stored10 == true) {
				this.insert(stored10value);
			}
			
			this.insert(sum);
		}
		
		@Override
		public String toString() {
			String output = "[";
			Node x = this.head;
			while (x.getNext()!= null) {
				output += x.getValue() + ", ";
				x = x.getNext();
			}
			
			output += x.getValue() + "]";
			
			return output;			
		}
	}
	
	private static class Node{
		int value;
		Node next;
		
		Node(int value){
			this.value = value;
		}
		
		private int getValue() {
			return value;
		}
		
//		private void setValue(int value) {
//			this.value = value;
//		}
		
		private Node getNext() {
			return next;
		}
		
		private void setNext(Node next) {
			this.next = next;
		}
		
	}
	
}
