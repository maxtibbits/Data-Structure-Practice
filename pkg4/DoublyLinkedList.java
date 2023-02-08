package pkg4;

public class DoublyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public void insertAtTail (T data) {
		
		Node<T> newNode = new Node<T>(data);

		if (this.head == null) {
			this.head = newNode;
		}
		
		if (this.tail != null) {
			this.tail.setNextNode(newNode);
			newNode.setPreviousNode(this.tail);
			
		}
		
		this.tail = newNode;
		
	}
	

	public void insertAtHead (T data) {
		Node<T> newNode = new Node<T>(data);
		
		newNode.setNextNode(this.head);
		
		if (this.head != null) {
			this.head.setPreviousNode(newNode);
			newNode.setNextNode(this.head);
		}
		
		this.head = newNode;
		
		if (this.tail == null) {
			this.tail = newNode;
		}
	}
	
	public Node<T> getTail(){
		return this.tail;
	}
	
	public Node<T> getHead(){
		return this.head;
	}

	/* 
	 * Will switch back to integer instead of generic type in order to practice insertion sort implementation
	 * 
	 * 
	public void insertionSort (T data) {
		Node<T> newNode = new Node<T>(data);
		Node<T> current;
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		
		else {
			current = this.head;
			while (newNode.getData() > current.getData()) {
				if (current.getNextNode() != null && current.getNextNode().getData() > newNode.getData()) {
					current = current.getNextNode();
				}
			}
			
		}
	}
	*/
	
	public String reversePrint() {
		String result = "{";
		Node<T> current = this.tail;
		
		while (current != null) {
			if(current.getPreviousNode() == null) {
				result += current.toString();
			}
			else {
				result +=current.toString() +", ";
			}
			current = current.getPreviousNode();
		}
		
		result += "}";
		
		return result;
	}
	
	@Override
	public String toString () {
		String result = "{";
		Node<T> current = this.head;
		
		while (current != null) {
			if(current.getNextNode() == null) {
				result += current.toString();
			}
			else {
				result += current.toString() + ", ";

			}
			current = current.getNextNode();
		}
		
		result += "}";
		return result;
	}
}
