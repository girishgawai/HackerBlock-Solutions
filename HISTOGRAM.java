package stack_problems;

import java.util.Scanner;
import java.util.Stack;

public class HISTOGRAM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(histogramArea(arr));
	}

	private static long histogramArea(int[] arr) {
		// TODO Auto-generated method stub
		Stack<Integer> st =  new Stack<>();
		
		long ans = 0;
		for (int i = 0; i < arr.length; i++) 
		{
			while(!st.isEmpty() && arr[i]<arr[st.peek()])
			{
				int r = i;					// rt minimum of top of stack
				int h = arr[st.pop()];			// pop kro stack ke top ka data-->ht
				
				if(!st.isEmpty())				// toh isko left min and rt min dono rhege
				{
					int l = st.peek();					// lft min
					ans = Math.max(ans, (r-l-1)*h);
				}
				else
				{
					ans = Math.max(ans, r*h);			// sirf rt min rhega
				}
			}
			
			st.push(i);
		}
		
		int r = arr.length;			// stack me lft min rhege hi nhi.. toh sirf rt min rhega.. woh v end index ko lege jiski ht 0 consider kege
		while(!st.isEmpty())
		{
			long  h = arr[st.pop()];
			if(!st.isEmpty())
			{
				int l = st.peek();
				ans = Math.max(ans, (r-l-1)*h);
			}
			else
			{
				ans = Math.max(ans, r*h);
			}
		}
		
//		System.out.println(ans);
		return ans;
	}

}
