package string;

import java.util.Scanner;

public class Strings_Remove_Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		String ans = removeDuplicates(str);
		System.out.println(ans);
	}

	public static String removeDuplicates(String str)
	{
		String ans=new String();
		ans=ans+str.charAt(0);
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)!=str.charAt(i-1))
				ans=ans+str.charAt(i);
		}
		return ans;
	}
}
