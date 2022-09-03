package arrays_problems;

import java.util.Scanner;

public class Next_Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int n=sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt();
			}
			
			justNextGreater(arr);
			for (int i = 0; i < arr.length; i++)
			{				
				System.out.print(arr[i]+"\t");
			}
			System.out.println();
			t--;
		}
	}

	private static int[] justNextGreater(int[] arr) {
		// TODO Auto-generated method stub
		int q=0;
		for (int i = arr.length-2; i >= 0; i--)
		{
			if(arr[i]<arr[i+1])
			{	
				q=i;							// smaller num than next one
				break;
			}
		}

		int p=0;
		for (int i = arr.length-1; i>q ; i--) 
		{
			if(arr[i]>arr[q])
			{
				p=i;							// found the num, which is greater than arr[q]
				break;
			}
		}
		
		if(q==0 && p==0)						// agr sare phle num bde rhege next wale se toh pura array rev krege
		{
			for (int i = 0,j=arr.length-1; i<j ; i++,j--)
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			
			return arr;
		}
		
		int temp=arr[p];
		arr[p]=arr[q];
		arr[q]=temp;
		
		for (int i = q+1, j=arr.length-1; i<j ; i++,j--) {
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		return arr;
	}

}
