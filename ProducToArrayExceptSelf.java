package arrays_optimized.codes;

import java.util.Scanner;

public class ProducToArrayExceptSelf {
	// with O(N)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] arr = new long[n];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextLong();
		}
		
		ProducToArrayExceptSelf(arr,n);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	private static long[] ProducToArrayExceptSelf(long[] arr, int n) {
		// TODO Auto-generated method stub
		long[] left = new long[n];
		long[] right = new long[n];
		
		left[0]=1;
		for (int i = 1; i < left.length; i++) {
			left[i]=left[i-1]*arr[i-1];
		}

		right[n-1]=1;
		for (int i = n-2; i>=0 ; i--) {
			right[i]=right[i+1]*arr[i+1];
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = left[i] * right[i];
		}
		
		return arr;
	}

}
