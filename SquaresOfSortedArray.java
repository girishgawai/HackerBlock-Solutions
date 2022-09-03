//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

package arrays_problems;

import java.util.Scanner;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		SquaresOfArray(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"  ");
		}
	}

	private static void SquaresOfArray(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			arr[i]=arr[i]*arr[i];
		}
		SquaresOfSortedArray(arr);
	}

	public static void SquaresOfSortedArray(int[] arr)
	{
		int temp=0;
		for(int i=0;i<arr.length;i++)
		{
			temp=0;
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
}
