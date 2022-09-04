package arrays_2D;

import java.util.Scanner;

public class Arrays_Spiral_Print_AntiClockwise {

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
		
		printSpiral(arr);
	}
	
	
	public static void printSpiral(int[][] arr)
	{
		int count=arr.length * arr[0].length;
		int minr=0;
		int maxr=arr.length-1;
		int minc=0;
		int maxc=arr[0].length-1;
		
		while(count>0)
		{
			int i=minc;
			for (int j = minr; count>0 && j <=maxr ; j++) {
				System.out.print(arr[j][i]+",\t");
				count--;
			}
			minc++;
			
			i=maxr;
			for (int j = minc; count>0 && j <=maxc ; j++) {
				System.out.print(arr[i][j]+",\t");
				count--;
			}
			maxr--;
			
			i=maxc;
			for (int j = maxr; count>0 && j >=minr ; j--) {
				System.out.print(arr[j][i]+",\t");
				count--;
			}
			maxc--;
			
			i=minr;
			for (int j = maxc; count>0 && j >=minc ; j--) {
				System.out.print(arr[i][j]+",\t");
				count--;
			}
			minr++;
			
		}
		
		System.out.print("END");
	}
}
