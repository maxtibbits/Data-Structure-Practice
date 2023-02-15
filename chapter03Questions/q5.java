package chapter03Questions;

import java.util.Random;

/**
 * @author maxti
 *
 * Write a program to sort a stack such that the smallest items are on the top. 
 * You can use an additional temporary stack, but you may  not copy the 
 * elements into any other data structure (such as an array). The stack
 * supports the following operations: push, pop, peek, isEmpty.
 * 
 * Dev Note: I interpreted this question as requiring me to sort a stack that
 * already has been initialized, otherwise I would sort the Stack while
 * elements are added in the push method.
 */


public class q5 {

	public static void main(String[] args) {
		Random rd = new Random();
		Stack test = new Stack();
		
		Stack test2 = new Stack();
		
		
		for (int i = 0; i < 10; i++) {
			test.push(rd.nextInt(21));
		}
		
		System.out.println(test.toString());
		
		test2 = test.sortToMinTop();
		System.out.println(test.toString());
		System.out.println(test2.toString());

	}
	
	private static class Stack{
		private Node top;
		
		private void push(int value) {
			Node newNode = new Node(value);
			if (top != null) {
				newNode.setNext(this.top);
				this.top = newNode;
			}
			else {
				this.top = newNode;
			}
		}
		
		@Override
		public String toString() {
			String output = "[";
			Node tmp = this.top;
			while(tmp != null) {
				output += tmp.getValue();
				if (tmp.getNext() != null) {
					output += ", ";
				}
				tmp = tmp.getNext();
			}
			
			
			output += "]";
			return output;
		}
		
		//Hello World! This is where I solve the problem.
		private Stack sortToMinTop() {
			if (this.top == null) {
				System.out.println("Stack not initialized!");
				return this;
			}
			if (this.top.getNext() == null) {
				System.out.println("Only one Element!");
				return this;
			}
			
			Stack minStack = new Stack();
			minStack.push(this.pop().getValue());
			
			//Solution without using node.setValue()
			
			Node tmp = this.pop();
			
			if (tmp.getValue() <= minStack.top.getValue()){
				minStack.push(tmp.getValue());
			}
			else {
				minStack.top.setNext(tmp);
			}
			
			while(this.top != null) {
				tmp = this.pop();
				if (tmp.getValue() <= minStack.top.getValue()){
					minStack.push(tmp.getValue());
				}
				else {
					Node minNode = minStack.top;
					while(minNode != null) {
						// This was the hardest part to figure out for me, I kept trying to do this with
						// a recursive call.
						if(minNode.getNext() == null) {
							minNode.setNext(tmp);
							break;
						}
						if(tmp.getValue()< minNode.getNext().getValue()) {
							tmp.setNext(minNode.getNext());
							minNode.setNext(tmp);
							break;
						}
						else {
							minNode = minNode.getNext();
						}

					}
				}
			}
			
			return minStack;
		}
//Alternate solution:
			
			
//			Node tmp = minStack.top;
//			
//			while (this.top != null) {
//				minStack.push(this.pop().getValue());
//				minStackCheckMin(minStack.top);
//			}
//	
//			return minStack;
//		}
//		
//		private void minStackCheckMin(Node x) {
//			if(x.getNext() == null) {
//				return;
//			}
//			if(x.getValue() > x.getNext().getValue()) {
//				int tmp = x.getValue();
//				x.setValue(x.getNext().getValue());
//				x.getNext().setValue(tmp);
//				minStackCheckMin(x.getNext());
//			}
//			else {
//				minStackCheckMin(x.getNext());
//			}
//			
		

		private Node pop() {
			Node output = this.top;
			this.top = this.top.getNext();
			System.out.println("Popped: " + output.getValue());
			output.setNext(null);
			return output;
		}
		
//		private Node peek() {
//			return this.top;
//		}
		
//		private boolean isEmpty() {
//			if (this.top == null) {
//				return true;
//			}
//			return false;
//		}
		
		private static class Node{
			int value;
			Node next;
			
			Node(int value){
				this.value = value;
			}
			
			public int getValue() {
				return this.value;
			}
			
//			public void setValue(int value) {
//				this.value = value;
//			}
			
			public void setNext(Node next) {
				this.next = next;
			}
			
			public Node getNext() {
				return this.next;
			}
		}
	}
}
