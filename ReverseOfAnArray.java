//Take as input N, the size of array. Take N more inputs and store that in an array. Write a function that reverses the array. Print the values in reversed array.


package arrays_problems;

import java.util.Scanner;

public class ReverseOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		ReverseOfAnArray(n,arr);
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	public static void ReverseOfAnArray(int n, int[] arr)
	{
		int temp=0;
		for(int i=0,j=n-1;i<j;i++,j--)
		{
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}

}
