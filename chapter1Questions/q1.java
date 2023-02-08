package chapter1Questions;

/**
 * 
 * @author maxti
 *
 *Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 */



public class q1 {
	public static void main (String[] args) {
		String input1 = "Hello";
		String input2 = "Hunt";
		
		q1 test = new q1();
		
		test.isUnique(input1);
		test.isUnique(input2);
		
		test.isUniqueFaster(input1);
		test.isUniqueFaster(input2);
		
	}
	
	// runtime is 0(n^2)
	public void isUnique(String input) {
		for (int i = 0; i < input.length(); i++) {	
			for (int j = i+1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					System.out.println("The string does not comprise of all unique characters!");
					return;			
				}
			}	
		}
		System.out.println("The string does comprise of all unique characters!");		
	}
	
	//runtime is O(n)
	public void isUniqueFaster(String input) {
		int checker = 0;
		for (int i = 0; i < input.length(); i++) {
			int val = input.charAt(i) - 'a';
			if((checker & (1 << val)) > 0){
				
				System.out.println("The string does not comprise of all unique characters!");
				return;
			}
			
			checker |= (1 << val);
		}
		System.out.println("The string does comprise of all unique characters!");
	}
		
}

