package chapter03Questions;

/**
 * 
 * @author maxti
 * How would you design a stack which, in addition to push and pop, has a function 
 * min which returns the minimum element?
 * 
 * Push, pop, and min should all operate in O(1) time.
 * 
 * Solved by modifying push method. Several ways of doing this. Not sure if allowed to save
 * another node in the stack class. Could also sort in the push method. Technically makes 
 * two stacks.
 */

public class q2 {
	public static void main (String[] args) {
		
		Stack test = new Stack();
		
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		
		System.out.println(test.toString());
		
		System.out.println("Min value is: " + test.min());
		
		System.out.println("Popped: " + test.pop().getValue());
		
		System.out.println(test.toString());

		System.out.println("Min value is: " + test.min());
		
		test.push(1);
		
		System.out.println(test.toString());
		
		System.out.println("Min value is: " + test.min());
		
		System.out.println("Popped: " + test.pop().getValue());
		
		System.out.println(test.toString());
		
		System.out.println("Min value is: " + test.min());

		System.out.println("Popped: " + test.pop().getValue());

		System.out.println(test.toString());

		System.out.println("Min value is: " + test.min());
		
	}
	
	private static class Stack{
		StackNode top;
		
		public void push(int value){
			if (top == null) {
				StackNode newEntry = new StackNode(value, value);
				this.top = newEntry;
				return;
			}
			else {
				if(value < top.min) {
					StackNode newEntry = new StackNode(value, value);
					newEntry.setNext(this.top);
					this.top = newEntry;
				}
				if(value >= top.min) {
					StackNode newEntry = new StackNode(value, top.min);
					newEntry.setNext(this.top);
					this.top = newEntry;
				}
			}			
		}
		
		public StackNode pop(){
			StackNode output = this.top;
			this.top = this.top.getNext();
			return output;
		}
		
		public int min() {
			return this.top.getMin();
		}
		
		@Override
		public String toString() {
			String output = "[";
			StackNode tmp = this.top;
			while (tmp != null) {
				output += tmp.getValue();
				if (tmp.getNext() != null) {
					output += ", ";
				}
				tmp = tmp.getNext();
			}
			output += "]";
			
			return output;
		}
	}
	
	private static class StackNode{
		int value;
		int min;
		StackNode next;
		
		StackNode(int value, int min){
			this.value = value;
			this.min = min;
		}
		
		private StackNode getNext() {
			return this.next;
		}
		
		private void setNext(StackNode nextNode) {
			this.next = nextNode;
		}
		
		private int getValue() {
			return this.value;
		}
		
		private int getMin() {
			return this.min;
		}
	}

}
