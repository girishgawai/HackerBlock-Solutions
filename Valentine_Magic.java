package dp.qps;

import java.util.Arrays;
import java.util.Scanner;

public class Valentine_Magic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int g = sc.nextInt();
		
		int[] boys_choclate = new int[b];
		for (int i = 0; i < boys_choclate.length; i++) {
			boys_choclate[i] = sc.nextInt();
		}
		int[] girls_candy = new int[g];
		for (int i = 0; i < girls_candy.length; i++) {
			girls_candy[i] = sc.nextInt();
		}
		
		// sorting bcaz so that previously occurring boygirl can make pair.. so possibly min absolute diff be obtained so
		Arrays.sort(boys_choclate);
		Arrays.sort(girls_candy);
		
		// Normal Recursion
//		System.out.println(makeMinDiffPair(boys_choclate,girls_candy,0,0));
		
		// Bottom UP Approach
		
				
		// Using DP --> Top Down Approach
		int[][] dp = new int[b][g];
		// but ans can be 0 as well.. so filliing array default values with -1
		for(int[] a : dp)
		{
			Arrays.fill(a, -1);
		}
		System.out.println(makeMinDiffPair(boys_choclate,girls_candy,0,0,dp));
	}

	// Using DP --> Bottom UP Approach

	// Using DP --> Top Down Approach
	private static int makeMinDiffPair(int[] boys_choclate, int[] girls_candy, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		// agr ldke khtm ho gye mtlb sare pairs bn chuke hai.. aur koi bnna baki nhi so Return 0
		if(boys_choclate.length==i)
		{
			return 0;
		}
		
		// agr ldki hi khtm ho gyi.. aur ldke bche hi hai pairing krne ke--> uss case me sbse max value return krdege.. bcaz hme 
					// compare krke lena hai sbse min diff wale.. bt Integer.Max_Value nh lege.. bcaz MaxVal+ANYTHING range k bahr hoga
		if(girls_candy.length==j)
		{
			return 105154445;
		}
		
		if(dp[i][j]!=-1)
			return dp[i][j];
		
		// 2 choices hai.. pair bnayega ldka .. pair nh bnayega dusri ldki pe jayega
		int paired = makeMinDiffPair(boys_choclate, girls_candy, i+1, j+1,dp) + Math.abs(boys_choclate[i]-girls_candy[j]);
		int unpair = makeMinDiffPair(boys_choclate, girls_candy, i, j+1,dp);		// agr pair nh bnayi boy ne.. toh next girl pe jayega phle grl ko skip krke
																						// boy whi rhega bs agli girl dekhega		
		//dono me se jo sbse cum abs diff wali sum pair lakr dega usko krege return
		return dp[i][j] = Math.min(paired, unpair);
		
	}
	
	
	private static int makeMinDiffPair(int[] boys_choclate, int[] girls_candy, int i, int j) {
		// TODO Auto-generated method stub
		// agr ldke khtm ho gye mtlb sare pairs bn chuke hai.. aur koi bnna baki nhi so Return 0
		if(boys_choclate.length==i)
		{
			return 0;
		}
		
		// agr ldki hi khtm ho gyi.. aur ldke bche hi hai pairing krne ke--> uss case me sbse max value return krdege.. bcaz hme 
					// compare krke lena hai sbse min diff wale.. bt Integer.Max_Value nh lege.. bcaz MaxVal+ANYTHING range k bahr hoga
		if(girls_candy.length==j)
		{
			return 1000000;
		}
		
		// 2 choices hai.. pair bnayega ldka .. pair nh bnayega dusri ldki pe jayega
		int paired = makeMinDiffPair(boys_choclate, girls_candy, i+1, j+1) + Math.abs(boys_choclate[i]-girls_candy[j]);
		int unpair = makeMinDiffPair(boys_choclate, girls_candy, i, j+1);		// agr pair nh bnayi boy ne.. toh next girl pe jayega phle grl ko skip krke
																				// boy whi rhega bs agli girl dekhega
		//dono me se jo sbse cum abs diff wali sum pair lakr dega usko krege return
		return Math.min(paired, unpair);
		
	}

}
