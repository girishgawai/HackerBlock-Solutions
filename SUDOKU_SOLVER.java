package recursion;

import java.util.Iterator;
import java.util.Scanner;

public class SUDOKU_SOLVER {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j]=sc.nextInt();
			}
		}

		solveSudo(grid,0,0);
		//		displayGrid(grid);

	}

	private static void solveSudo(int[][] grid, int col, int row) {
		// TODO Auto-generated method stub
		if(col==grid[0].length)
		{
			row++;
			col=0;
		}

		if(row==grid.length)
		{
			displayGrid(grid);
			return;
		}

		if(grid[row][col]!=0)													// agr already element hai wha toh next col pe dekho
			solveSudo(grid, col+1, row);
		else																	// agr cell empty hai toh put kro value
		{
			for (int value = 1; value < 10; value++) {							// value 1 - 9 tk rkhni hai
				if(isItPossible(grid,value,row,col)==true)								// agr val rkhna possible hai toh
				{
					grid[row][col]=value;										// value rkh diye
					solveSudo(grid, col+1, row);											// next cell pe jayege ab rkhne ke baad
					grid[row][col]=0;						// agr val rkhne se baat nh bni us value ko jisko rkhe firse empty krdo
				}
			}
		}


	}

	private static boolean isItPossible(int[][] grid, int value, int row, int col) {
		// TODO Auto-generated method stub
		// checking in row
		for (int c = 0; c < grid.length; c++) {
			if(grid[row][c]==value)
				return false;
		}

		// checking in column
		for (int r = 0; r < grid.length; r++) {
			if(grid[r][col]==value)
				return false;
		}

		// checking in inner matrix grid
		int r=row - row%3;						// uss jgah jha pe value rkhni hai uska internal grid matrix ki first location find krne
		int c=col- col%3;						// row and col nikale iss formula se.. %3 kia kyu ki internal matrix 3x3 ka tha
		for (int i = r; i < r+3 ; i++) {				// r+3 c+3 kia kyu ki starting point/cell se uss inner matrix me uska jitna suize
			for (int j = c; j < c+3; j++) {						// hai woh nikalne nd usime inner matrix me ghune ke liye
				if(grid[i][j]==value)
					return false;
			}
		}

		return true;
	}

	private static void displayGrid(int[][] grid) {
		// TODO Auto-generated method stub
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				System.out.print(grid[row][col] + "\t");
			}
			System.out.println();
		}

	}

}
