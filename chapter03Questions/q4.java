package chapter03Questions;

/**
 * @author maxti
 * Implement a MyQueue class which implements a queue using two stacks.
 */

public class q4 {
	
	public static void main(String[] args) {
		
		MyQueue test = new MyQueue();
		System.out.println(test.toString());

		System.out.println("Is empty: " + test.isEmpty());

		
		for (int i = 0; i <= 10; i++) {
			test.add(i);
		}
		
		System.out.println(test.toString());
		
		System.out.println("Peek LIFO: " + test.peek().getValue());

		System.out.println("Is empty: " + test.isEmpty());

		
		System.out.println("Remove LIFO: " + test.remove().getValue());
		
		System.out.println(test.toString());
		
	}
	
	private static class MyQueue{
		
		Stack realStack = new Stack();
		Stack storStack = new Stack();
		
		private boolean isEmpty() {
			return realStack.isEmpty();
		}
		
		private void add (int value) {
			realStack.push(value);
		}
		
		private Node remove() {
			Node output;
			while (realStack.top.getNext() != null) {
				storStack.push(realStack.pop().getValue());
			}
			
			output = realStack.pop();
			
			while(storStack.top != null) {
				realStack.push(storStack.pop().getValue());
			}
			
			return output;
		}
		
		private Node peek() {
			Node output;
			while (realStack.top != null) {
				storStack.push(realStack.pop().getValue());
			}
			output = storStack.peek();
			while (storStack.top != null) {
				realStack.push(storStack.pop().getValue());
			}
			
			return output;
		}
		
		@Override
		public String toString() {
			String output = "[";
			if (this.realStack.top != null) {
				Node tmp = realStack.top;
				while (tmp != null) {
					output += tmp.getValue();
					if (tmp.getNext() != null) {
						output += ", ";
					}
					tmp = tmp.getNext();
				}
			}
			output += "]";
			
			return output;
		}
		
		private static class Stack{
			private Node top;
			
			public void push(int value) {
				Node newNode = new Node(value);
				
				if (this.top == null) {
					this.top = newNode;
				}
				else {
					newNode.setNext(this.top);
					this.top = newNode;
				}
			}
			
			public Node pop() {
				Node output = this.top;
				this.top = this.top.getNext();
				return output;
			}
			
			public boolean isEmpty() {
				if(this.top == null) {
					return true;
				}
				return false;
			}
			
			public Node peek() {
				return this.top;
			}	
		}	
	}
	
	private static class Node{
		int value;
		Node next;
		
		private Node(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}

		private void setNext(Node next) {
			this.next = next;
		}
		
		public Node getNext() {
			return this.next;
		}
	}
}
