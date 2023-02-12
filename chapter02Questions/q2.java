package chapter02Questions;

/**
 * 
 * @author maxti
 *
 *Implement an algorithm to find the kth to last element of a singly linked list
 *
 *I solved this 3 different ways just to practice in case certain solutions would not
 *be accepted. I didn't feel like making a wrapper class for the index to solve it 100%
 *recursively.
 *
 */
public class q2 {
	
	public static void main (String[] args) {
		
		int k = 4;
		
		SinglyLinkedList test = new SinglyLinkedList();
		
		test.insertAtHead(1);
		test.insertAtHead(2);
		test.insertAtHead(3);
		test.insertAtHead(1000);
		test.insertAtHead(5);
		test.insertAtHead(6);

		System.out.println(test.toString());
		
		int kthValueWLength = test.findKthToLastWLength(k);

		System.out.println("The kth to last element of the singly linked "
				+ "list when k = " + k + " is: "+ kthValueWLength +".");
		
		int kthValueWWhileloop = test.findKthToLastWhileLoop(k);
		
		
		System.out.println("w/ while Loop:" + kthValueWWhileloop );
		
		@SuppressWarnings("unused")
		int kRecursion = test.findKthToLastRecursion(test.head, k);
		
	}
	
	private static class SinglyLinkedList{
		Entry head;
		int length = 0;
		
		void insertAtHead(int value) {
			Entry newEntry = new Entry(value);
			
			if (this.head == null) {
				this.head = newEntry;
				length++;
			}
			
			else {	
				newEntry.next = this.head;
				this.head =  newEntry;
				length++;
			}
		}
		
		
		//Solution for when the length is known
		int findKthToLastWLength(int k){
			Entry output = this.head;
			for (int i = 0; i <= length-1-k; i++) {
				output = output.getNext();
			}
						
			return output.getValue();
		}
		
		int findKthToLastWhileLoop(int k) {
			Entry x = this.head;
			Entry y = this.head;
			
			int lengthRec = 0;
			
			while (x != null){
				lengthRec++;
				x = x.getNext();
			}
			
			//System.out.println(lengthRec);
			//System.out.println(y.getValue());
					
			while (lengthRec - k > 0) {
				//System.out.println(lengthRec-k);
				lengthRec--;
				y = y.getNext();
			}
			
			return y.getValue();
		}
		
		int findKthToLastRecursion(Entry x, int k) {
			if (x == null) {
				return 0;
			}
			int index = findKthToLastRecursion(x.next, k) + 1;
			if (index == k) {
				System.out.println("The kth from ending value when k is " + 
						k + " is: " + x.getValue()+ ".");
			}
			return index;
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
	
	private static class Entry{
		int value;
		Entry next;
		
		Entry(int value){
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public Entry getNext() {
			return next;
		}
		
	}
}
