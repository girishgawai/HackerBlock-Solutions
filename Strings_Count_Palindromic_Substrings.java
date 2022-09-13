package string_arrays;

import java.util.Scanner;

public class Strings_Count_Palindromic_Substrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		Count_Palindromic_Substrings(str);
	}

	private static void Count_Palindromic_Substrings(String str) {
		// TODO Auto-generated method stub
		int count=0;
		for (int fix = 0; fix < str.length(); fix++) 
		{
			for (int end = str.length()-1; end>fix; end--)
			{
				if(str.charAt(end)==str.charAt(fix))
				{
					int f=0;
					for (int si = fix, ei=end; si<ei; si++,ei--)
					{
						if(str.charAt(si)!=str.charAt(ei))
							f=1;
					}
					if(f==0)
						count++;
					
				}
			}
			
		}
		
		System.out.println(count+str.length());
	}

}
