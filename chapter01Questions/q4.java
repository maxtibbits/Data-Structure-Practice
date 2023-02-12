package chapter01Questions;

/*Question 1.4
 * 
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need
 * to be limited to just dictionary words.
 */
		

public class q4 {
	public static void main(String args[]) {
		String input = "tact Coaz";
		char[] inputArray = new char[input.length()];
		for (int i = 0; i < input.length(); i++) {
			inputArray[i] = input.charAt(i);
		}
		
		System.out.println(toPrintChar(inputArray));
	
		//Use hash-table to sort array
		
		int[] tableOfCounts = tableCreate(inputArray);
		
		System.out.println(toPrint(tableOfCounts));
		
		checkPalindrome(tableOfCounts);
		
		String input2 = "tact Coa";
		char[] inputArray2 = new char[input2.length()];
		for (int i = 0; i < input2.length(); i++) {
			inputArray2[i] = input2.charAt(i);
		}
		
		System.out.println(toPrintChar(inputArray2));
	
		//Use hash-table to sort array
		
		int[] tableOfCounts2 = tableCreate(inputArray2);
		
		System.out.println(toPrint(tableOfCounts2));
		
		checkPalindrome(tableOfCounts2);
	}
	
	private static int[] tableCreate (char[] input){
		int[] counts = new int[26];
		int hashIndex;
		
		for (int i = 0; i < input.length; i++) {
			hashIndex = hash(input[i]);
			if (hashIndex == -1) {
				
			}
			else {
				counts[hashIndex]++;
			}
		}
		
		
		return counts;
	}
	
	private static int hash (Character value){
		int hash = value;
		
		if ((hash < 065) || (hash > 90 && hash < 97) || (hash > 122)) { // check for non characters
			hash = -1;
			
			return hash;
		}
		
		if (hash <= 90 ) { //check for capitalized
			hash += 32;
		}
		
		hash -= 97;
		
		return hash;
	}
	
	private static void checkPalindrome(int[] x){
		
		boolean oddFound = false;
		
		for (int i = 0; i < x.length; i++) {
			if (x[i] != 0){
				if ((x[i]%2 != 0) && oddFound == true) {
					System.out.println("Not a palindrome!");
					return;
				}
				if ((x[i]%2) != 0 && oddFound != true) {
					oddFound = true;
				}
				
				
			}
			
		}
		System.out.println("A palindrome!");

	}
	
	private static String toPrint(int[] x) {
		String output = "[";
		for (int i = 0; i < x.length; i++) {
			output += x[i] + " ";
		}
		
		output += "]";
		
		return output;
	}

	private static String toPrintChar(char[] x) {
		String output = "[";
		for (int i = 0; i < x.length; i++) {
			output += x[i] + " ";
		}
		
		output += "]";
		
		return output;
	}
	
}