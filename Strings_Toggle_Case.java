package string;

import java.util.Scanner;

public class Strings_Toggle_Case {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = toggleTheCase(str);
		System.out.println(ans);
	}

	private static String toggleTheCase(String str) {
		// TODO Auto-generated method stub
		String ans= new String();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z')
				ans=ans+(char)(str.charAt(i)-32);
			else
				ans=ans+(char)(str.charAt(i)+32);
		}
		return ans;
	}
}
