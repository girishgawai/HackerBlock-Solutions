package arrays_optimized.codes;

import java.util.Scanner;

public class Trapping_Rain_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<arr.length;i++)
			{
				arr[i]=sc.nextInt();
			}

			System.out.println(Trapping_Rain_Water(arr));
			t--;
		}
	}


	public static int Trapping_Rain_Water(int[] arr)
	{
		int[] left = new int[arr.length];		// contains left side most greatest / maxm num (ht. of bulding)
		left[0]=arr[0];
		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(arr[i], left[i-1]);
		}

		int[] right = new int[arr.length];		// contains right side most greatest / maxm num (ht. of bulding)
		right[right.length-1] = arr[arr.length-1];
		for(int i=right.length-2;i>=0;i--)
		{
			right[i] = Math.max(arr[i], right[i+1]);
		}

		int sum=0;
		for(int i=0;i<left.length;i++)
			sum=sum + Math.min(left[i], right[i])-arr[i];

		return sum;
	}

}
