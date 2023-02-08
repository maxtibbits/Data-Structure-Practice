package pkg5;

public class StackDemo {
	public static void main (String[] args) {
		Stack test = new Stack(5);
		test.peek();
		test.pop();
		test.push(4);
		test.push(5);
		test.push(20);
		test.push(31);
		test.push(2312);
		test.push(1234);
		test.peek();
		test.pop();
		test.peek();
	}
}
