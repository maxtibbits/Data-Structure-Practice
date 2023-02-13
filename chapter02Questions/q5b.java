package chapter02Questions;

/**
 * 
 * @author maxti
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * This should be reviewed X_X. No idea how I got this right haha.
 */

public class q5b {
	
	public static void main(String[] args) {
		LinkedList n1 = new LinkedList();
		
		//Create 617
		
		n1.insert(7);
		n1.insert(1);
		n1.insert(7);

		n1.insert(7);

		n1.insert(7);

		n1.insert(9);

		
		//create 295
		LinkedList n2 = new LinkedList();
		n2.insert(5);
		n2.insert(9);

		n2.insert(9);
		n2.insert(9);
		n2.insert(9);

		n2.insert(9);
		
		System.out.println(n1.toString());
		System.out.println(n2.toString());
		
		LinkedList n3 = new LinkedList();
		n3.additionReverse(n1, n2);
		System.out.println(n3.toString());
	
	}
	
	private static class LinkedList{
		Node head;
		int length;
	//	Node tail;
		
		//Insertion At Head
		private void insert(int value) {
			Node newNode = new Node(value);
			if (this.head == null) {
				this.head = newNode;
				this.length++;
				//this.tail = newNode;
				return;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
				this.length++;
			}
		}
		
		private Node reverseInsert(Node node) {
			if(node.next == null) {
				this.insert(node.getValue());
			}else {
				reverseInsert(node.getNext());
				this.insert(node.getValue());
			}
			return node;
		}
		
		private void additionReverse(LinkedList n1, LinkedList n2) {
			int diff = 0;
			LinkedList tmp = new LinkedList();
			

			//Ensures both linkedlists have the same length!
			if (n1.length > n2.length) {
				diff = n1.length-n2.length;
				tmp.reverseInsert(n2.head);
	
				while(diff != 0 ) {
					tmp.insert(0);
					diff--;
				}
				
				n2 = tmp;
			}
			
			if (n2.length > n1.length) {
				diff = n2.length-n1.length;
				tmp.reverseInsert(n1.head);
				
				while(diff != 0 ) {
					tmp.insert(0);
					diff--;
				}	
				n1 = tmp;
			}
			
			if (n1.length == n1.length) {		
				this.insert(sumReverse(n1.head, n2.head));
			}
		}
		
		public int sumReverse (Node n1, Node n2) {
			int sum = n1.getValue() + n2.getValue();
			int output;
			
			if (n1.next != null) {
				sum += sumReverse(n1.getNext(),n2.getNext());
			}
			if (sum >= 10) {
				output = sum%10;
			}
			else {
				output = sum;
			}
		
			System.out.println(sum);
			this.insert(output);
			
			return (sum-sum%10)/10;
			
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
