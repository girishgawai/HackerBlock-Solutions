package string;

import java.util.Scanner;

public class Strings_Difference_in_Ascii_Codes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		asciiDiffBetChar(str);
	}

	private static void asciiDiffBetChar(String str) {
		// TODO Auto-generated method stub
		String ans=new String();
		for(int i=1;i<str.length();i++)
		{
			ans=ans+str.charAt(i-1)+(str.charAt(i)-str.charAt(i-1));
		}
		ans=ans+str.charAt(str.length()-1);
		System.out.println(ans);
	}

}
