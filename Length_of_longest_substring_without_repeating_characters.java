package string_arrays;

import java.util.Scanner;

public class Length_of_longest_substring_without_repeating_characters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		int maxLength= Length_of_longest_substring_without_repeating_characters(str);
		System.out.println(maxLength);
	}

	private static int Length_of_longest_substring_without_repeating_characters(String str) {
		// TODO Auto-generated method stub
		int count=0;
		int maxLength=0;
		int si=0;
		int ei=0;
		while(si<=ei && ei<str.length())
		{
			int tempMinusCount=0;
			for(int i=ei-1;i>=si;i--)
			{
				tempMinusCount++;
				if(str.charAt(i)==str.charAt(ei))
				{
					count=tempMinusCount-1;
//					System.out.println(count+"=="+tempMinusCount+"=="+ei+"==="+si);
					si=i+1;
					break;
				}
			}
			count++;
			maxLength=Math.max(maxLength, count);
			ei++;
		}
		
		return maxLength;
	}

}
