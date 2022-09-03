//  You are given two integers n and k. Find the greatest integer x, such that, x^k <= n.
//  
//  Input Format
//  First line contains number of test cases, T. Next T lines contains integers, n and k.
//  
//  Constraints
//  1<=T<=10
//  1<=N<=10^15
//  1<=K<=10^4
//  
//  Output Format
//  Output the integer x
//  
//  Sample Input
//  2
//  10000 1
//  1000000000000000 10
//  Sample Output
//  10000
//  31

package arrays_problems;

import java.util.Scanner;

public class Kth_Root {

	public static void main(String[] args) {
		//   TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)
		{
			long n = sc.nextLong();							// bcaz n i/p is bigger
			int k = sc.nextInt();

			int x = find_Kth_RootOfWhat(n,k);

			System.out.println(x);
			t--;
		}
	}

	private static int find_Kth_RootOfWhat(long n, int k) {
		// TODO Auto-generated method stub
		for (int i=1; i>0; i++) 				// ye loop infinite me dalega bt kv na kv break hoga return pe
		{
			long product=1;								//// bcaz ans of product is going to be biggest
			for(int j=1;j<=k;j++)
			{
				product = product*i;
//				System.out.println(product+" =====xxx");
			}

			if(product==n)
				return i;

			if(product>n)
				return i-1;			
		}

		return 1;									// ye unreachable part hai bs fn ka syntax bnaye rkhne k iye
	}

}
