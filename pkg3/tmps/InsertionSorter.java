package pkg3.tmps;

import java.util.Arrays;

public class InsertionSorter {
	
	public static void main(String[] args) {
		int[] data = {7,3,6,8,2};
		new InsertionSorter().sort(data);
		System.out.println(Arrays.toString(data));
	}
	
	public void sort(int[] data) {
		for (int i =0; i < data.length; i++) {
			int current = data[i];
			int j = i-1;
			while (j >=0 && data[j] >= current) {
				data[j+1] = data[j];
				j--;
			}
			data[j+1] = current;
		}
	}
}
