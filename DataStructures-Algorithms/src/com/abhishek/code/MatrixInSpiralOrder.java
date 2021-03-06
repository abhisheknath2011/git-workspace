package com.abhishek.code;

/**
 * @author Abhishek Nath
 * The program prints the given matrix in spiral order
 *
 */

public class MatrixInSpiralOrder {

	public static void main(String[] args) {
		int matrix [][] = {{1, 2, 3, 4, 5},
				   {16,17,18,19, 6},
				   {15,24,25,20, 7},
				   {14,23,22,21, 8},
				   {13,12,11,10,9}};
		printInSpiralOrder(matrix);

	}
	
	public static void printInSpiralOrder(int matrix [][]) {
		// Initialize row size and column size
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		// counter to keep track of total elements
		int count = 0;
		// 4 pointers to keep track of right, down, left and up position
		int right = colSize-1;
		int down = rowSize-1;
		int left = -1;
		int up = 0;
		// Iterate through the matrix elements
		while(count < rowSize*colSize) {
			// Increment left and move from left to right
			left+=1; 
			for(int i=left;i<=right;i++) {
				System.out.print(matrix[left][i]+" ");
				++count;
			}
			// Increment up and go from up to down
			up+=1;
			for(int i=up;i<=down;i++) {
				System.out.print(matrix[i][right]+" ");
				++count;
			}
			// Decrement right and go from right to left
			right-=1;
			for(int i=right;i>=left;i--) {
				System.out.print(matrix[down][i]+" ");
				++count;
			}
			// Decrement down and go from down to up
			down-=1;
			for(int i=down;i>=up;i--) {
				System.out.print(matrix[i][left]+" ");
				++count;
			}
		}
	}

}
