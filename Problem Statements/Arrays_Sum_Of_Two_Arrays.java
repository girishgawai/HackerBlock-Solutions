package arrays_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Arrays_Sum_Of_Two_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=sc.nextInt();
		}

		int m = sc.nextInt();
		int[] arr2 = new int[m];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=sc.nextInt();
		}

		indArraySum(arr1,arr2);
	}

	private static void indArraySum(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int sum = 0;
		int carry = 0;

		ArrayList<Integer> list = new ArrayList<>();
		int i = arr1.length-1;
		int j = arr2.length-1;
		while(i>=0 || j>=0)
		{
			sum=0;
			if(i>=0)
			{
				sum=sum+arr1[i];
			}
			if(j>=0)
			{
				sum=sum+arr2[j];
			}
			
			if(i<=-2 || j<=-2)
				carry=0;

			sum=sum+carry;
			list.add(sum%10);
			carry=sum/10;

			i--;
			j--;
		}

//IMP condition for last digits addititon agr carry generate ho gya last digits ki sum se toh usko add krne ke liye
		if(carry>0)
			list.add(carry);
		
		//either use this
//		Collections.reverse(list);
//		System.out.println(list);
		
		for(int k=list.size()-1;k>=0;k--)
		{
			System.out.print(list.get(k) + ",\t");
		}
		System.out.print("END");
	}

}
