package chapter02Questions;


/**
 * 
 * @author maxti
 *
 * Write code to remove duplicates from an unsorted linked list.
 *
 * Follow up: How would you solve this problem if a temporary buffer is not allowed?
 * 
 * I solved this by focusing on the follow up prompt in order to practice recursion.
 * It runs in O(n^2) but is requires 0(1) memory allocation. Using hashing probably results
 * in O(n) runtime, but I used hashing a lot in the previous chapter.
 */

public class q1 {
	
	public static void main(String[] args) {
		
		LinkedList test = new LinkedList();
		
		test.insertAtHead(5);
		test.insertAtHead(6);
		test.insertAtHead(7);
		test.insertAtHead(6);
		test.insertAtHead(5);
		test.insertAtHead(5);
		test.insertAtHead(5);

		System.out.println(test.toString());
		System.out.println(test.length);
		
		test.removeDupValues(test.head, test.head.getValue());

		System.out.println(test.toString());
		System.out.println(test.length);
		
		test.insertAtHead(5);
		test.insertAtHead(7);
		test.insertAtHead(8);
		test.insertAtHead(9);
		test.insertAtHead(8);
		
		System.out.println(test.toString());
		System.out.println(test.length);
		
		test.removeDupValues(test.head, test.head.getValue());
		
		System.out.println(test.toString());
		System.out.println(test.length);
		
	}
	
	public static class LinkedList{
		Entry head;
		int length = 0;
		
		LinkedList(){
			this.head = null;
		}
		
		public void insertAtHead(Integer value) {
			Entry newEntry = new Entry(value);
			this.length++;
			
			if (this.head == null) {
				this.head = newEntry;
			}
			
			else {
				newEntry.setNext(this.head);
				this.head = newEntry;
			}
			
		}

		public void removeDupValues(Entry entry, Integer value) {
			if (entry.getNext() == null) {
				return;
			}
			
			if(value == entry.getNext().getValue()) {
				entry.setNext(entry.getNext().getNext());
				this.length--;
				removeDupValues(entry, value);
			}
			else {
				removeDupValues(entry.getNext(), value);
			}
			
			if (entry.getNext() != null) {
				removeDupValues(entry.getNext(), entry.getNext().getValue());
			}
			
		}
		
		@Override
		public String toString() {
			String result = "{";
			Entry current = this.head;

			while (current != null) {
				if(current.getNext() == null) {
					result += current.getValue();
					break;
				}
				else {
					result += current.getValue() + ", ";
					current = current.getNext();
				}
			}
				
			result += "}";
			return result;
		}
	}
	
	public static class Entry{
		Integer value;
		Entry nextEntry;
		
		Entry(Integer value){
			this.value = value;
		}
		
		public Integer getValue() {
			return value;
		}
		
		public void setNext(Entry next) {
			this.nextEntry = next;
		}
		
		public Entry getNext() {
			return nextEntry;
		}
	}
}
