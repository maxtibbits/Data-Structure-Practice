package chapter01Questions;
import java.util.Random;


/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0
 * 
 */

public class q8 {
	public static void main(String[] args) {
		
		q8 test = new q8();
		
		Random rd = new Random();
		int x = 6;
		int y = 6;
		int[][] matrix = new int[x][y];
				
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[i][j] = rd.nextInt(10 - 0) + 0;
			}
		}
		
		test.printMatrix(matrix, x, y);
		
		test.checkZeros(matrix, x, y);
		
		System.out.println("");
		System.out.println("Matrix with rows and columns with zeros removed:");

		
		test.printMatrix(matrix, x, y);
		
	}
	
	public void printMatrix(int[][] matrix, int length, int width){
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(matrix[i][j]);
				if (j == width-1) {
					System.out.println("");
				}
				else {
					System.out.print(" ");
				}
			}
		}	
	}
	
	public void checkZeros(int[][] matrix, int length, int width) {
		
		CoordsMap coordsMap = new CoordsMap();
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 0) {
					coordsMap.insert(i,j);
				}
			}
		}
				
		int count = 0;
		
		while (coordsMap.coordsArray[count] != null) {
			int x0 = coordsMap.coordsArray[count].getX();
			int y0 = coordsMap.coordsArray[count].getY();
			
			for (int i = 0; i < length; i++) {
				matrix[x0][i] = 0;
			}
			
			for (int i = 0; i < width; i++) {
				matrix[i][y0] = 0;
			}
			
			count++;
		}
	}
	
	public class Coords{
		int x;
		int y;
		
		Coords(int x, int  y){
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
	}
	
	public class CoordsMap{
		int size = 40;
		Coords[] coordsArray = new Coords[size];
		int arrayIndex = 0;
		
		public void insert(int x, int y) {
			coordsArray[arrayIndex] = new Coords(x, y);
			arrayIndex++;
		}
	}
}



	