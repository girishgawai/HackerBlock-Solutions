package arrays_problems;

import java.util.Scanner;

public class Arrays_TargetSumPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		int target=sc.nextInt();
		targetSum(arr,target);

	}

	public static void targetSum(int[] arr, int target)
	{
		for(int j=0;j<arr.length;j++)
		{
			for(int i=j+1;i<arr.length;i++)
			{
//				if(i==arr.length)
//					break;
				
				if(arr[i]+arr[j]==target)
				{
					if(arr[i]>arr[j])
						System.out.println(arr[j]+" and "+arr[i]);
					else
						System.out.println(arr[i]+" and "+arr[j]);
				}
			}
			
		}

	}

}
