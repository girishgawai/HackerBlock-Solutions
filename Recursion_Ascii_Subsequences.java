package recursion;

import java.util.Iterator;
import java.util.Scanner;

public class Recursion_Ascii_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		subSequence(str, "", "", 0);
		
		System.out.println();
		int count = count_subSequence(str, "", "", 0);
		System.out.println(count);
	}


	private static void subSequence(String que, String temp, String ans, int i) {
		// TODO Auto-generated method stub
		if(i==que.length())
		{
			System.out.print(ans + "\t");
			return;
		}

		subSequence(que, temp+que.charAt(i), ans, i+1);						// yeh subsequence bnayega kisko v naa lekr

		subSequence(que, temp+que.charAt(i), ans+que.charAt(i), i+1);		// yeh subsequence bnayega character string wale char ko lekr
		
		subSequence(que, temp, ans+(int)que.charAt(i), i+1);			// yeh subsequence bnayega ascii values ko lekr ek ek char ki

	}

	private static int count_subSequence(String que, String temp, String ans, int i) {
		// TODO Auto-generated method stub
		if(i==que.length())
		{
//			System.out.print(ans + "\t");
			return 1;
		}

		int a = count_subSequence(que, temp+que.charAt(i), ans, i+1);						// yeh subsequence bnayega kisko v naa lekr

		int b = count_subSequence(que, temp+que.charAt(i), ans+que.charAt(i), i+1);		// yeh subsequence bnayega character string wale char ko lekr
		
		int c = count_subSequence(que, temp, ans+(int)que.charAt(i), i+1);			// yeh subsequence bnayega ascii values ko lekr ek ek char ki

		return a+b+c;
	}

	

}
