package chapter1Questions;

/**
 * @author maxti
 *There are three types of edits that can be performed on string: insert a character, remove a character, or
 *replace a character. Given two string, write a function to check if they are one edit (or zero edits) away.
 *
 *
 *This answer is written to assume that only alphabetical inputs will be used. Otherwise a bigger array will be needed
 *to store the counts of the chars. Both capitalized and lower case inputs are acceptable and are distinguished!
 *
 *My original answer did not take into account the order of characters in the string. 
 *Using the charAt(i) method fix this.
 */

public class q5 {

	
	public static void main(String[] args) {
		
		String input1 = "abecd";
		String input2 = "abfcd";
		
		if (input1.equals(input2)) {
			System.out.println(input1 + " is the same string as "+ input2 + "!");
		}
		else {
			char[] input1Array = new char[input1.length()];
			char[] input2Array = new char[input2.length()];
			
			int lengthDiff = input2Array.length-input1Array.length;
			
			if(Math.abs(lengthDiff) > 1) {
				System.out.println(input1 + " is more than one edit away from "+ input2 + "!");
				return;
			}
			
			if(lengthDiff == 0) {
				boolean diffValue = false;
				
				for (int i = 0; i < input1.length(); i++) {
					if(!(input1.charAt(i) == input2.charAt(i)) && diffValue == true) {
						System.out.println(input1 + " is more than one edit away from "+ input2 + "!");
						return;
					}
					if(!(input1.charAt(i) == input2.charAt(i)) && diffValue == false) {
						diffValue = true;
					}

				}
				
				System.out.println(input1 + " is one edit away from "+ input2 + "!");
			}

			if(lengthDiff == 1) {
				//System.out.println(lengthDiff);
				checkRemoval(input2, input1);
			}
			if(lengthDiff == -1){
			//	System.out.println(lengthDiff);
				checkRemoval(input1, input2);
			}

			
			//My original answer that doesn't take into account the order of characters in a string
			/*
			for (int i = 0; i < input1.length(); i++) {
				input1Array[i] = input1.charAt(i);
			}

			for (int i = 0; i < input2.length(); i++) {
				input2Array[i] = input2.charAt(i);
			}
			
	
			
			int[] count1 = count(input1Array);
			int[] count2 = count(input2Array);
			
			System.out.println(input1 + " is converted to:"+ toPrint(count1));
			System.out.println(input2 + " is converted to:" + toPrint(count2));
			
			int differences = subtractCounts(count1, count2);
			
			System.out.println("The number of differences is "+ differences+".");
			
			if(differences == 2 && input1.length()==input2.length()) {
				System.out.println(input1 + " is a replacement away from "+ input2+"!");
			}
			
			if(differences == 1) {
				System.out.println(input1 + " is an edit away from "+ input2+"!");
			}
			*/
		}
			
		
	}
	
	private static void checkRemoval(String bigger, String smaller) {
		boolean diffValue = false;
		
		for (int i = 0; i < smaller.length(); i++) {
			if(smaller.charAt(i) != bigger.charAt(i) && diffValue == false) {
				diffValue = true;
				i--;
			}
			if(smaller.charAt(i) != bigger.charAt(i+1) && diffValue == true) {
				System.out.println("Two differences have been found!");
				return;
			}
			System.out.println(bigger + " is one edit away from "+ smaller + "!");
		}
		
		System.out.println(bigger + " is one edit away from "+ smaller + "!");
	}

	

	


	/*
	
		
	private static String toPrint(int[] x) {
		String output = "[";
		for (int i = 0; i < x.length; i++) {
			output += x[i] + " ";
		}
		
		output += "]";
		
		return output;
	}
	
	public static int subtractCounts(int[] x, int[] y) {
		int difference = 0;
		int loopSize = 0;
		if (x.length >= y.length) {
			loopSize = x.length;
		}
		if (y.length > x.length) {
			loopSize = y.length;
		}
		
		for (int i = 0; i < loopSize; i++) {
			difference += Math.abs(x[i] - y[i]);
		}
		
		return difference;
	}
	
		private static int getHash(char x) {
		int hash = x;
		
		if ((hash < 065) || (hash > 90 && hash < 97) || (hash > 122)) { // check for non characters
				hash = -1;
				
			return hash;
		}
		
		if(hash >= 97) {
			hash -= 6;	//shifts down lower case chars
		}
				
		hash -= 65;
			
		return hash;

	}
	
		private static int[] count (char[] x) {
		int[] countArray = new int[52];
		int hashIndex;
		
		for(int i = 0; i < x.length; i++) {
			hashIndex = getHash(x[i]);
			if (hashIndex == -1) {
				
			}
			else {
				countArray[hashIndex]++;
			}
			
		}
		
		return countArray;
	}
	
	*/
	
}
