package recursion;

import java.util.Scanner;

public class All_Indices_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int target=sc.nextInt();
		
		boolean[] ans = new boolean[n];
		ans = find(arr,0,target,ans);
		
		for (int i = 0; i < ans.length; i++) {
			if(ans[i]==true)
				System.out.print(i+"\t");
		}
	}

	private static boolean[] find(int[] arr, int i, int target, boolean[] ans) {
		// TODO Auto-generated method stub
		if(i==arr.length)
			return ans;
		
		if(arr[i]==target)
			ans[i]=true;
		
		return find(arr, i+1, target, ans);
		
		
	}

}
