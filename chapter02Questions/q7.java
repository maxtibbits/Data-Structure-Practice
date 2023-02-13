package chapter02Questions;


/**
 * @author maxti
 *
 *Given two (singly) linked lists, determine if the two lists intersect. Return the
 *intersecting node. Note that the intersection is defined based on reference, not value.
 *That is, if the kth node of the first linked list is the exact same node (by reference) 
 *as the jth node of the second linked list, then they are intersecting.
 */

public class q7 {

	public static void main(String[] args) {
		
		Node intersectingNode = null;
		
		LinkedList test1 = new LinkedList();
		test1.insert(9);
		test1.insert(9);
		test1.insert(9);
		test1.insert(3);
		test1.insert(2);
		test1.insert(2);
		test1.insert(1);
		
		LinkedList test2 = new LinkedList();
		
		test2.insert(5);
		test2.insert(2);
		test2.insert(3);
		test2.insert(2);
		test2.insert(2);
		test2.insert(1);
		
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		
		test1.testIntersection(test2);

		LinkedList test3 = new LinkedList();

		
		test3.insert(5);
		test3.insert(2);
		test3.insert(3);
		test3.insert(1);
		
		System.out.println("");
		
		System.out.println(test3.toString());
		System.out.println(test2.toString());
		
		intersectingNode = (test3.testIntersection(test2));
		
		System.out.println("Intersecting at node:" + intersectingNode.getValue());
		
	}
	
	
	private static class LinkedList{
		Node head;
		int length;
		
		//insert at head
		private void insert(int value) {
			Node newNode = new Node(value);
			
			if (this.head == null) {
				this.head = newNode;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
			}
			this.length++;
		}
		
		private Node testIntersection(LinkedList n2) {
			Node tmpNode;
			int diff = this.length - n2.length;
			
			//triggers if n1 length = n2 length
			if (this.length == n2.length) {
				System.out.println("Same Length");
				return testIntersection(this.head, n2.head);
			}
			else {
				//triggers if n1 is longer than n2
				if (diff > 0) {
					System.out.println("n1 is longer!");
					tmpNode = this.head;
					while (diff > 0) {
						tmpNode = tmpNode.getNext();
						diff--;
					}
					
					return testIntersection(tmpNode, n2.head);
				}

				//triggers if n2 is longer than n1
				if (diff < 0) {
					System.out.println("n2 is longer!");
					tmpNode = n2.head;
					while (diff < 0) {
						tmpNode = tmpNode.getNext();
						diff++;
					}
					
					return testIntersection(tmpNode, this.head);
				}

				return null;
			}
		}
		
		private Node testIntersection(Node n1, Node n2){

			Node tmp = null;
			if (n1.getNext() != null) {
				tmp = testIntersection(n1.getNext(), n2.getNext());
				
				if (n1.getValue() == n2.getValue() && tmp != null){
					System.out.println("Intersection Continued!");
					return n1;
				}
				
				if (n1.getValue() != n2.getValue() && tmp != null) {
					System.out.println("Intersection Discontinued!");
					return tmp;
				}
			}
			
			if(n1.getValue() == n2.getValue() && n1.getNext() == null && n2.getNext() == null) {
				System.out.println("Intersection found!");
				return n1;
			}
			
			if(n1.getValue() != n2.getValue() && n1.getNext() == null && n2.getNext() == null) {
				System.out.println("No intersection found!");
				return null;
			}
			//System.out.println("shouldn't get here");
			return tmp;
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
		private int value;
		private Node next;
		
		Node (int value){
			this.value = value;
		}
		
		private int getValue() {
			return value;
		}
		
//		private void setValue(int value) {
//			this.value = value;
//		}
//		
		private Node getNext() {
			return next;
		}
		
		private void setNext(Node input){
			this.next = input;
		}
		
	}
}
