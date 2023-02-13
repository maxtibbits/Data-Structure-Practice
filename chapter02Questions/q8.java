package chapter02Questions;


/**
 * @author maxti
 *
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 * 
 * I made this a boolean so that way it wouldn't return null if there is no loop.
 * I can easily modify this to return a node, but I wanted to ensure I implemented
 * a circular linkedlist properly.
 */
public class q8 {

	public static void main(String[] args) {
		LinkedList test = new LinkedList();	
		
		int loops = 20; //used to make test2 with x loops to ensure algorithm 
						//distinguishes between memory and value
		
		for (int i = 10; i > 0; i-- ) {
			test.insert(i);
		}
		
		System.out.println(test.toString());
		if (test.findLoop() == false) {
			System.out.println("Loop not found!");
		}
		
		
		LinkedList test2 = new LinkedList();
		int x = 0;
		
		while (x <= loops) {
			for (int i = 10; i > 4; i--) {
				test2.insert(i);
			}
			x++;
		}
		for (int i = 10; i > 0; i-- ) {
			test2.insert(i);
		}
		
		System.out.println(test2.toString());
		if (test2.findLoop() == false) {
			System.out.println("Loop not found! Algorithm differentiates between memory/value!");
		}		
		
		System.out.println("");
		System.out.println(test.toString());
		
		test.createLoop();
		
		System.out.println(test.toString());
	
		if (test.findLoop() == true) {
			System.out.println("Loop found");
		}

	}
	
	private static class LinkedList{
		Node head;
		Node tail; 							//only used to create loop
		int length;							//used to display loop
		
		//insert at head
		private void insert(int value) {
			Node newNode = new Node(value);
			
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
			}
			
			length++;
		}
		
		private void createLoop() {
			this.tail.setNext(this.head.getNext().getNext().getNext().getNext());
		}

		private boolean findLoop() {
			boolean isLoop = false;
			Node tmpNode = this.head;
			Node tmpNode2 = this.head;
			
			//System.out.println("Commence!");
			
			while (tmpNode != null && tmpNode2 != null && isLoop == false) {
				tmpNode = tmpNode.getNext();
				if (tmpNode2.getNext() != null) {
					tmpNode2 = tmpNode2.getNext();
				}
				else {
					break;
				}
				if (tmpNode2.getNext() != null) {
					tmpNode2 = tmpNode2.getNext();
				}
				else {
					break;
				}
				//System.out.println(tmpNode.getValue() + " " + tmpNode2.getValue());

				if(tmpNode == tmpNode2) {
					System.out.println("Collision at: " + tmpNode.getValue() + " " + tmpNode2.getValue());
					isLoop = true;
				}				
			}
			if (isLoop == false) {
				return isLoop;
			}
			
			System.out.println("HENNLO");
			tmpNode = this.head;
			
			while (tmpNode != tmpNode2) {
				tmpNode = tmpNode.getNext();
				tmpNode2 = tmpNode2.getNext();
			}
			
			System.out.println("Loop starts at " + tmpNode2.getValue());
			
			return isLoop;
		}		
		
		@Override
		public String toString() {
			String output = "[";
			Node x = this.head;
			while (x.getNext()!= null) {
				output += x.getValue() + ", ";
				x = x.getNext();
				if (output.length() > this.length*30) {
					
					break;
				}
			}
			
			output += x.getValue() + "]";
			
			return output;			
		}
	}
	
	private static class Node{
		private int value;
		private Node next;
		
		Node (int value){
			this.value = value;
		}
		
		private int getValue() {
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
