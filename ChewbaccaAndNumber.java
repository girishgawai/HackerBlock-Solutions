//Luke Skywalker gave Chewbacca an integer number x. Chewbacca isn't good at numbers but he loves inverting digits in them. Inverting digit t means replacing it with digit 9 - t.
//
//Help Chewbacca to transform the initial number x to the minimum possible positive number by inverting some (possibly, zero) digits. The decimal representation of the final number shouldn't start with a zero.

import java.util.Scanner;

public class ChewbaccaAndNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong();						//input datype taken long bcaz given in qstn
		
		long mult=1,rem=0,sum=0;
		while(n>0)			// n!=9 ==> bcaz we dont want leading 9.. if starting is 9 the  												// keep it as it is
		{
			rem=n%10;
			if((9-rem<rem) && n!=9)
			{
				rem=9-rem;
			}
			
			sum=sum+(rem*mult);
			mult=mult*10;
			
			n=n/10;
		}
		
		System.out.println(sum);

	}

}
