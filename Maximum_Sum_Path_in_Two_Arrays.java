package arrays_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_Sum_Path_in_Two_Arrays {

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

			Maximum_Sum_Path_in_Two_Arrays(arr1,arr2);
			t--;
		}
	}

	private static void Maximum_Sum_Path_in_Two_Arrays(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub

		int times=2,finalmax=0;
		while(times>0)
		{
			int sum1=0,sum2=0,max=0,f=0;
			for(int i=0;i<arr1.length;i++)
			{
				sum2=0;
				sum1=sum1+arr1[i];
				f=0;
				for(int j=0;j<arr2.length;j++)
				{ 
					if(arr1[i]==arr2[j])
					{
						f=1;
						j++;
						if(j>=arr2.length)
							break;
					}
					if(f==1)
						sum2=sum2+arr2[j];
				}
				if(max<sum1+sum2)
					max=sum1+sum2;
//				System.out.println(sum1+"   "+sum2);

			}
			if(finalmax<max)
				finalmax=max;
			times--;
			
//			System.out.println(max);
//			System.out.println();
			int[] temp= new int[arr1.length];
			temp=arr1;
			arr1=arr2;
			//			for (int i = 0; i < arr2.length; i++) {
			//				System.out.print(arr1[i]+"  ");
			//			}
			arr2=temp;
			//			for (int i = 0; i < arr2.length; i++) {
			//				System.out.print(arr2[i]+"  ");
			//			}
		}
				System.out.println(finalmax);
	}

}


//1
//8 8
//2 5 7 8 12 13 16 20
//3 4 5 6 8 13 15 20