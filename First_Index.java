package recursion;

import java.util.Scanner;

public class First_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		
		int m = sc.nextInt();
		System.out.println(find(arr,0,m));
	}

	private static int find(int[] arr, int current, int target) {
		// TODO Auto-generated method stub
		if(current==arr.length)
			return -1;
		
		if(arr[current]==target)
			return current;
		
		return find(arr, current+1, target);
	}

}
