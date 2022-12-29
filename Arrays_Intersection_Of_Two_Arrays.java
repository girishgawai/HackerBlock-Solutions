package hashmap.qps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Arrays_Intersection_Of_Two_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		
		intersectionRepating(arr1, arr2, n);
	}

	private static void intersectionRepating(int[] arr1, int[] arr2, int n) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			if(map.containsKey(arr1[i]))							// agr phle se key hai usme toh uski value ko 1 se bdha do
			{
				map.put(arr1[i], map.get(arr1[i])+1);
			}
			else
			{											// nhi hai key present toh key bna kr value daldo 1
				map.put(arr1[i], 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if(map.containsKey(arr2[i]))						// agr map me yeh key present hai toh is key ko print krdo & ek bari occur
			{												// ho gya isliye existing value se map me ke iss key ki value ko 1 se cum krdo
				if(map.get(arr2[i])>0)				// agr 0 se bdi hai means toh hi dono array me occurr hue hai alg alg posn pe mtlb repeated element hai woh
				{
//					System.out.print(arr2[i] + " ");
					list.add(arr2[i]);
					map.put(arr2[i], map.get(arr2[i])-1);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list);
	}

}
