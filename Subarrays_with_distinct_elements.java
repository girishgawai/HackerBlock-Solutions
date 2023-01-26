package mixed_dsa_qps;

import java.util.HashMap;
import java.util.Scanner;

public class Subarrays_with_distinct_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		subArrays(arr);
	}

	private static void subArrays(int[] arr) {
		// TODO Auto-generated method stub

		int new_len = 0;							// count the len of all valid form SubArrays --> Latest len till now
		for(int i = 0; i<arr.length; i++)
		{
			HashMap<Integer, Boolean> freq = new HashMap<>();
//			String subarray = new String();
			int oldlen = 0;										// count len of valid SubArrays and holds older len than current
			for (int j = i; j < arr.length; j++) {
				if(freq.containsKey(arr[j]))
				{
					break;
				}
				
				oldlen++;
				new_len+=oldlen;
				freq.put(arr[j], true);
				
				/* Forms SubArray
					subarray+=arr[j];
					System.out.print("[" + subarray + "]" + " ");
				*/
			}
		}

		System.out.println(new_len);
	}
}
