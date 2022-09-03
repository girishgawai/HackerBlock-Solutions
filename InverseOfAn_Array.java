package arrays_problems;

import java.util.Scanner;

public class InverseOfAn_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		InverseOFArray(arr);
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"         ");
	}

	private static void InverseOFArray(int[] arr) {
		// TODO Auto-generated method stub
		int temp=0;
		for(int i=0,j=arr.length-1;i<j;i++,j--)
		{
			if(i==arr[i])
				i++;
			if(j==arr[j])
				j--;
			
			if(i>=j)
			{
				break;
			}
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			
		}

	}

}
