package recursion;

import java.util.Scanner;

public class Generate_Binary_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();

		while(t-->0)
		{
			String str=sc.next();
			generateBinary(str,"",0);
			System.out.println();
		}
//		System.out.println(t);
	}

	private static void generateBinary(String str, String ans, int i) {
		// TODO Auto-generated method stub
		if(i==str.length())
		{
			System.out.print(ans + "\t");
			return;
		}

		if(str.charAt(i)=='?')
		{
			generateBinary(str, ans+0, i+1);
			generateBinary(str, ans+1, i+1);
		}
		else
			generateBinary(str, ans+str.charAt(i), i+1);

	}

}
