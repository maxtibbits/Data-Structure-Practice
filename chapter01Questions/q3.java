package chapter01Questions;

/**
 * 
 * @author maxti
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at
 * the end to hold the additional characters, and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 */
public class q3 {
	public static void main(String args[]) {
		char[] input = {'M', 'r', ' ','J','o','h','n',' ','S','m','i','t','h'};
		
		int numberOfSpaces = findSpaces(input);
		System.out.println(input);
		System.out.println(replace(input, numberOfSpaces));
	}
	
	public static char[] replace (char[] input, int numberOfSpaces){
		char[] output = new char[input.length+(numberOfSpaces*2)];
		int outputIndex = 0;
		
		for (int i = 0; i < input.length; i++) {
			if(input[i] == ' ') {
				output[outputIndex] = '%';
				output[outputIndex+1] = '2';
				output[outputIndex+2] = '0';
				outputIndex += 3;
			}
			else {
				output[outputIndex] = input[i];
				outputIndex += 1;
			}
		}
		
		return output;
	}
	
	public static int findSpaces(char[] input) {
		int numberOfSpaces = 0;
		
		for (int i = 0; i<input.length;i++) {
			if(input[i] == ' ') {
				numberOfSpaces += 1;
			}
		}
			
		return numberOfSpaces;
	}
}
