//It is Alex’s birthday and she wants to go shopping. She only has ‘A’ units of money and she wants to spend all of her money. However, she can only purchase one kind of item. She goes to a shop which has ‘n’ types items with prices A0,A1,A2,…,An-1. The shopkeeper claims that he has atleast ‘k’ items she can choose from. Help her find out if the shopkeeper is correct or not.

package arrays_problems;

import java.util.Scanner;

public class Alex_Goes_Shopping_CORRECTCODE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		int q=sc.nextInt();
		
		while(q>0)
		{
			int a=sc.nextInt();						// Amount
			int k=sc.nextInt();						// kind of items that can be buy
			shopping(arr,q,a,k);
			q--;
		}
	}
	
	public static void shopping(int[] arr, int q, int a, int k)
	{
//		Scanner sc = new Scanner(System.in);
		
		
		
		int sum=0;
		int item=0;
		for(int i=0;i<arr.length;i++)
		{
			if(a%arr[i]==0)
				item++;
		}
		
		if(item>=k)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
	}

}
