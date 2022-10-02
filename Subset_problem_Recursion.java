package recursion;

import java.util.Scanner;

public class Subset_problem_Recursion {
	
	static int count=0;						// ye sbse frst time ans print krte time notify krega jb space print krni rhegi sirf frst time
	static int subsetForm=0;					// to calculate total subset form to form target sum
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int target=sc.nextInt();
		String ans = new String();
		subsetSum(arr,target,0,0,ans,0);
		System.out.println("\n"+subsetForm);
	}

	private static void subsetSum(int[] arr, int target, int sum, int index, String ans, int last) {
		// TODO Auto-generated method stub
		if(index==arr.length)
			return;
		
		if(sum==target)
		{
			if(count==0)		// woh agr frst time ans print kr rhe toh hi space nhi print krani frst me isliye liya
			{
				System.out.print(ans.substring(1)+" ");				// sirf ek hi br chlega yeh statement in begining
				count++;											// ek br chlne pe space avoid krne pe count bdhega ab wapis nhi ayega
			}
			else													// ab hmesh apsce print hoga new ans ke phle me add hue huye
			{
				System.out.print(ans+" ");
			}	
			
			subsetForm++;
			return;
		}
		
		for (int i = last; i < arr.length; i++) {
			
//			if(i==0)
//				subsetSum(arr, target, sum+arr[i], index+1, ans+arr[i], i+1);
//			else
				subsetSum(arr, target, sum+arr[i], index+1, ans+" "+arr[i], i+1);
		}
	}

}
