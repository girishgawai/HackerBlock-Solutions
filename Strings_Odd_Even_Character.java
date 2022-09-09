package string;

import java.util.Scanner;

public class Strings_Odd_Even_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = convertEvenOdd(str);
		System.out.println(ans);
	}

	private static String convertEvenOdd(String str) {
		// TODO Auto-generated method stub
		int count=-1;
		String ans = new String();
		for (int i = 0; i < str.length(); i++) {
			count++;
			if(count%2==0) {
				ans=ans+(char)(str.charAt(i)+1);
			}
			else
				ans=ans+(char)(str.charAt(i)-1);
		}
		return ans;
	}

}
