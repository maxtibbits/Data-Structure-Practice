package pkg8;

import java.util.Random;
/*
 * Attempt to fix insertion sort algorithm
 */
public class ShellSort {

	private static void shellsort(int[] x, int n) {
		
		for (int interval = n / 2; interval > 0; interval /= 2) {
			for (int i = interval; i < n; i += 1) {
				int temp = x[i];
		    	int j;
		    	for (j = i; j >= interval && x[j - interval] > temp; j -= interval) {
		    		x[j] =x[j - interval];
		    	}
		    	
		    	x[j] = temp;
		    	
		    }
		}
	}
	
	private static String printArray(int[] x) {
		 if(x == null) {
			 return "Error: array empty!";
		 }
		 String result = "[" + x[0];
		 if (x.length == 1) {
			 return result += "] Array only has one element!";
		 }
		 for (int i = 1; i < x.length; i++) {
			 result += ", " + x[i];
		 }
		 result += "]";
		 
		 return result;
	 }
	
	// Demonstration 
	public static void main(String[] args) {
		Random rand = new Random();
		int[] x = new int[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = rand.nextInt(100);
		}
		
		System.out.println("Array before shellsort: " + printArray(x));
		
		int size = x.length;
		
		shellsort(x, size);
		
		System.out.println("Array after shellsort:  " + printArray(x));
	}
}
