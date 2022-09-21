package recursion;

import java.util.Scanner;

public class Replace_all_0s_with_5_CORRECTCODE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(atAtleast1Zero(n)==false)
		{
			System.out.println(n);
		}
		else
		{
		int ans = replacement(n,0);								//num...quotioent //remainder
		System.out.println(ans);
		}
	}

	private static boolean atAtleast1Zero(int n) {
		// TODO Auto-generated method stub
		while(n>0)
		{
			if(n%10==0)
				return true;
			
			n=n/10;
		}
		return false;
	}

	private static int replacement(int quotionent, int remainder) {
		// TODO Auto-generated method stub
		if(quotionent==0)
		{
			return reverse(remainder);
		}
		
		if(quotionent%10==0)
		{
//			System.out.println(quotionent+"/10"+"    "+remainder+" *10 + 5"+"=============");
			return replacement(quotionent/10, (remainder*10)+5);
		}
		else
		{
//			System.out.println(quotionent+"/10"+"    "+remainder+" *10 " + quotionent + "  %10");
			return replacement(quotionent/10, (remainder*10)+quotionent%10);
		}
		
		
//		System.out.println(remainder);
	}

	private static int reverse(int revTheRem) {
		// TODO Auto-generated method stub
		int rem=0;
		while(revTheRem>0)
		{
			rem=rem*10 + revTheRem%10;
			revTheRem/=10;
		}
		return rem;
	}

}
