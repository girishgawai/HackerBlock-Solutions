package bitmasking;

import java.util.Scanner;

public class Playing_With_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int q = sc.nextInt();
		while(q>0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(countSetBitsBet_a_b(a,b));			
			
			q--;
		}
	}

	private static int countSetBitsBet_a_b(int a, int b) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for( ; a<=b; a++)
		{
			int temp = a;
			while(temp!=0)
			{
				count++;
				temp = temp & (temp-1);
			}
		}
		
		return count;
	}
}
