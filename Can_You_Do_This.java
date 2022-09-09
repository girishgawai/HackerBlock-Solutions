package string;

import java.util.Scanner;

public class Can_You_Do_This {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		divideCamelCase(str);
	}
	
	
	public static void divideCamelCase(String str)
	{
		String ans = new String();
		ans=ans+str.charAt(0);
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)>='A' && str.charAt(i)<='Z')
			{
				System.out.println(ans);
				ans ="";
			}
			
			ans=ans+str.charAt(i);
		}
		System.out.println(ans);						 // to print final string ans jo loop end hone 
															// pe store hai value usko print krne ke liye
	}
}
