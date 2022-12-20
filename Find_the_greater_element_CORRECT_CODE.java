package stack_problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Find_the_greater_element_CORRECT_CODE {
												// CORRECT CODE -->  WORKS ON CICULAR ARRAY eg. 5,4,3,2,1
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int[] ans = new int[n];
		Arrays.fill(ans, -1);
		findGreater(arr,ans);
		
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}
	}

	private static void findGreater(int[] arr, int[] ans) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < 2*arr.length; i++) 				// due to checking for cicular array
		{
			while(!st.isEmpty() && arr[i%arr.length]>arr[st.peek()])
			{
				ans[st.pop()]= arr[i%arr.length];
			}
			st.push(i%arr.length);
		}
	}

}
