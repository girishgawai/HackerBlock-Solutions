package mixed_dsa_qps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Merge_K_sorted_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0)-o2.get(0);
			}
		});
		while(k>0)
		{
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			pq.add(list);
			
			k--;
		}
//		System.out.println(pq);
		ArrayList<Integer> ans = mergeSorted(pq);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	private static ArrayList<Integer> mergeSorted(PriorityQueue<ArrayList<Integer>> pq) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = new ArrayList<>();
//		ArrayList<Integer> temp = ans;
		
		while(!pq.isEmpty())
		{
			ArrayList<Integer> removed = pq.poll();
			int rem = removed.remove(0);
			
			ans.add(rem);
			
			if(!removed.isEmpty())
				pq.add(removed);
		}
		
//		System.out.println(ans);
		
//		return temp;
		return ans;
	}

}
