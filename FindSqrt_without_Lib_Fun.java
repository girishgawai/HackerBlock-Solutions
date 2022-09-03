package arrays_problems;

import java.util.Scanner;

public class FindSqrt_without_Lib_Fun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		
		int sq = findSquareRootOf(n);
		System.out.println(sq);
	}
	
	
	public static int findSquareRootOf(int n)
	{
		if(n==0)
			return 0;
		
		int i=0, sq=0;
		for(i=0;sq<n;i++)
		{
			sq=i*i;
			if(sq==n)
				return i;
		}
		
		i-=2;
		return i;
	}

}
