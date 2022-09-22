package recursion;

import java.util.Scanner;

public class Nth_Triangle_Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		findNthTriangle(n,1,0);
	}

	private static void findNthTriangle(int n, int time, int ans) {
		// TODO Auto-generated method stub
		if(n==0)
		{
			System.out.println(ans);
			return;
		}
		
		findNthTriangle(n-1,time+1,ans+time);
		
	}

}
