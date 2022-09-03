package arrays_problems;

import java.util.Scanner;

public class FindSqrt_UsingBinarySearchAlgo_without_Lib_Fun2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int sq = findSquareRootOf(n);
		System.out.println(sq);
	}
	
	
	public static int findSquareRootOf(int n)
	{
		int[] sq=new int[n/2];
		for(int i=0;i<sq.length;i++)
			sq[i]=i*i;
		
		int low=0,high=sq.length-1,mid=0;
		for(int i=0;i>=0 && low<=high;i++)
		{
			mid=(low+high)/2;
			
			if(sq[mid]==n)
				return mid;
			else if(sq[mid]>n)
				high=mid-1;
			else
				low=mid+1;
		}
		
		return high;
	}

}
