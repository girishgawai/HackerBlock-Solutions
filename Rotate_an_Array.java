package arrays_problems;

import java.util.Scanner;

public class Rotate_an_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		int rotate=sc.nextInt();

		Rotate_an_Array(arr,rotate);

		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}

	private static void Rotate_an_Array(int[] arr, int rotate) {
		// TODO Auto-generated method stub

		while(rotate>0)
		{
			int temp=arr[arr.length-1];
			for(int i=arr.length-2;i>=0;i--)
			{
				arr[i+1]=arr[i];
			}
			arr[0]=temp;
			
			rotate--;
		}
	}

}
