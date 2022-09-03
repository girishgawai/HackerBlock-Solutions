package arrays_problems;

import java.util.Scanner;

public class Calculate_The_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		int q=sc.nextInt();
		int[] x =new int[q];
		for (int i = 0; i < x.length; i++) {
			x[i]=sc.nextInt();
		}
		
		int[] ans = Calculate_The_Sum(arr,x);
		int sum=0;
		for (int i = 0; i < ans.length; i++) {
//			System.out.print(ans[i]);
			sum=sum+ans[i];
		}
		System.out.println(sum%((int)Math.pow(10, 9)+7));
	}

	private static int[] Calculate_The_Sum(int[] arr, int[] x) {
		// TODO Auto-generated method stub
		for(int i=0;i<x.length;i++)
		{
			int temp=0;
			if(x[i]!=0)
				temp=arr[0]+arr[arr.length-x[i]];
			else
				temp=arr[0]+arr[0];
			
			int[] nextStepAns= new int[arr.length];
			for(int j=1;j<arr.length;j++)
			{
//				System.out.println(j-x[i]);
				if(j-x[i]<0)
				{
//					System.out.println(arr.length-(j-x[i])+" === "+arr.length+" --- "+(j-x[i]));
					nextStepAns[j]=arr[j]+arr[arr.length+(j-x[i])];
				}
				else
				{
					System.out.println();
					nextStepAns[j]=arr[j]+arr[j-x[i]];
				}
			}
			
			nextStepAns[0]=temp;
			arr=nextStepAns;
		}
		
		return arr;
	}

}
