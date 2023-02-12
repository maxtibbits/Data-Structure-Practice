package chapter01Questions;

/**
 * 
 * @author maxti
 *
 *Given two strings, write a method to decide if one is a permutation of the other
 */

public class q2 {
	public static void main(String args[]) {
		String string1 = "tac";
		String string2 = "cat";
		String string3 = "cdt";
		String string4 = "ct";
		
		q2 test = new q2();
		
		test.printResult(string1, string2);
		test.printResult(string1, string3);
		test.printResult(string1, string4);
	}
	
	public boolean permutationTest(String string1, String string2){
		if(string1.length() != string2.length()) {
			return false;
		}
		
		int[] x = new int[128];//this is assuming the strings are in ASCII
		for (int i = 0; i < string1.length(); i++) {
			x[string1.charAt(i)]++;
		}
		
		for (int i = 0; i < string2.length(); i++) {
			x[string2.charAt(i)]--;
			if (x[string2.charAt(i)] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public void printResult(String x, String y) {
		if (permutationTest(x, y) == true) {
			System.out.println(x + " is a permutation of "+y);
		}
		
		else {
			System.out.println(x + " is not a permutation of "+y);
		}
	}
}
