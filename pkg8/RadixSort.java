package pkg8;

import java.util.Random;

public class RadixSort {
	
	private static void countingsort(int[] x, int place) {
		int size = x.length;
		int[] y = new int[size + 1];

		int max = x[0];
		for (int i = 1; i < size; i++) {
			if(x[i] > max) {
				max = x[i];
			}
		}
		
		int[] countArray = new int[max + 1];
		
		for (int i = 0; i <size; i++) {
			countArray[(x[i]/place)%10]++;
		}
		
		for (int i = 1; i <= max; i++) {
			countArray[i] += countArray[i-1];
		}
		
		for (int i = size- 1; i >= 0; i--) {
		      y[countArray[(x[i]/place)%10] - 1] = x[i];
		      countArray[(x[i]/place)%10]--;
		}
		
		for (int i = 0; i < size; i++) {
			x[i] = y[i];
		}
		
	}
	
	private static void radixsort(int[] x) {
		int size = x.length;
		
		int max = x[0];
		for (int i = 1; i < size; i++) {
			if(x[i] > max) {
				max = x[i];
			}
		}
		
		for(int place = 1; max/place > 0; place*= 10) {
			countingsort(x, place);
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
		
		System.out.println("Array before radixsort: " + printArray(x));
		
		radixsort(x);
		
		System.out.println("Array after radixsort:  " + printArray(x));
	}
}

