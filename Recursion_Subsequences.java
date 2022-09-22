package recursion;

import java.util.Scanner;

public class Recursion_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int count = countSubSeq(str,"");
		System.out.println("\n"+count);
	}

	private static int countSubSeq(String que, String ans) {
		// TODO Auto-generated method stub
		if(que.length()==0)
		{
			System.out.print(ans + "\t");
			return 1;
		}
		
		char ch = que.charAt(0);
		int s1 = countSubSeq(que.substring(1), ans);
		int s2 = countSubSeq(que.substring(1), ans+ch);
		return s1+s2;
	}

}
