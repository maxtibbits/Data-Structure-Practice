package chapter1Questions;

/**
 * 
 * @author maxti
 * Assume you have a method isSubstring  which checks if one word is a substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a rotation
 * of s1 using only one call to isSubstring
 */
public class q9 {
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		String s3 = "erbottlewate";
		String s4 = "rebottlewat";
		
		q9 test = new q9();
		
		test.isSubstring(s1, s2);
		test.isSubstring(s1, s3);
		test.isSubstring(s1, s4);

	}
	
	public void isSubstring(String s1, String s2) {
		if (s1.length() != s2.length()) {
			System.out.println(s2 + " is not a substring of " + s1 + "! They have different lengths!");
			return;
		}
		
		int l = s1.length();
		
		char firstChar = s1.charAt(0);
		
		int matchedCharIndex = l;
		
		for (int i = 0; i < l; i++) {
			if (firstChar == s2.charAt(i)) {
				matchedCharIndex = i;
				break;
			}
		}
		
		if (matchedCharIndex == l) {
			System.out.println(s2 + " is not a substring of " + s1 +"!" + firstChar + 
					" was not found in s2!");
		}
		
		for (int i = 0; i < l; i++) {
			if(i+matchedCharIndex >= l) {
				if(s1.charAt(i) != s2.charAt((i+matchedCharIndex)-l)) {
					System.out.println(s2 + " is not a substring of " + s1 +"!" + s1.charAt(i)  + 
							" was not found in the right place at s2!");
					return;
				}
				
				
			}
			else {
				if(s1.charAt(i) != s2.charAt(i+matchedCharIndex)) {
					System.out.println(s2 + " is not a substring of " + s1 +"!" + s1.charAt(i)  + 
							" was not found in the right place at s2!");
					return;
				}
			}
			
		}
		
		System.out.println(s2 + " is a substring of " + s1 + "!");

	}

}
