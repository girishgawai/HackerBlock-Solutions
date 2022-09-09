package string;

import java.util.Scanner;

public class String_Compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(getCompression(str));
	}
	
	
	public static String getCompression(String str)
	{
		int count=1;
		String compress = new String();
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)==str.charAt(i-1))
			{
				count++;
			}
			else
			{
				compress=compress+str.charAt(i-1)+count;
				count=1;
			}
		}
		
		compress=compress+str.charAt(str.length()-1)+count;
		return compress;
	}

}
