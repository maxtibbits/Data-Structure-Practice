package chapter03Questions;

/**
 * @author maxti
 * 
 * An animal shelter, which holds only dogs and cats, operates on a strictly 
 * "first in, first out" basis. People must adopt either the "oldest" (based
 * on arrival time) of all animals at the shelter, or that they can select
 * whether they would prefer a dog or a cat ( and will receive the oldest 
 * animal of that type). They cannot select which specific animal they would 
 * like. Create the data structures to maintain this system and implement 
 * operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat. 
 * 
 * You may use the built-in LinkedList data structure.
 */


public class q6 {
	public static void main (String[] args) {
		LinkedList test = new LinkedList();
		
		test.enqueue("cat");
		test.enqueue("cat");
		test.enqueue("cat");
		test.enqueue("dog");
		test.enqueue("cat");
		test.enqueue("cat");
		
		System.out.println(test.toString());
		
		test.dequeueAny();
		System.out.println("Dequeue oldest any: " + test.toString());

		
		test.dequeueCat();
		System.out.println("Dequeue oldest cat: " + test.toString());

		test.dequeueDog();
		System.out.println("Dequeue oldest dog: " + test.toString());
		
		test.dequeueDog();
		System.out.println("Dequeue oldest dog: " + test.toString());


	}
	
	private static class LinkedList{
	
		private Node head;
				
		private void enqueue(String animalType) {
			if (animalType != "cat" && animalType != "dog") {
				System.out.println("Error, not a cat or dog!");
				return;
			}
			Node newNode = new Node(animalType);
			if (this.head == null) {
				this.head = newNode;
				return;
			}
			else {
				newNode.setNext(this.head);
				this.head = newNode;
				return;
			}
		}
		
		private Node dequeueAny() {
			Node output = this.head;
			this.head = this.head.getNext();
			return output;
		}
		
		private Node dequeueDog() {
			
			Node output = null;
			
			if (this.head.getAnimalType() == "dog") {
				output = this.head;
				this.head = this.head.getNext();
				return output;
			}
			
			Node tmp = this.head;
			
			while(tmp.getNext()!= null) {
				if (tmp.getNext().getAnimalType() == "dog") {
					output = tmp.getNext();
					tmp.setNext(output.getNext());
					break;
				}
				tmp = tmp.getNext();
			}			
			
			if (output == null) {
				System.out.println("Sorry we have no doggos!");
			}
			
			return output;
		}
		
		private Node dequeueCat() {
			Node output = null;
			
			if (this.head.getAnimalType() == "cat") {
				output = this.head;
				this.head = this.head.getNext();
				return output;
			}
			
			Node tmp = this.head;
			
			while(tmp.getNext()!= null) {
				if (tmp.getNext().getAnimalType() == "cat") {
					output = tmp.getNext();
					tmp.setNext(output.getNext());
					break;
				}
				tmp = tmp.getNext();
			}			
			
			if (output == null) {
				System.out.println("Sorry we have no kittys!");
			}
			
			return output;
		}
		
		@Override
		public String toString() {
			String output = "[";
			Node tmp = this.head;
			
			while(tmp != null) {
				output += tmp.getAnimalType();
				if (tmp.getNext() != null) {
					output+= ", ";
				}
				tmp = tmp.getNext();
			}
			
			output += "]";
			
			return output;
		}
		
		private static class Node{
			String animalType;
			Node next;
			
			private Node(String animalType) {
				this.animalType = animalType;
			}
			
			private void setNext(Node next) {
				this.next = next;
			}
			
			private Node getNext() {
				return this.next;
			}
			
			private String getAnimalType() {
				return this.animalType;
			}
		}
	}
}
