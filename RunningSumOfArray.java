//Given an array nums of length n. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//Return the running sum of nums.

package arrays_problems;

import java.util.Scanner;

public class RunningSumOfArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		RunningSumOfArray(arr);
		
	}

	private static void RunningSumOfArray(int[] arr) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{	
			sum=sum+arr[i];
			System.out.print(sum+" ");
		}
	}

}
