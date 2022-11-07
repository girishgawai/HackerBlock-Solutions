package stack_problems;

import java.util.Scanner;
import java.util.Stack;

public class Stock_Span {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int[] prices=new int[N];
		for(int i=0;i<N;i++){
			prices[i]=s.nextInt();
		}
		
		int[] ans=StockSpanUsingStacks(prices, new Stack<>());
		for(int i=0;i<ans.length;i++){
			System.out.print(ans[i]+" ");
		}
		System.out.println("END");
	}

	private static int[] StockSpanUsingStacks(int[] prices, Stack<Integer> st) {
		// TODO Auto-generated method stub
		int[]  ans = new int[prices.length];
		
		for (int i = 0; i < prices.length; i++) 
		{
			while(!st.isEmpty() && prices[i]>prices[st.peek()])
			{
				st.pop();			// agr  prices[i] ki val bdi hogi stack k last index wale element se toh uss stack data ko udado pop
			}
			
			if(st.isEmpty())
			{
				ans[i]=i+1;				// agr pop krte krte or sbse frst time me stack Empty Khali rha toh ans me index+1 krdo
			}										// means sare phle k elements pop krdiye prsnt no ne kyu ki whi sbse bda hai (span)
			else
			{
				ans[i]=i-st.peek();
			}
			
			st.push(i);				// data k index ko push krege stack me
		}
		
		return ans;
	}

}
