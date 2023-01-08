package dp.qps;

import java.util.Arrays;
import java.util.Scanner;

public class _0_1_Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();						// num of items to pick
		int s = sc.nextInt();									// capacity of the bag
		
		int[] capacity = new int[n];
		for (int i = 0; i < capacity.length; i++) {				// num of items to pick with there capacities
			capacity[i] = sc.nextInt();
		}
		
		int[] bag = new int[n];									
		for (int i = 0; i < bag.length; i++) {								// cost of those items
			bag[i] = sc.nextInt();
		}

		/*************	Normal Recursion	***********/
//		int ans = knapsackMaxCostwithinCap(capacity, bag, 0, s);
		
		/*************	Top Down Recursion	***********/
		int[][] dp = new int[n][s+1];		// dp ka array capacity+1 lia ek side ka.. jb v 2 [][] ho nd kisi aur var pe depend kre toh var+1 krna
		for (int[] a: dp) {
			Arrays.fill(a, -1);
		}
		int ans = knapsackMaxCostwithinCapTD(capacity, bag, 0, s, dp);
		System.out.println(ans);
	}
	
	/*************	Top Down Recursion	***********/
	private static int knapsackMaxCostwithinCapTD(int[] capacity, int[] bag, int i, int limit, int[][] dp) {
		// TODO Auto-generated method stub
		if(limit==0)
			return 0;
		
		if(i>=capacity.length)
			return 0;							//return Integer.MIN_VALUE;
		
		int pick = 0;
		int unpick = 0;
		
		if(dp[i][limit]!=-1)				// using DP--> if already ans is available & problems overlaps just used the old ans
			return dp[i][limit];
		
		if(limit>=capacity[i])
			pick = knapsackMaxCostwithinCapTD(capacity, bag, i+1, limit-capacity[i], dp) + bag[i];	// picking it so adding curr wala item
		
		unpick = knapsackMaxCostwithinCapTD(capacity, bag, i+1, limit, dp);
		
		return dp[i][limit] = Math.max(pick, unpick);						// memorizing the ans
	}

	/*************	Normal Recursion	***********/
	private static int knapsackMaxCostwithinCap(int[] capacity, int[] bag, int i, int limit) {
		// TODO Auto-generated method stub
		if(limit==0)
			return 0;
		
		if(i>=capacity.length)
			return 0;							//return Integer.MIN_VALUE;
		
		int pick = 0;
		int unpick = 0;
		
		if(limit>=capacity[i])
			pick = knapsackMaxCostwithinCap(capacity, bag, i+1, limit-capacity[i]) + bag[i];
		
		unpick = knapsackMaxCostwithinCap(capacity, bag, i+1, limit);
		return Math.max(pick, unpick);
	}

}
