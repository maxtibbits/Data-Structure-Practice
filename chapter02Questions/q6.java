package chapter02Questions;

/**
 * 
 * @author maxti
 * Implement a function to check if a linked list is a palindrome.
 * 
 * This solution is more time intensive. Can also be solved recursively if the length of the
 * LinkedList is known. This information was not specified in the question prompt. You can find
 * the length of a LinkedList by using a while loop easily. I might implement a recursive way
 * to do this algorithm at a later date.
 */

public class q6 {

	public static void main (String[] args) {
		
		LinkedList test1 = new LinkedList();
		test1.insert('c');
		test1.insert('s');
		test1.insert('a');
		test1.insert('s');
		test1.insert('c');
		
		LinkedList test2 = new LinkedList();
		test2.insert('c');
		test2.insert('d');
		test2.insert('a');
		test2.insert('s');
		test2.insert('c');

		//a palindrome
		System.out.println(test1.toString());

		//not a palindrome
		System.out.println(test2.toString());
		
		System.out.println("Is " + test1.toString() + " a palindrome? " + test1.checkLLPalindrome());
		System.out.println("Is " + test2.toString() + " a palindrome? " + test2.checkLLPalindrome());
		
	}
	
	private static class LinkedList{
		Node head;
		
		//insert at head
		private void insert(char value) {
			Node newNode = new Node(value);
			
			if (this.head == null) {
				this.head = newNode;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
			}
		}
		
		private boolean checkLLPalindrome() {
			boolean isPalindrome = true;
			LinkedList tmp = new LinkedList();
			Node tmpNode = this.head;
			Node nNode = this.head;
			
			while(tmpNode != null) {
				tmp.insert(tmpNode.getValue());
				tmpNode = tmpNode.getNext();
			}
			
			//System.out.println(tmp.toString());
			
			//compare tmp to n
			tmpNode = tmp.head;
			
			while (tmpNode != null && nNode != null) {
				if(tmpNode.getValue() != nNode.getValue()) {
					isPalindrome = false;
					break;
				}
				tmpNode = tmpNode.getNext();
				nNode = nNode.getNext();
			}
			
			return isPalindrome;
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
		private char value;
		private Node next;
		
		Node (char value){
			this.value = value;
		}
		
		private char getValue() {
			return value;
		}
		
		private Node getNext() {
			return next;
		}
		
		private void setNext(Node input){
			this.next = input;
		}
		
		
		
		
	}
}
