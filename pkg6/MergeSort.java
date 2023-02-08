package pkg6;
import java.util.Arrays;

/*
 * Implementation of the MergeSort array in Java
 * 
 * Recursion practice
 */
public class MergeSort {
	
	void merge(int[] array, int start, int midpoint, int end) {
		int lengthLeft = (midpoint-start) + 1;
		int lengthRight = (end-midpoint);
		int[] left = new int[lengthLeft];
		int[] right = new int[lengthRight];
		
		for (int i = 0; i < lengthLeft; i++) {
			left[i] = array[start+i];
		}
		
		for (int j = 0; j < lengthRight; j++) {
			right[j] = array[midpoint+1+j];
		}
		
		int x = 0, y = 0, k = start;
		
		while (x < lengthLeft && y < lengthRight) {
			if (left[x] <= right[y] && x <= midpoint) {
				array[k] = left[x];
				x++;
			}
			else{
				array[k] = right[y];
				y++;
			}
			k++;
		}
		
		while (x < lengthLeft) {
			array[k] = left[x];
			x++;
			k++;
		}
		
		while (y < lengthRight) {
			array[k] = right[y];
			y++;
			k++;
		}
		
	}
	
	public void sort(int[] array, int start, int end) {
		if (start < end) {
			int midpoint = ((start + end)/2);
			sort(array, start, midpoint);
			sort(array, midpoint + 1, end);
			merge(array, start, midpoint, end);
		
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {1042,231,24,1,1241,9999,124, 123, 9213494, 97298714, 7234, 234241, -123, 0 };
		System.out.println("Array before being sorted is:");
		System.out.println(Arrays.toString(array));
		MergeSort test = new MergeSort();
		test.sort(array, 0, (array.length)-1);
		System.out.println("Array after being sorted is:");
		System.out.println(Arrays.toString(array));		
		
	}

}
