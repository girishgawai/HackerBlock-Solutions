package string_arrays;

import java.util.Scanner;

public class Form_minimum_number_from_given_Sequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = new String();

		while(n>0)
		{
			str=sc.next();
			minNumber(str);
			System.out.println();
			n--;
		}
	}

	private static void minNumber(String str) {
		// TODO Auto-generated method stub
		int[] ans = new int[str.length()+1];

		int num=1;
		for (int i = 0; i <= str.length(); i++) 
		{
			if(i==str.length() || str.charAt(i)=='I')
			{
				ans[i]=num;
				num++;

				for (int j = i-1; j >=0  && str.charAt(j)=='D'; j--) 
				{
					ans[j]=num;
					num++;
				}
			}


		}


		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]);
		}

	}
}
