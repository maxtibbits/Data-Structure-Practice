package pkg5;


/*
 * Circular Queue implementation using an integer array
 * Not O(n^2) time
 */


public class Queue {
	boolean validHead = false;
	int arraySize = 10;
	int[] storageArray = new int[arraySize];
	int tailPos = -1;
	int headPos = 0;
	
	Queue(int inputSize){
		this.arraySize = inputSize;
		this.storageArray = new int[inputSize];
		System.out.println("A queue with the max size of " + arraySize + " has been created!");
	}
	
	
	public void enqueue(int input) {
		if ((headPos-tailPos) == 1 || Math.abs(tailPos-headPos) == (arraySize - 1)) {  //check if array is full
			if (tailPos != -1) {
				System.out.println("Error: Cannot run enqueue method. Queue is full! " + input + " not added!" );
				return;
			}
			else {
				storageArray[headPos] = input;
				tailPos++;
				validHead = true;
				return;
			}
		}
		else{
			if (tailPos == (arraySize - 1)) {		//moves tail to front of array if tail is at end of the array, this method makes this function faster
				tailPos = 0;
			}
			else {
				if(validHead != false) {
					tailPos++;
				}
				
			}
			storageArray[tailPos] = input;
			System.out.println(input + " has been added to the queue!");
			validHead = true;
			return;
		}
	}
	
	public int dequeue() {
		int output = 0;
		if (tailPos == -1) {
			System.out.println("Error: Cannot run dequeue method. Queue not initialized!");
			return 0;
		}
		if(tailPos == headPos) {
			if (validHead == false) {
				System.out.println("Error: Cannot run dequeue method. Nothing stored in Queue!");
				return output;
			}
			else {
				output = storageArray[headPos];
				validHead = false;
				System.out.println(output + " has been removed from the queue!");
				return output;
			}
		}

		if (Math.abs(tailPos - headPos) <= arraySize-1) {
			output = storageArray[headPos];
			if (headPos == arraySize-1) {
				headPos = 0;
			}
			else {
				headPos++;
			}
			
			System.out.println(output + " has been removed from the queue!");

			return output;
		}
		
		System.out.println("Situation wasn't handled by if statement!"); //debug notification!!!!
		return output;
	}
	
	public int peek() {
		if (tailPos == -1) {
			System.out.println("Error: Cannot run peek method. Queue not initialized!");
			return 0;
		}
		if (validHead == false) {
			System.out.println("Error: Cannot run peek method. Queue is Empty!");
			return 0;
		}
		System.out.println(storageArray[headPos] + " is the head of the Queue!");
		return storageArray[headPos];
	}

}
