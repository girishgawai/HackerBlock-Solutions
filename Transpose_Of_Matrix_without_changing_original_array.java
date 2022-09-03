package arrays_2D;

import java.util.Scanner;

public class Transpose_Of_Matrix_without_changing_original_array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			//matrix axb
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int[][] ans = display(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		
	}

	private static int[][] display(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] ans = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr[0].length; j++) {
				ans[i][j]=arr[j][i];
				ans[j][i]=arr[i][j];
			}
		}

		return ans;
	}
}
