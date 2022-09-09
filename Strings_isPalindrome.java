package string;

import java.util.Scanner;

public class Strings_isPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean status = checkPalindrome(str);
		System.out.println(status);
	}

	private static boolean checkPalindrome(String str) {
		// TODO Auto-generated method stub
		for(int i=0, j=str.length()-1;i<j;i++,j--)
		{
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}

}
