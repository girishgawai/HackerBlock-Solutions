package arrays_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_Target_Sum_Triplets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		int target=sc.nextInt();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"  ");

		System.out.println();
		Arrays_Target_Sum_Triplets(arr,target);

	}

	private static void Arrays_Target_Sum_Triplets(int[] arr, int target) {
		// TODO Auto-generated method stub
		if(arr.length==1 && arr[0]==target)
			System.out.println(arr[0]);
		else if(arr.length==2 && (arr[0]+arr[1]==target))
			System.out.println(arr[0]+" and "+arr[1]);
		else
		{
			for(int i=0;i<arr.length-2;i++)
			{
				//			System.out.print("I ");
				for(int j=i+1;j<arr.length-1;j++)
				{
					if(j>=arr.length)
						break;
					//				System.out.print("LOVE ");
					for(int k=j+1;j<arr.length;k++)
					{
						if(k>=arr.length)
							break;
						//					System.out.print("YOU ");
						//					System.out.print(k+" ");
						//					System.out.println(arr[i]+""+arr[j]+""+arr[k]);
						if((arr[i]+arr[j]+arr[k])==target)
							System.out.println(arr[i]+", "+arr[j]+" and "+arr[k]);
						//				System.out.println();
					}
					//				System.out.println();
				}
			}

		}
	}

}
