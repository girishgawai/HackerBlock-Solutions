package arrays_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_Path_in_2_Arrays_CORRECTCODE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)	
		{
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();

			int[] arr1=new int[n1];
			for (int i = 0; i < arr1.length; i++) {
				arr1[i]=sc.nextInt();
			}

			int[] arr2=new int[n2];
			for (int i = 0; i < arr2.length; i++) {
				arr2[i]=sc.nextInt();
			}

			int ans = Maximum_Sum_Path_in_Two_Arrays(arr1,arr2);
			System.out.println(ans);
			t--;
		}
	}

	private static int Maximum_Sum_Path_in_Two_Arrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int max=0,f1=0,f2=0,sum1=0,sum2=0;
		
		for(int i=f1;i<arr1.length;i++)
		{
			sum1=sum1+arr1[i];
			sum2=0;
			
			for(int j=f2;j<arr2.length;j++)
			{
				sum2=sum2+arr2[j];
				
				if(arr2[j]==arr1[i])
				{
					f2=j+1;
					max=max+Math.max(sum1, sum2);
					sum1=0;
					break;
				}
			}
		}

		if(arr1[arr1.length-1]!=arr2[arr2.length-1])
			max=max+Math.max(sum1, sum2);
		
		return max;
	}

}


//1
//8 8
//2 5 7 8 12 13 16 20
//3 4 5 6 8 13 15 20