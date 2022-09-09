package string;

import java.util.Scanner;

public class Strings_Max_Frequency_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		maxCharacter(str);
	}

	private static void maxCharacter(String str) {
		// TODO Auto-generated method stub
		char ch='a';
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) 
		{
			int count=1;
			for (int j = i+1; j < str.length(); j++) 
			{
				if(str.charAt(i)==str.charAt(j))
					count++;
			}
			if(max<count)
				ch=str.charAt(i);
			max=Math.max(max, count);
		}
		System.out.println(ch);
	}

}
