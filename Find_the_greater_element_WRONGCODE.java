package stack_problems;

import java.util.Scanner;
import java.util.Stack;

public class Find_the_greater_element_WRONGCODE {
												// WRONG CODE --> NOT WORKS ON CICULAR ARRAY eg. 5,4,3,2,1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
			max=Math.max(max, arr[i]);
		}
		int[] ans = new int[n];
		findGreater(arr,ans);
		
		if(arr[arr.length-1]<max)				// circular array hai isliye last element ki v checking hongi array ke sare elements ke sath
			ans[ans.length-1]=max;
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}
	}

	private static void findGreater(int[] arr, int[] ans) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) 
		{
			while(!st.isEmpty() && arr[i]>arr[st.peek()])
			{
				ans[st.pop()]= arr[i];
			}
			st.push(i);
		}
		
		while(!st.isEmpty())
		{
			ans[st.pop()]=-1;
		}
		
	}

}
