package arrays_problems;

import java.util.Scanner;

public class MaximumValueInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		System.out.println(maximumValueInArray(arr));

	}

	public static int maximumValueInArray(int[] arr)
	{
		int max=arr[0];
		for(int j=1;j<arr.length;j++)
		{
			if(max<arr[j])
				max=arr[j];
		}
		return max;
	}
}
