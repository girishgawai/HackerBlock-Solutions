package recursion;

import java.util.Scanner;

public class Split_array_Recursion {

	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		STA(arr,0,0,"",0,"");				// arr[], index, sum1 one side, ans1 one side, sum2 second sode, ans2 second side
	
		System.out.println(count);
	}

	private static void STA(int[] arr, int i, int sum1, String ans1, int sum2, String ans2) {
		// TODO Auto-generated method stub
		if(i==arr.length)
		{
			if(sum1==sum2)	   // kyu ki initial stage me sum1 aur sum2 ki val 0 haitoh woh yhi se return krdega nd code kv chlega hi nhi
			{															// isliye isko bahr ke if statement ke undr rkha
				count++;
				System.out.println(ans1 + "and " + ans2);
			}
			
			return;
		}


		STA(arr, i+1, sum1+arr[i], ans1+arr[i]+" ", sum2, ans2);

		STA(arr, i+1, sum1, ans1, sum2+arr[i], ans2+arr[i]+" ");

	}

}
