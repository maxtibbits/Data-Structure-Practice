package pkg3;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int [] data = {4334, 1234, 21513, 1234, 12};
		new InsertionSort().sort(data);
		System.out.println(Arrays.toString(data));
	}

	public void sort(int[] data) {
            
            for (int i = 0; i < data.length; i++) {
                int tmp = data[i];
                int j = i - 1;
                while (j >= 0 && data[j] >= tmp){
                    data[j + 1] = data[j];
                    j = j - 1;
                    
                }
                data [j + 1] = tmp;
            }
            
	}
}