package pkg5;

//import java.util.EmptyStackException;


public class Stack{
	int maxSize;
	int top = -1;
	int[] stackArray;	
	
	Stack(int inputSize){
		this.maxSize = inputSize;
		this.stackArray = new int[inputSize];
	}
	
	public void pop() {
		if (top != -1) {
			int output = stackArray[top];
			stackArray[top] = 0;
			top --;
			System.out.println("Popped: " + output);
			return;
		}
		else {
			System.out.println("Pop operation null due to empty stack!");
			return;
		}

	}
	
	public void push (int input){
		if ((top+1) >= maxSize){
			System.out.println("Push operation null due to full stack!");
			return;
		}
		top ++;
		stackArray[top] = input;
	}
	
	public void peek(){
		if (top != -1) {
			System.out.println("Peek: " + stackArray[top]);
		}
		else {
			System.out.println("Peek operation null due to empty stack!");
		}
	}
//private static class Stack{
//		
//		private StackNode top;
//		
//		public int pop() {
//			if (top == null) {
//				throw new EmptyStackException();
//			}
//			
//			int output = top.data;
//			top = top.next;
//			return output;
//		}
//		
//		void push(int value){
//			StackNode newNode = new StackNode(value);
//			newNode.next = this.top;
//			this.top = newNode;
//		}
//		
//		public int peek() {
//			if (top == null) {
//				throw new EmptyStackException();
//			}
//			return this.top.data;
//		}
//		
//		public boolean isEmpty() {
//			if (top == null) {
//				return true;
//			}
//			else return false;
//		}
//		
//		private static class StackNode{
//			private int data;
//			private StackNode next;
//			
//			public StackNode(int data) {
//				this.data = data;
//			}
//		}
//		
//		
//	}
}
