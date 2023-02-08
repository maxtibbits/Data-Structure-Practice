package pkg4;

public class intNode {
	private int data;
	private intNode nextNode;
	private intNode previousNode;

	public intNode(int data) {
		this.data = data;
	}


	public int getData() {
		return data;
	}

	public intNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(intNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public intNode getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(intNode nextNode) {
		this.previousNode = nextNode;
	}
	
	@Override
	public String toString() {
		return "Data: " + this.data;
	}
	
	


}
