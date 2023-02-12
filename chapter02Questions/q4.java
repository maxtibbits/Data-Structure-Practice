package chapter02Questions;

/**
 *
 * @author maxti
 *
 *Write code to partition a linked list around a value x, such that all nodes less
 *than x come before all nodes greater than or equal to x. If x is contained within
 *the list, the values of x only need to be after the elements less than x (see below).
 *The partition element x can appear anywhere in the "right partition"; it does not
 *need to appear between the left and right partitions.
 *
 *There are several ways to solve this obviously, the simplest, in my opinion is just 
 *passing through the linked list twice.
 *
 * Could also be done by keeping track of the tail of the smaller partition, but I'm
 * not sure if that would be allowed in an interview. I am solving it this way for now
 * since that shows that I can modify the data structures to suit my needs.
 *
 */

public class q4 {
	public static void main (String[] args) {
		
		LinkedList test = new LinkedList();
		
		for (int i = 0; i < 12; i++) {
			test.insert(i);
		}
		
		for (int i = 3; i < 26; i++) {
			test.insert(i);
		}
		
		for (int i = 0; i < 12; i++) {
			test.insert(i);
		}
		
		System.out.println(test.toString());
		
		//SETS THE PARTITION
		int n = 6;
		
		LinkedList sortLL = test.partitionSort(n);
		System.out.println("Partition is "+ n);
		System.out.println(sortLL.toString());
		
	}
	
	private static class LinkedList{
		Node head;
		Node tail;
		
		//Insertion At Head
		private void insert(int value) {
			Node newNode = new Node(value);
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
				return;
			}
			else {
				newNode.next = this.head;
				this.head = newNode;
			}
				
		}
		
//		private void insertNodeAtTail(LinkedList x, LinkedList y) {
//			x.tail.setNext(y.head);
//		}
		
		//this is sorting it with the partition so I renamed it as such.
		
		private LinkedList partitionSort(int x) {
			Node current = this.head;
			LinkedList output = new LinkedList();
			LinkedList tmp = new LinkedList();
			int y;
			
		
			while (current != null) {
				y = current.getValue();
				if (y >= x) {
					tmp.insert(y);
				}
				if (y < x) {
					output.insert(y);
				}
				current = current.getNext();
			}
			
			
			System.out.println("Output head:" + output.head.getValue() + " Output tail:"
			+ output.tail.getValue());
			
			System.out.println(tmp.toString());
			System.out.println(output.head.getValue() + output.tail.getValue());
			
			
			output.tail.setNext(tmp.head);
			output.tail = tmp.tail;
			
			System.out.println("Output head:" + output.head.getValue() + " Output tail:"
			+ output.tail.getValue());
			
			return output;
			
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
