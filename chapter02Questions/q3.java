package chapter02Questions;

/**
 * 
 * @author maxti
 *
 *Implement an algorithm to delete a node in 
 *the middle of a singly linked list, given only access to that node.
 */


public class q3 {
	
	public static void main (String[] args) {
		LinkedList test = new LinkedList();
		
		test.insertAtHead(1);
		test.insertAtHead(2);
		test.insertAtHead(3);
		test.insertAtHead(4);
		test.insertAtHead(5);
		test.insertAtHead(6);
		
		System.out.println(test.toString());
		
		test.deleteSpecificNode(test.findEntry(test.head, 3));
		
		System.out.println(test.toString());
	}
	
	private static class LinkedList{
		Entry head;
		
		void insertAtHead(int value) {
			Entry newEntry = new Entry(value);
			
			if (head == null) {
				this.head = newEntry;
			}
			else {
				newEntry.setNext(this.head);
				this.head = newEntry;
			}
		}
		
		Entry findEntry (Entry x, int value) {
			if (x == null) {
				System.out.println("Value not found!");
				return null;
			}
			
			if(x.getValue() == value) {
				System.out.println("Value " + value + " found!");
				return x;
			}
			
			return findEntry(x.getNext(), value);
		}
		
		void deleteSpecificNode(Entry x) {
			x.setValue(x.getNext().getValue());
			x.setNext(x.getNext().getNext());
		}
		
		@Override
		public String toString() {
			
	
			String output = "[";
			Entry x = this.head;
			while (x.getNext()!= null) {
				output += x.getValue() + ", ";
				x = x.getNext();
			}
			
			output += x.getValue() + "]";
			
			return output;			
		}
	}
	
	private static class Entry{
		int value;
		Entry next;
		
		Entry(int value){
			this.value = value;
		}
		
		private void setNext(Entry newEntry){
			this.next = newEntry;
		}
		
		private Entry getNext() {
			return next;
		}
		
		private void setValue(int value) {
			this.value = value;
		}
		
		private int getValue() {
			return value;
		}
		
	}
	

}
