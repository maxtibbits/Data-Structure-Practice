package pkg5;

public class QueueDemo {
	public static void main (String[] args) {
		Queue test = new Queue(5);

		
		test.enqueue(14);
		test.dequeue();
		test.enqueue(1);
		test.peek();
	
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		test.enqueue(5);
		test.enqueue(6);
		test.peek();
		
		test.dequeue();
		test.peek();

		test.enqueue(6);
		
		test.peek();


		test.dequeue();
		test.dequeue();
		test.peek();

		
		test.dequeue();
		test.dequeue();
		
		test.peek();
		
		test.dequeue();
		
		test.peek();
		
		test.enqueue(7);
		test.enqueue(8);
		test.enqueue(9);
		test.enqueue(10);
		test.enqueue(11);
		
		test.peek();
		
		test.enqueue(12);
		
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		
		test.dequeue();
		test.peek();
		
		
	}
}
