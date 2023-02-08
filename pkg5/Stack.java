package pkg5;

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
	
}
