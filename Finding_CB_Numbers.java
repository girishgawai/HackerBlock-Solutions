package string;

import java.util.Scanner;

public class Finding_CB_Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String str=sc.next();
		
		printSubString(str);
		
	}

	private static void printSubString(String str) {
		// TODO Auto-generated method stub
		boolean[] vis= new boolean[str.length()];				// default values sare false store rhte hai isme
		int count=0;											// counts the total CB numbers
		for (int len = 1; len <= str.length(); len++)
		{
			for(int j=len;j<=str.length();j++)
			{
				int i=j-len;							// since, j-i=len
				String s = str.substring(i,j);
//				System.out.println(s);					// prints all the substrings
				
				long num = Long.parseLong(s);
				if(isCBNumber(num)==true && isVisited(i, j-1, vis))
				{
//					System.out.println(num);				// yeh dikhayega CB Number
					count++;
					for (int k = i; k < j; k++) 	// agr CB num hai and visited hai toh hi loop chlega					{
					{
						vis[k]=true;						// yeh mark krdega visited numbers ki loc ko
					}
				}
					
			}	
		}
		
		System.out.println(count);
	}
	
	
	public static boolean isCBNumber(long n)
	{
		if(n==0 || n==1)
			return false;
		
		int[] arr = {2,3,5,7,11,13,17,19,23};
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i]==n)
				return true;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(n%arr[i]==0)
				return false;
		}
		
		return true;	
	}
	
	
	public static boolean isVisited(int i, int j, boolean[] vis)
	{
		for (int k = i; k <=j ; k++) {
			if(vis[k]==true)
				return false;
		}
		
		return true;
	}
	
}
