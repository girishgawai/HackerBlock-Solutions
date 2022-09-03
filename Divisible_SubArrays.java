//You are given N elements, a1,a2,a3….aN. Find the number of good sub-arrays.
//A good sub-array is a sub-array [ai,ai+1,ai+2….aj] such that (ai+ai+1+ai+2+….+aj) is divisible by N.
//
//
//
//Input Format
//The first line contains the number of test cases T. First line of each test case contains an integer N denoting the number of elements. Second line of each test case contains N integers, a1, a2, a3….aN, where ai denotes the ith element of the array.
//
//Constraints
//1<=T<=10
//1<=N<=10^5
//|ai|<=10^9
//
//Output Format
//Output a single integer denoting the number of good sub-arrays.
//
//Sample Input
//2
//5
//1 1 1 1 1
//5
//5 5 5 5 5
//Sample Output
//1
//15
//Explanation
//In first test case, there is only one sub-array [1, 1, 1, 1, 1], such that 1+1+1+1+1=5, which is divisible by N=5

package arrays_problems;

import java.util.Scanner;

public class Divisible_SubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			System.out.println(checkGoodSubArray(arr));
			t--;
		}




	}

	private static long checkGoodSubArray(int[] arr) {
		// TODO Auto-generated method stub
		int n=arr.length;
		long[] freq = new long[n];
		long sum=0;
		freq[0] = 1;
		for (int i = 0; i < arr.length; i++)
		{
			sum = sum+arr[i];
			int idx = (int) (sum%n);
			if(idx<0)
				idx=idx+n;
			freq[idx] = freq[idx]+1;					
		}

		long ans=0;
		for (int i = 0; i < freq.length; i++)
		{
			if(freq[i]>=2)
			{
				long pointer=freq[i];
				ans = ans + (pointer *(pointer-1))/2;
			}
		}
		
		return ans;
	}

}
