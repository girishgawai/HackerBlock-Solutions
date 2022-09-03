package arrays_problems;

import java.util.Scanner;

public class Maximum_Circular_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			System.out.println(maxCircularSum(arr));
			t--;
		}
	}

	private static int maxCircularSum(int[] arr) {
		// TODO Auto-generated method stub
		int linearSum=kadane(arr);				// max sub array ki sum...
		
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum=sum+arr[i];							// pure array ke elements ki sum
			arr[i]=arr[i]*(-1);						// sare element ko invert kro... + ko - and  - ko +
		}
		
		int invertedArraySum= kadane(arr);		// inverted array ki max sum.. means jo part chut gya tha -ve woh 													+ve bnke uski sum..
		
		int circularArraySum = invertedArraySum+sum;		//ab circular ring bnne ke liye inverted -ve part ki 															plus pure array element kis sum jo bnegi circular sum
		
		return Math.max(linearSum, circularArraySum);		// circular ya linear array sum se jo max sum hogi 																woh return krdo and hoga whi
		
	}
	
	
	private static int kadane(int[] arr) {
		// TODO Auto-generated method stub
		int sum=0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			sum=sum+arr[i];
			maxSum=Math.max(maxSum, sum);
			if(sum<0)
				sum=0;
		}
		
		return maxSum;
	}

}
