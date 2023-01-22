package graph.qps;

import java.util.*;
import java.lang.*;

class Minimum_Spanning_Tree
{
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	
	public Minimum_Spanning_Tree(int v)
	{
		for (int i = 0; i < v; i++) {
			map.put(i, new HashMap<>());
		}
	}
	
	public void addEdge(int v1, int v2, int cost)
	{
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}
	
	class GraphPair {
		int e1;
		int e2;
		int cost;
		
		public GraphPair(int e1, int e2, int cost)
		{
			this.e1 = e1;
			this.e2 = e2;
			this.cost = cost;
		}
	}
	
	public List<GraphPair> alledges()
	{
		List<GraphPair> list = new ArrayList<>();
		for(int key : map.keySet())
		{
			for(int nbrs : map.get(key).keySet())
			{
				int cost = map.get(key).get(nbrs);
				GraphPair pair = new GraphPair(key, nbrs, cost);
				list.add(pair);
			}
		}
		
		return list;
	}
	
	public class DisjointSet {

	class Node {
		int data;
		int rank;
		Node parent;
	}

	HashMap<Integer, Node> set = new HashMap<>();

	public void createSeT(int v)
	{
		Node nn = new Node();
		nn.data = v;
		nn.rank = 0;
		nn.parent = nn;
		
		set.put(v, nn);
	}

	public int find(int v)
	{
		Node temp = set.get(v);
		return findREAdd(temp).data;
	}

	private Node findREAdd(Node temp) {
		// TODO Auto-generated method stub
		if(temp.parent==temp)
			return temp;

		return findREAdd(temp.parent);
	}

	public void union(int v1, int v2)
	{
		Node re1 = set.get(v1);
		Node re2 = set.get(v2);
		
		if(re1.rank==re2.rank)
		{
			re1.parent = re2;
			re2.rank+=1;
		}
		else if(re1.rank>re2.rank)
			re2.parent = re1;
		else
			re1.parent = re2;
	}

}
	
	public void MinimumCostTree()
	{
		List<GraphPair> list = alledges();
		Collections.sort(list, new Comparator<GraphPair>() {

			@Override
			public int compare(GraphPair o1, GraphPair o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		
		
		DisjointSet dsu = new DisjointSet();
		for (int i = 0; i < map.size(); i++) {
			dsu.createSeT(i);
		}

		int minCost = 0;
		
		for(int i=0;i<list.size();i++)
		{
			int a = list.get(i).e1;
			int b = list.get(i).e2;
			
			int re1 = dsu.find(a);
			int re2 = dsu.find(b);
			
			// agr dono Representative Elements same hai .. it means dono same set me ahi nd Cycle form krte hai so ignore
			if(re1==re2)
			{
				
			}
			else
			{
				// agr dono ke RE alg alg hai means woh merge ho skte dono ke sets
				dsu.union(re1, re2);
				minCost+=list.get(i).cost;
			}
		}
		
		System.out.println(minCost);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		Minimum_Spanning_Tree ks = new Minimum_Spanning_Tree(v);
		
		int e = sc.nextInt();
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			ks.addEdge(a, b, cost);
		}
		
		ks.MinimumCostTree();
	}
}