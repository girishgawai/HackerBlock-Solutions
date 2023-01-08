package hashmap.qps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Exist_OR_Not {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while(t>0)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n;i++)
			{
				arr[i] = sc.nextInt();
			}

			int q = sc.nextInt();
			int[] queries = new int[q];
			for(int i=0; i<q;i++)
			{
				queries[i] = sc.nextInt();
			}

			doesExist(arr, queries);

			t--;
		}
	}

	private static void doesExist(int[] arr, int[] queries) {
		// TODO Auto-generated method stub
		HashSet<Integer> map = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			map.add(arr[i]);
		}
		
		for (int i = 0; i < queries.length; i++) {
			if(map.contains(queries[i]))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		
	}

}
