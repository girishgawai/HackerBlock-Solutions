package recursion;

import java.util.Scanner;

public class Generate_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int pair=sc.nextInt();
		
		printPerfectParenthesis(pair,0,0,"");				//pair-size..open brace..closing brace..ans

	}

	private static void printPerfectParenthesis(int pair, int open, int close, String ans) {
		// TODO Auto-generated method stub
		if(open==pair && close==pair)
		{
			System.out.println(ans);
			return;
		}
		
//		if(close>open)
//			return;
		
		if(close<open)
		{
			printPerfectParenthesis(pair, open, close+1, ans+")");
		}
		if(open<pair)
		{
			printPerfectParenthesis(pair, open+1, close, ans+"(");
		}
		
	}

}
