package graph.qps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Detect_cycle_in_Graph {

	HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
	
	public Detect_cycle_in_Graph(int v)
	{
		for (int i = 1; i <= v; i++) {
			graph.put(i, new HashMap<>());
		}
	}
	
	public void addEdges(int v1, int v2)
	{
		graph.get(v1).put(v2, 2);
		graph.get(v2).put(v1, 2);
	}
	
	public void isCycle()
	{
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		
		for(int src : graph.keySet())
		{
			if(visited.contains(src))
				continue;
			
			q.add(src);
			while(!q.isEmpty())
			{
				int removed = q.poll();
				
				if(visited.contains(removed))
				{
					System.out.println("YES");
					return;
				}
				
				visited.add(removed);
				
				for(int nbrs : graph.get(removed).keySet())
				{
					if(!visited.contains(nbrs))
						q.add(nbrs);
				}
			}			
		}
		
		System.out.println("NO");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int v = sc.nextInt();
			Detect_cycle_in_Graph obj = new Detect_cycle_in_Graph(v);
			int e = sc.nextInt();
			
			for (int i = 1; i <= e; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				
				obj.addEdges(v1, v2);
			}
			obj.isCycle();
			
			t--;
		}
	}

}
