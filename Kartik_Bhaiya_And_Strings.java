package string_arrays;

import java.util.Scanner;

public class Kartik_Bhaiya_And_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();									// max total flips--> isse jaada nhi hone chahiye
		String str=sc.next();
		int ans = maxmPerfectenessSubstringLength(str,k);
		System.out.println(ans);
	}

	private static int maxmPerfectenessSubstringLength(String str, int k) {
		// TODO Auto-generated method stub
		int maxPerfectSubstringLenA_flipB = maxLenSubstringFlip(str,k,'b');
		int maxPerfectSubstringLenB_flipA = maxLenSubstringFlip(str,k,'a');
		
		int ans = Math.max(maxPerfectSubstringLenA_flipB, maxPerfectSubstringLenB_flipA);
		
		return ans;
	}

	private static int maxLenSubstringFlip(String str, int k, char ch) {
		// TODO Auto-generated method stub
		int flip=0;								//count total flips needed
		int max_SubString_Length=0;
		int si=0;
		int ei=0;
		
		int len=0;
		
		while(ei<str.length())
		{
			//Grow the window
			if(str.charAt(ei)==ch)
				flip++;
			
			//shrink krega agr flip ki value cross ho gyi given maximum limit se (k)
			while(flip>k && si<=ei)			   // agr flip ki value bdi ho gyi maximim allowed flip se toh ye loop chlega
			{
				if(str.charAt(si)==ch)
					flip--;
				
				si++;
			}
			
			//Calculate krege max length--> jo operation krna hai woh krlege
			len=ei-si+1;
			max_SubString_Length=Math.max(max_SubString_Length, len);
//			max_SubString_Length=Math.max(max_SubString_Length, ei-si+1);
			
			ei++;
		}
		
		return max_SubString_Length;
	}

}
