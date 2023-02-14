package chapter03Questions;

/**
 *  @author maxti
 *  
 *	Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *  Therefore, in real life, we would likely start a new stack when the previous stack 
 *	exceeds some threshold. Implement a data structure SetOfStacks that mimics this.
 *	SetOfStacks should be composed of several stacks and should create a new stack 
 *	once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 *	should behave identically to a single stack (that is, pop() should return the same
 *	values as it would if there were just a single stack).
 *
 *	Follow up:
 *	Implement a function popAt(int index) which performs a pop operation on a specific
 *	sub-stack.
 *	
 */

public class q3 {
	
	public static void main(String[] args) {
		
		//Initialize Set Of Stacks
		SetOfStacks test = new SetOfStacks();
		for (int i = 1; i <= 15; i++) {
			test.push(i);
		}
		
		System.out.println(test.toString());
		
		//run pop 6 times to test deletion of stack
		for (int i = 0; i<=5;i++) {
			test.pop();
		}

		System.out.println(test.toString());
		
		//run pop 6 times to test deletion of stack
		for (int i = 0; i<=5;i++) {
			test.pop();
		}

		System.out.println(test.toString());
		
		//add more values
		for (int i = 1; i <= 15; i++) {
			test.push(i);
		}
		
		System.out.println(test.toString());

		System.out.println("pop at index 2\n");
		test.popAtIndex(2);

		System.out.println(test.toString());

	}
	
	private static class SetOfStacks{
		
		private int stackIndex = 0;
		private Stack currentStack = new Stack(stackIndex);
		
		private void push(int value) {
			if (this.currentStack.top == null && this.currentStack.getStackIndex() == 0) {
				this.currentStack.push(value);
				return;
			}
			if (!this.currentStack.isFull()){
				this.currentStack.push(value);
				return;
			}
			if (this.currentStack.isFull()) {
				stackIndex++;
				Stack newStack = new Stack(stackIndex);
				newStack.push(value);
				newStack.setPrevious(this.currentStack);
				this.currentStack = newStack;
			}
			
		}
		
		public StackNode pop() {
			StackNode output = currentStack.pop();
			if(currentStack.isEmpty()) {
				currentStack = currentStack.getPrevious();
				stackIndex--;
			}
			
			return output;
		}
		
		//This was less annoying than I thought
		public StackNode popAtIndex(int index) {
			StackNode output = null;
			
			if (index == this.stackIndex) {
				output = this.currentStack.pop();
				return output;
			}
			if (index > this.stackIndex) {
				output = null;
				return output;
			}
			//the annoying part
			if (index < this.stackIndex) {
				Stack tmp = currentStack.getPrevious();
				while (tmp.getStackIndex() != index) {
					tmp = tmp.getPrevious();
				}
				
				output = tmp.pop();
				
				SetOfStacks storage = new SetOfStacks();
				
				//create reverse set of stacks
				while(stackIndex != index) {
					storage.push(this.pop().getValue());
				}
				
				while(storage.currentStack != null) {
					this.push(storage.pop().getValue());
				}
					
				return output;
				
			}
			
			return output;
		}
		
		@Override
		public String toString() {
			String output = "Set of Stacks:\n";
			if(currentStack == null) {
				output += "Set of Stacks not initialized!";
			}
			else {
				output += currentStack.toString();
				if(this.stackIndex > 0) {
					Stack tmp = currentStack.getPrevious();
					while (tmp != null) {
						output += tmp.toString();
						tmp = tmp.getPrevious();
					}
				}
			}
			
			return output;					
		}
		
		public static class Stack{
			private int length = 0;
			private int maxSize = 5;
			private int stackIndex;
			private Stack previous;
			private StackNode top;
			
			private Stack(int stackIndex) {
				this.stackIndex = stackIndex;
			}
			
			private void push(int value) {
				StackNode newStackNode = new StackNode(value);
				if(this.top == null) {
					this.top = newStackNode;
				}
				else {
					newStackNode.setNext(this.top);
					this.top = newStackNode;
				}
				length++;
			}
			
			private void setPrevious(Stack previous) {
				this.previous = previous;
			}
			
			public boolean isFull() {
				if (this.length == this.maxSize) {
					return true;
				}
				else {
					return false;
				}
			}
			public boolean isEmpty() {
				if (this.length == 0) {
					return true;
				}
				else {
					return false;
				}
			}
			
			public Stack getPrevious(){
				return this.previous;
			}
			
			public StackNode pop() {
				StackNode output = this.top;
				this.top = this.top.getNext();
				this.length--;
				return output;
			}
			
			public int getStackIndex(){
				return this.stackIndex;
			}
			
			@Override
			public String toString() {
				String output = "Stack#"+ stackIndex + " [";
				StackNode tmp = this.top;
				while (tmp != null) {
					output += tmp.getValue();
					if (tmp.getNext() != null) {
						output += ", ";
					}
					tmp = tmp.getNext();
				}
				
				output += "]\n";
				
				return output;
			}
					
		}
		
		public static class StackNode{
			int value;
			StackNode next;
			
			private StackNode(int value){
				this.value = value;
			}
			
			private int getValue() {
				return this.value;
			}
			
			private void setNext(StackNode input) {
				this.next = input;
			}
			
			private StackNode getNext() {
				return this.next;
			}
		}
	}
}
