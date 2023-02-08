package pkg8;

import java.util.Random;

public class QuickSort {
	
	private static void quicksort(int[] x) {
		if(x == null) {
			System.out.println("Error: Array not initialized!");
			return;
		}
		quicksort(x, 0, x.length - 1);
	}
	
	
	private static void quicksort(int[] x, int start, int end){

		if(start >= end) {
			return;
		}
		
		int middle = start+(end-start)/2;
		int pivot = x[middle];
		
	    int i = start, j = end;
	    while (i <= j) 
	    {
	      //Check until all values on left side array are lower than pivot
	      while (x[i] < pivot) 
	      {
	        i++;
	      }
	      //Check until all values on left side array are greater than pivot
	      while (x[j] > pivot) 
	      {
	        j--;
	      }
	      //Now compare values from both side of lists to see if they need swapping 
	      //After swapping move the iterator on both lists
	      if (i <= j) 
	      {
	        swap (x, i, j);
	        i++;
	        j--;
	      }
	    }
	    
	    //Do same operation as above recursively to sort two sub arrays
	    if (start < j){
	      quicksort(x, start, j);
	    }
	    if (end > i){
	      quicksort(x, i, end);
	    }

	
	}
		 
	public static int partition(int[] x, int start, int end, int pivot){
		
		int left = start;
		int right = end - 1;
		
		while (left < right) {
			while(x[left] <= pivot && left < right) {
				left++;
			}
			
			while(x[right] >= pivot && left < right) {
				right--;
			}
	
			swap(x, left, right);
		}
		
		if(x[left] > x[end]) {
		     swap(x, left, end);
		}
		else {
		    	left = end;
		}
		    
		return left;
		  
	}
	
	public static void swap(int[] x, int i, int j) {
		int tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
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
		
		System.out.println("Array before quicksort: " + printArray(x));
		
		quicksort(x);
		
		System.out.println("Array after quicksort:  " + printArray(x));
	}

}
