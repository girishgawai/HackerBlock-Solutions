package recursion;

import java.util.Scanner;

public class N_Queen {
	static int noOfWays=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		int n = 4;
		int n = sc.nextInt();
		boolean[][] board = new boolean[n][n];
		fixDQueen(board,0,n);
		System.out.println(noOfWays);
	}

	private static void fixDQueen(boolean[][] board, int row, int tnq) {
		// TODO Auto-generated method stub
		if(tnq==0)
		{
//			display(board);
//			System.out.println();
			noOfWays++;
			return;
		}
		
		for (int col = 0; col < board.length; col++) 
		{
			if(areQueensSafe(board,row,col)==true)
			{
				board[row][col]=true;
				fixDQueen(board, row+1, tnq-1);
				board[row][col]=false;
			}
			
		}
		
	}

	private static boolean areQueensSafe(boolean[][] board, int row, int col) {
		// TODO Auto-generated method stub
		// upper side
		int r=row;
		while(r>=0)
		{
			if(board[r][col]==true)
				return false;
			r--;
		}
		
		// right upper side diagonal
		r=row;
		int c=col;
		while(r>=0 && c<board.length)
		{
			if(board[r][c]==true)
				return false;
			r--;
			c++;
		}
		
		// left upper side diagonal
		r=row;
		c=col;
		while(r>=0 && c>=0)
		{
			if(board[r][c]==true)
				return false;
			r--;
			c--;
		}
		
		return true;
	}
	
	private static void display(boolean[][] board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
