package pkg4;

public class LinkedListDemo {
	public static void main (String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println(list);
		System.out.println("Length: " + list.length());
		
		list.deleteHead();
		System.out.println(list);
		System.out.println("Length: " + list.length());
		System.out.println ("Found: " + list.find(15));
		
		

	}
}
