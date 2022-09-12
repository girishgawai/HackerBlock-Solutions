package string_arrays;

import java.util.Scanner;

public class Non_Repeating_Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			String str= sc.next();
			System.out.println(firstNonRepeatingChar(str));
		}
	}

	// this logic will be fail.. jb 2 charcaters same same side by side aaye...   "abbac"
	//	public static void firstNonRepeatingChar(String str)
	//	{
	//		for (int i = 0; i < str.length(); i++) {
	//			int count=0;
	//			for (int j = i; j < str.length(); j++) {
	//				if(str.charAt(i)==str.charAt(j))
	//				{
	//					count++;
	//				}	
	//			}
	//			
	//			if(count==1)
	//			{
	//				System.out.println(str.charAt(i));
	//				break;
	//			}
	//				
	//		}
	//	}

	
	public static String firstNonRepeatingChar(String str)
	{
		int flag=0;
		char ch='a';
		int matchingNum=0;
		for (int i = 0; i < str.length(); i++) {
			int countOfChar=0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(i)==str.charAt(j))
				{
					matchingNum++;
					countOfChar++;
				}	
			}

			if(countOfChar==1 && flag==0)
			{
				ch=str.charAt(i);
				flag=1;
			}

		}
		
		if(flag==1 && matchingNum>str.length())
			return ch+"";
		
		return -1+"";
	}
}
