package hashmap.qps;

import java.util.HashMap;
import java.util.Scanner;

public class Highest_frequency_Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int ans = highestFreqData(arr);
		System.out.println(ans);
	}

	private static int highestFreqData(int[] arr) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();							// store the freq of data
		int maxfreq = 0, maxdata = 0;;								// map me uss key pe present value
		
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i], 1);
				if(maxfreq < map.get(arr[i]))
				{
					maxdata = arr[i];
					maxfreq = 1; 
				}
			}
			else
			{
				int item = map.get(arr[i]);					// map me uss key pe present value
				map.put(arr[i], item+1);					// map me uss key pe present value ko 1 se plus krdo purane value se.. means wapis mil gyi thi so freq++
				
				if(maxfreq < map.get(arr[i]))			// agr maxfreq chori hai toh nyi bdi wali maxfreq store krege with that data
				{
					maxfreq = map.get(arr[i]);
					maxdata = arr[i];
				}
			}
		}
		
//		System.out.println(map);
		
//		System.out.println(maxdata + " : " + maxfreq);
		
		return maxdata;
	}

}
