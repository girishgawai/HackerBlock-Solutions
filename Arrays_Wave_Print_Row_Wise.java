package arrays_2D;

import java.util.Scanner;

public class Arrays_Wave_Print_Row_Wise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();			//matrix ax
		int n = sc.nextInt();			//matrix b
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		printWave(arr);
	}

	private static void printWave(int[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) 
		{
			if(i%2==0)
			{
				for (int j=0 ; j<arr[i].length ; j++) 
				{
					System.out.print(arr[i][j]+",\t");
				}
			}
			else
			{

				for (int j=arr[i].length-1;j>=0; j--) 
				{
					System.out.print(arr[i][j]+",\t");
				}
			}
		}
		System.out.print("END");
	}

}
