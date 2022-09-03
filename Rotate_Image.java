package arrays_2D;

import java.util.Scanner;

public class Rotate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();			
		int[][] arr = new int[m][m];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		Rotate_Image(arr);
	}

	private static void Rotate_Image(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] ans = new int[arr.length][arr[0].length];
		for (int i = 0, j2=0 ; i < arr.length; i++, j2++)				// Given array row
		{
			
			for (int j = 0, i2=ans.length-1; j < arr[i].length; j++, i2--)			// Given array col
			{
//				System.out.print(arr[i][j]+"\t");
				ans[i2][j2]=arr[i][j];
			}
//			System.out.println();
		}
		
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j]+"\t");
			}
			System.out.println();
		}
		
	}

}
