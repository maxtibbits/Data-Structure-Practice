package pkg4;

public class LinkedList<T> {
	private Node<T> head;

	public Node<T> getHead(){
		return this.head;
	}
	
	public void insertAtHead (T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	public Node<T> deleteHead() {
		Node<T> deleted = this.head;
		this.head = this.head.getNextNode();
		return deleted;
	}
	
	public int length () {
		if (this.head == null) {
			return 0;
		}
		int length = 0;
		Node<T> current = this.head;
		
		while (current!= null) {
			length ++;
			current = current.getNextNode();
		}
		
		return length;
	}
	

	
	public Node<T> find(T data) {
		Node<T> current = this.head;
		
		while (current != null) {
			if (current.getClass().equals(data)) {
				return current;
			}
			
			current = current.getNextNode();
		}
		
		return null;
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
