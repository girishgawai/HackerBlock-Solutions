package string;

import java.util.Scanner;

public class Playing_with_Good_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int ans = checkGoodString(str);
		System.out.println(ans);
	}

	private static int checkGoodString(String str) {
		// TODO Auto-generated method stub
		int count=0,max=0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int f=0;
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				f=1;
				count++;
			}
			if(f==0)
				count=0;
			max = Math.max(max, count);
		}
		return max;
	}

}
