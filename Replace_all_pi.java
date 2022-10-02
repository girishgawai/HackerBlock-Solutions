package recursion;

import java.util.Scanner;

public class Replace_all_pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.next();
		}
//		String str = "xabpixx3.15x";
//		replacement(str,"",0);
		
		for (int i = 0; i < arr.length; i++) {
			replacement(arr[i], "", 0);
		}
		
	}
	
	public static void replacement(String ques, String ans, int i)
	{
		
		if(i<ques.length()-1 && ques.charAt(i)=='p' && ques.charAt(i+1)=='i')
			replacement(ques, ans+3.14, i+2);
		else if(i<ques.length())
		{
			replacement(ques, ans+ques.charAt(i), i+1);
		}
		else
		{
			System.out.println(ans);
			return;
		}
		
	}

}
