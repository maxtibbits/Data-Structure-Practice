package pkg4;

public class DoublyEndedListDemo {
	public static void main (String[] args) {
		DoublyLinkedList<Integer> dList = new DoublyLinkedList<Integer>();
		
		System.out.println("henlo");
		
		dList.insertAtHead(7);
		
		System.out.println("The head is: " + dList.getHead());
		System.out.println("The tail is: " + dList.getTail());
		
		dList.insertAtTail(20);
		dList.insertAtHead(5);
		dList.insertAtTail(31);
		
		System.out.println("The head is: " + dList.getHead());
		System.out.println("The tail is: " + dList.getTail());
		
		System.out.println("Doubly linked list printed forwards: " + dList);
		System.out.println("Doubly linked list printed backwards: " + dList.reversePrint());
		
		//insertion sort practice with intNode
		
		//dList.insertionSort(19);
		System.out.println("Doubly linked list printed forwards: " + dList);
		System.out.println("Doubly linked list printed backwards: " + dList.reversePrint());
		
		/*
		 * Switching from generic to integer type in order to do insertion sort implementation
		 */
		
		
		IntDoublyLinkedList dIntList = new IntDoublyLinkedList();
		
		dIntList.insertionSort(3);
		dIntList.insertionSort(1);
		dIntList.insertionSort(5);
		dIntList.insertionSort(20);
		dIntList.insertionSort(4);
		System.out.println("Doubly Int linked list printed forwards: " + dIntList);
	
	}

}
