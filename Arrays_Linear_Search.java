package arrays_problems;

import java.util.Scanner;

public class Arrays_Linear_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}

		int find=sc.nextInt();

		System.out.println(Linear_Search(arr,find));
	}

	private static int Linear_Search(int[] arr, int find) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==find)
				return i;
		}
		
		return -1;
		
	}
}
