package priority_queue.qps;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Find_kth_Largest_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int kth = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans = findK_largest(arr, kth);
		System.out.println(ans);
	}

	private static int findK_largest(int[] arr, int kth) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		/***  Priority Queue mein hmne 'K' Elements daal diye  ***/
		for (int i = 0; i < kth; i++) {
			pq.add(arr[i]);
		}
		
		/****  Ab PQ se top ka data(jo sbse chota rhega PQ me usko nikalte jayege agr koi sbse chote se(top) se bda data aya toh
		 * 				and top ka data nikal kr uss data ko bde wale PQ me add krdege
		 ****/
		
		for (int i = kth; i < arr.length; i++) {
			if(pq.peek()<arr[i])						// agr PQ ka top ka data sbse chota rhta hai woh chota hai arr[i] ke data se
			{
				pq.poll();									// Top ka data remove krdo jo sbse chota hai PQ me
				pq.add(arr[i]);										// jo nya data hai arr ka jo bda hai PQ ke top ke chote data se usko add krdo
				// adding new data bigger one into PQ
			}
		}
		
		// Ab Priority Queue ke top me sbse chota data rhega PQ me.. whi Kth Largest Data hai
		return pq.peek();
	}
}
