/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath
 *
 */
public class CountIslandInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int matrix[][]=  new int[][] {{1, 1, 0, 0, 0},
            						  {0, 1, 0, 0, 1},
            						  {1, 0, 0, 1, 1},
            						  {0, 0, 0, 0, 0},
            						  {1, 0, 1, 0, 1}};
        int count = countIslands(matrix);
        System.out.println("Island Count : "+count);

	}
	
	private static boolean isValidCell(int rowSize, int colSize, int row, int col) {
		if(row >=0 && col >=0 && row < rowSize && col < colSize) {
			return true;
		}
		return false;
	}
	
	private static int DFS(int matrix[][], int row, int col, Boolean isVisited [][], int size) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		int cellRowPos [] = {-1, -1, -1, 0, 0, 1, 1, 1};
		int cellColPos [] = {-1, 0, 1, -1, 1, -1, 0, 1};
		isVisited[row][col] = true;
		int count = 0;
		for(int i=0;i<8;i++) {
			int rowPos = row + cellRowPos[i];
			int colPos = col + cellColPos[i];
			if(isValidCell(rowSize, colSize, rowPos, colPos)) {
				if(!isVisited[rowPos][colPos] && matrix[rowPos][colPos] == 1) {
					count++;
					size = DFS(matrix, rowPos, colPos, isVisited, size + 1);
				}
			}
		}
		return size;
	}
	
	private static int countIslands(int matrix[][]) {
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		Boolean isVisited [][] = new Boolean[rowSize][colSize];
		for(int i=0;i<rowSize;i++) {
			for(int j=0;j<colSize;j++) {
				isVisited[i][j] = false;
			}
		}
		int count = 0;
		int maxSizeIsland = 0;
		for(int i=0;i<rowSize;i++) {
			for(int j=0;j<colSize;j++) {
				if(matrix[i][j] == 1 && !isVisited[i][j]) {
					count++;
					int islandSize = DFS(matrix, i, j, isVisited, 1);
					if(maxSizeIsland < islandSize) {
						maxSizeIsland = islandSize;
					}
				}
			}
		}
		System.out.println("Max Size Island : "+maxSizeIsland);
		return count;
	}

}
