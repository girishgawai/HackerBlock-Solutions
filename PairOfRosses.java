package arrays_problems;

import java.util.Scanner;

public class PairOfRosses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) 
			{
				arr[i]=sc.nextInt();
			}

			int limit = sc.nextInt();

			buyRose(arr,limit);
			t--;
		}

	}

	private static void buyRose(int[] arr, int limit) {
		// TODO Auto-generated method stub
		int diff=1000001;
		int m1=0,m2=0;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==limit)
				{
					if(arr[i]>arr[j])
					{	if(diff>arr[i]-arr[j])
						{
							diff=arr[i]-arr[j];
							m1=arr[i];
							m2=arr[j];
						}
					}
					else
					{
						if(diff>arr[j]-arr[i])
						{
							diff=arr[j]-arr[i];
							m1=arr[j];
							m2=arr[i];
						}
					}
						
				}
			}
		}
		System.out.println("Deepak should buy roses whose prices are "+m2+" and "+m1+".");
	}

}
