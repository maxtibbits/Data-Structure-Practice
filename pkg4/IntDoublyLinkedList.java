package pkg4;

public class IntDoublyLinkedList {
	private intNode head;
	private intNode tail;
	
	public void insertAtTail (int data) {
		
		intNode newNode = new intNode(data);

		if (this.head == null) {
			this.head = newNode;
		}
		
		if (this.tail != null) {
			this.tail.setNextNode(newNode);
			newNode.setPreviousNode(this.tail);
			
		}
		
		this.tail = newNode;
		
	}
	

	public void insertAtHead (int data) {
		intNode newNode = new intNode(data);
		
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
	
	public intNode getTail(){
		return this.tail;
	}
	
	public intNode getHead(){
		return this.head;
	}
	
	public void insertionSort (int data) {
		intNode newNode = new intNode(data);
		intNode current;
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		
		else {
			current = this.head;
			if (newNode.getData() < current.getData()) {
				this.head = newNode;
				current.setPreviousNode(newNode);
				newNode.setNextNode(current);
			}
			while (newNode.getData() > current.getData()) {
				if (current.getNextNode() != null && current.getNextNode().getData() < newNode.getData()) {
					current = current.getNextNode();
				}
				if (current.getNextNode() == null) {
					current.setNextNode(newNode);
					newNode.setPreviousNode(current);
					this.tail = newNode;
					return;
				}
				if (current.getNextNode().getData() > newNode.getData()) {
					current.getNextNode().setPreviousNode(newNode);
					newNode.setNextNode(current.getNextNode());
					newNode.setPreviousNode(current);
					current.setNextNode(newNode);
					return;
				}
			}		
		}
	}

	
	public String reversePrint() {
		String result = "{";
		intNode current = this.tail;
		
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
		intNode current = this.head;
		
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
