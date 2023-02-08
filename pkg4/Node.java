package pkg4;

//doubly linked node

public class Node<T> {
	private T data;
	private Node<T> nextNode;
	private Node<T> previousNode;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node<T> getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(Node<T> nextNode) {
		this.previousNode = nextNode;
	}
	
	@Override
	public String toString() {
		return "Data: " + this.data;
	}

}
