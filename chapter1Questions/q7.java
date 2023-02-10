package chapter1Questions;

import java.util.Random;

/**
 * 
 * @author maxti
 *Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 *wirte a method to rotate the image by 90 degrees. Can you do this in place?
 */

public class q7 {
	public static void main(String[] args) {
		
		Random rd = new Random();
		int n = 6;
		int[][] matrix = new int[n][n];
				
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				matrix[i][j] = rd.nextInt(9999 - 1000) + 1000;
			}
		}

		printMatrix(matrix);
//		System.out.println(matrix[0][matrix.length-1]);
//		System.out.println(matrix[0][0]);
//		System.out.println(matrix[matrix.length-1][0]);
		
		System.out.println("");
		
		rotateMatrix90degrees(matrix);

		printMatrix(matrix);

		
	}
	
	
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
				if (j == matrix.length-1) {
					System.out.println("");
				}
				else {
					System.out.print(" ");
				}
			}
		}
		
	}
	
	private static void rotateMatrix90degrees(int[][] matrix) {
		int n = matrix.length-1;
		int tmp;
		int x;
		int first;
		int last;
		for (int level = 0; level < n/2; level++) {
			
			first = level;
			last = n-level;
			
			for(int i = first; i < last; i++) {
					x = i - first; //shift
			
					tmp = matrix[first][i]; //top left stored
					
					matrix[first][i] = matrix[last-x][first]; //top left = bottom left 
					
					matrix[last-x][first] = matrix[last][last-x]; // bottom left = bottom right
					
					matrix[last][last-x] = matrix[i][last]; //bottom right = top right;
					
					matrix[i][last] = tmp; //top right = top left
			}
		}
	}
	
	
	
}
